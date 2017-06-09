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
    [RoutePrefix("api/extras"), BasicAuthorization(Roles = "Colaborador")]
    public class ExtrasController : ControllerBasica
    {
        private ExtraRepositorio _repositorio;

        public ExtrasController()
        {
            _repositorio = new ExtraRepositorio();
        }

        public HttpResponseMessage Get(int id)
        {
            return ResponderOK(_repositorio.Obter(id));
        }

        [HttpGet, Route("disponiveis")]
        public HttpResponseMessage ListaDisponiveis()
        {
            return ResponderOK(_repositorio.ListarDisponiveis());
        }
    }
}
