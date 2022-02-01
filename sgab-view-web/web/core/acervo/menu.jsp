<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="/core/header.jsp" %>

    <html class="no-js" lang="">
    <head>
      <meta charset="utf-8">
      <title>SGAB | Gestão de Acervo</title>
      <meta name="description" content="">
      <meta name="viewport" content="width=device-width, initial-scale=1">

      <meta property="og:title" content="">
      <meta property="og:type" content="">
      <meta property="og:url" content="">
      <meta property="og:image" content="">

      <link rel="stylesheet" href="../../css/styles.css">

      <meta name="theme-color" content="#fafafa">
    </head>

    <body>
      <main>
        <section id="nome-form">
          <h1>Gestão de Acervo</h1>
        </section>

        <section>
          <div class="caixa-gestao">
            <h2>Operações de Restauração</h2>
            <button class="button-gestao" onclick="abreModal('formEnvioRestauracao')">Enviar para restauração</button>
            <button class="button-gestao" onclick="abreModal('formRetornoRestauracao')">Registrar retorno</button>
            <button class="button-gestao" onclick="abreModal('formDesativacaoInvalidez')">Desativar livro</button>
            <button class="button-gestao" >Listar livros em restauração</button>
          </div>
          <br>
          <div class="caixa-gestao">
            <h2>Operações de Consulta</h2>
            <button class="button-gestao" onclick="abreModal('formExemplarConsulta')">Registrar livro de consulta</button>
            <button class="button-gestao" >Listar livros em consulta</button>
          </div>
          <br>
          <div class="caixa-gestao">
            <h2>Operações de Transferência entre Bibliotecas</h2>
            <button class="button-gestao" onclick="abreModal('formTransferExemplar')">Transferir livro</button>
            <button class="button-gestao" onclick="abreModal('formRecebExemplar')">Receber livro</button>
            <button class="button-gestao" >Listar transferências</button>

          </div>

        </section>

        <!-- Formulários Pop-up -->

        <!-- Form de envio-->
        <div class="form-popup" id="formEnvioRestauracao">
          <div class="close-btn" onclick="fechaModal('formEnvioRestauracao')" >&times;</div>
          <form class="form-container">
            <h2> Cadastro de Envio para Restauração</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idEnvio" required></label>
              <label>Data de envio: <input type="date" name="dataEnvio" required></label>
              <label>Justificativa: <input type="text" placeholder="Razão para envio à restauração" name="razaoEnvio" required></label>
              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de retorno-->
        <div class="form-popup" id="formRetornoRestauracao">
          <div class="close-btn" onclick="fechaModal('formRetornoRestauracao')">&times;</div>
          <form class="form-container">
            <h2>Registro de Retorno da Restauração</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>
              <label>Data de retorno: <input type="date" name="dataRetorno" required></label>
              <label>Status de restauração:
                <label for="completa"><input type="radio" id="completa" name="fav_language" value="Completa">Completa</label>
                <label for="incompleta"><input type="radio" id="incompleta" name="fav_language" value="Incompleta">Incompleta</label>
              </label>
              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">

            </div>
          </form>
        </div>

        <!-- Formulário de desativação -->
        <div class="form-popup" id="formDesativacaoInvalidez">
          <div class="close-btn" onclick="fechaModal('formDesativacaoInvalidez')">&times;</div>
          <form class="form-container">
            <h2>Desativar livro por invalidez</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>
              <label>Data de desativação: <input type="date" name="dataDesativar" required></label>
              <label>Justificativa: <input type="text" placeholder="Razão para desativar" name="razaoDesativar" required></label>
              <label>Confirmação: <input type="password" placeholder="Senha do Bibliotecário" required></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de consulta -->
        <div class="form-popup" id="formExemplarConsulta">
          <div class="close-btn" onclick="fechaModal('formExemplarConsulta')">&times;</div>
          <form class="form-container">
            <h2>Registrar como Livro de Consulta</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>
              <label>Justificativa: <input type="text" placeholder="Razão para registrar como de consulta" name="razaoConsulta" required></label>
              <label>Confirmação: <input type="password" placeholder="Senha do Gestor" required></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de Transferencia -->
        <div class="form-popup" id="formTransferExemplar">
          <div class="close-btn" onclick="fechaModal('formTransferExemplar')">&times;</div>
          <form class="form-container">
            <h2>Transferir Exemplar para outra Bilioteca</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>

              <label>ID da Biblioteca: <input type="number" placeholder="Identificação da Biblioteca Receptora"></label>

              <label> Confirmação: <input type="password" placeholder="Senha do Gestor" required></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

        <!-- Formulário de Recebimento -->
        <div class="form-popup" id="formRecebExemplar">
          <div class="close-btn" onclick="fechaModal('formRecebExemplar')">&times;</div>
          <form class="form-container">
            <h2>Confirmar Recebimento de Exemplar de outra Biblioteca</h2>
            <div>
              <label>ID: <input type="text" placeholder="ID do Livro" name="idRetorno" required></label>

              <label>ID da Biblioteca: <input type="number" placeholder="Identificação da Biblioteca Receptora"></label>

              <label> Confirmação: <input type="password" placeholder="Senha do Gestor" required></label>

              <button type="submit" class="button-form">Enviar</button>
              <input type="reset" class="button-form">
            </div>
          </form>
        </div>

      </main>
      <!-- JS -->
      <script src="../../js/abreModal.js"></script>
    </body>

<%@include file="/core/footer.jsp" %>
