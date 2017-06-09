using Dominio.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio.Entidades;

namespace LocadoraGamesCrescer.Infraestrutura.Repositorio
{
    public class LocacaoRepositorio
    {
        private Contexto contexto = new Contexto();

        public dynamic ListarPacotes()
        {
            return contexto.Database
                .SqlQuery<ListagemPacoteView>(
                @"SELECT p.Id AS IdPacote, p.Nome as NomePacote, p.DiasDuracao, e.Nome AS NomeExtra, e.Id AS IdExtra, e.Valor, ep.Quantidade 
                    FROM extra e  JOIN ExtraPacote ep ON e.Id = ep.IdExtra
                    JOIN Pacote p on p.Id = ep.IdPacote ")
                    .GroupBy(x => x.IdPacote)
                    .Select(e => new {
                        IdPacote = e.FirstOrDefault().IdPacote,
                        Nome = e.FirstOrDefault().NomePacote,
                        DiasDuracao = e.FirstOrDefault().DiasDuracao,
                        Extra = e.Select(x => new {
                            IdExtra = x.IdExtra,
                            Nome = x.NomeExtra,
                            Quantidade = x.Quantidade,
                            Valor = x.Valor
                        }) 
                    });

            //return contexto.
            //    ExtrasPacote
            //    .GroupBy(x => new { x.Pacote })
            //    .Select(g => new {
            //        Nome = g.Key.Pacote.Nome,
            //        Duracao = g.FirstOrDefault().Pacote.DiasDuracao,
            //        Extras = g.Select(x => new { Nome = x.Extra.Nome, Quantidade = x.Quantidade })
            //    }).ToList();
        }

        public Locacao Criar(Locacao locacao)
        {
            locacao.DataPedido = DateTime.Now;
            contexto.Entry(locacao.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.Produto).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(locacao.ExtrasPacote.Pacote).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();

            return locacao;
        }

        public List<Locacao> Listar()
        {
            return contexto.Locacoes.ToList();
        }

        public Extra ObterExtra(int id)
        {
            return contexto.Extras.FirstOrDefault(x => x.Id == id);
        }

        public Pacote ObterPacote(int id)
        {
            return contexto.Pacotes.FirstOrDefault(x => x.Id == id);
        }

    }
}