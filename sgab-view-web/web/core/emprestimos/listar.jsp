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
                            Código
                        </th>
                        <th>
                            Login
                        </th>
                        <th>
                            CPF
                        </th>
                        <th>
                            Nome Completo
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            Tipo
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
                                <a href="/sgab/main?acao=EmprestimoAlterar&emprestimoId=<%=emprestimo.getId()%>"><%=emprestimo.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=EmprestimoAlterar&emprestimoId=<%=emprestimo.getId()%>"><%=emprestimo.getLogin()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=EmprestimoAlterar&emprestimoId=<%=emprestimo.getId()%>"><%=emprestimo.getCpf()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=EmprestimoAlterar&emprestimoId=<%=emprestimo.getId()%>"><%=emprestimo.getNome()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=EmprestimoAlterar&emprestimoId=<%=emprestimo.getId()%>"><%=emprestimo.getEmail()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=EmprestimoAlterar&emprestimoId=<%=emprestimo.getId()%>"><%=emprestimo.getTipo()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=emprestimo.getId()%>,document.listarEmprestimo)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center>
        <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
        <%@include file="/core/footer.jsp" %>    