-- Exercicio 4

-- 1)
SELECT Projeto, DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev) AS Tempo_Previsto,
DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) AS Tempo_Realizado FROM Licitacao
WHERE DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) > DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev);

-- 2)
SELECT TOP 10 Empresa_Licitante, SUM(Valor_Realizado) AS Total_Faturamento,
SUM(Valor_Realizado) / SUM(Profissionais)  AS Valor_Medio_Por_Profissional
FROM Licitacao GROUP BY Empresa_Licitante;

-- 3)
SELECT TOP 10 Municipio, SUM(Imposto_Municipal) AS Total_Imposto_Municipal FROM Licitacao
GROUP BY Municipio ORDER BY SUM(Imposto_Municipal) DESC;

-- 4)
SELECT Projeto, Data_Inicio_Real FROM Licitacao
WHERE DATEPART(DW, Data_Inicio_Real) IN (1, 7); 


-- 5)
SELECT Empresa_Licitante, SUM(Valor_Previsto) AS Total_Valor_Previsto, SUM(Faturamento_1Ano_Anterior) AS Total_Faturamento_Anterior
FROM Licitacao GROUP BY Empresa_Licitante HAVING SUM(Valor_Previsto) > AVG(Faturamento_1Ano_Anterior) * 0.50;

-- 6)
SELECT Projeto, CustoReal =
CASE Esfera
 	WHEN 'Federal' THEN (Valor_Realizado - Imposto_Federal)
 	WHEN 'Municipal' THEN (Valor_Realizado - Imposto_Estadual)
 	WHEN 'Estadual' THEN (Valor_Realizado - Imposto_Estadual)
END
FROM Licitacao;

-- 7)
SELECT Data_Fim_Prev, Data_Fim_Real, DATEDIFF(MONTH, Data_Fim_Prev, Data_Fim_Real) AS Tempo_Atrasado
FROM licitacao WHERE Identificador = 17255;
