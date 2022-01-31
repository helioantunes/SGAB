<!doctype html>
<html class="no-js" lang="">
<html>
<head>
  <meta charset="utf-8">
  <title>SGAB | Página do Atendente</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta property="og:title" content="">
  <meta property="og:type" content="">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <link rel="manifest" href="site.webmanifest">
  <link rel="apple-touch-icon" href="icon.png">


  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/modal.css">
  <link rel="stylesheet" href="../../css/styles.css">

  <meta name="theme-color" content="#fafafa">
</head>

<body>
  <header>
    <div id="pagina-inicial">
      <a href="" title="Página Inicial">SGAB</a>
    </div>
    <div id="logo-topo">
      <a href="https://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
        <img src="../../images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
      </a>
    </div>
  </header>

  <main>
    <section id="nome-form">
      <h1>Página do Atendente</h1>
    </section>
    <section>
      <div class="caixa-gestao">
        <h2>Operações de Bibliotecários</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroBibliotecario')">Cadastrar</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoBibliotecario')">Editar</button>
        <button class="button-gestao" onclick="abreModal('formListarBibliotecario')">Listar</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Atendente</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroAtendente')">Cadastrar</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoAtendente')">Editar</button>
        <button class="button-gestao" onclick="abreModal('formListarAtendente')">Listar</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Biblioteca</h2>
        <button class="button-gestao" onclick="locantion.href('/sgab/core/biblioteca/opcoes.jsp')">Gestão Biblioteca</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Unidade Organizacional</h2>
        <button class="button-gestao" onclick="locantion.href('/sgab/core/unidadeorganizacional/')">Gestão Unidade Organizacional</button>
      </div>
    </section>

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroBibliotecario">
      <div class="close-btn" onclick="fechaModal('formCadastroBibliotecario')">&times;</div>
      <form class="form-container" method="POST" name="GravarBibliotecario">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>

          <input type="hidden" name="table" value="Bibliotecario">
          <input type="hidden" name="acao" value="gravar">
            
          <label>Nome do bibliotecário(a): <input type="text" placeholder="Nome de usuário do(a) bibliotecário(a):" name="login" required></label>

          <label>Nome Completo: <input type="text" placeholder="Nome Completo do(a) bibliotecário(a):" name="nome" required></label>          
          
          <label>CPF do bibliotecário(a): <input type="text" placeholder="CPF do(a) bibliotecário(a):" name="cpf" required></label>

          <label>Email do bibliotecário(a): <input type="email" placeholder="Email do(a) bibliotecário:" name="email" required></label>

          <label>Senha do bibliotecário(a): <input type="password" placeholder="Senha do(a) bibliotecário:" name="senha" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do(a) Bibliotecario(a)" name="adminpsw" required></label>
          
          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarBibliotecario)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar bibliotecário -->
    <div class="form-popup" id="formEdicaoBibliotecario">
      <div class="close-btn" onclick="fechaModal('formEdicaoBibliotecario')">&times;</div>
      <form class="form-container" method="POST" name="EdicaoBibliotecario">
        <h2> Editar bibliotecário:</h2>
        
        <h3>Editar</h3>
        
        <div>
          <input type="hidden" name="table" value="Bibliotecario">
          <input type="hidden" name="acao" value="alterar">
          <label>Nome de usuario: <input type="email" placeholder="Nome ou Email do(a) bibliotecário(a)" name="login" required></label>
          <button type="button" class="button-form" onclick="gravarAlteracao(document.EdicaoBibliotecario)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- FormulÃ¡rios Pop-up -->

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroAtendente">
      <div class="close-btn" onclick="fechaModal('formCadastroAtendente')">&times;</div>
      <form class="form-container" method="POST" name="GravarAtendente">
        <h2> Cadastrar</h2>
        <div>
          
          <h3>Cadastrar</h3>
          <input type="hidden" name="table" value="Atendente">
          <input type="hidden" name="acao" value="gravar">
            
          <label>Nome do bibliotecário(a): <input type="text" placeholder="Nome de usuário do(a) atendente:" name="login" required></label>
          
          <label>CPF do bibliotecário(a): <input type="text" placeholder="CPF do(a) atendente:" name="cpf" required></label>

          <label>Email do bibliotecário(a): <input type="email" placeholder="Email do(a) atendente:" name="email" required></label>

          <label>Senha do bibliotecário(a): <input type="password" placeholder="Senha do(a) atendente:" name="senha" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do(a) Atendente" name="adminpsw" required></label>

          <button type="button" class="button-form" onclick="gravarAlteracao(document.GravarAtendente)">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar atendente -->
    <div class="form-popup" id="formEdicaoAtendente">
      <div class="close-btn" onclick="fechaModal('formEdicaoAtendente')">&times;</div>
      <form class="form-container" method="POST" name="EdicaoAtendente">
        <h2> Editar</h2>
        <div>
          <input type="hidden" name="table" value="Atendente">
          <input type="hidden" name="acao" value="alterar">
          <label>Nome de usuario: <input type="email" placeholder="Nome ou Email do(a) bibliotecário(a)" name="login" required></label>
          <button type="button" class="button-form" onclick="gravarAlteracao(document.EdicaoAtendente)">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formListarBibliotecario">
      <div class="close-btn" onclick="fechaModal('formListarBibliotecario')">&times;</div>
      <form class="form-container" method="POST" name="login">

        <input type="hidden" name="table" value="Bibliotecario">
        <input type="hidden" name="acao" value="pesquisarPorLogin">
        
        <label>Nome do bibliotecário(a): <input type="text" placeholder="Nome de usuário do(a) atendente:" name="login" required></label>  
        <button type="button" class="button-form" onclick="gravarAlteracao(document.login)">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formListarAtendente">
      <div class="close-btn" onclick="fechaModal('formListarAtendente')">&times;</div>
      <form class="form-container" method="POST" name="login">

        <input type="hidden" name="table" value="Atendente">
        <input type="hidden" name="acao" value="pesquisarPorLogin">
        
        <label>Nome do bibliotecário(a): <input type="text" placeholder="Nome de usuário do(a) atendente:" name="login" required></label>  
        <button type="button" class="button-form" onclick="gravarAlteracao(document.login)">Enviar</button>
        </div>
      </form>
    </div>

    <div id="mask" onclick="fechaModalAll()"></div>
  </main>

  <!-- JS -->
  <script src="../../js/abreModal.js"></script>
  <script src="../../js/helper.js"></script>
</body>
<footer>
  <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
</footer>
</html>

