using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorio
{
    public interface IRepositorio<T> where T : class
    {
        List<T> Listar();
        T Obter(int id);
        T Criar(T objeto);
        T Alterar(int id, T objeto);
        void Deletar(int id);

    }
}
