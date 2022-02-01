<%-- 
    Document   : listar
    Created on : 10 de jan. de 2022, 19:17:30
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- 
%@page import="sgab.model.dto.Exemplar" %> 
%@page import="sgab.model.dto.Autor" %>
%@page import="java.util.List" %>
-->

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
                      <option value="autor">Autor</option>
                      <option value="estado">Estado</option>
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
                      <th>TÍTULO</th>
                      <th>AUTORES</th>
                      <th>EDITORA</th>
                      <th>EDIÇÃO</th>
                      <th>VOLUME</th>
                      <th>ANO</th>
                      <th>ESTADO</th>
                      <th></th>
                    </tr>
                    <!-- 
                    % 
                    List<Exemplar> lista = (List<Exemplar>) request.getAttribute("listExemplars");
                    for(Exemplar exemplar : lista){
                    %>
                    -->
                    <tr>
                      <td><!-- %= exemplar.getId()%> --></td>
                      <td><!-- %= exemplar.getTitulo()%> --></td>
                      <td>
                      <!-- 
                      % for(Autor autor: exemplar.getAutor()){ %>
                      %= autor.getNome()%>;
                      % } %> 
                      -->
                      
                      </td>
                      <td><!-- %= exemplar.getEditora()%> --></td>
                      <td><!-- %= exemplar.getEdicao()%> --></td>
                      <td><!-- %= exemplar.getVolume()%> --></td>
                      <td><!-- %= exemplar.getAnoPublicacao()%> --></td>
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
                            " class="button" value="Reservar"></td>
                    </tr>
                    <!-- 
                    % } %> 
                    -->
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


