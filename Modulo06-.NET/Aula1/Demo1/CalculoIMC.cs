using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class CalculoIMC
    {
        public double Altura { get; set; }
        public double Peso { get; set; }

        public CalculoIMC(double altura, double peso)
        {
            this.Altura = altura;
            this.Peso= peso;
        }

        public double calcular()
        {
            return Peso / (Math.Pow(Altura, 2));
        }
    }
}
