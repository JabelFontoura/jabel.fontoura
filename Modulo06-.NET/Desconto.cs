using System;

namespace Exercicio3
{
    public class Desconto
    {
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
        }

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
