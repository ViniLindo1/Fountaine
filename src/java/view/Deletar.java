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
@WebServlet(name = "Deletar", urlPatterns = {"/Deletar"})
public class Deletar extends HttpServlet {

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
        HttpSession sessao = request.getSession(true);
        int codProduto;
        response.sendRedirect("Carrinho");
        PrintWriter out = response.getWriter();
        try {
            ArrayList<Produto> carrinho = (ArrayList<Produto>) sessao.getAttribute("carrinho");
            codProduto = Integer.parseInt(request.getParameter("codigo"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Deletar</title>");
            out.println("</head>");
            out.println("<body>");
            if(carrinho != null){
                for(int i = 0; i < carrinho.size(); i++){
                    if(carrinho.get(i).getCodigo() == codProduto){
                        carrinho.remove(i);
                        break;
                    }
                }
            }
            
            sessao.setAttribute("carrinho", carrinho);
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
       
      
        out.println("<h1>Erro ao remover produto: " + ex.getMessage() + "</h1>");        
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
