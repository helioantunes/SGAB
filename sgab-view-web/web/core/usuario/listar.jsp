<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="sgab.model.dto.util.UsuarioTipo" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

<%
    String usuarioTipo = request.getParameter("usuarioTipo");
    String titulo = "";

    switch(usuarioTipo) {
        case "ADMINISTRADOR":
            titulo = "Administradores";
            break;
        case "ATENDENTE":
            titulo = "Atendentes";
            break;
        case "BIBLIOTECARIO":
            titulo = "Bibliotecários";
            break;
        case "GESTOR":
            titulo = "Gestores";
            break;
        case "LEITOR":
            titulo = "Leitores";
            break;
    }
%>

        <center>
        <div>
            <h2>Lista de <%=titulo%></h2>
        </div>
            <form name="listarUsuarios" method="post">
                <input type="hidden" name="table" value="Usuario">
                <input type="hidden" name="pessoaId" value="">
                <input type="hidden" name="usuarioTipo" value="">                

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
                            Nome
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Pessoa> listUsuarios = (List<Pessoa>) request.getAttribute("listUsuarios");
                        for (Pessoa pessoa: listUsuarios) {
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
                                <button onclick="excluirUsuario(<%=pessoa.getId()%>,'<%=usuarioTipo%>',document.listarUsuarios)">Excluir</button>
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center>
        <link rel="stylesheet" href="/sgab/css/modal.css">
        <link rel="stylesheet" href="/sgab/css/styles.css">
        <%@include file="/core/footer.jsp" %>    