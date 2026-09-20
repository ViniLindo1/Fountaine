/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Produto;

/**
 *
 * @author vinic
 */
@WebServlet(name = "Carrinho", urlPatterns = {"/Carrinho"})
public class Carrinho extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sessao;
        ArrayList<Produto> carrinho;
        double vf;
        try  {
            vf=0;
            sessao=request.getSession(true);
            carrinho=(ArrayList<Produto>) sessao.getAttribute("carrinho");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Carrinho</title>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&family=Saira:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
            out.println("<link rel='stylesheet' href='CSS/Carrinho.css'>");
            out.println("</head>");
            out.println("<body>");
            if (carrinho != null) {
                for(Produto p : carrinho){
                    out.println("<form action='Controlador' method='post'>");
                    out.println("<input type='text' name='codigo' value='" + p.getCodigo() + "' hidden >");
                    out.println("<section>");
                    out.println("<img src='imagem/" + p.getImg() +  "' name='img' width='200' >");
                    
                    out.println("<div class='text'>");
                    out.println("<h2 name='descricao'>" + p.getDescricao() + "</h2>");
                    out.println("<h5 name='preco'R$>" + p.getPreco() + "</h5>");
                    out.println("<h6>R$" + String.format("%.2f", p.getTotal()) + "</h6>");
                    out.println("</div>");
                    
                    out.println("<div class='qtde'>");
                    out.println("<p name='qntd'>" + p.getQtde() + "</p>");
                    out.println("<input type='submit' value='Deletar'  name='b1'  >");
                    
                    out.println("</div>");
                    out.println("</section>");
                    out.println("</form>");
                    vf+= p.getTotal();
                } 
            } else {
                out.println("<form>");
                out.println("<h5>O carrinho está vazio</h5>");
                out.println("</form>");
            }
            
            out.println("<form action='Finalizar' method='post'>");
            out.println("<nav>");
            out.println("<h2> O valor final foi de: R$" + String.format("%.2f", vf) + "</h2>");
            out.println("<input type='submit' value='Finalizar'  name='b1'  >");
            out.println("</nav>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            System.err.print("Erro no servidor -> " +ex.getMessage());
        }
    }

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
