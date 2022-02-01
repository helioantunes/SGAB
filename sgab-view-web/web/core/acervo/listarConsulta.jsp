<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Acervo" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
    <center>
            <h3>Exemplares de Consulta</h3>
            <form name="listarReparo" method="post">
                <input type="hidden" name="table" value="Pessoa">
                <input type="hidden" name="pessoaId" value="">

                <table id="exemplar">
                    <tr>
                        <th>
                            Código
                        </th>
                        <th>
                            Nome
                        </th>
                        <th>
                            Autor
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                <%
                List<Exemplar> listExemplares = (List<Exemplar>) request.getAttribute("listarConsulta");
                for (Exemplar exemplar: listExemplar) {
                %>

                <%  } %>
            </center>


<%@include file="/core/footer.jsp" %>