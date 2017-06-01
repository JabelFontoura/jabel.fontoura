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
            //return Ok(new { dados = repositorio.Listar() });
            return Ok(new { dados = repositorio.ListarResumo() });
        }
        
        [Route("{isbn:int}")]
        public IHttpActionResult Get(int isbn)
        {
            return Ok(new { dados = repositorio.Obter(isbn) });
        }

        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            //return Ok(new { dados = repositorio.Obter(genero) });
            return Ok(new { dados = repositorio.ObterResumo(genero) });
        }


        [HttpGet][Route("lancamentos")]
        public IHttpActionResult GetLancamentos()
        {
            return Ok(new { dados = repositorio.ObterResumoLancamentos() });
        }

        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            return Ok(new { dados = repositorio.Alterar(isbn, livro) });
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Delete(int isbn)
        {
            repositorio.Deletar(isbn);
            return Ok(new { mensagens = "Deletado com sucesso"});
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}