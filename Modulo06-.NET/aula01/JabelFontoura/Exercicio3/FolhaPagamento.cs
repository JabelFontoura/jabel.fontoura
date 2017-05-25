
using System;

namespace Exercicio3
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            var ValorHora = salarioBase / horasCategoria;
            var HorasExtras = new HorasCalculadas(horasExtras, ValorHora * horasExtras);
            var HorasDescontadas = new HorasCalculadas(horasDescontadas, ValorHora * horasDescontadas);
            var TotalProventos = (salarioBase + HorasExtras.ValorTotalHoras - HorasDescontadas.ValorTotalHoras);
            var Inss = new CalculaINSS().calcular(TotalProventos);
            var Irpf = new CalculaIRPF().calcular(TotalProventos - Inss.Valor);
            var TotalDescontos = Inss.Valor + Irpf.Valor;
            var AliquotaFgts = 0.11;
            var Fgts = new Desconto(AliquotaFgts, Utils.DoFormat((TotalProventos * AliquotaFgts)));

            return new Demonstrativo(
                salarioBase, 
                horasCategoria, 
                HorasExtras, 
                HorasDescontadas,
                TotalProventos, 
                Inss, 
                Irpf,
                Utils.DoFormat(TotalDescontos),
                Utils.DoFormat((TotalProventos - TotalDescontos)),
                Fgts 
            );
        }
    }
}
