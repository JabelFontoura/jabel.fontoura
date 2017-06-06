namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
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
                        DataEntrega = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(nullable: false),
                        DataPedido = c.DateTime(nullable: false),
                        ValorPrevisto = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorFinal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        ExtrasPacote_Id = c.Int(),
                        IdProduto = c.Int(nullable: false),
                        IdUsuario = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.ExtraPacote", t => t.ExtrasPacote_Id)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.ExtrasPacote_Id)
                .Index(t => t.IdProduto)
                .Index(t => t.IdUsuario);
            
            CreateTable(
                "dbo.ExtraPacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdPacote = c.Int(nullable: false),
                        IdExtra = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Extra", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdExtra, cascadeDelete: true)
                .Index(t => t.IdPacote)
                .Index(t => t.IdExtra);
            
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
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissaos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ExtraLocacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        Extra_Id = c.Int(nullable: false),
                        Locacao_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Extra", t => t.Extra_Id, cascadeDelete: true)
                .ForeignKey("dbo.Locacao", t => t.Locacao_Id, cascadeDelete: true)
                .Index(t => t.Extra_Id)
                .Index(t => t.Locacao_Id);
            
            CreateTable(
                "dbo.LocacaoExtras",
                c => new
                    {
                        Locacao_Id = c.Int(nullable: false),
                        Extra_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Locacao_Id, t.Extra_Id })
                .ForeignKey("dbo.Locacao", t => t.Locacao_Id, cascadeDelete: true)
                .ForeignKey("dbo.Extra", t => t.Extra_Id, cascadeDelete: true)
                .Index(t => t.Locacao_Id)
                .Index(t => t.Extra_Id);
            
            CreateTable(
                "dbo.PermissaoUsuario",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissaos", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ExtraLocacao", "Locacao_Id", "dbo.Locacao");
            DropForeignKey("dbo.ExtraLocacao", "Extra_Id", "dbo.Extra");
            DropForeignKey("dbo.Locacao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.PermissaoUsuario", "IdPermissao", "dbo.Permissaos");
            DropForeignKey("dbo.PermissaoUsuario", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Locacao", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Locacao", "ExtrasPacote_Id", "dbo.ExtraPacote");
            DropForeignKey("dbo.ExtraPacote", "IdExtra", "dbo.Pacote");
            DropForeignKey("dbo.ExtraPacote", "IdPacote", "dbo.Extra");
            DropForeignKey("dbo.LocacaoExtras", "Extra_Id", "dbo.Extra");
            DropForeignKey("dbo.LocacaoExtras", "Locacao_Id", "dbo.Locacao");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.PermissaoUsuario", new[] { "IdPermissao" });
            DropIndex("dbo.PermissaoUsuario", new[] { "IdUsuario" });
            DropIndex("dbo.LocacaoExtras", new[] { "Extra_Id" });
            DropIndex("dbo.LocacaoExtras", new[] { "Locacao_Id" });
            DropIndex("dbo.ExtraLocacao", new[] { "Locacao_Id" });
            DropIndex("dbo.ExtraLocacao", new[] { "Extra_Id" });
            DropIndex("dbo.ExtraPacote", new[] { "IdExtra" });
            DropIndex("dbo.ExtraPacote", new[] { "IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdUsuario" });
            DropIndex("dbo.Locacao", new[] { "IdProduto" });
            DropIndex("dbo.Locacao", new[] { "ExtrasPacote_Id" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.PermissaoUsuario");
            DropTable("dbo.LocacaoExtras");
            DropTable("dbo.ExtraLocacao");
            DropTable("dbo.Permissaos");
            DropTable("dbo.Usuario");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.ExtraPacote");
            DropTable("dbo.Locacao");
            DropTable("dbo.Extra");
            DropTable("dbo.Cliente");
        }
    }
}
