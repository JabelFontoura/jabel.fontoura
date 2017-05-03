-- Exercicio

-- 1) Liste o nome do empregado, o nome do gerente e o departamento de cada um.
SELECT emp.NomeEmpregado, ger.NomeEmpregado AS NomeGerente, dep.NomeDepartamento
FROM Empregado emp JOIN Empregado ger ON emp.IDGerente = ger.IDEmpregado
JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento;

-- 2) Liste o deparamento (id e nome) com o empregado de maior salário.
SELECT DISTINCT dep.IDDepartamento, dep.NomeDepartamento, emp.Salario FROM Departamento dep
JOIN Empregado emp ON dep.IDDepartamento = emp.IDDepartamento
AND emp.Salario = (SELECT MAX(Salario) FROM Empregado WHERE IDDepartamento IS NOT NULL);

-- 3) Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO,
--    este reajuste deve ser de 17,3%. Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.
SELECT * INTO CopiaEmpregado FROM Empregado;

BEGIN TRANSACTION
	UPDATE emp SET emp.Salario = emp.Salario * 1.173 FROM Empregado emp
	JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento AND dep.Localizacao IN ('SAO PAULO');
GO
COMMIT

-- 4) Liste todas as cidades duplicadas (nome e UF iguais).	
SELECT Nome, COUNT(Nome) FROM Cidade
GROUP BY Nome HAVING COUNT(Nome) > 1;

-- 5) Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. 
--    Mas atenção! apenas a cidade com maior ID deve ser alterada.
BEGIN TRANSACTION
	UPDATE Cidade SET Nome = Nome + '*' WHERE Nome+UF IN (SELECT Nome+UF FROM Cidade
	GROUP BY Nome, UF HAVING COUNT(1) > 1) AND IDCidade IN(
		SELECT MAX(IDCidade) FROM Cidade GROUP BY Nome, UF HAVING COUNT(1) > 1);
COMMIT
GO
