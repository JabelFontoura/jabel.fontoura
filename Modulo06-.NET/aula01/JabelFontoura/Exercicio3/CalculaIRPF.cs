using System;

namespace Exercicio3
{
    class CalculaIRPF : ICalcula
    {

        public Desconto calcular(double valor)
        {
            double aliquota = 0;

            if (valor <= 1710.78) return new Desconto(0, 0);
            else if (valor <= 2563.91) aliquota = 0.075;
            else if (valor <= 3418.59) aliquota = 0.15;
            else if (valor <= 4271.59) aliquota = 0.225;
            else aliquota = 0.275;

            return new Desconto(aliquota, Utils.DoFormat(valor * aliquota));
        }
    }
}
