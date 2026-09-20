/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.DepartamentosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cliente;

/**
 *
 * @author vinic
 */
@WebServlet(name = "Departamentos", urlPatterns = {"/Departamentos"})
public class Departamentos extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        DepartamentosDAO objDAO;
        ResultSet tabela;
        HttpSession sessao;
        ArrayList<Cliente> listaCliente;
        try {

            objDAO = new DepartamentosDAO();
            tabela = objDAO.listar();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Departamentos</title>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<meta http-equiv=\"refresh\" content=\"5\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&family=Saira:ital,wght@0,100..900;1,100..900&display=swap\" rel=\"stylesheet\">");
            out.println("<link rel='stylesheet' href='CSS/Departamento.css'>");
            out.println("</head>");
            out.println("<body>");
            sessao=request.getSession(true);
            listaCliente=(ArrayList<Cliente>) sessao.getAttribute("listaCliente");
            if(listaCliente == null) {
                out.println("<h1>Sem login.</h1>");
            }else {
                Cliente c = listaCliente.get(listaCliente.size() - 1);

                out.println("<h1>" + c.getUser() + "</h1>");
                out.println("<h6>Codigo: " + c.getCodigo() + "</h1>");
            }
               

            while (tabela.next()) {
                out.println("<a  href='ListarProdutos?txtDep=" + tabela.getInt(1) + "' target='produtos'><h4>🀦 " + tabela.getString(2) + "</h4></a>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Departamentos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro ao Listar Departamentos: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
