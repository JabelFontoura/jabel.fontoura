-- EXERCICIOS

-- 1)
SELECT * INTO CidadeAux FROM Cidade;

-- 2)
TRUNCATE TABLE CidadeAux

INSERT INTO CidadeAux SELECT * FROM Cidade WHERE UF = 'RS'

-- 3)

CREATE TABLE Produto (
	IDProduto int identity,
	Nome varchar(100),
	Descricao varchar(200),
	Data_Criacao date,
	Local_Estoque varchar(100),
	Quantidade int,
	Preco decimal,
	constraint PK_Produto primary key (IDProduto)
);

-- 4)

INSERT INTO Produto (Nome, Descricao, Data_Criacao, Local_Estoque, Quantidade, Preco)
VALUES ('Lapís', 'Lapís cinza', '28/04/2017', 'Algum local', 100, 3.00);	

INSERT INTO Produto (Nome, Descricao, Data_Criacao, Local_Estoque, Quantidade, Preco)
VALUES ('Caneta', 'Caneta azul', '28/04/2017', 'Algum local', 120, 3.00);	

SELECT * FROM Produto