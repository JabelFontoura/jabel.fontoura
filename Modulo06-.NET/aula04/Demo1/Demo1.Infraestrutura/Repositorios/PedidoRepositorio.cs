using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {

        string stringConexao = "Server=13.65.101.67;User Id=jabel.fontoura; Password=123456;Database=aluno17db;MultipleActiveResultSets=True";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"UPDATE Pedido (NomeCliente) VALUES @nome";

                    comando.Parameters.AddWithValue("@nome", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO Pedido (NomeCliente) VALUES (@nome)";

                    comando.Parameters.AddWithValue("@nome", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                using (var comando = conexao.CreateCommand())
                {
                    foreach(ItemPedido item in pedido.Itens)
                    {
                        comando.CommandText = @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) VALUES(@pedidoId, @produtoId, @quantidade)";
                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();

                        comando.CommandText = @"UPDATE Produto SET Estoque = Estoque -  @quantidade WHERE Id = @itemProdutoId";
                        comando.Parameters.AddWithValue("@itemProdutoId", item.ProdutoId);

                        comando.ExecuteNonQuery();

                        comando.Parameters.Clear();
                    }

                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE FROM Pedido WHERE Id = @inputId";

                    comando.Parameters.AddWithValue("@inputId", id);
                    comando.ExecuteNonQuery();
                }

            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT p.Id AS IdPedido, p.NomeCliente, ip.Id AS IdItemPedido, ip.ProdutoId, ip.Quantidade FROM Pedido p JOIN ItemPedido ip ON p.Id = ip.PedidoId";
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        int idAtual = (int)dataReader["IdPedido"];

                        if (pedidos.Where(p => p.Id == idAtual).Count() == 1)
                        {
                            pedidos.Where(p => p.Id == idAtual).First().Itens.Add(new ItemPedido()
                            {
                                Id = (int)dataReader["IdItemPedido"],
                                ProdutoId = (int)dataReader["ProdutoId"],
                                Quantidade = (int)dataReader["Quantidade"]
                            });
                        }else
                        {
                            pedidos.Add(new Pedido()
                            {
                                Id = idAtual,
                                NomeCliente = (string)dataReader["NomeCliente"],
                                Itens = new List<ItemPedido>()
                                {
                                    new ItemPedido {
                                        Id = (int)dataReader["IdItemPedido"],
                                        ProdutoId = (int)dataReader["ProdutoId"],
                                        Quantidade = (int)dataReader["Quantidade"]
                                    }
                                }
                            });

                        }
                    }
                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            var pedido = new Pedido();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT p.Id AS IdPedido, p.NomeCliente, ip.Id AS IdItemPedido, ip.ProdutoId, ip.Quantidade FROM Pedido p JOIN ItemPedido ip ON p.Id = ip.PedidoId AND p.Id = @inputId";
                    comando.Parameters.AddWithValue("@inputId", id);
                    var dataReader = comando.ExecuteReader();

                    while (dataReader.Read())
                    {
                        int idAtual = (int)dataReader["IdPedido"];

                        if (pedido.Id == idAtual)
                        {
                            pedido.Itens.Add(new ItemPedido()
                            {
                                Id = (int)dataReader["IdItemPedido"],
                                ProdutoId = (int)dataReader["ProdutoId"],
                                Quantidade = (int)dataReader["Quantidade"]
                            });
                        }
                        else
                        {
                            pedido.Id = idAtual;
                            pedido.NomeCliente = (string)dataReader["NomeCliente"];
                            pedido.Itens = new List<ItemPedido>()
                            {
                                new ItemPedido
                                {
                                    Id = (int)dataReader["IdItemPedido"],
                                    ProdutoId = (int)dataReader["ProdutoId"],
                                    Quantidade = (int)dataReader["Quantidade"]
                                }
                             };

                        }
                    }
                }
            }
            return pedido;
        }
    }
}
