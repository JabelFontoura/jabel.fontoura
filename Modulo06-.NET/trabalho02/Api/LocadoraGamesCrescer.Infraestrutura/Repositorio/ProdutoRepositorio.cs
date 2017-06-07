using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Repositorio
{
    public class ProdutoRepositorio
    {
        private Contexto contexto = new Contexto();

        public IEnumerable<Produto> Listar()
        {
            return contexto.Produtos.ToList();
        }

        public Produto Obter(int id)
        {
            return contexto.Produtos.Where(u => u.Id == id).FirstOrDefault();
        }

        public Produto Alugar(Produto produto)
        {
            produto.Alugar();

            contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return produto;
        }

        public Produto Devolver(Produto produto)
        {
            produto.Devolver();

            contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();

            return produto;
        }
    }
}
