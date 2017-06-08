namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AjusteNomeFk : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Locacao", "Extra_Id", "dbo.Extra");
            DropIndex("dbo.Locacao", new[] { "Extra_Id" });
            RenameColumn(table: "dbo.ExtraLocacao", name: "Extra_Id", newName: "IdExtra");
            RenameColumn(table: "dbo.ExtraLocacao", name: "Locacao_Id", newName: "IdLocacao");
            RenameIndex(table: "dbo.ExtraLocacao", name: "IX_Extra_Id", newName: "IX_IdExtra");
            RenameIndex(table: "dbo.ExtraLocacao", name: "IX_Locacao_Id", newName: "IX_IdLocacao");
            DropColumn("dbo.Locacao", "Extra_Id");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Locacao", "Extra_Id", c => c.Int());
            RenameIndex(table: "dbo.ExtraLocacao", name: "IX_IdLocacao", newName: "IX_Locacao_Id");
            RenameIndex(table: "dbo.ExtraLocacao", name: "IX_IdExtra", newName: "IX_Extra_Id");
            RenameColumn(table: "dbo.ExtraLocacao", name: "IdLocacao", newName: "Locacao_Id");
            RenameColumn(table: "dbo.ExtraLocacao", name: "IdExtra", newName: "Extra_Id");
            CreateIndex("dbo.Locacao", "Extra_Id");
            AddForeignKey("dbo.Locacao", "Extra_Id", "dbo.Extra", "Id");
        }
    }
}
