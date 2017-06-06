using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public int DiasDuracao { get; set; }
        public virtual List<ExtraPacote> Extras { get; set; }

        public Pacote()
        { }
    }
}
