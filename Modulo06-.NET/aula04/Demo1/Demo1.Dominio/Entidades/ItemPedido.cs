using System;
using System.Linq;
using System.Collections.Generic;

namespace Demo1.Dominio.Entidades
{
    public class ItemPedido
    {
        public int Id { get; set; }
        public int ProdutoId { get; set; }
        public int Quantidade { get; set; }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (Quantidade < 1)
                mensagens.Add("A quantidade dever ser maior ou igual a 1");

            return mensagens.Count() == 0;
        }
    }
}