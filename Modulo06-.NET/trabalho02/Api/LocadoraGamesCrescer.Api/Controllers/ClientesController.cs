using Dominio.Entidades;
using EditoraCrescer.Api.App_Start;
using LocadoraGamesCrescer.Api.Models;
using LocadoraGamesCrescer.Infraestrutura.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace LocadoraGamesCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/clientes")]
    public class ClientesController : ControllerBasica
    {
        readonly ClienteRepositorio _clientesRepositorio;

        public ClientesController()
        {
            _clientesRepositorio = new ClienteRepositorio();
        }

        [HttpGet, BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult Listar()
        {
            return Ok(new { dados =_clientesRepositorio.Listar() });
        }

        [HttpGet, BasicAuthorization(Roles = "Colaborador")]
        public IHttpActionResult Obter(int id)
        {
            return Ok(new { dados =_clientesRepositorio.Obter(id)});
        }

        [HttpPost, Route("registrar"), BasicAuthorization(Roles = "Colaborador")]
        public HttpResponseMessage Registrar([FromBody]RegistrarClienteModel model)
        {
            if (_clientesRepositorio.Obter(model.Cpf) == null)
            {
                var cliente = new Cliente(model.Nome, model.Endereco, model.Cpf, model.Genero, model.DataNascimento);

                if (cliente.Validar())
                {
                    _clientesRepositorio.Criar(cliente);
                }
                else
                {
                    return ResponderErro(cliente.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Usuário já existe.");
            }

            return ResponderOK();
        }
       
    }
}
