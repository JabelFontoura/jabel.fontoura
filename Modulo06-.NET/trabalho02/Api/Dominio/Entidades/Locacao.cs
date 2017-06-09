using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Locacao
    {
        private Cliente cliente;
        private Produto produto;
        private ExtraPacote extraPacote;

        public int Id { get; set; }
        public Cliente Cliente { get; set; }
        public Usuario Usuario { get; set; }
        public Produto Produto { get; set; }
        public ExtraPacote ExtrasPacote { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public DateTime DataPedido { get; set; }
        public decimal ValorPrevisto { get; set; }
        public decimal? ValorFinal { get; set; }

        public Locacao()
        {

        }

        public Locacao(Cliente cliente, Usuario usuario, Produto produto, DateTime dataEntrega, DateTime dataPedido, ExtraPacote extraPacote, decimal valorPrevisto)
        {
            Cliente = cliente;
            Produto = produto;
            DataEntrega = dataEntrega;
            DataPedido = dataPedido;
            ExtrasPacote = extraPacote;
            ValorPrevisto = valorPrevisto;
            Usuario = usuario;
        }
    }
}
