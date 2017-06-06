﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class ExtraPacote
    {
        public int Id { get; set; }
        public Extra Extra { get; set; }
        public Pacote Pacote { get; set; }
        public int Quantidade { get; set; }

        public ExtraPacote()
        { }
    }
}
