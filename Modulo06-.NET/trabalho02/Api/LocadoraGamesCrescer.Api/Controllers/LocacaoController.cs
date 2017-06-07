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
    [RoutePrefix("api/locacao"), BasicAuthorization(Roles = "Colaborador")]
    public class LocacaoController : ControllerBasica
    {
        readonly LocacaoRepositorio _locacaoRepositorio;

        public LocacaoController()
        {
            _locacaoRepositorio = new LocacaoRepositorio();
        }

        [HttpGet, Route("pacotes")]
        public IHttpActionResult ListarPacote()
        {
            return Ok( new { dados = _locacaoRepositorio.ListarPacotes() } );
        }

    }
}
