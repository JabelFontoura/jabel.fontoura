-- Exercicios 3

-- 1)
SELECT IDEmpregado, NomeEmpregado, DATEDIFF(year, DataNascimento, DataAdmissao) AS IdadeAdmissao
FROM Empregado WHERE YEAR(DataAdmissao) = 1980; 
