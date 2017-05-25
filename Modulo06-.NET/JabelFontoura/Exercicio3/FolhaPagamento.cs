using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    public class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            var valorHora = salarioBase / horasCategoria;
            var hExtras = new HorasCalculadas(horasExtras, valorHora * horasExtras);
            var hDescontadas = new HorasCalculadas(horasDescontadas, valorHora * horasDescontadas);
            var totalProventos = (salarioBase + hExtras.ValorTotalHoras - hDescontadas.ValorTotalHoras);
            var inss = new CalculaINSS(totalProventos).calcular();
            var irpf = new CalculaIRPF(totalProventos, inss).calcular();
            var totalDescontos = inss.Valor + irpf.Valor;
            var aliquotaFgts = 11;
            var fgts = new Desconto(aliquotaFgts, (totalProventos * aliquotaFgts) / 100);

            return new Demonstrativo(
                salarioBase, 
                horasCategoria, 
                hExtras, 
                hDescontadas,
                totalProventos, 
                inss, 
                irpf,
                totalDescontos,
                (totalProventos - totalDescontos),
                fgts 
            );
        }


    }
}
