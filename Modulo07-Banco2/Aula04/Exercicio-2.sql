/*
2) Liste os estados com maior n�mero de apostas, e maior valor arrecadado em cada concurso. 
   Adicionalmente tamb�m deve ser exibido o total de acertadores e o valor da premia��o em cada estado.
*/

SELECT cid.UF, co.IDConcurso, SUM(a.IDAposta) Numero_Apostas , SUM(a.Valor) Valor_Arrecadado, 
SUM(ap.IDAposta_Premiada) Acertadores, SUM(ap.Valor) Premiacao
FROM Aposta a JOIN Cidade cid ON a.IDCidade = cid.IDCidade
JOIN Concurso co ON co.IDConcurso = a.IDConcurso
LEFT JOIN Aposta_Premiada ap ON ap.IDAposta = a.IDAposta
GROUP BY co.IDConcurso, cid.UF;
