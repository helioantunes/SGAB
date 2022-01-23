<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title>SGAB | Página do Gerente</title>
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
      <h1>Página do Gerente</h1>
    </section>
    <section>
      <div class="caixa-gestao">
        <h2>Operações de Bibliotecários</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroBibliotecario')">Cadastrar bibliotecário</button>
        <button class="button-gestao" onclick="abreModal('formHabilitacaoBibliotecario')">Habilitar bibliotecário</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoBibliotecario')">Editar bibliotecário</button>
        <button class="button-gestao" onclick="abreModal('formDesativacaoBibliotecario')">Desativar bibliotecário</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Atendente</h2>
        <button class="button-gestao" onclick="abreModal('formCadastroAtendente')">Cadastrar atendente</button>
        <button class="button-gestao" onclick="abreModal('formHabilitacaoAtendente')">Habilitar atendente</button>
        <button class="button-gestao" onclick="abreModal('formEdicaoAtendente')">Editar atendente</button>
        <button class="button-gestao" onclick="abreModal('formDesativacaoAtendente')">Desativar atendente</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Biblioteca</h2>
        <button class="button-gestao" onclick="">Gestão Biblioteca</button>
      </div>
      <br>
      <div class="caixa-gestao">
        <h2>Operações de Unidade Organizacional</h2>
        <button class="button-gestao" onclick="">Gestão Unidade Organizacional</button>
      </div>
    </section>

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroBibliotecario">
      <div class="close-btn" onclick="fechaModal('formCadastroBibliotecario')">&times;</div>
      <form class="form-container" action="ServletBibliotecarios" method="POST">
        <h2> Cadastrar bibliotecários</h2>
        <div>
          <label>Nome do bibliotecário: <input type="text" placeholder="Nome do bibliotecários:" name="inputNomeBibliotecarioCadastrar" required></label>

          <label>Email do bibliotecário: <input type="email" placeholder="Email do bibliotecário:" name="inputEmailBibliotecarioCadastrar" required></label>

          <label>Senha do bibliotecário: <input type="password" placeholder="Senha do bibliotecário:" name="inputSenhaBibliotecarioCadastrar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecario" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de habilitar bibliotecário -->
    <div class="form-popup" id="formHabilitacaoBibliotecario">
      <div class="close-btn" onclick="fechaModal('formHabilitacaoBibliotecario')">&times;</div>
      <form class="form-container" action="ServletBibliotecarios" method="POST">
        <h2> Habilitar bibliotecário:</h2>
        <div>
          <label>Identificação do bibliotecário: <input type="number" placeholder="identificação do bibliotecário" name="inputIdentBibliotecarioHabilitar" required></label>

          <label>Email: <input type="email" placeholder="Email do bibliotecário:" name="inputEmailBibliotecarioHabilitar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecario" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar bibliotecário -->
    <div class="form-popup" id="formEdicaoBibliotecario">
      <div class="close-btn" onclick="fechaModal('formEdicaoBibliotecario')">&times;</div>
      <form class="form-container" action="ServletBibliotecarios" method="POST">
        <h2> Editar bibliotecário:</h2>
        <div>
          <label>Identificação do bibliotecário:  <input type="number" placeholder="identificação do bibliotecário" name="inputIdentBibliotecarioEditar" required></label>

          <label>Email: <input type="email" placeholder="Email do bibliotecário" name="inputEmailBibliotecarioEditar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecario" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formEdicaoConfirmadaBibliotecario">
      <div class="close-btn" onclick="fechaModal('formEdicaoConfirmadaBibliotecario')">&times;</div>
      <form class="form-container" action="ServletBibliotecarios" method="POST">
        <h2> Editar bibliotecário</h2>
        <div>
          <label>Identificação do bibliotecário: <input type="number" placeholder="identificação do bibliotecário" name="inputIdentBibliotecarioEditConfir"></label>

          <label>Email:  <input type="email" placeholder="Email do bibliotecário" name="inputEmailBibliotecarioEditConfir"></label>

          <label>Nascimento: <input type="date" name="inputNascBibliotecarioEditConfir"></label>

          <label>Afiliação: <input type="text" placeholder="Local de afiliação" name="inputAfiliBibliotecarioEditConfir"></label>

          <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecario" name="adminpsw"></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de desativar bibliotecário -->
    <div class="form-popup" id="formDesativacaoBibliotecario">
      <div class="close-btn" onclick="fechaModal('formDesativacaoBibliotecario')">&times;</div>
      <form class="form-container" action="ServletBibliotecarios" method="POST">
        <h2> Desativar bibliotecário</h2>
        <div>
          <label>Identificação do bibliotecário: <input type="number" placeholder="identificação do bibliotecário" name="inputIdentBibliotecarioDesativar" required></label>

          <label>Email: <input type="email" placeholder="Email do bibliotecário:" name="inputEmailBibliotecarioDesativar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecario" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- FormulÃ¡rios Pop-up -->

    <!-- Form de cadastro -->
    <div class="form-popup" id="formCadastroAtendente">
      <div class="close-btn" onclick="fechaModal('formCadastroAtendente')">&times;</div>
      <form class="form-container" action="ServletAtendentes" method="POST">
        <h2> Cadastrar Gerente</h2>
        <div>
          <label>Nome do Gerente: <input type="text" placeholder="Nome do gerente" name="inputNomeGerenteCadastrar" required></label>

          <label>Email do Gerente: <input type="email" placeholder="Email do gerente" name="inputEmailGerenteCadastrar" required></label>

          <label>Senha do Gerente: <input type="password" placeholder="Senha do gerente" name="inputSenhaGerenteCadastrar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do gerente" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de habilitar gerente -->
    <div class="form-popup" id="formHabilitacaoAtendente">
      <div class="close-btn" onclick="fechaModal('formHabilitacaoAtendente')">&times;</div>
      <form class="form-container" action="ServletAtendentes" method="POST">
        <h2> Habilitar Gerente</h2>
        <div>
          <label>Identificação do Gerente: <input type="number" placeholder="identificação do gerente" name="inputIdentGerenteHabilitar" required></label>

          <label>Email: <input type="email" placeholder="Email do gerente" name="inputEmailGerenteHabilitar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do gerente" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de editar atendente -->
    <div class="form-popup" id="formEdicaoAtendente">
      <div class="close-btn" onclick="fechaModal('formEdicaoAtendente')">&times;</div>
      <form class="form-container" action="ServletAtendentes" method="POST">
        <h2> Editar Gerente</h2>
        <div>
          <label>Identificação do Gerente:  <input type="number" placeholder="identificação do atendente" name="inputIdentGerenteEditar" required></label>

          <label>Email: <input type="email" placeholder="Email do gerente" name="inputEmailGerenteEditar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do gerente" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <div class="form-popup" id="formEdicaoConfirmadaAtendente">
      <div class="close-btn" onclick="fechaModal('formEdicaoConfirmadaAtendente')">&times;</div>
      <form class="form-container" action="ServletAtendentes" method="POST">
        <h2> Editar Gerente</h2>
        <div>
          <label>Identificação do Gerente: <input type="number" placeholder="identificação do atendente" name="inputIdentGerenteEditConfir"></label>

          <label>Email:  <input type="email" placeholder="Email do gerente" name="inputEmailGerenteEditConfir"></label>

          <label>Nascimento: <input type="date" name="inputNascGerenteEditConfir"></label>

          <label>Afiliação: <input type="text" placeholder="Local de afiliação" name="inputAfiliGerenteEditConfir"></label>

          <label>Confirmação: <input type="password" placeholder="Senha do gerente" name="adminpsw"></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>

    <!-- Form de desativar atendente -->
    <div class="form-popup" id="formDesativacaoAtendente">
      <div class="close-btn" onclick="fechaModal('formDesativacaoAtendente')">&times;</div>
      <form class="form-container" action="ServletAtendentes" method="POST">
        <h2> Desativar Gerente</h2>
        <div>
          <label>identificação do Gerente <input type="number" placeholder="identificação do atendente" name="inputIdentGerenteDesativar" required></label>

          <label>Email: <input type="email" placeholder="Email do gerente" name="inputEmailGerenteDesativar" required></label>

          <label>Confirmação: <input type="password" placeholder="Senha do gerente" name="adminpsw" required></label>

          <button type="submit" class="button-form">Enviar</button>
        </div>
      </form>
    </div>
    <div id="mask" onclick="fechaModalAll()"></div>
  </main>
    
  <footer>
    <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
  </footer>

  <!-- JS -->
  <script src="../js/abreModal.js"></script>

</body>

</html>
