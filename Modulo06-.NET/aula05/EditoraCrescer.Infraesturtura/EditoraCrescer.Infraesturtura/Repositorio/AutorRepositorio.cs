using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public Autor Obter(int id)
        {
            return contexto.Autores.Where(a => a.Id == id).FirstOrDefault();
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            contexto.Autores.Remove(contexto.Autores.Where(l => l.Id == id).FirstOrDefault());
            contexto.SaveChanges();
        }
    }
}
