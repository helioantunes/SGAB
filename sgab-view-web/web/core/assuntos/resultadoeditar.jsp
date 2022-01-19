<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SGAB | Gestão de Assuntos</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <% String assuntoAntigo = request.getAttribute("tagAssuntoAntigo");
        String assuntoEditado = request.getAttribute("tagAssuntoNovo"); %>
        <header>
            <div id="pagina-inicial">
                <a href=""title="Página Inicial">
                    SGAB
                </a>
            </div>
            <div id="logo-topo">
                <a href="http://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
                    <img src="imgs/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
                </a>
            </div>
        </header>
        <main>
            <section id="nome-form">
                <h1>Edição de Assuntos</h1>
            </section>
            <section id="cadastro">
                <div id="caixa-form">
                    <h2>Assunto <%= assuntoAntigo%> foi alterado para <%= assuntoEditado%>!</h2>
                    <div class="caixa-form-footer">
                        <a href="editar.html">Editar Novo Assunto</a>
                    </div>
                </div>
            </section>
        </main>
        <footer>
            <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
        </footer>
    </body>
</html>
