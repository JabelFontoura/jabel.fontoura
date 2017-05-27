using System;

namespace ChatApi.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Foto { get; set; }
        public DateTime DataEntrada { get; set; }
    }
}