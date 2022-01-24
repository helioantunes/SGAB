<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/core/header.jsp" %>


  </div>
      <div class="caixa-gestao">
        <h2>Operações de Gestor</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroGestor')">Cadastrar</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoGestor')">Editar</button>
        <button class="button-gestao" onclick="abreModal('formListarGestor')">Listar</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Administrador</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroAdministrador')">Cadastrar</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoAdministrador')">Editar</button>
        <button class="button-gestao" onclick="abreModal('formListarAdministrador')">Listar</button>
      </div>
      <br>
    </section>

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroGestor">
      <div class="close-btn" onclick="fechaModal('formCadastroGestor')">&times;</div>
      <form class="form-container" method="POST" name="GravarGestor">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>

          <input type="hidden" name="table" value="Gestor">
          <input type="hidden" name="acao" value="gravar">
            
          <div>
                <label for="login">Informe o seu Login <span class="input-obrigatorio">*</span></label>
                <input type="text" id="login" name="login" placeholder="Login" required>
                <small>Digite um Login válido.</small>
           </div>
          
          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarGestor)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar Gestor -->
    <div class="form-popup" id="formEdicaoGestor">
      <div class="close-btn" onclick="fechaModal('formEdicaoGestor')">&times;</div>
      <form class="form-container" method="POST" name="EdicaoGestor">
        <h2> Editar gestor:</h2>
        
        <h3>Editar</h3>
        
        <div>
          <input type="hidden" name="table" value="Gestor">
          <input type="hidden" name="acao" value="alterar">
          <label>Nome de usuario: <input type="email" placeholder="Nome ou Email do(a) gestor(a)" name="login" required></label>
          <button type="button" class="button-form" onclick="gravarAlteracao(document.EdicaoGestor)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- FormulÃ¡rios Pop-up -->

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroAdministrador">
      <div class="close-btn" onclick="fechaModal('formCadastroAdministrador')">&times;</div>
      <form class="form-container" method="POST" name="GravarAdministrador">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>
          <input type="hidden" name="table" value="Administrador">
          <input type="hidden" name="acao" value="gravar">
            
           <div>
                <label for="login2">Informe o seu Login <span class="input-obrigatorio">*</span></label>
                <input type="text" id="login2" name="login" placeholder="Login" required>
                <small>Digite um Login válido.</small>
           </div>

          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarAdministrador)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar Administrador -->
    <div class="form-popup" id="formEdicaoAdministrador">
      <div class="close-btn" onclick="fechaModal('formEdicaoAdministrador')">&times;</div>
      <form class="form-container" method="POST" name="EdicaoAdministrador">
        <h2> Editar</h2>
        <div>
          <input type="hidden" name="table" value="Administrador">
          <input type="hidden" name="acao" value="alterar">
          <label>Nome de usuario: <input type="email" placeholder="Nome ou Email do(a) administrador(a)" name="login" required></label>
          <button type="button" class="button-form" onclick="gravarAlteracao(document.EdicaoAdministrador)">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formListarGestor">
      <div class="close-btn" onclick="fechaModal('formListarGestor')">&times;</div>
      <form class="form-container" method="POST" name="loginGestor">
        <div>
        <input type="hidden" name="table" value="Gestor">
        <input type="hidden" name="acao" value="pesquisarPorLogin">
        
        <label>Nome do gestor(a): <input type="text" placeholder="Nome de usuário do(a) Gestor:" name="login" required></label>  
        <button type="button" class="button-form" onclick="pesquisar(document.login)">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formListarAdministrador">
      <div class="close-btn" onclick="fechaModal('formListarAdministrador')">&times;</div>
      <form class="form-container" method="POST" name="loginAdministrador">
        <div>
        <input type="hidden" name="table" value="Administrador">
        <input type="hidden" name="acao" value="pesquisarPorLogin">
        
        <label>Nome do administrador(a): <input type="text" placeholder="Nome de usuário do(a) Administrador:" name="" required></label>  
        <button type="button" class="button-form" onclick="pesquisar(document.login)">Enviar</button>
        </div>
      </form>
    </div>

    <div id="mask" onclick="fechaModalAll()"></div>
  </main>

  <!-- JS -->
  <script src="../../js/abreModal.js"></script>
  <script src="../../js/helper.js"></script>
  <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>
  <script type="text/javascript" language="JavaScript" src="/sgab/js/validacaoAdministrador.js"></script>
  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/modal.css">
  <link rel="stylesheet" href="../../css/styles.css">
</body>

<%@include file="/core/footer.jsp" %>


</html>
