using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Mapping
{
    public class ExtraLocacaoMap : EntityTypeConfiguration<ExtraLocacao>
    {
        public ExtraLocacaoMap()
        {
            ToTable("ExtraLocacao");

            HasKey(x => x.Id);

            HasRequired(ep => ep.Extra);
            //.WithMany()
            //.Map(x => x.MapKey("IdExtra"));

            HasRequired(ep => ep.Locacao);
                //.WithMany()
                //.Map(x => x.MapKey("IdLocacao"));
        }
    }
}
