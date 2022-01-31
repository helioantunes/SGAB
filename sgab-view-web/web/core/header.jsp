<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.controller.LoginController"%>

<%
    LoginController.validarSessao(request, response);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SGAB | Sistema de Gestão de Acervo Bibliográfico </title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="/sgab/css/styles.css">
        <script type="text/javascript" language="JavaScript" src="/sgab/js/helper.js"></script>
    </head>
    <body>
        <header>
            <div id="pagina-inicial">
                <a href="" title="Página Inicial">
                    SGAB
                </a>
            </div>
            <div id="logo-topo">
                <a href="http://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
                    <img src="/sgab/images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais" />                </a>
            </div>
        </header>
        <main>
            <section id="nome-form">
                <h1>Menu</h1>
            </section>
            <div class="menu">
                <% 
                    Pessoa usuario = (Pessoa) request.getSession().getAttribute("usuario");
                    if (ControleAutorizacao.checkPermissao("aquisicao", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=IniciaCadastroAquisicao'>Aquisições</a>
                <%} if (ControleAutorizacao.checkPermissao("assunto", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=AssuntoListar'>Assuntos</a>
                <%} if (ControleAutorizacao.checkPermissao("autor", usuario.getTipo())) {%>
                <a href='/sgab/core/autores/menu.jsp' id="autores-menu">Autores</a>
                <%} if (ControleAutorizacao.checkPermissao("biblioteca", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=BibliotecaListar'>Bibliotecas</a>
                <%} if (ControleAutorizacao.checkPermissao("fornecedor", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=FornecedorListar'>Fornecedores</a>                
                <%} if (ControleAutorizacao.checkPermissao("obra", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=ObraListar'>Obras</a>         
                <%} if (ControleAutorizacao.checkPermissao("pessoa", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=PessoaListar'>Pessoas</a>
                <%} if (ControleAutorizacao.checkPermissao("unidade", usuario.getTipo())) {%>
                <a href='/sgab/main?acao=UnidadeOrganizacionalListar'>Unid. Org.</a> 
                <%} if (ControleAutorizacao.checkPermissao("usuario", usuario.getTipo())) {%>
                <a href='/sgab/core/usuario/index.jsp'>Usuários</a>
                <%}%>
            </div>
