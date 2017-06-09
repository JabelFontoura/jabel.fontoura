using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Repositorio
{
    public class ExtraRepositorio
    {
        private Contexto contexto = new Contexto();

        public IEnumerable<Extra> Listar()
        {
            return contexto.Extras.ToList();
        }

        public Extra Obter(int id)
        {
            return contexto.Extras.Where(u => u.Id == id).FirstOrDefault();
        }

        public Extra Alugar(Extra extra, int quantidade)
        {
            extra.Alugar(quantidade);

            contexto.Entry(extra).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return extra;
        }

        public Extra Devolver(Extra extra, int quantidade)
        {
            extra.Devolver(quantidade);

            contexto.Entry(extra).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return extra;
        }

        public List<Extra> ListarDisponiveis()
        {
            return contexto.Extras.Where(x => x.Quantidade > 0).ToList();
        }
    }
}
