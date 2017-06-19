/*
CREATE OR REPLACE PACKAGE pck_aula03 AS
  PROCEDURE Remover_Cidades_Duplicadas;
END;
*/

CREATE OR REPLACE PACKAGE BODY pck_aula03 AS
  PROCEDURE Remover_Cidades_Duplicadas AS
    CURSOR c_cidades IS
         SELECT MIN(IDCidade) AS MenorIdCidade, Nome, UF FROM Cidade 
         GROUP BY Nome, UF HAVING COUNT(1) > 1;
    CURSOR c_clientes (pNome IN VARCHAR2, pUF   IN VARCHAR2) IS
       SELECT cli.IDCliente, cli.Nome AS Nome_Cliente, cid.Nome AS Nome_Cidade,
        cli.IDCidade AS IDCidade, cid.UF FROM Cliente cli
        JOIN Cidade cid ON cid.IDCidade = cli.IDCidade
        WHERE cid.Nome = pNome AND cid.UF   = pUF;
    BEGIN
      FOR c in c_cidades LOOP     
          FOR i in c_clientes (c.Nome, c.UF) LOOP
                UPDATE Cliente SET IDCidade = c.MenorIdCidade 
                WHERE IDCidade != c.MenorIdCidade AND IdCliente = i.IDCliente;
          END LOOP;
          DELETE FROM Cidade WHERE Nome = c.Nome AND IDCidade != c.MenorIdCidade;
      END LOOP;
  END Remover_Cidades_Duplicadas;
END pck_aula03;

EXEC pck_aula03.Remover_Cidades_Duplicadas;