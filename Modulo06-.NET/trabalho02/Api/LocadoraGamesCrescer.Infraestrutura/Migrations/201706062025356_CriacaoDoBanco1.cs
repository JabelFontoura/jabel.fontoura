namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco1 : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.LocacaoExtras", "Locacao_Id", "dbo.Locacao");
            DropForeignKey("dbo.LocacaoExtras", "Extra_Id", "dbo.Extra");
            DropIndex("dbo.LocacaoExtras", new[] { "Locacao_Id" });
            DropIndex("dbo.LocacaoExtras", new[] { "Extra_Id" });
            AddColumn("dbo.Locacao", "Extra_Id", c => c.Int());
            CreateIndex("dbo.Locacao", "Extra_Id");
            AddForeignKey("dbo.Locacao", "Extra_Id", "dbo.Extra", "Id");
            DropTable("dbo.LocacaoExtras");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.LocacaoExtras",
                c => new
                    {
                        Locacao_Id = c.Int(nullable: false),
                        Extra_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Locacao_Id, t.Extra_Id });
            
            DropForeignKey("dbo.Locacao", "Extra_Id", "dbo.Extra");
            DropIndex("dbo.Locacao", new[] { "Extra_Id" });
            DropColumn("dbo.Locacao", "Extra_Id");
            CreateIndex("dbo.LocacaoExtras", "Extra_Id");
            CreateIndex("dbo.LocacaoExtras", "Locacao_Id");
            AddForeignKey("dbo.LocacaoExtras", "Extra_Id", "dbo.Extra", "Id", cascadeDelete: true);
            AddForeignKey("dbo.LocacaoExtras", "Locacao_Id", "dbo.Locacao", "Id", cascadeDelete: true);
        }
    }
}
