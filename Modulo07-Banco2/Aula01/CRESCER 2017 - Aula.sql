-- 1) Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.
SELECT prod.IDPRODUTO, prod.NOME FROM PRODUTO prod WHERE prod.IDPRODUTO NOT IN (
  SELECT pi.IDPRODUTO FROM PEDIDO p
  JOIN PEDIDOITEM pi ON p.IDPEDIDO = pi.IDPEDIDO 
  AND p.DATAPEDIDO BETWEEN ADD_MONTHS(TRUNC(SYSDATE,'mm'), -4) 
  AND LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE,'mm'), -4))
);

-- 2) Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses.
UPDATE PRODUTO prod SET prod.SITUACAO = 'I' WHERE prod.IDPRODUTO NOT IN (
  SELECT pi.IDPRODUTO FROM PEDIDO p
  JOIN PEDIDOITEM pi ON p.IDPEDIDO = pi.IDPEDIDO 
  AND p.DATAPEDIDO BETWEEN ADD_MONTHS(TRUNC(SYSDATE,'mm'), -4) 
  AND LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE,'mm'), -4))
);
/* 3) Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela 
      PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2017). */
DEFINE pID = 2;

SELECT prod.IDPRODUTO, COUNT(pi.IDPRODUTO) AS QUANTIDE_VENDIDA FROM PRODUTO prod
JOIN PEDIDOITEM pi ON prod.IDPRODUTO = pi.IDPRODUTO AND pi.IDPRODUTO = :pID 
JOIN Pedido p ON p.IDPEDIDO = pi.IDPEDIDO AND p.DATAENTREGA >= TO_DATE(201701, 'YYYYMM')
GROUP BY prod.IDPRODUTO;
      
      