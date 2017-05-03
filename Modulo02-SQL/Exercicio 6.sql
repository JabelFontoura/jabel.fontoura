-- Exercicios 6

-- 1) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
SELECT TOP 1 PrimeiroNome.Nome AS NomeCliente, COUNT(PrimeiroNome.Nome) AS TotalOcorrencia
FROM (SELECT (SUBSTRING(Nome, 1, CHARINDEX(' ', cliente.Nome) -1)) AS Nome FROM cliente) AS PrimeiroNome
GROUP BY PrimeiroNome.Nome ORDER BY TotalOcorrencia DESC;

-- 2) Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017.
SELECT COUNT(1) AS Quantidade, SUM(ValorPedido) AS ValorPedido FROM Pedido 
WHERE DATEPART(MONTH, DataPedido) IN (4) AND  DATEPART(YEAR, DataPedido) IN (2017);

-- 3) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente),
--    liste também qual o Estado possuí o menor número de clientes.
SELECT TOP 1 cid.UF, COUNT(cli.IDCliente) AS TotalClientes FROM Cliente cli
JOIN Cidade cid ON cid.IDCidade = cli.IDCidade 
GROUP BY cid.UF ORDER BY COUNT(cli.IDCliente) DESC;

-- 4)
/*
Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:

Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A
*/
INSERT INTO Produto(Nome, PrecoCusto, PrecoVenda, Situacao) 
VALUES('Galocha Maragato', 35.67, 77.95, 'A');

-- 5)
/*
Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).

=> Obs.: o produto criado anteriormente deverá ser listado (apenas este)
*/
SELECT * FROM Produto prod LEFT JOIN PedidoItem pedI ON prod.IDProduto = pedI.IDProduto
LEFT JOIN Pedido ped ON pedI.IDPedido = ped.IDPedido WHERE ped.IDPEDIDO IS NULL;