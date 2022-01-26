
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="/core/header.jsp" %>

<center><h3>Fazer Aquisição</h3></center>
<section id="form">
  <div id="caixa-form">
    <form name="frmPesquisaObra" method="post">
      <p>Escreva o nome da Obra que deseja fazer uma aquisição.</p>
      <div class="pesquisa-container">
        <input type="hidden" value="primeiro" name="etapa" />
        <input type="text" name="nomeObra" placeholder="Insira o nome da obra." />
        <input class="button" type="button" onclick="validarCamposPesquisaObra(document.frmPesquisaObra)" value="Pesquisar" />
      </div>
    </form>
  </div>
</section>
<script>
    
function validarCamposPesquisaObra(frm){
    let nome = frm.nomeObra.value;
    if (nome == ""){
        alert("Preencha o campo de nome!");
        frm.nomeObra.focus();
    }
    else{
        frm.action = "/sgab/main?acao=AquisicaoCriar";
        frm.submit();
    }
}
</script>

<%@include file="/core/footer.jsp" %>
