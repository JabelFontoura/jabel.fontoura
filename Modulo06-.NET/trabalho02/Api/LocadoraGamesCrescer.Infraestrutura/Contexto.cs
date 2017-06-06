using Dominio.Entidades;
using LocadoraGamesCrescer.Infraestrutura.Mapping;
using LocadoraGamesCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraGamesCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Extra> Extras { get; set; }
        public DbSet<Locacao> Locacoes { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }
        public DbSet<ExtraPacote> ExtrasPacote { get; set; }
        public DbSet<ExtraLocacao> ExtrasLocacao{ get; set; }

        public Contexto() : base("name=LocadoraGames")
        { }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new ExtraMap());
            modelBuilder.Configurations.Add(new LocacaoMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new ExtraPacoteMap());
            modelBuilder.Configurations.Add(new ExtraLocacaoMap());

            //modelBuilder.Entity<Extra>()
            //    .HasMany<Locacao>(e => e.Locacao)
            //    .WithMany(p => p.Extras)
            //    .Map(el =>
            //    {
            //        el.MapLeftKey("IdExtra");
            //        el.MapRightKey("IdLocacao");
            //        el.ToTable("ExtraLocacao");
            //    });
        }
    }
}
