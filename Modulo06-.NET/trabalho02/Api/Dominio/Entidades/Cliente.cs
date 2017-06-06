using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Cliente : EntidadeBasica
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public string Cpf { get; set; }
        public Genero Genero { get; set; }
        public DateTime DataNascimento { get; set; }

        public Cliente()
        { }

        public Cliente(string nome, string endereco, string cpf, Genero genero, DateTime dataNascimento)
        {
            Nome = nome;
            Endereco = endereco;
            Cpf = cpf;
            Genero = genero;
            DataNascimento = dataNascimento;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
