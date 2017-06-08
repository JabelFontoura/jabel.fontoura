using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Extra : EntidadeBasica
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Valor { get; set; }
        public int Quantidade { get; set; }
        //public virtual List<ExtraPacote> Pacotes { get; set; }
        //public virtual List<Locacao> Locacao { get; set; }

        public Extra()
        { }

        public void Alugar(int quantidade)
        {
            Quantidade -= quantidade;
        }

        public void Devolver(int quantidade)
        {
            Quantidade += quantidade;
        }

        public bool Validar(int quantidade)
        {
            Mensagens.Clear();

            if (Quantidade <= 0)
                Mensagens.Add("Não possui opcionais suficientes para alugar");

            return Quantidade > 0 && Quantidade >= quantidade;
        }

        public override bool Validar()
        {
            throw new NotImplementedException();
        }
    }
}
