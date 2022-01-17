<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SGAB | Cadastro de Fornecedores</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../css/styles.css">
    <script src="../../js/helper.js"></script>
</head>
<body>
    <header>
        <div id="pagina-inicial">
            <a href="" title="Página Inicial">
            SGAB
            </a>
        </div>
        <div id="logo-topo">
            <a href="http://www.cefetmg.br/" target="_blank" title="Centro Federal de Educação Tecnológica de Minas Gerais">
                <img src="../../images/logo_topo.png" alt="Centro Federal de Educação Tecnológica de Minas Gerais" />
            </a>
        </div>
    </header>
    <main>
        <section id="nome-form">
            <h1>Cadastro de Fornecedores</h1>
        </section>
        <section id="form">
            <div id="caixa-form">
                <form>
                    <div>
                        Nome: <input type="text" id="nomeEmpresa" name="nome" placeholder="Nome da empresa" required>
                    </div>
                    <div>
                        <label for="cnpj">CNPJ:</label> <input type="text" id="cnpj" name="cnpj" placeholder="ID" required>
                    </div>
                    <div id="caixa-form-footer">  
                        <button type="submit" id="botaoProximo"  onclick="cnpj()" >Acessar</button>
                        <button type="submit" id="dados" onclick="document.getElementById('caixa-dados').style.visibility = 'visible'; email()">Cadastrar</button>
                        <button type="submit" id="dados" onclick="document.getElementById('caixa-dados').style.visibility = 'visible'; email()">Mudar Dados</button>
                        <button type="submit" id="deletar" onclick="cnpj()">Deletar Fornecedor</button>
                    </div>
                </form>
                <form>
                <div id="caixa-dados">
                    <div>
                        Nome: <input type="text" id="nomeEmpresa" name="nome" placeholder="Nome da empresa">
                    </div>
                    <div>
                        email: <input type="text" id="idemail" name="email" placeholder="email">
                    </div>
                    <div>
                        cep: <input type="text" id="idcep" name="cep" placeholder="cep">
                    </div>
                    <div>
                        endereço: <input type="text" id="idcep" name="cep" placeholder="cep">
                    </div>
                    
                    <div id="caixa-form-footer">
                        <button type="submit" id="finalizar">Finalizar</button>
                    </div>
                </div>
                </form>                
            </div>
        </section>
    </main>
    <footer>
        <p>SGAB - Sistema de Gestão de Acervo Bibliográfico</p>
    </footer>
</body>
</html>
