using ChatApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace ChatApi.Controllers
{
    public class UsuarioController : ApiController
    {
        public static List<Usuario> Usuarios = new List<Usuario>()
        {
            new Usuario(){ Nome = "Jabel", Foto = "Foto", DataEntrada = DateTime.Now }
        };
        private static int Id = 1;
        private object locker = new object();

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null) return BadRequest("Usuário não informado");

            lock(locker)
            {
                usuario.Id = Id++;
                usuario.DataEntrada = DateTime.Now;
                Usuarios.Add(usuario);
            }

            return Ok();
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
