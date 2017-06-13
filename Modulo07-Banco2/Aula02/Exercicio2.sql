/* 2)Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens.
Esta rotina deve receber por parametro o IDPedido e então verificar o valor total de seus itens (quantidade x valor unitário).
*/
DECLARE
  CURSOR C_Pedido(Id IN number) IS
     SELECT Quantidade, PrecoUnitario FROM PedidoItem
     WHERE IdPedido = Id;
   vPedidoId Pedido.IdPedido%TYPE;
   vValor Pedido.ValorPedido%TYPE;
 BEGIN
   vPedidoId := 7;
   vValor := 0.0;
   FOR i IN C_Pedido(vPedidoId) LOOP
     vValor := vValor + ( i.quantidade * i.precounitario);
   END LOOP;
   UPDATE Pedido 
   SET ValorPedido =  vValor
   WHERE IdPedido = vPedidoId;
 END;