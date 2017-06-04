using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public class LivroRepositorio : IRepositorio<Livro>, IDisposable
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

        public object ListarResumo()
        {
            return contexto.Livros.Select(l => new {
               Isbn = l.Isbn,
               Titulo = l.Titulo,
               Capa = l.Capa,
               NomeAutor = l.Autor.Nome,
               Genero = l.Genero
            }).ToList();
        }

        public object ListarResumo(int quantidadePular, int quantidadeTrazer)
        {
            return contexto.Livros
                .OrderBy(l => l.Isbn)
                .Skip(quantidadePular)
                .Take(quantidadeTrazer)
                .Select(l => new {
                    Isbn = l.Isbn,
                    Titulo = l.Titulo,
                    Capa = l.Capa,
                    NomeAutor = l.Autor.Nome,
                    Genero = l.Genero
                }).ToList();
        }

        public object ObterQuantidadeLivros()
        {
            return contexto.Livros.Count();   
        }

        public Livro Obter(int isbn)
        {
            var livro = contexto.Livros.FirstOrDefault(l => l.Isbn == isbn);

            livro.Autor = autorRepositorio.Obter(livro.IdAutor);
            livro.Revisor = revisorRepositorio.Obter(livro.IdRevisor);

            return livro;
        }

        public object ObterResumoLancamentos(int quantidadePular, int quantidadeTrazer)
        {
            var data = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(l => (l.DataPublicacao > data))
                .OrderBy(l => l.Isbn)
                .Skip(quantidadePular)
                .Take(quantidadeTrazer)
                .Select(l => new {
                    Isbn = l.Isbn,
                    Titulo = l.Titulo,
                    Capa = l.Capa,
                    NomeAutor = l.Autor.Nome,
                    Genero = l.Genero
                })
                .ToList();
        }

        public object Obter(string genero)
        {
            var livro = contexto.Livros.FirstOrDefault(l => l.Genero.Contains(genero));

            livro.Autor = autorRepositorio.Obter(livro.IdAutor);
            livro.Revisor = revisorRepositorio.Obter(livro.IdRevisor);

            return livro;
        }

        public object ObterResumo(string genero)
        {
            return contexto.Livros.Where(l => l.Genero.Contains(genero)).Select(l => new {
                Isbn = l.Isbn,
                Titulo = l.Titulo,
                Capa = l.Capa,
                NomeAutor = l.Autor.Nome,
                Genero = l.Genero
            }).ToList();
        }

        public Livro Alterar(int isbn, Livro livro)
        {
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return Obter(isbn);
        }

        public Livro Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();

            return livro;
        }

        public void Deletar(int id)
        {
            contexto.Livros.Remove(contexto.Livros.Where(l => l.Isbn == id).FirstOrDefault());
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
