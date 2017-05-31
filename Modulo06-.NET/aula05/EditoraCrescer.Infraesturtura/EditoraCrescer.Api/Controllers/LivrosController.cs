using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{ 
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();
        
        public IHttpActionResult Get()
        {
            return Ok(repositorio.Listar());
        }
        
        [Route("{isbn:int}")]
        public IHttpActionResult Get(int isbn)
        {
            return Ok(repositorio.Obter(isbn));
        }

        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            return Ok(repositorio.Obter(genero));
        }

        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(livro);
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            return Ok(repositorio.Alterar(isbn, livro));
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}