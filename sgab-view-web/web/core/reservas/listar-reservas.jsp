<%-- 
    Document   : listar
    Created on : 10 de jan. de 2022, 19:17:30
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 
<%@page import="sgab.model.dto.Exemplar" %> 
<%@page import="sgab.model.dto.Autor" %>
<%@page import="sgab.model.dto.Reserva" %>
<%@page import="java.util.List" %>


<%@include file="/core/header.jsp" %>
      <center>
          <h3>Reservas - Acervo de Exemplares</h3>
          <div class="acoes">
              <span></span>
              <form class="pesquisa-container" name="frmPesquisa" method="post">
                  <input type="hidden" value="ExemplarPesquisar" name="acao">
                  <select name="tipo">
                      <option value="null" selected>[Pesquisar por]</option>
                      <option value="titulo">Título</option>
                      <option value="estado">Leitor</option>
                  </select>
                  <input type="text" name="nome" placeholder="Escolha o tipo.">
                  <input type="button" class="button" onclick="validarCamposPesquisaExemplar(document.frmPesquisa)" value="Pesquisar">
              </form>
          </div>
          <form name="frmExemplar" method="post">
                <input type="hidden" name="table" value="Exemplar">
                <input type="hidden" name="exemplarId" value="">
                <table id="usuario" style="width: 100%;">
                    <tr>
                      <th>LEITOR</th>  
                      <th>EXEMPLARES</th>
                      <th>BIBLIOTECA</th>
                      <th>DATA</th>
                    </tr>
                    <% 
                    List<Reserva> lista = (List<Reserva>) request.getAttribute("listReservas");
                    for(Reserva reserva : lista){
                    %>
                    
                    <tr>
                      <td><%= reserva.getId()%></td>
                      <td><%= reserva.getPessoa().getNome()%></td>
                      <td>
                      <% for(Exemplar exemplar: reserva.getExemplares()){ %>
                      <%= exemplar.getObra().getTitulo()%>;
                      <% } %> 
                      
                      </td>
                      <td><%= reserva.getLocalReserva().getNome%></td>
                      <td><%= reserva.getHorario()%></td>
                      <td><input type="button" style="
                                display: block; 
                                margin-left: auto; 
                                margin-right: auto; 
                                padding: 4px 4px; 
                                height: 26px; 
                                border-color: #aaaaaa; 
                                background-color: #aaaaaa;
                                color: black;
                                width: 100%;
                                border-radius: 0;
                            " class="button" value="?" onclick="window.location.href='/sgab/core/reservas/reservar.jsp';"></td>
                    </tr> 
                    <% } %> 
        </table>
        </form>
        
    </center>
        
    <style>
        .hpesquisa{
            flex: 0.5;
        }
        .pesquisa{
            cursor: pointer;
            flex: 0.5;
        }
    </style>        
    <%@include file="/core/footer.jsp" %>