namespace LocadoraGamesCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AceitarValoresNull : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Locacao", "DataDevolucao", c => c.DateTime());
            AlterColumn("dbo.Locacao", "ValorFinal", c => c.Decimal(precision: 18, scale: 2));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Locacao", "ValorFinal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Locacao", "DataDevolucao", c => c.DateTime(nullable: false));
        }
    }
}
