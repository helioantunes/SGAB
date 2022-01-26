<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
        <section id="nome-form">
            <h1>Empréstimo de obras</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <h1>Empréstimo de obras</h1>
                <form name="cadastrar" method="POST">
                    <input type="hidden" name="table" value="Autor">
                    <input type="hidden" name="acao" value="gravar">  <!-- Nome da tabela que serÃ¡ alterada -->
                    <label for="nomeAutor">Qual obra será emprestada?</label>
                    <input type="text" id="cadastroNome" name="nomeAutor" placeholder="Nome da Obra">
                    <label for="nomeAutor">Login do Leitor</label>
                    <input type="text" id="cadastroNome" name="loginLeitor" placeholder="Login do Leitor">
                    <button type="submit" onclick="gravarAlteracao(document.cadastrar)">Solicitar Empréstimo</button>
                 </div>
                </form>
            </div>
        </section>
<%@include file="/core/footer.jsp" %>