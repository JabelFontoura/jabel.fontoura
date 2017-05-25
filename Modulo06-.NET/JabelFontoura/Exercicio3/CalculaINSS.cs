using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    class CalculaINSS : ICalcula
    {
        public double TotalProventos { get; set; }

        public CalculaINSS(double totalProventos)
        {
            TotalProventos = totalProventos;
        }

        public Desconto calcular()
        {
            var aliquota = 0D;

            if (TotalProventos <= 1000) aliquota = 0.08;
            else if (TotalProventos <= 1500) aliquota = 0.09;
            else aliquota = 0.1;
            return new Desconto(aliquota, (TotalProventos * aliquota));

            throw new NotImplementedException();
        }
    }
}
