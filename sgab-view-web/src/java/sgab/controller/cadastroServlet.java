/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sgab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgab.model.dto.Fornecedor;
import sgab.model.service.GestaoFornecedoresService;

/**
 *
 * @author T-Gamer
 */
@WebServlet(name = "cadastroServlet", urlPatterns = {"/cadastroServlet"})
public class cadastroServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            
            String adicionarNomeInput = request.getParameter("adicionarNomeInput");
            Long adicionarCNPJInput = Long.parseLong(request.getParameter("adicionarCNPJInput"));
            Long adicionarCEPInput = Long.parseLong(request.getParameter("adicionarCEPInput"));
            String adicionarEnderecoInput = request.getParameter("adicionarEnderecoInput");
            String adicionarEmailInput = request.getParameter("adicionarEmailInput");
            Long adicionarTelefoneInput = Long.parseLong(request.getParameter("adicionarTelefoneInput"));

            GestaoFornecedoresService cadastro = new GestaoFornecedoresService();

            Fornecedor novoFornecedor = new Fornecedor(adicionarCNPJInput, adicionarNomeInput, adicionarEmailInput,
                    adicionarTelefoneInput, adicionarCEPInput, adicionarEnderecoInput);

            cadastro.Cadastrar(novoFornecedor);

            request.setAttribute("adicionarNomeInput", adicionarNomeInput);
            request.setAttribute("adicionarCNPJInput", adicionarCNPJInput);
            request.setAttribute("adicionarCEPInput", adicionarCEPInput);
            request.setAttribute("adicionarEnderecoInput", adicionarEnderecoInput);
            request.setAttribute("adicionarEmailInput", adicionarEmailInput);
            request.setAttribute("adicionarTelefoneInput", adicionarTelefoneInput);
            
            

            response.sendRedirect("../../../web/core/fornecedores/resposta.jsp");
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
