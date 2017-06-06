namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AjusteNomeDeFKExtraPacote : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Locacao", name: "ExtrasPacote_Id", newName: "IdExtraPacote");
            RenameIndex(table: "dbo.Locacao", name: "IX_ExtrasPacote_Id", newName: "IX_IdExtraPacote");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.Locacao", name: "IX_IdExtraPacote", newName: "IX_ExtrasPacote_Id");
            RenameColumn(table: "dbo.Locacao", name: "IdExtraPacote", newName: "ExtrasPacote_Id");
        }
    }
}
