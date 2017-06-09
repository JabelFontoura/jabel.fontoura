namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Teste : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Locacao", "IdExtraPacote", "dbo.ExtraPacote");
            DropIndex("dbo.Locacao", new[] { "IdExtraPacote" });
            AddColumn("dbo.Locacao", "IdPacote", c => c.Int());
            CreateIndex("dbo.Locacao", "IdPacote");
            AddForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote", "Id");
            DropColumn("dbo.Locacao", "IdExtraPacote");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Locacao", "IdExtraPacote", c => c.Int());
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote");
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropColumn("dbo.Locacao", "IdPacote");
            CreateIndex("dbo.Locacao", "IdExtraPacote");
            AddForeignKey("dbo.Locacao", "IdExtraPacote", "dbo.ExtraPacote", "Id");
        }
    }
}
