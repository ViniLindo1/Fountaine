/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ItemDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Banco;
import model.Cliente;
import model.Item;
import model.Produto;
import model.Venda;

/**
 *
 * @author vinic
 */
@WebServlet(name = "Finalizar", urlPatterns = {"/Finalizar"})
public class Finalizar extends HttpServlet {

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
        Cliente objCliente;
        Venda objVenda;
        Item objItem;
        ProdutoDAO daoProduto;
        VendaDAO daoVenda;
        ItemDAO daoItem;
        Banco bb;
        HttpSession sessao;
        double total=0;
        ArrayList<Produto> carrinho;
        ArrayList<Cliente> listaCliente;
        try {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Finalizar</title>");
            out.println("</head>");
            out.println("<body>");
            sessao = request.getSession(true);
            listaCliente = (ArrayList<Cliente>) sessao.getAttribute("listaCliente");

            if(listaCliente == null || listaCliente.isEmpty()){
                response.sendRedirect("Login.html");
                return;
            } else{
                objCliente = listaCliente.get(listaCliente.size() - 1);
                carrinho = (ArrayList<Produto>) sessao.getAttribute("carrinho");
                
                if(carrinho == null){
                    out.println("<h1>O carrinho esta vazio</h1>");
                } else {
                    bb = new Banco();
                    objVenda = new Venda();
                    objVenda.setCodcli(objCliente.getCodigo());
                    for (Produto objP : carrinho) {
                        total += objP.getPreco() * objP.getQtde();
                    }
                    objVenda.setTotal(total);
                    daoVenda = new VendaDAO();
                    daoProduto = new ProdutoDAO();
                    
                    objItem = new Item();
                    daoItem = new ItemDAO();
                    try {
                        Banco.conexao.setAutoCommit(false);
                        daoVenda.gravar(bb, objVenda);
                        for (Produto objP : carrinho) {
                            objItem.setCodproduto(objP.getCodigo());
                            if (objP.getQtde() <= 0) {
                                throw new Exception("Quantidade invalida");
                            }
                            objItem.setQtde(objP.getQtde());
                            objItem.setPrecounit(objP.getPreco());
                            objItem.setCodvenda(objVenda.getCodigo());
                            
                            daoItem.gravar(bb, objItem);
                            
                            daoProduto.alterarEstoque(bb, objP.getCodigo(), objP.getQtde());
                        }
                        Banco.conexao.commit();
                        Banco.conexao.setAutoCommit(true);
                        Banco.conexao.close();
                        sessao.removeAttribute("carrinho");
                        response.sendRedirect("ListarProdutos?txtDep=2"); 
                    } catch (Exception ex) {
                        ex.printStackTrace();

                        Banco.conexao.rollback();

                        out.println("<h1>A venda não foi concluída</h1>");
                        out.println("<h2>" + ex.getMessage() + "</h2>");
                    }
                }
            }
            
            
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
       
      
        out.println("<h1>Erro ao remover produto: " + ex.getMessage() + "</h1>");        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Finalizar</title>");
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
