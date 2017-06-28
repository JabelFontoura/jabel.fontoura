package br.com.crescer.aula05;

// @author jabel.fontoura
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteServlet extends HttpServlet {
  
  private List<String> nomes = new ArrayList<String>();
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    try (final PrintWriter out = resp.getWriter();) {
      out.append(
      "<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "  <head>\n" +
      "    <title></title>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
      "  </head>\n" +
      "  <body>\n" +
      "    <form action=\"/aula05/cliente\" method=\"POST\">\n" +
      "      <label for=\"nome\">Nome: </label>\n" +
      "      <input type=\"text\" name=\"nome\" value=\"\">\n" +
      "      <input type=\"submit\" name=\"enviar\" value=\"Enviar\">\n" +
      "    </form>\n"); 
      
      out.append(
      "<table>\n" +
      " <tr>\n" +
      "   <th>Nome</th>\n" +
      " </tr>\n");
      nomes.forEach(nome -> out.append(" <tr><td>" + nome +"</td></tr>"));
      out.append("</table>");
      
      
      out.append("  </body>\n" +
      "</html>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getParameter("nome") != null)
    nomes.add(req.getParameter("nome"));

    resp.sendRedirect("/aula05/cliente");
  }
  
  
}
