<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
        <section id="nome-form">
            <h1>Empréstimo de obras</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <h1>Empréstimo de obras</h1>
            <form name="emprestimo" method="POST">
                    <input type="hidden" name="table" value="Emprestimo">
                    <input type="hidden" name="acao" value="solicita">  <!-- Nome da tabela que serÃ¡ alterada -->
            <input id="obras-input" type="hidden" name="obras" value="">
            <div id="obras" style="padding-top: 10px;"></div>
                    <label for="idEmprestimo">Id</label>
                    <input type="text" name="idEmprestimo" placeholder="Insira o código da obra." />
                    <label for="loginLeitor">Login do Leitor</label>
                    <input type="text" id="cadastroNome" name="loginLeitor" placeholder="Login do Leitor">
                    <input type="button" class="button" onclick="gravarAlteracao(document.emprestimo)" value="Solicitar emprestimo">
                 </div>
                </form>
            </div>
                        
        </section>
         </div>
        
        <script src="/sgab/js/abreModal.js"></script>
        <script src="/sgab/js/ajaxControl.js"></script>
<%@include file="/core/footer.jsp" %>
