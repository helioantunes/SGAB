<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SGAB | Gestão de Assuntos</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="..\..\css\styles.css">
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
                <img src="../../images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
            </a>
        </div>
    </header>
    <main>
        <section id="nome-form">
            <h1>Edição de Assuntos</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <form action="../../controller/AssuntosController.java" method="post"> <!-- verificar caminho do action (./editarController) -->
                    <div>
                        <label for="tag">Informe o assunto a ser editado <span class="input-obrigatorio">*</span></label>
                        <input type="text" id="assunto" name="assuntoAntigo" placeholder="Assunto a ser editado" required>
                    </div>
                    <div>
                        <label for="tag">Informe o novo assunto <span class="input-obrigatorio">*</span></label>
                        <input type="text" id="assunto" name="assuntoNovo" placeholder="Novo assunto" required>
                    </div>
                    <div class="caixa-form-footer">
                        <button type="submit">Editar</button><br>
                    </div>
                </form>
            </div>
        </section>
    </main>
    <footer>
        <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
    </footer>
</body>
</html>