-- Exercicios 2

-- 1)
SELECT * FROM Empregado ORDER BY DataAdmissao;

-- 2)
SELECT * FROM Empregado WHERE Comissao IS NULL
ORDER BY Salario;

-- 3) 
SElECT IDEmpregado, NomeEmpregado, (Salario * 13) AS SalarioAnual,
 COALESCE((Comissao * 12), 0) AS ComissaoAnual, ((Salario * 13) + COALESCE((Comissao * 12), 0)) AS RendaAnual 
 FROM Empregado;

-- 4)
SELECT IDEmpregado, NomeEmpregado, Cargo, Salario FROM Empregado
WHERE (Salario * 13) < 18500.00 OR Cargo IN ('Atendente');
 
