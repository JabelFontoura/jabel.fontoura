using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Views
{
    public class ListagemPacoteView
    {
        public int IdPacote { get; set; }
        public string NomePacote { get; set; }
        public int DiasDuracao { get; set; }
        public string NomeExtra { get; set; }
        public int Quantidade { get; set; }
    }
}
