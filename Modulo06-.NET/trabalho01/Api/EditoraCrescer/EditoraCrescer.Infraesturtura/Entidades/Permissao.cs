using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }
        public int Id { get; set; }

        public Permissao()
        { }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
