<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
        <section id="nome-form">
            <h1>Empréstimo de obras</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <h1>Empréstimo de obras</h1>
                <form name="cadastrar" method="POST">
                    <input type="hidden" name="table" value="Emprestimo">
                    <input type="hidden" name="acao" value="gravar">  <!-- Nome da tabela que serÃ¡ alterada -->
                    <label>Obras</label>
            <span
              onclick="abreModal('pesquisaObra')"
              style="
                float: right;
                font-weight: bolder;
                font-size: 1.5em;
                cursor: pointer;
                user-select: none;
              "
              >+</span
            >
            <input id="obras-input" type="hidden" name="obras" value="">
            <div id="obras" style="padding-top: 10px;"></div>

            <div id="mask" onclick="fechaModalAll()"></div>
            <!-- Modal Obras-->
            <div class="form-popup" id="pesquisaObra">
                <div class="close-btn" onclick="fechaModal('pesquisaObra')">&times;</div>
                <form class="form-container">
                    <h2>Adicionar Obra</h2>
                    <div>
                        <div class="pesquisa-container">
                            <input type="text" id="nomeObra" placeholder="Insira o nome do obra." />
                            <input type="text" id="codigoObra" placeholder="Insira o código da obra." />
                            <input class="button" type="button" onclick="ajaxObra()" value="Pesquisar" />
                        </div>
                    <div id="resultados-pesquisa-obras"></div>
                    </div>
                </form>
            </div>
                    <label for="loginLeitor">Login do Leitor</label>
                    <input type="text" id="cadastroNome" name="loginLeitor" placeholder="Login do Leitor">
                    <button type="submit" onclick="gravarAlteracao(document.cadastrar)">Solicitar Empréstimo</button>
                 </div>
                </form>
            </div>
        </section>
        <script src="/sgab/js/abreModal.js"></script>
        <script src="/sgab/js/ajaxControl.js"></script>
<%@include file="/core/footer.jsp" %>
