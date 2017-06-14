/* 4) Fa�a uma rotina que receba dois par�metros:
    -IDProduto
    -M�s e Ano
E ent�o fa�a uma rotina que verifique no ANO/M�S para o produto informado qual a lista de materiais (incluindo a quantidade) � necess�rio para atender 
todos os Pedidos desde per�odo. Deve imprimir o nome do material e quantidade total.
*/
DECLARE
    CURSOR C_ListaProdutos(Id IN NUMBER, Mes IN NUMBER, Ano IN NUMBER) IS
        SELECT p.IdProduto AS IdProduto, SUM(pi.Quantidade) Quantidade_Produto FROM Produto p
        JOIN PedidoItem pi ON p.IdProduto = pi.IdProduto AND p.IdProduto = Id
        JOIN Pedido ped ON ped.IDPEDIDO = pi.IDPEDIDO 
        WHERE TO_CHAR(ped.DATAPEDIDO, 'MM') = Mes AND TO_CHAR(ped.DATAPEDIDO, 'YYYY') = Ano
        GROUP BY p.IdProduto;
    CURSOR C_MateriaisProduto(IdProduto IN NUMBER) IS
        SELECT m.IdMaterial, m.Descricao, pm.Quantidade FROM Material m
        JOIN ProdutoMaterial pm ON m.IdMaterial = pm.IdMaterial AND pm.IdProduto = IdProduto;
BEGIN
    FOR reg IN C_ListaProdutos(2, 2, 2014) LOOP
        FOR item IN C_MateriaisProduto(reg.IdProduto) LOOP
            DBMS_OUTPUT.PUT_LINE(item.Descricao || ' -> ' || item.Quantidade * reg.Quantidade_Produto);
        END LOOP;
    END LOOP;
END;