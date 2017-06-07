using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Produto : EntidadeBasica
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Valor { get; set; }
        public int Quantidade { get; set; }

        public Produto()
        { }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (Quantidade <= 0)
                Mensagens.Add("Não possui produtos suficientes para alugar");

            return Quantidade > 0;
        }

        public void Alugar()
        {
            Quantidade--;
        }

        public void Devolver()
        {
            Quantidade++;
        }
    }
}
