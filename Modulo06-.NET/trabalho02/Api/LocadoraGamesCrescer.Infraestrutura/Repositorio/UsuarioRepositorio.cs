using Dominio.Entidades;
using LocadoraGamesCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace LocadoraGamesCrescer.Infraesturtura.Repositorio
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public void Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }
        public void Excluir(Usuario usuario)
        {
            contexto.Usuarios.Remove(usuario);
            contexto.SaveChanges();
        }

        public IEnumerable<Usuario> Listar()
        {
            return contexto.Usuarios.ToList();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.Where(u => u.Email == email).Include(u => u.Permissoes).FirstOrDefault();
        }
    }
}