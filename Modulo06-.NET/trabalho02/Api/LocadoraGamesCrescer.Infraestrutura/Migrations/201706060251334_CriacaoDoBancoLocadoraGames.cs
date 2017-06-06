namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBancoLocadoraGames : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Endereco = c.String(),
                        Cpf = c.String(),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Extra",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdCliente = c.Int(nullable: false),
                        IdUsuario = c.Int(nullable: false),
                        IdProduto = c.Int(nullable: false),
                        DataEntrega = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(nullable: false),
                        DataPedido = c.DateTime(nullable: false),
                        ValorPrevisto = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorFinal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ExtrasPacote_IdExtra = c.Int(),
                        ExtrasPacote_IdPacote = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.ExtraPacotes", t => new { t.ExtrasPacote_IdExtra, t.ExtrasPacote_IdPacote })
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdProduto)
                .Index(t => new { t.ExtrasPacote_IdExtra, t.ExtrasPacote_IdPacote });
            
            CreateTable(
                "dbo.ExtraPacotes",
                c => new
                    {
                        IdExtra = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdExtra, t.IdPacote })
                .ForeignKey("dbo.Extra", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdExtra, cascadeDelete: true)
                .Index(t => t.IdExtra)
                .Index(t => t.IdPacote);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        DiasDuracao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                        Cargo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ExtraLocacao",
                c => new
                    {
                        IdExtra = c.Int(nullable: false),
                        IdLocacao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdExtra, t.IdLocacao })
                .ForeignKey("dbo.Extra", t => t.IdExtra, cascadeDelete: true)
                .ForeignKey("dbo.Locacao", t => t.IdLocacao, cascadeDelete: true)
                .Index(t => t.IdExtra)
                .Index(t => t.IdLocacao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ExtraLocacao", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.ExtraLocacao", "IdExtra", "dbo.Extra");
            DropForeignKey("dbo.Locacao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Locacao", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Locacao", new[] { "ExtrasPacote_IdExtra", "ExtrasPacote_IdPacote" }, "dbo.ExtraPacotes");
            DropForeignKey("dbo.ExtraPacotes", "IdExtra", "dbo.Pacote");
            DropForeignKey("dbo.ExtraPacotes", "IdPacote", "dbo.Extra");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.ExtraLocacao", new[] { "IdLocacao" });
            DropIndex("dbo.ExtraLocacao", new[] { "IdExtra" });
            DropIndex("dbo.ExtraPacotes", new[] { "IdPacote" });
            DropIndex("dbo.ExtraPacotes", new[] { "IdExtra" });
            DropIndex("dbo.Locacao", new[] { "ExtrasPacote_IdExtra", "ExtrasPacote_IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdProduto" });
            DropIndex("dbo.Locacao", new[] { "IdUsuario" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.ExtraLocacao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.ExtraPacotes");
            DropTable("dbo.Locacao");
            DropTable("dbo.Extra");
            DropTable("dbo.Cliente");
        }
    }
}
