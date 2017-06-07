using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Repositorio
{
    public class ClienteRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }

        public void Alterar(Cliente cliente)
        {
            contexto.Entry(cliente).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Excluir(Cliente cliente)
        {
            contexto.Clientes.Remove(cliente);
            contexto.SaveChanges();
        }

        public IEnumerable<Cliente> Listar()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente Obter(int id)
        {
            return contexto.Clientes.Where(u => u.Id == id).FirstOrDefault();
        }

        public Cliente Obter(string cpf)
        {
            return contexto.Clientes.Where(u => u.Cpf == cpf).FirstOrDefault();
        }
    }
}
