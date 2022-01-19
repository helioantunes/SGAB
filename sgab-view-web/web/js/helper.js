/*---------------------------------------------------------------------
 * Funcao de validacao do CNPJ
 *---------------------------------------------------------------------*/
function cnpj() {
    let botaoElcnpj = document.querySelector('#botaoProximo');
    let cnpjEscrito = document.querySelector('#cnpj');
    let verificaCnpj = /[0-9]{2}[.][0-9]{3}[.][0-9]{3}[.][/][0-9]{4}[-][0-9]{2}/;
    if (verificaCnpj.test(cnpjEscrito.value) == false) {
        document.getElementById("erro").innerHTML = "Cnpj escrito errado";
    }
}


/*---------------------------------------------------------------------
 * Funcao de validacao dos campos formLogin
 * Utilizacao:  funcao ValidaLogin() 
 *---------------------------------------------------------------------*/
function validarCamposLogin(frm) {
    var login = frm.login.value;
    var senha = frm.senha.value;
    var result = false;
    
    if (login === "") {
        alert("Preencha o campo usuário!");
        frm.login.focus();
    } else if (senha === "") {
        alert("Preencha o campo senha!");
        frm.senha.focus();
    } else {
        frm.action = "/sgab/main?acao=Logar";
        frm.submit();
        result = true;
    }
    return result;
}



function validarUsuario(frm) {
    var result = false;
    
    if (frm.login.value === "") {
        alert("Informar o login!");
        frm.login.focus();
    } else if (frm.nome.value === "") {
        alert("Informar o nome!");
        frm.nome.focus();
    } else if (frm.senha.value === "") {
        alert("Informar a senha!");
        frm.senha.focus();
    } else if (frm.email.value === "") {
        alert("Informar o email!");
        frm.email.focus();
    } 
    else
        result = true;
        
    return result;

}

function validarPessoa(frm) {
    var result = false;
    
    if (frm.cpf.value == "") {
        alert("Informar o cpf!");
        frm.cpf.focus();
    } else if(frm.login.value === ""){
        alert("Informar o Login!");
        frm.login.focus();
    } else if (frm.nome.value === "") {
        alert("Informar o nome!");
        frm.nome.focus();
    } else if (frm.senha.value === "") {
        alert("Informar a senha!");
        frm.senha.focus();
    } else if (frm.email.value === "") {
        alert("Informar o email!");
        frm.email.focus();
    } 
    else
        result = true;
        
    return result;

}

function pesquisar(frm){
    var table = frm.table.value;
    
    if (table === "Pessoa") {
        if(frm.acao.valeu === "pesquisarPorLogin"){
            if (frm.login.value == "") {
                alert("Informar o login!");
                frm.login.focus();
            } else {
                frm.action = "/sgab/main?acao=PessoaPesquisar&PessoaLogin=" + frm.login.value;            
                frm.submit();
            }
        }
    }
}

function gravarAlteracao(frm) {
    var table = frm.table.value;

    if (table === "Usuario") {
        if (validarUsuario(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=UsuarioGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=UsuarioGravarInsercao";
        }
    }
    else if (table === "Pessoa") {
        if (validarPessoa(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=PessoaGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=PessoaGravarInsercao";
        }
    }
    else if(table === "Obra") {
        if (validarObra(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=ObraGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=ObraGravarInsercao";
        }
    }
    else if(table === "Biblioteca"){
        if(validarBiblioteca(frm)){
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/gerenciaBiblioteca?acao=BibliotecaGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/cadastroBiblioteca?acao=BibliotecaGravarInsercao";
        }
    }
    else if (table === "UnidadeOrganizacional") {
        if (validarUnidadeOrganizacional(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=UnidadeOrganizacionalGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=UnidadeOrganizacionalGravarInsercao";
        }
    }

    frm.action = caminhourl;
    frm.submit();
}

function excluir(id, frm) {
    var table = frm.table.value;

    if (table === "Usuario") {
        if (confirm('Deseja excluir o Usuário com Id = ' + id + '?')) {
            frm.usuarioId.value = id;
            frm.action = "/sgab/main?acao=UsuarioExcluir";            
            frm.submit();
        }
    } 
    else if (table === "Pessoa") {
        if (confirm('Deseja excluir o Usuário com Id = ' + id + '?')) {
            frm.pessoaId.value = id;
            frm.action = "/sgab/main?acao=PessoaExcluir";            
            frm.submit();
        }
    }
    if(table === "Obra") {
        if (confirm('Deseja excluir a Obra com Id = ' + id + '?')) {
            frm.obraId.value = id;
            frm.action = "/sgab/main?acao=ObraExcluir";            
            frm.submit();
        }
    }
    if(table === "UnidadeOrganizacional") {
        if (confirm('Deseja excluir a Unidade Organizacional com Id = ' + id + '?')) {
            frm.uOrgId.value = id;
            frm.action = "/sgab/main?acao=UnidadeOrganizacionalExcluir";            
            frm.submit();
        }
    }    
}

function validarCamposPesquisaObra(frm){
    let tipo = frm.tipo.value;
    let nome = frm.nome.value;

    if(tipo == "null"){
        alert("Escolha um tipo de pesquisa!");
        frm.tipo.focus();
    }
    else if (nome == ""){
        alert("Preencha o campo de nome!");
        frm.nome.focus();
    }
    else{
        frm.action = "/sgab/main?acao=ObraPesquisar";
        frm.submit();
    }
}

function validarObra(frm){
    let result = false;
    if (frm.titulo.value === "") {
        alert("Informar o título!");
        frm.titulo.focus();
    } else if (frm.autores.value == ""){
        alert ("Insira ao menos algum autor!");
    } else if (frm.ano.value === "") {
        alert("Informar o ano de publicação!");
        frm.ano.focus();
    } else if (frm.editora.value === "") {
        alert("Informar a editora!");
        frm.editora.focus();
    } else if (frm.cidEditora.value === "") {
        alert("Informar a cidade da editora!");
        frm.cidEditora.focus();
    } else if (frm.edicao.value === "") {
        alert("Informar a edição!");
        frm.edicao.focus();
    } else if (frm.volume.value === "") {
        alert("Informar o volume!");
        frm.volume.focus();
    }
    else
        result = true;

    return result
}

function validarBiblioteca(validar) {
    let result = false;
    
    if(validar.adicionarUnidadeOrgInput.value == "" && validar.adicionarNomeInput.value != undefined) {
        window.confirm("Adicionar Unidade glub glub Org!");
    } 
     
    else if(validar.adicionarNomeInput.value == "" && validar.adicionarNomeInput.value != undefined) {
        window.confirm("Adicionar Nome!");
    }


    else
        result = true;
    
    return result;
}

function validarUnidadeOrganizacional(frm){
    let result = false;
    if (frm.nome.value === "") {
        alert("Informar o nome!");
        frm.nome.focus();
    } 
    else if (frm.endereco.value == ""){
        alert ("Insira o endereço!");
        frm.endereco.focus();
    }
    else
        result = true;

    return result
}