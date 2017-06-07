using EditoraCrescer.Api.App_Start;
using LocadoraGamesCrescer.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraGamesCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/produtos")]
    public class ProdutosController : ControllerBasica
    {
        readonly ProdutoRepositorio _repositorio;

        public ProdutosController()
        {
            _repositorio = new ProdutoRepositorio();
        }

        [HttpGet]
        public IHttpActionResult Listar()
        {
            return Ok(new { dados = _repositorio.Listar() });
        }

        [HttpGet]
        public IHttpActionResult Obter(int id)
        {
            return Ok(new { dados = _repositorio.Obter(id) });
        }

        [HttpPut, Route("alugar/{id:int}"), BasicAuthorization(Roles = "Colaborador")]
        public HttpResponseMessage Alugar(int Id)
        {
            var produto = _repositorio.Obter(Id);

            if (produto.Validar())
                return ResponderErro(produto.Mensagens);

            return ResponderOK(new { dados = _repositorio.Alugar(produto) });
        }

        [HttpPut, Route("devolver/{id:int}"), BasicAuthorization(Roles = "Colaborador")]
        public HttpResponseMessage Devolver(int id)
        {
            var produto = _repositorio.Obter(id);

            return ResponderOK(new { dados = _repositorio.Devolver(produto) });
        }
    }
}
