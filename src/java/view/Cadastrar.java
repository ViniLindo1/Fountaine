/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author vinic
 */
@WebServlet(name = "Cadastrar", urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {

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
        Cliente obj;
        ClienteDAO dao;
        int qtde=0;
        ArrayList<Cliente> listaCliente;
        HttpSession sessao;
        try  {
            obj = new Cliente();
            obj.setCodigo(request.getParameter("codigo"));
            obj.setNome(request.getParameter("nome"));
            obj.setUser(request.getParameter("user"));
            obj.setSenha(request.getParameter("senha"));
            obj.setCidade(request.getParameter("cidade"));
            obj.setBairro(request.getParameter("bairro"));
            obj.setRua(request.getParameter("rua"));
            obj.setNumero(request.getParameter("numero"));
            sessao=request.getSession(true);
            listaCliente=(ArrayList<Cliente>) sessao.getAttribute("listaCliente");
            if(listaCliente == null){
                listaCliente = new ArrayList<>();
            }
            dao = new ClienteDAO();
            qtde = dao.gravar(obj);
            listaCliente.add(obj);
            sessao.setAttribute("listaCliente", listaCliente);
            response.sendRedirect("Login.html");
            if(qtde>0)
                out.println("<h1>"+obj.getNome()+" salvo com sucesso.</h1>");
            else
                out.println("<h1>Nada foi salvo.</h1>"); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadastrar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            
        }
        
        catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadastrar</title>");
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
