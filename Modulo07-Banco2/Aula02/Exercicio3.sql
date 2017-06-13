/* 3) Crie uma rotina que atualize todos os clientes que n�o realizaram nenhum pedido nos �ltimos 6 meses (considere apenas o m�s, dia 01 do 6� m�s anterior). 
Definir o atributo Situacao para I.
*/
DECLARE
    CURSOR C_Clientes IS
        SELECT c.IdCliente FROM Cliente c JOIN Pedido p ON c.IdCliente = p.IdCliente
        WHERE IdPedido NOT IN (
            SELECT IdPedido FROM PedidoItem WHERE p.DataPedido >= ADD_MONTHS(TRUNC(SYSDATE), - 6)
        );
    BEGIN
        FOR reg in C_Clientes LOOP
            UPDATE Cliente SET Situacao = 'I'
            WHERE IdCliente = reg.IdCliente;
        END LOOP;
    END;