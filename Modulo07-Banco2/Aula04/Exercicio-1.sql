/*
1) Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
  O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. A auditoria deve monitorar
  tanto as apostas quanto os números de cada aposta.
*/

CREATE TABLE Log_Aposta (
  IDLogAposta integer not null,
  IDAposta integer not null,
  Data date default sysdate,  
  Operacao char(1) not null,
  CONSTRAINT PK_LogAposta PRIMARY KEY (IDLogAposta)
);
CREATE SEQUENCE sqLogAposta;

CREATE TABLE Log_Numero_Aposta (
  IDLogNumero_Aposta integer not null,
  IDLogAposta integer not null,
  IDAposta integer not null,
  IDNumero_Aposta integer not null,
  Numero integer not null,
  Data date default sysdate,  
  Operacao char(1) not null,
  CONSTRAINT PK_LogNumero_Aposta PRIMARY KEY (IDLogNumero_Aposta),
  CONSTRAINT FK_Log_Aposta FOREIGN KEY (IDLogAposta) REFERENCES Log_Aposta(IDLogAposta)
);
CREATE SEQUENCE sqLogNumero_Aposta;

CREATE OR REPLACE TRIGGER TR_AUD1_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Aposta
    FOR EACH ROW
DECLARE
  v_operacao char(1);
BEGIN
  IF INSERTING THEN
     v_operacao := 'I';
  ELSIF UPDATING THEN
     v_operacao := 'U';       
  ELSE
     v_operacao := 'D';
  END IF;
  INSERT INTO Log_Aposta (IDLogAposta, IDAposta, Data, Operacao) 
  VALUES (sqLogAposta.NEXTVAL, :new.IDAposta, SYSDATE, v_operacao);
END TR_AUD1_APOSTA;

CREATE OR REPLACE TRIGGER TR_AUD1_NUMERO_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Numero_Aposta
    FOR EACH ROW
DECLARE
  v_operacao char(1);
  v_IDAposta Numero_Aposta.IDAposta%TYPE;
BEGIN
  IF INSERTING THEN
     v_operacao := 'I';
  ELSIF UPDATING THEN
     v_operacao := 'U';       
  ELSE
     v_operacao := 'D';
  END IF;
  
  SELECT IDLogAposta INTO v_IDAposta FROM Log_Aposta WHERE IDAposta = :new.IDAposta;
  
  INSERT INTO Log_Numero_Aposta (IDLogNumero_Aposta, IDLogAposta, IDAposta, IDNumero_Aposta, Numero, Data, Operacao) 
  VALUES (sqLogNumero_Aposta.NEXTVAL, v_IDAposta, :new.IDAposta, :new.IDNumero_Aposta, :new.Numero, SYSDATE, v_operacao);
END TR_AUD1_NUMERO_APOSTA;