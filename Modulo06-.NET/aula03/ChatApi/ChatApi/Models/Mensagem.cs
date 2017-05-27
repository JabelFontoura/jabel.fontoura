using System;

namespace ChatApi.Models
{
    public class Mensagem
    {
        public string Texto { get; set; }
        public DateTime Data { get; set; }
        public Usuario Usuario { get; set; }

    }
}