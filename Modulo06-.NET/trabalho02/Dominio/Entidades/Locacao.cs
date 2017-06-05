using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public Usuario Usuario { get; set; }
        public Produto Produto { get; set; }
        public List<Extras> Extras { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime DataDevolucao { get; set; }
        public DateTime DataPedido { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal ValorFinal { get; set; }
    }
}
