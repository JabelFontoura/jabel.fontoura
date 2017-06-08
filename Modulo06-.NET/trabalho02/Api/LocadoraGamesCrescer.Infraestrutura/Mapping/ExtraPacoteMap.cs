using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Mapping
{
    public class ExtraPacoteMap : EntityTypeConfiguration<ExtraPacote>
    {
        public ExtraPacoteMap()
        {
            ToTable("ExtraPacote");
            HasKey(ep => ep.Id);

            HasRequired(ep => ep.Extra)
                .WithMany()
                .Map(ep => ep.MapKey("IdPacote"));

            HasRequired(ep => ep.Pacote)
                .WithMany()
                .Map(ep => ep.MapKey("IdExtra"));

        }
    }
}
