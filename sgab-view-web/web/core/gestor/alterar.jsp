<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Pessoa" %>
<%@page import="sgab.model.dto.util.PessoaTipo" %>
<%@page import="sgab.model.service.GestaoGestor" %>
<%@page import="java.util.List" %>

<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <title>SGAB | Página do Atendente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" href="../../css/styles.css">
</head>

<%  Pessoa pessoa = (Pessoa) request.getAttribute("pessoa"); %>

<body> 

        <h3>Alteração</h3>
        <section id="form">
            <div id="caixa-form">
                <form name="modificarPessoa" method="post">
                    <%if(pessoa.getTipo()==PessoaTipo.BIBLIOTECARIO){%>
                        <%=<input type="hidden" name="table" value="Bibliotecario"> %>
                    <%}%>
                    <%else if(pessoa.getTipo()==PessoaTipo.ATENDENTE){%>
                        <%=<input type="hidden" name="table" value="Atendente"> %>
                    <%}%>
                    <input type="hidden" name="acao" value="gravarAlteracao">
                    <div>
                        <label for="pessoaId">Código</label>
                        <input type="number" id="pessoaId" name="pessoaId" placeholder="ID" value="<%=pessoa.getId()%>" readonly>
                    </div>
                    <div>
                        <label for="cpf">CPF</label>
                        <input type="number" id="cpf" name="cpf" placeholder="CPF" value="<%=pessoa.getCpf()%>" readonly>
                    </div>
                    <div>
                        <label for="login">Login</label>
                        <input type="text" id="login" name="login" placeholder="Login" value="<%=pessoa.getLogin()%>" readonly>
                    </div>
                    <div>
                        <label for="nome">Nome</label>
                        <input type="text" id="nome" name="nome" placeholder="Nome" value="<%=pessoa.getNome()%>">
                        <small>Digite seu nome e sobrenome.</small>
                    </div>
                    <div>
                        <label for="email">Email</label>
                        <input type="text" id="email" name="email" placeholder="Email" value="<%=pessoa.getEmail()%>">
                        <small>Digite um endereço de email válido.</small>
                    </div>
                    <div>
                        <label for="senha">Senha</label>
                        <input type="password" id="senha" name="senha" placeholder="Senha" value="<%=pessoa.getSenha()%>">
                        <small>A senha precisa ter 8 caracteres, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.</small>
                    </div>
                    <div id="senha2-div">
                        <label for="senha2">Confirme a nova senha <span class="input-obrigatorio">*</span></label>
                        <input type="password" id="senha2" name="senha2" placeholder="Senha">
                        <small>As senhas não correspondem.</small>
                    </div>
                    <div>

                    </div>
                    <div id="caixa-form-footer">
                        <input type="button" class="button" name="ordem" value="Alterar" onclick="gravarAlteracao(document.modificarPessoa)">
                    </div>
                </form>
            </div>
        </section>


</body>

<footer>
    <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
</footer>
        <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
        

</html>