<!doctype html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title>SGAB | Página do Leitor</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta property="og:title" content="">
  <meta property="og:type" content="">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <link rel="manifest" href="site.webmanifest">
  <link rel="apple-touch-icon" href="icon.png">


  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/styles.css">
  <link rel="stylesheet" href="../../css/modal.css">

  <meta name="theme-color" content="#fafafa">
</head>

<body>
  <header>
    <div id="pagina-inicial">
      <a href="" title="Página Inicial">SGAB</a>
    </div>
    <div id="logo-topo">
      <a href="https://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
        <img src="img/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais">
      </a>
    </div>
  </header>

  <main>
    <section id="nome-form">
      <h1>Página do Leitor</h1>
    </section>

    <section>
      <div class="caixa-gestao">
        <h2>Operações de Leitores</h2>
        <button class="button-gestao" onclick="abreFormCadastro()">Cadastrar leitor</button> 
      </div>
      <br>
    </section>

    <!-- Formulários Pop-up -->

    <!-- Form de cadastro -->
    
    <section class="form-popup" id="formCadastro">
      <div class="close-btn" onclick="fechaFormCadastro()">&times;</div>
      <div id="caixa-form" style=>
          <form class="form-container" name="inserirPessoa" method="post">
              <input type="hidden" name="table" value="Pessoa">
              <input type="hidden" name="acao" value="gravar">
              <div>
                  <label for="login">Informe o seu Login <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="login" name="login" placeholder="Login" required>
                  <small>Digite um Login válido.</small>
              </div>
              <div>
                  <label for="cpf">Informe o seu CPF <span class="input-obrigatorio">*</span></label>
                  <input type="number" id="cpf" name="cpf" placeholder="CPF" required maxlength="11">
                  <small>Digite um CPF válido. Informe apenas números.</small>
              </div>
              <div>
                  <label for="nome">Informe o seu nome <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="nome" name="nome" placeholder="Nome" required>
                  <small>Digite seu nome e sobrenome.</small>
              </div>
              <div>
                  <label for="email">Informe o seu endereço de email <span class="input-obrigatorio">*</span></label>
                  <input type="text" id="email" name="email" placeholder="Email" required>
                  <small>Digite um endereço de email válido.</small>
              </div>
              <div>
                  <label for="senha">Crie uma senha <span class="input-obrigatorio">*</span></label>
                  <input type="password" id="senha" name="senha" placeholder="Senha" required>
                  <small>A senha precisa ter 8 caracteres, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.</small>
              </div>
              <div>
                  <label for="senha2">Confirme a sua senha <span class="input-obrigatorio">*</span></label>
                  <input type="password" id="senha2" name="senha2" placeholder="Senha" required>
                  <small>As senhas não correspondem.</small>
              </div>
              <div class="caixa-form-footer">
                  <input type="button" class="button-form" name="ordem" value="Cadastrar">
              </div>
          </form>
      </div>
  </section>

  <script type="text/javascript" language="JavaScript" src="/sgab/js/validacao.js"></script>

  <footer>
    <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
  </footer>

  <!-- JS -->
  <script src="js/vendor/modernizr-3.11.2.min.js"></script>
  <script src="js/plugins.js"></script>
  <script src="js/main.js"></script>
  <script src="js/script.js"></script>

</body>

</html>
