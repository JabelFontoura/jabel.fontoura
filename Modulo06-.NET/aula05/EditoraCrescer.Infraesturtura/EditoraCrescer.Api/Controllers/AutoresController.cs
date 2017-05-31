using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorio;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Listar());
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }
    }
}
