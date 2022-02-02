<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Exemplar"%>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
        <center>
            <h3>Exemplares em Restauração</h3>
             <form name="frmObra" method="post">
                <input type="hidden" name="table" value="Obra">
                <input type="hidden" name="obraId" value="">
                <table id="usuario" style="width: 100%;">
                    <tr>
                      <th class="hpesquisa"></th>
                      <th>ID</th>
                      <th>NOME</th>
                      <th>ID</th>
                    </tr>
                    <% 
                    List<Exemplar> lista = (List<Exemplar>) request.getAttribute("exemplaresListar");
                    for(Exemplar exemplar : lista){
                    %>
                    <tr>
                      <td class="pesquisa"><a href="">&#128270</a></td>
                      <td><%= exemplar.getId()%></td>
                      <td><%= exemplar.getObra().getTitulo()%></td>
                    </tr>
                    <% } %>
        </table>
        </form>
        </center>
        <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>


<%@include file="/core/footer.jsp" %>