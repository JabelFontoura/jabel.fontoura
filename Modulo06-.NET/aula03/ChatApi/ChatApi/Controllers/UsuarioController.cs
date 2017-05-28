using ChatApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web.Http;

namespace ChatApi.Controllers
{
    public class UsuarioController : ApiController
    {
        public static List<Usuario> Usuarios = new List<Usuario>();
        private static int Id = 1;
        private object locker = new object();

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null) return BadRequest("Usuário não informado");

            Regex rgx = new Regex(@"(nunes)", RegexOptions.IgnoreCase);

            usuario.Nome = rgx.Replace(usuario.Nome, "$$$$$$ $1 $$$$$$");

            lock(locker)
            {
                usuario.Id = Id++;
                usuario.DataEntrada = DateTime.Now;
                Usuarios.Add(usuario);
            }

            return Ok(usuario);
        }

        public IEnumerable<Usuario> Get()
        {
            return Usuarios;
        }

        public IEnumerable<Usuario> Get(int id)
        {
            return Usuarios.Where(u => u.Id == id);
        }
    }
}
