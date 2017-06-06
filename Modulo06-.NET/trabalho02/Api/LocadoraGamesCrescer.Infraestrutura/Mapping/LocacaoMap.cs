using Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Mapping
{
    public class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));

            HasRequired(x => x.Usuario)
                .WithMany()
                .Map(x => x.MapKey("IdUsuario"));
            
            HasRequired(x => x.Produto)
                .WithMany()
                .Map(x => x.MapKey("IdProduto"));

            HasOptional(x => x.ExtrasPacote)
                .WithMany()
                .Map(x => x.MapKey("IdExtraPacote"));

            //HasOptional(x => x.ExtrasPacote)
            //    .WithMany()
            //    .HasForeignKey(x => x.IdExtraPacote);
        }
    }
}
