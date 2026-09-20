/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

/**
 *
 * @author vinic
 */
@WebServlet(name = "ListarProdutos", urlPatterns = {"/ListarProdutos"})
public class ListarProdutos extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ProdutoDAO objDAO;
        ResultSet tabela;
        int coddep=0;
        try {
            coddep=Integer.parseInt(request.getParameter("txtDep"));
            objDAO = new ProdutoDAO();
            tabela = objDAO.listar(coddep);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("<title>ListarProdutos</title>");
            
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");          
            out.println("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&family=Saira:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
            out.println("<link rel='stylesheet' href='CSS/Produtos.css'>");
            
            out.println("<script type='text/javascript'>");
            out.println("function VerificarQtde(codigo){");
            out.println("const qtde = Number(document.getElementById('idQtde' + codigo).textContent);");
            out.println("const qntd = Number(document.getElementById('idQntd' + codigo).value);");
            out.println("const b1 = document.getElementById('idBotao'+codigo);");
            out.println("const msg = document.getElementById('idH6' + codigo);");
            out.println("if(qntd <= 0 || qntd > qtde ){");
            out.println("msg.innerHTML = 'Quantidade deve ser maior que 0 e menor ou igual ao estoque';");
            out.println("document.getElementById('idQntd'+ codigo).focus();");
            out.println("b1.disabled = true ;");
            out.println("return false;");
            out.println("} else {");
            out.println("msg.innerHTML = '';");
            out.println("b1.disabled = false");
            out.println("}");
            out.println("return true;");
            out.println("}");
            out.println("</script>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='produtos'>");
            
            while (tabela.next()) {
                
                out.println("<form action='Controlador' method='post'>");
                
                out.println("<input type='text' name='codigo' value='" + tabela.getInt(1) + "' hidden >");
                out.println("<input type='text' name='imagem' value='" + tabela.getString(2) + "'  hidden >");
                out.println("<input type='text' name='descricao' value='" + tabela.getString(3) + "'  hidden >");
                out.println("<input type='text' name='preco' value='" + tabela.getDouble(4) + "' hidden >");
                
                
                
                
                
                
                
                out.println("<img src='imagem/" + tabela.getString(2) +  "'  width='200' >");
                out.println("<h2>" + tabela.getString(3) + "🕮</h2>");
                out.println("<h6>️R$" + tabela.getDouble(4) + "</h6>");
                out.println("<h5 id='idH6"+tabela.getInt(1)+"' style='color:red' ></h5>");
                
                
                out.println("<div class='estoque'>");
                out.println("<p>Estoque: <span id='idQtde" + tabela.getInt(1) + "'>" + tabela.getInt(5) + "</span></p>");
                out.println("<input type='number' name='qtde' value='1' id='idQntd"+tabela.getInt(1)+"'  onblur='VerificarQtde("+ tabela.getInt(1) +")' >");
                
                out.println("</div>");
                
                
                out.println("<input class='compras' type='submit' value='Comprar' id='idBotao"+tabela.getInt(1)+"' name='b1'>");
               

               
                out.println("</form>");

            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarProdutos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro ao Listar Produtos: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
