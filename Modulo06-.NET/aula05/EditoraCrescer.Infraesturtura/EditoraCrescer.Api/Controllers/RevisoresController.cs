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
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(new { dados = repositorio.Obter(id) });
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            return Ok(new { dados = repositorio.Criar(revisor) });
        }

        public IHttpActionResult Put(int id, Revisor revisor)
        {
            return Ok(repositorio.Alterar(id, revisor));
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok(new { mensagens = "Deletado com sucesso" });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
