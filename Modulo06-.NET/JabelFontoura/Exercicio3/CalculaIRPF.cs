using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    class CalculaIRPF : ICalcula
    {
        public double TotalProventos { get; set; }
        public Desconto Inss { get; set; }

        public CalculaIRPF(double totalProventos, Desconto inss)
        {
            TotalProventos = totalProventos;
            Inss = inss;
        }

        public Desconto calcular()
        {
            double aliquota = 0;

            if (TotalProventos <= 1710.78) return new Desconto(0, 0);
            else if (TotalProventos <= 2563.91) aliquota = 7.5;
            else if (TotalProventos <= 3418.59) aliquota = 15;
            else if (TotalProventos <= 4271.59) aliquota = 22.5;
            else aliquota = 27.5;

            return new Desconto(aliquota, ((TotalProventos - Inss.Valor) * aliquota) / 100);
        }
    }
}
