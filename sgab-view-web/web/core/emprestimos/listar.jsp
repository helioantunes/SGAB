<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>
       
        <center>
            <h3>Lista de Empréstimos</h3>
            <a href="/sgab/core/emprestimos/inserir.jsp">Novo Empréstimo</a>
            <form name="listarEmprestimo" method="post">
                <input type="hidden" name="table" value="Emprestimo">
                <input type="hidden" name="emprestimoId" value="">

                <table id="emprestimo">
                    <tr>
                        <th>
                            Usuário
                        </th>
                        <th>
                            Id do Empréstimo
                        </th>
                        <th>
                            Data
                        </th>
                        <th>
                            Nome Completo
                        </th>
                        <th>
                            Status
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Emprestimo> listEmprestimos = (List<Emprestimo>) request.getAttribute("listEmprestimos");
                        for (Emprestimo emprestimo: listEmprestimos) {
                    %>
                        <tr>
                            <td>
                                <%=emprestimo.getPessoa().getNome()%></a>
                            </td>
                            <td>
                                <%=emprestimo.getNome()%></a>
                            </td>
                            <td>
                                <%=emprestimo.getData()%></a>
                            </td>
                            <td>
                                <%=exemplar.getStatus()%></a>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center>
        <%@include file="/core/footer.jsp" %>    
