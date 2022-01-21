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
                <a href='/sgab/core/autores/menu.jsp' id="autores-menu">Autores</a>
                <a href='/sgab/main?acao=AssuntoListar'>Assuntos</a>                
                <a href='/sgab/main?acao=BibliotecaListar'>Bibliotecas</a>
                <a href='/sgab/main?acao=FornecedorListar'>Fornecedor</a>                
                <a href='/sgab/main?acao=ObraListar'>Obras</a>         
                <a href='/sgab/main?acao=PessoaListar'>Pessoas</a>
                <a href='/sgab/main?acao=UnidadeOrganizacionalListar'>Unid. Org.</a>      
            </div>
