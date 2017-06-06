using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraGamesCrescer.Api.Models
{
    public class RegistrarClienteModel
    {
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public string Cpf { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}