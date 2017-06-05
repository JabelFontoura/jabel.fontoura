using EditoraCrescer.Api.App_Start;
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
        
        //[BasicAuthorization]
        public IHttpActionResult Get()
        {
            //return Ok(new { dados = repositorio.Listar() });
            return Ok(new { dados = repositorio.ListarResumo() });
        }
        
        [HttpGet]
        public IHttpActionResult GetPorQuantidade(int quantidadePular, int quantidadeTrazer)
        {
            return Ok(new { dados = repositorio.ListarResumo(quantidadePular, quantidadeTrazer) });
        }

        [HttpGet]
        [Route("quantidadetotal")]
        public IHttpActionResult ObterQuantidadeLivrosPublicadosExcetoLancamentos()
        {
            return Ok(new { dados = repositorio.ObterQuantidadeLivros() });
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
        public IHttpActionResult GetLancamentos(int quantidadePular, int quantidadeTrazer)
        {
            return Ok(new { dados = repositorio.ObterResumoLancamentos(quantidadePular, quantidadeTrazer) });
        }

        [HttpGet, Route("revisao")]
        public IHttpActionResult GetLivrosSemRevisao()
        {
            return Ok(new { dados = repositorio.ObterResumoSemRevisao() });
        }

        [HttpGet, Route("revisados")]
        public IHttpActionResult GetLivrosRevisados()
        {
            return Ok(new { dados = repositorio.ObterResumoComRevisao() });
        }

        [BasicAuthorization(Roles = "Administrador, Publicador, Colaborador")]
        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        [BasicAuthorization(Roles = "Administrador, Colaborador")]
        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            return Ok(new { dados = repositorio.Alterar(isbn, livro) });
        }

        [BasicAuthorization(Roles = "Administrador, Revisor")]
        [HttpPut, Route("revisar/{isbn:int}")]
        public IHttpActionResult RevisarLivro(int isbn, Livro livro)
        {
            return Ok(new { dados = repositorio.Alterar(isbn, livro) });
        }

        [BasicAuthorization(Roles = "Administrador, Publicador")]
        [HttpPut, Route("publicar/{isbn:int}")]
        public IHttpActionResult PublicarLivro(int isbn, Livro livro)
        {
            if (livro.IdRevisor == null || livro.DataRevisao == null)
                return BadRequest("Um livro só pode ser publicado se estiver revisado");

            if(livro.ValidarDataPublicacao())
                return BadRequest("Um livro não pode ser publicado no fim de semana");

            return Ok(new { dados = repositorio.Alterar(isbn, livro) });
        }

        [BasicAuthorization(Roles = "Administrador, Publicador, Colaborador")]
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