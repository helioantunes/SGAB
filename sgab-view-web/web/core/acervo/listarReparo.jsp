<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Acervo" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
        <center>
            <h3>Exemplares em Restauração</h3>
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
                        List<Exemplar> listExemplares = (List<Exemplar>) request.getAttribute("listarRestauracao");
                        for (Exemplar exemplar: listExemplar) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=listarRestauracao&acervoId=<%=acervo.getId()%>"><%=acervo.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=listarRestauracao&acervoId=<%=acervo.getId()%>"><%=acervo.getName()%></a>
                            </td>
                            

                        </tr>
                    <%  } %>
                </table>
            </form>
        </center>
        <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>


<%@include file="/core/footer.jsp" %>