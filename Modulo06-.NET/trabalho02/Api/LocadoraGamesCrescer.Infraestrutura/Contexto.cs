using Dominio.Entidades;
using LocadoraGamesCrescer.Infraestrutura.Mapping;
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

            //modelBuilder.Entity<Extra>()
            //    .HasMany<Pacote>(e => e.Pacotes)
            //    .WithMany(p => p.Extras)
            //    .Map(cs =>
            //    {
            //        cs.MapLeftKey("IdExtra");
            //        cs.MapRightKey("IdPacote");
            //        cs.ToTable("ExtraPacote");
            //    });


            modelBuilder.Entity<ExtraPacote>().HasKey(ep => new { ep.IdExtra, ep.IdPacote});

            modelBuilder.Entity<ExtraPacote>().HasRequired(ep => ep.Extra).WithMany(p => p.Pacotes).HasForeignKey(ep => ep.IdPacote);

            modelBuilder.Entity<ExtraPacote>().HasRequired(ep => ep.Pacote).WithMany(c => c.Extras).HasForeignKey(ep => ep.IdExtra);

            modelBuilder.Entity<Extra>()
                .HasMany<Locacao>(e => e.Locacao)
                .WithMany(p => p.Extras)
                .Map(el =>
                {
                    el.MapLeftKey("IdExtra");
                    el.MapRightKey("IdLocacao");
                    el.ToTable("ExtraLocacao");
                });

        }
    }
}
