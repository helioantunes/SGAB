<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="java.util.List" %>

<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <title>SGAB | Página do Atendente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../../css/styles.css">
</head>

<body> 

            <h3>Lista de Pessoas</h3>
            <a href="/sgab/core/pessoa/inserir.jsp">Nova Pessoa</a>
            <form name="listarPessoa" method="post">
                <input type="hidden" name="table" value="Pessoa">
                <input type="hidden" name="pessoaId" value="">

                <table id="pessoa">
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
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Pessoa> listPessoas = (List<Pessoa>) request.getAttribute("listPessoas");
                        for (Pessoa pessoa: listPessoas) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getId()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getLogin()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getCpf()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getNome()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=PessoaAlterar&pessoaId=<%=pessoa.getId()%>"><%=pessoa.getEmail()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=pessoa.getId()%>,document.listarPessoa)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>

</body>

<footer>
    <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
</footer>
        <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
        

</html>