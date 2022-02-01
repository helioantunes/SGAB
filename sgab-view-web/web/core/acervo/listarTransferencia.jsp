<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Acervo" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
    <center>
            <h3>Exemplares em Transferência</h3>
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
                            Status
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>

                <%
                  List<Exemplar> listExemplares = (List<Exemplar>) request.getAttribute("listarTransferencia");
                  for (Exemplar exemplar: listExemplar) {
                %>
                <tr>
                    <td>
                       <a href="/sgab/main?acao=AtendenteAlterar&atendenteId=<%=atendente.getId()%>"><%=atendente.getId()%></a>
                    </td>
                </tr>
                <%  } %>

            </center>


<%@include file="/core/footer.jsp" %>