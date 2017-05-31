using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public class RevisorRepositorio : IRepositorio<Revisor>, IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor Obter(int id)
        {
            return contexto.Revisores.Where(a => a.Id == id).FirstOrDefault();
        }

        public Revisor Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();

            return revisor;
        }

        public void Deletar(int id)
        {
            contexto.Revisores.Remove(contexto.Revisores.Where(l => l.Id == id).FirstOrDefault());
            contexto.SaveChanges();
        }

        public Revisor Alterar(int id, Revisor revisor)
        {
            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
