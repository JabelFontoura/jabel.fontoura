SELECT * FROM Log_Aposta la
JOIN Log_Numero_Aposta lna ON la.IDLogAposta = lna.IDLogAposta
JOIN Aposta a ON la.IDAposta = a.IDAposta
JOIN Concurso c ON c.IDConcurso = a.IDConcurso
WHERE la.Data > c.Data_Sorteio;