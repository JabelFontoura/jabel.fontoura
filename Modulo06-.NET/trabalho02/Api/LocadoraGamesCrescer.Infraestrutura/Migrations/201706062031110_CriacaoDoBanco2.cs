namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco2 : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.ExtraPacote", "Quantidade", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.ExtraPacote", "Quantidade");
        }
    }
}
