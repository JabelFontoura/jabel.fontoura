using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorio;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(new { dados = repositorio.Listar() });
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(new { dados = repositorio.Obter(id) });
        }

        [HttpGet]
        [Route("{id}/livros")]
        public IHttpActionResult GetLivros(int id)
        {
            return Ok(new { dados = repositorio.ObterLivros(id) });
        }

        public IHttpActionResult Post(Autor autor)
        {
            
            return Ok(new { dados = repositorio.Criar(autor) });
        }

        public IHttpActionResult Put(int id, Autor autor)
        {
            return Ok(new { dados = repositorio.Alterar(id, autor) });
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
