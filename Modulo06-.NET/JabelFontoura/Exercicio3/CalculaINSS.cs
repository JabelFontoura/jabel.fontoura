using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    class CalculaINSS : ICalcula
    {
        public Desconto calcular(double totalProventos)
        {
            var aliquota = 0D;

            if (totalProventos <= 1000) aliquota = 0.08;
            else if (totalProventos <= 1500) aliquota = 0.09;
            else aliquota = 0.1;
            return new Desconto(aliquota, Utils.DoFormat((totalProventos * aliquota)));

            throw new NotImplementedException();
        }

    }
}
