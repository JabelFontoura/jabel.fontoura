
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class ExtraLocacao
    {
        public int Id { get; set; }
        public Locacao Locacao { get; set; }
        public Extra Extra { get; set; }
        public int Quantidade { get; set; }

        public ExtraLocacao()
        {

        }
    }
}
