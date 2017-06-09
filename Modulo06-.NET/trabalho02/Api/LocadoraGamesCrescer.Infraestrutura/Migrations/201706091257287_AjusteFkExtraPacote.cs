namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AjusteFkExtraPacote : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.ExtraPacote", name: "IdPacote", newName: "__mig_tmp__0");
            RenameColumn(table: "dbo.ExtraPacote", name: "IdExtra", newName: "IdPacote");
            RenameColumn(table: "dbo.ExtraPacote", name: "__mig_tmp__0", newName: "IdExtra");
            RenameIndex(table: "dbo.ExtraPacote", name: "IX_IdPacote", newName: "__mig_tmp__0");
            RenameIndex(table: "dbo.ExtraPacote", name: "IX_IdExtra", newName: "IX_IdPacote");
            RenameIndex(table: "dbo.ExtraPacote", name: "__mig_tmp__0", newName: "IX_IdExtra");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.ExtraPacote", name: "IX_IdExtra", newName: "__mig_tmp__0");
            RenameIndex(table: "dbo.ExtraPacote", name: "IX_IdPacote", newName: "IX_IdExtra");
            RenameIndex(table: "dbo.ExtraPacote", name: "__mig_tmp__0", newName: "IX_IdPacote");
            RenameColumn(table: "dbo.ExtraPacote", name: "IdExtra", newName: "__mig_tmp__0");
            RenameColumn(table: "dbo.ExtraPacote", name: "IdPacote", newName: "IdExtra");
            RenameColumn(table: "dbo.ExtraPacote", name: "__mig_tmp__0", newName: "IdPacote");
        }
    }
}
