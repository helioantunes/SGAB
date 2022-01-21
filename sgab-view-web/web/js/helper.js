
/*---------------------------------------------------------------------
 * Funções de validação
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

function validarAutor(frm) {
    let result = false;
    if (frm.nomeAutor.value.trim() === "") {
        alert("Informar o nome!");
        frm.nomeAutor.focus();
    } else {
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
    } else if (frm.login.value === "") {
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
    } else if (frm.assuntos.value == ""){
        alert ("Insira ao menos algum assunto!");
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

function validarBiblioteca(frm) {
    let result = false;
    
    if (frm.uOrgNome.value === "") {
        alert("Informar a unidade organizacional.")
        frm.uOrgNome.focus();
    }
    else if (frm.bibliotecaNome.value === "") {
        alert("Informar o nome da biblioteca.")
        frm.bibliotecaNome.focus();
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

    return result;
}

function validarAssunto(frm){
    if (frm.nome.value === "") {
        alert("Informar o nome!");
        frm.nome.focus();
        return false;
    } 
    else
        return true;
}

function validarFornecedor(frm) {
    var result = false;
    if (frm.cnpj.value === "") {
        alert("Informar o cnpj!");
        frm.cnpj.focus();
    } else if (frm.nome.value === "") {
        alert("Informar o nome!");
        frm.nome.focus();
    } else if (frm.email.value === "") {
        alert("Informar o email!");
        frm.email.focus();
    } else if (frm.telefone.value === "") {
        alert("Informar o telefone!");
        frm.telefone.focus();
    } else if (frm.endereco.value === "") {
        alert("Informar o endereco!");
        frm.endereco.focus();
    } else if (frm.cep.value === "") {
        alert("Informar o cep!");
        frm.cep.focus();
    } 
    else
        result = true;

    return result;
}

/*---------------------------------------------------------------------
 * Funções de pesquisa
 *---------------------------------------------------------------------*/


function pesquisar(frm){
    var table = frm.table.value;
    
    if (table === "Pessoa") {
        if (frm.acao.value === "pesquisarPorLogin") {
            if (frm.login.value == "") {
                alert("Informar o login!");
                frm.login.focus();
            } else {
                frm.action = "/sgab/main?acao=PessoaPesquisar&PessoaLogin=" + frm.login.value;            
                frm.submit();
            }
        }
    }
    if (table === "Autor") {
        frm.action = "/sgab/main?acao=AutorPesquisar";
        frm.submit();
    }
}

/*---------------------------------------------------------------------
 * Funções de gravação de alterações
 *---------------------------------------------------------------------*/

function gravarAlteracao(frm) {
    var table = frm.table.value;

    if (table === "Assunto") {
        if (validarAssunto(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=AssuntoGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=AssuntoGravarInsercao";
        }
    }
    else if (table === "Autor") {
        if (validarAutor(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=AutorAlterar";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=AutorCadastrar";
        }
    }        
    else if(table === "Biblioteca"){
        if(validarBiblioteca(frm)){
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=BibliotecaGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=BibliotecaGravarInsercao";
        }
    }    
    else if (table === "Fornecedor") {
        if (validarFornecedor(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=FornecedorGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=FornecedorGravarInsercao";
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
    else if (table === "Pessoa") {
        if (validarPessoa(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=PessoaGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=PessoaGravarInsercao";
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
    else if (table === "Usuario") {
        if (validarUsuario(frm)) {
            if (frm.acao.value === "alterar")
                caminhourl = "/sgab/main?acao=UsuarioGravarAlteracao";
            else if (frm.acao.value === "gravar")
                caminhourl = "/sgab/main?acao=UsuarioGravarInsercao";
        }
    }    
    

    frm.action = caminhourl;
    frm.submit();
}

/*---------------------------------------------------------------------
 * Funções de exclusão
 *---------------------------------------------------------------------*/

function excluir(id, frm) {
    var table = frm.table.value;

    if (table === "Assunto") {
        if (confirm('Deseja excluir o Assunto com Id = ' + id + '?')) {
            frm.assuntoId.value = id;
            frm.action = "/sgab/main?acao=AssuntoExcluir";            
            frm.submit();
        }
    } 
    else if (table === "Autor") {
        if (confirm('Deseja excluir o Autor com Id = ' + frm.idAutor.value + '?')) {
            frm.action = "/sgab/main?acao=AutorExcluir";
            frm.submit();
        }
    }
    else if (table === "Biblioteca") {
        if (confirm('Deseja excluir a Biblioteca com Id = ' + id + '?')) {
            frm.bibliotecaId.value = id;
            frm.action = "/sgab/main?acao=BibliotecaExcluir";
            frm.submit();
        }
    }    
    else if(table === "Fornecedor") {
        if (confirm('Deseja excluir o Fornecedor com o id = ' + id + '?')) {
            frm.fornecedorCNPJ.value = id;
            frm.action = "/sgab/main?acao=FornecedorExcluir";            
            frm.submit();
        }
    } 
    else if(table === "Obra") {
        if (confirm('Deseja excluir a Obra com Id = ' + id + '?')) {
            frm.obraId.value = id;
            frm.action = "/sgab/main?acao=ObraExcluir";            
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
    else if(table === "UnidadeOrganizacional") {
        if (confirm('Deseja excluir a Unidade Organizacional com Id = ' + id + '?')) {
            frm.uOrgId.value = id;
            frm.action = "/sgab/main?acao=UnidadeOrganizacionalExcluir";            
            frm.submit();
        }
    }
    else if (table === "Usuario") {
        if (confirm('Deseja excluir o Usuário com Id = ' + id + '?')) {
            frm.usuarioId.value = id;
            frm.action = "/sgab/main?acao=UsuarioExcluir";            
            frm.submit();
        }
    } 
}
    