using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {
        public static int Id = 0;
        public static List<Heroi> herois =  new List<Heroi>()
            {
                new Heroi() { Id = Id++, Nome = "Goku", Poder = new Poder() { Nome = "Genki Dama", Dano = 3000 } },
                new Heroi() { Id = Id++, Nome = "Batman", Poder = new Poder() { Nome = "Dinheiro", Dano = 1000 } },
                new Heroi() { Id = Id++, Nome = "Iron Man", Poder = new Poder() { Nome = "Armadura", Dano = 3000 } }
             };

    public IEnumerable<Heroi> Get(string nome = null, int? id = null)
        {
            return herois
                    .Where(h => (id ==null || h.Id == id) &&
                                (nome == null || h.Nome == nome));
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if(heroi.Id == 0)
            {
                heroi.Id = Id++;
                herois.Add(heroi);
                return Ok();
            }

            return BadRequest();
        }
    }
}
