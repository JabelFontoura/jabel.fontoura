using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(Usuario usuario)
        {
            contexto.Add(usuario);
        }

        public void Alterar(Usuario usuario)
        {12
            contexto[usuario.Email] = usuario;
        }
        public void Excluir(Usuario usuario)
        {
            contexto[usuario.Email] = usuario;
        }

        public IEnumerable<Usuario> Listar()
        {
            return contexto.Select(u => u.Value);
        }

        public Usuario Obter(string email)
        {
            return contexto.Where(u => u.Key == email).Select(u => u.Value).FirstOrDefault();
        }
    }
}