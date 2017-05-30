using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {
        IPedidoRepositorio pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Get()
        {
            var pedidos = pedidoRepositorio.Listar();

            return Ok(pedidos);
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(pedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Post(Pedido pedido)
        {
            var mensagens = new List<string>();
            foreach(var item in pedido.Itens)
            {
                if (!item.Validar(out mensagens))
                    return BadRequest(string.Join(".", mensagens.ToArray()));
            }

            pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Put(Pedido pedido)
        {
            pedidoRepositorio.Alterar(pedido);

            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            pedidoRepositorio.Excluir(id);
            return Ok();
        }

    }
}