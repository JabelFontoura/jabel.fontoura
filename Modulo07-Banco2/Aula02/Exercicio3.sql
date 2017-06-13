/* 3) Crie uma rotina que atualize todos os clientes que não realizaram nenhum pedido nos últimos 6 meses (considere apenas o mês, dia 01 do 6º mês anterior). 
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