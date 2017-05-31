using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public class AutorRepositorio : IRepositorio<Autor>, IDisposable
    {
        private Contexto contexto = new Contexto();
        private RevisorRepositorio revisorRepositorio = new RevisorRepositorio();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public Autor Obter(int id)
        {
            return contexto.Autores.Where(a => a.Id == id).FirstOrDefault();
        }

        public Autor Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();

            return autor;
        }

        public List<Livro> ObterLivros(int id)
        {
            var livros = contexto.Livros.Where(l => l.IdAutor == id).ToList();

            livros.ForEach(l => {
                l.Autor = Obter(l.IdAutor);
                l.Revisor = revisorRepositorio.Obter(l.IdRevisor);
            });

            return livros;
        }

        public void Deletar(int id)
        {
            contexto.Autores.Remove(contexto.Autores.Where(l => l.Id == id).FirstOrDefault());
            contexto.SaveChanges();
        }

        public Autor Alterar(int id, Autor autor)
        {
            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
