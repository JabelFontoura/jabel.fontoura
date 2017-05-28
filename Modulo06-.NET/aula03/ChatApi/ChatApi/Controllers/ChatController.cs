using ChatApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Web.Http;

namespace ChatApi.Controllers
{
    public class ChatController : ApiController
    {
        public static List<Mensagem> Mensagens = new List<Mensagem>();
        private object locker = new object();

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null) return BadRequest("Mensagem não informado");

            Regex rgx = new Regex(@"(nunes)", RegexOptions.IgnoreCase);

            mensagem.Texto = rgx.Replace(mensagem.Texto, "$$$$$$ $1 $$$$$$");

            lock (locker)
            {
                mensagem.Data = DateTime.Now;
                Mensagens.Add(mensagem);
            }

            return Ok();
        }

        public IEnumerable<Mensagem> Get()
        {
            return Mensagens;
        }

    }
}
