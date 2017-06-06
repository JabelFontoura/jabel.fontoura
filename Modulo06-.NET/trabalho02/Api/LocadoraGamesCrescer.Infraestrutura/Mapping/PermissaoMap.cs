using LocadoraGamesCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura.Mapping
{
    public class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");
        }
    }
}
