using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraGamesCrescer.Api.Models
{
    public class RegistrarLocacaoModel
    {
        public int IdCliente { get; set; }
        public int IdPacote { get; set; }
        public int IdExtra { get; set; }
        public string EmailUsuario { get; set; }
        public Produto Produto { get; set; }
        public ExtraPacote ExtraPacote { get; set; }
        public DateTime DataEntrega { get; set; }
        public DateTime? DataDevolucao { get; set; }
        public DateTime DataPedido { get; set; }
        public decimal ValorPrevisto { get; set; }
    }
}