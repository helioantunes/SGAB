<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/core/header.jsp" %>
    <section>
      <div class="caixa-gestao">
        <h2>Operações de Leitores</h2>
        <button class="button-gestao" onclick="abreFormCadastro()">Cadastrar leitor</button> 
      </div>
      <br>
    </section>

    <!-- FormulÃ¡rios Pop-up -->

    <!-- Form de cadastro -->
    
    <section class="form-popup" id="formCadastro">
      <div class="close-btn" onclick="fechaFormCadastro()">&times;</div>
      <div id="caixa-form" style=>
          <form class="form-container" name="inserirLeitor" method="post">
              <input type="hidden" name="table" value="Leitor">
              <input type="hidden" name="acao" value="gravar">
              <div>
                  <label for="login">Informe o seu Login <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="login" name="login" placeholder="Login" required>
                  <small>Digite um Login valido.</small>
              </div>
              <div>
                  <label for="cpf">Informe o seu CPF <span class="input-obrigatorio">*</span></label>
                  <input type="number" id="cpf" name="cpf" placeholder="CPF" required maxlength="11">
                  <small>Digite um CPF valido. Informe apenas numeros.</small>
              </div>
              <div>
                  <label for="nome">Informe o seu nome <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="nome" name="nome" placeholder="nome" required>
                  <small>Digite seu nome e sobrenome.</small>
              </div>
              <div>
                  <label for="email">Informe o seu endereço de email <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="email" name="email" placeholder="email" required>
                  <small>Digite um endereço de email vÃ¡lido.</small>
              </div>
              <div>
                  <label for="senha">Crie uma senha <span class="input-obrigatorio">*</span></label>
                  <input type="password" id="senha" name="senha" placeholder="senha" required>
                  <small>A senha precisa ter 8 caracteres, pelo menos uma letra maiuscula, uma letra minuscula, um numero e um caractere especial.</small>
              </div>
              <div>
                  <label for="senha2">Confirme a sua senha <span class="input-obrigatorio">*</span></label>
                  <input type="password" id="senha2" name="senha2" placeholder="senha" required>
                  <small>As senhas nao correspondem.</small>
              </div>
              <div class="caixa-form-footer">
                <button type="submit" onclick="gravarAlteracao(document.inserirLeitor)" >Cadastrar Leitor</button>
              </div>
          </form>
      </div>
  </section>
<script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
  <script src="/sgab/js/vendor/modernizr-3.11.2.min.js"></script>
  <script src="/sgab/js/helper.js"></script>
  <script src="/sgab/js/abreModal.js"></script>
  <script src="/sgab/js/validacao.js"></script>
  <script src="/sgab/js/cssControl.js"></script>
  <script src="/sgab/js/script.js"></script>
  <style>
      .form-popup{
          overflow-y: scroll;
          overflow-x: hidden;
      }
  </style>
  <link rel="stylesheet" href="/sgab/css/normalize.css">
  <link rel="stylesheet" href="../../css/styles.css">
  <link rel="stylesheet" href="../../css/modal.css">
  <%@include file="/core/footer.jsp" %>