<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SGAB | Gestão de Assuntos</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="..\..\css\styles.css">
    <style>
        main a {
            display: block;
            line-height: 40px;
            padding: 10px 5px;
            margin: 20px;
            background-color: #3c8dbc;
            border-color: #367fa9;
            border-radius: 3px;
            box-shadow: none;
            height: 34px;
            border: 1px solid transparent;
            font-size: 14px; 
            padding: 6px 12px;
            color: #fff;
            text-align: center;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <header>
        <div id="pagina-inicial">
            <a href=""title="Página Inicial">
                SGAB
            </a>
        </div>
        <div id="logo-topo">
            <a href="http://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
                <img src="..\..\images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
            </a>
        </div>
    </header>
    <main>
        <section id="nome-form">
            <h1>Gestão de Assuntos</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <a href="cadastrar.jsp">Cadastrar Assunto</a>
                <a href="editar.jsp">Editar Assunto</a>
                <a href="excluir.jsp">Excluir Assunto</a>
            </div>
        </section>
    </main>
    <footer>
        <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
    </footer>
</body>
</html>