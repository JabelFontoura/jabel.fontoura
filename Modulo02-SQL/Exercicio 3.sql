-- Exercicios 3

-- 1)
SELECT IDEmpregado, NomeEmpregado, DATEDIFF(year, DataNascimento, DataAdmissao) AS IdadeAdmissao
FROM Empregado WHERE YEAR(DataAdmissao) = 1980; 

-- 2)
SELECT TOP 1 Cargo FROM Empregado
GROUP BY Cargo ORDER BY COUNT(Cargo) DESC;

-- 3)
SELECT UF, COUNT(Nome) AS TotalDeCidades 
FROM Cidade GROUP BY UF;

-- 4)
BEGIN TRANSACTION

 INSERT INTO Departamento VALUES (70, 'Inovação', 'SÃO LEOPOLDO');

 UPDATE Empregado SET IDDepartamento = 70 WHERE MONTH(DataAdmissao) = 12 AND Cargo != 'Atendente';

 COMMIT
 GO