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
 * @author maffort <maffort@gmail.com>
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class gerenciaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            boolean mudancasFeitasBool = Boolean.parseBoolean(request.getParameter("alteracoesBool"));
            String nome = request.getParameter("nome");
            Long CNPJ = Long.parseLong(request.getParameter("CNPJ"));
            Long pesquisarCNPJ = Long.parseLong(request.getParameter("pesquisarCNPJ"));
            String pesquisarNome = request.getParameter("pesquisarNome");
            String alterarNomeInput = request.getParameter("alterarNomeInput");
            Long alterarCNPJInput = Long.parseLong(request.getParameter("alterarCNPJInput"));
            Long alterarCEPInput = Long.parseLong(request.getParameter("alterarCEPInput"));
            String alterarEnderecoInput = request.getParameter("alterarEnderecoInput");
            String alterarEmailInput = request.getParameter("alterarEmailInput");
            Long alterarTelefoneInput = Long.parseLong(request.getParameter("alterarTelefoneInput"));

            GestaoFornecedoresService gestaoFornecedores = new GestaoFornecedoresService();
            Fornecedor fornecedor;

            if(pesquisarCNPJ!=null){
                fornecedor = gestaoFornecedores.pesquisarPorCNPJ(pesquisarCNPJ);
                request.setAttribute("nome", fornecedor.getNomeFornecedor());
                request.setAttribute("cnpj", fornecedor.getCnpj());
                request.setAttribute("cep", fornecedor.getCep());
                request.setAttribute("endereco", fornecedor.getEndereco());
                request.setAttribute("email", fornecedor.getEmail());
                request.setAttribute("telefone", fornecedor.getTelefone());
                response.sendRedirect("../../../web/core/fornecedores/pesquisado.jsp");
            }

            else if(pesquisarNome!=null){
                fornecedor = gestaoFornecedores.pesquisarPorNome(pesquisarNome);
                request.setAttribute("nome", fornecedor.getNomeFornecedor());
                request.setAttribute("cnpj", fornecedor.getCnpj());
                request.setAttribute("cep", fornecedor.getCep());
                request.setAttribute("endereco", fornecedor.getEndereco());
                request.setAttribute("email", fornecedor.getEmail());
                request.setAttribute("telefone", fornecedor.getTelefone());
                response.sendRedirect("../../../web/core/fornecedores/pesquisado.jsp");
            }
            
            else if(mudancasFeitasBool == true) {
                fornecedor = gestaoFornecedores.pesquisarPorCNPJ(CNPJ);
                fornecedor.setNomeFornecedor(alterarNomeInput);
                fornecedor.setCep(alterarCEPInput);
                fornecedor.setCnpj(alterarCNPJInput);
                fornecedor.setEmail(alterarEmailInput);
                fornecedor.setEndereco(alterarEnderecoInput);
                fornecedor.setTelefone(alterarTelefoneInput);
            }
            
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
