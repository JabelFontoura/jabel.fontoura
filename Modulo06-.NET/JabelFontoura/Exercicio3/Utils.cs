using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    class Utils
    {

        public static double DoFormat(double valor)
        {
            return Math.Truncate(valor * 100) / 100;
        }
    }
}
