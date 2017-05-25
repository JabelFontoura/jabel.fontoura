using System;
using System.Collections.Generic;
using System.Text;

namespace Exercicio3
{
    public class HorasCalculadas
    {
        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {
            QtdHoras = qtdHoras;
            ValorTotalHoras = valorTotalHoras;
        }
        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
}
