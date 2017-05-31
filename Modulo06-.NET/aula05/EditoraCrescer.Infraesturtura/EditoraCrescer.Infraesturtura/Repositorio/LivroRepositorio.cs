using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();
        private AutorRepositorio autorRepositorio = new AutorRepositorio();
        private RevisorRepositorio revisorRepositorio = new RevisorRepositorio();

        public List<Livro> Listar()
        {
            var livros = contexto.Livros.ToList();

            livros.ForEach(l => {
                    l.Autor = autorRepositorio.Obter(l.IdAutor);
                    l.Revisor = revisorRepositorio.Obter(l.IdRevisor);
                });

             return livros;
        }

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            contexto.Livros.Remove(contexto.Livros.Where(l => l.Isbn == id).FirstOrDefault());
            contexto.SaveChanges();
        }
    }
}
