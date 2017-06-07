using Dominio.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Repositorio
{
    public class LocacaoRepositorio
    {
        private Contexto contexto = new Contexto();

        public dynamic ListarPacotes()
        {
            //return contexto.Database
            //    .SqlQuery<ListagemPacoteView>(
            //    @"SELECT 
            //            p.Nome as NomePacote, p.DiasDuracao, e.Nome, ep.Quantidade 
            //        FROM extra e  JOIN ExtraPacote ep 
            //            ON e.Id = ep.IdExtra
            //        JOIN Pacote p on p.Id = ep.IdPacote ");


            return null;
            //return contexto.
            //    ExtrasPacote
            //    .GroupBy(x => x.Pacote.Nome)
            //    .Select(g => new {
            //        Nome = g.Key,
            //        Duracao = g.FirstOrDefault().Pacote.DiasDuracao,
            //        Extras = g.Select(x => new { Nome = x.Extra.Nome, Quantidade = x.Quantidade })
            //    }).ToList();
        }
    }
}