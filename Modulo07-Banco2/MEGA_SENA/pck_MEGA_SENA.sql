create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  procedure geraProximoConcurso as
    vConcurso Concurso.IDconcurso%TYPE;
    vTotalArrecadado Aposta.Valor%TYPE;
    vAcumulado Concurso.Acumulou%TYPE;
    vPremio Concurso.Premio_Sena%TYPE;
   begin
      SELECT MAX(c.IDConcurso) AS Ultimo_Concurso, SUM(a.Valor) AS Total_Arrecadado, c.Acumulou, c.Premio_Sena
      INTO vConcurso, vTotalArrecadado, vAcumulado, vPremio 
      FROM Concurso c
      JOIN Aposta a ON c.IDConcurso = a.IDConcurso AND c.IDConcurso = (SELECT MAX(IDConcurso)FROM Concurso)
      GROUP BY a.IDConcurso, c.Acumulou, c.Premio_Sena;
    
    vConcurso := vConcurso + 1;
    vTotalArrecadado := vTotalArrecadado * 0.453;
    
    IF(vAcumulado = 1) THEN
        vTotalArrecadado := vTotalArrecadado + vPremio;
    END IF;
    
    salvaConcurso(vConcurso, SYSDATE, vTotalArrecadado);
      
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
    CURSOR C_Concurso IS
        SELECT IDConcurso,Premio_Sena, Premio_Quina, Premio_Quadra, Primeira_Dezena, Segunda_Dezena, Terceira_Dezena, Quarta_Dezena, Quinta_Dezena, Sexta_Dezena
        FROM Concurso WHERE IDConcurso = pConcurso;
    CURSOR C_Numeros_Aposta IS
        SELECT na.IDAposta, na.Numero FROM Numero_Aposta na 
        JOIN Aposta a ON a.IDAposta = na.IDAposta AND a.IDConcurso = pConcurso;
    CURSOR C_Acertos IS 
        SELECT Acertos, COUNT(ap.IDAposta) 
        FROM Aposta_Premiada ap 
        JOIN Aposta a ON a.IDAposta = ap.IDAposta AND a.IDConcurso = pConcurso
        GROUP BY Acertos;

    TYPE numeros IS TABLE OF Concurso.Primeira_Dezena%TYPE;
    vResultado numeros;
    vAcertos number;
    vApostaAtual number;
    vDezena number;
    vSena number;
    vPremio number;
   begin
    FOR reg IN C_Concurso LOOP
        vResultado := numeros(reg.Primeira_Dezena, reg.Segunda_Dezena, reg.Terceira_Dezena, reg.Quarta_Dezena, reg.Quinta_Dezena, reg.Sexta_Dezena);

        FOR i IN  C_Numeros_Aposta LOOP
            IF(i.IDAposta = vApostaAtual)THEN                
                IF(i.Numero MEMBER OF vResultado) THEN              
                    vAcertos := vAcertos + 1;
                END IF;
            ELSE
                IF(vAcertos >= 4) THEN
                    INSERT INTO APOSTA_PREMIADA (IDAposta, Acertos, Valor) VALUES (vApostaAtual, vAcertos, 0);
                END IF;
                vAcertos := 0;
                vApostaAtual := i.IDAposta;
                
                IF(i.Numero MEMBER OF vResultado) THEN              
                 vAcertos := vAcertos + 1;
                END IF;
            END IF;
        END LOOP;
        
        FOR j IN C_Acertos LOOP
            SELECT CASE COUNT(ap.IDAposta) WHEN 0 THEN 1 ELSE COUNT(ap.IDAposta)END 
            INTO vDezena FROM Aposta_Premiada ap 
            JOIN Aposta a ON a.IDAposta = ap.IDAposta AND a.IDConcurso = pConcurso
            WHERE ap.Acertos = j.Acertos;

            IF j.Acertos = 4 THEN
                vPremio := reg.Premio_Quadra;
            ELSIF j.Acertos = 5 THEN
                vPremio := reg.Premio_Quina;
            ELSE
                vPremio := reg.Premio_Sena;
            END IF;
            
            UPDATE Aposta_Premiada 
            SET Valor = vPremio / vDezena
            WHERE IDAposta IN (SELECT ap.IDAposta
                FROM Aposta_Premiada ap 
                JOIN Aposta a ON a.IDAposta = ap.IDAposta AND a.IDConcurso = pConcurso
                WHERE ap.Acertos = j.Acertos);
                
            IF (j.Acertos = 6) THEN
                UPDATE Concurso Set Acumulou = 0 WHERE IDConcurso = pConcurso;
            END IF;        
        END LOOP;
        EXIT;
    END LOOP;
       
   end atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;