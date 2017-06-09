using Dominio.Entidades;
using EditoraCrescer.Api.App_Start;
using LocadoraGamesCrescer.Api.Models;
using LocadoraGamesCrescer.Infraestrutura.Repositorio;
using LocadoraGamesCrescer.Infraesturtura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraGamesCrescer.Api.Controllers
{
    [RoutePrefix("api/locacao"), BasicAuthorization(Roles = "Colaborador")]
    public class LocacaoController : ControllerBasica
    {
        readonly LocacaoRepositorio _locacaoRepositorio;
        readonly ClienteRepositorio _clienteRepositiorio;
        readonly UsuarioRepositorio _usuarioRepositorio;
        readonly ExtraRepositorio _extraRepositorio;


        public LocacaoController()
        {
            _locacaoRepositorio = new LocacaoRepositorio();
            _clienteRepositiorio = new ClienteRepositorio();
            _usuarioRepositorio = new UsuarioRepositorio();
            _extraRepositorio = new ExtraRepositorio();

        }

        public HttpResponseMessage Get()
        {
            return ResponderOK(_locacaoRepositorio.Listar());
        }

        [HttpGet, Route("pacotes")]
        public IHttpActionResult ListarPacote()
        {
            return Ok( new { dados = _locacaoRepositorio.ListarPacotes() } );
        }

        [HttpPost, Route("registrar")]
        public HttpResponseMessage CriarLocacao([FromBody]RegistrarLocacaoModel model)
        {
            var cliente = _clienteRepositiorio.Obter(model.IdCliente);
            var usuario = _usuarioRepositorio.Obter(model.EmailUsuario);

            model.ExtraPacote.Pacote = _locacaoRepositorio.ObterPacote(model.IdPacote);
            model.ExtraPacote.Extra = _extraRepositorio.Obter(model.IdExtra);

            var locacao = new Locacao(cliente, usuario, model.Produto, model.DataEntrega, model.DataPedido, model.ExtraPacote, model.ValorPrevisto);

            return ResponderOK( _locacaoRepositorio.Criar(locacao));
        }
    }
}
