<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Fornecedor" %>

<%@include file="/core/header.jsp" %>

        <% Fornecedor uOrg = (Fornecedor) request.getAttribute("fornecedor"); %>

        <center>
            <h3>Alterar Usuário</h3>
            <form name="frmAltFornecedor" method="post">                
                <input type="hidden" name="table" value="Fornecedor">
                <input type="hidden" name="acao" value="alterar">
                <table>
                    <tr>
                        <td>
                            Cnpj:
                        </td>
                        <td>
                            <input type="text" name="uOrgCnpj" value="<%=uOrg.getCnpj()%>" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nome:
                        </td>
                        <td>
                            <input type="text" name="nome" value="<%=uOrg.getNomeFornecedor()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço:
                        </td>
                        <td>
                            <input type="text" name="endereco" value="<%=uOrg.getEndereco()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input type="text" name="email" value="<%=uOrg.getEmail()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefone:
                        </td>
                        <td>
                            <input type="text" name="telefone" value="<%=uOrg.getTelefone()%>">
                        </td>
                    </tr>
                    <tr>
                       <td colspan="2" aling="center">
                            <input type="button" value="Gravar" onclick="gravarAlteracao(document.frmAltFornecedor)">
                            <input type="button" value="Excluir" onclick="excluir(<%=uOrg.getCnpj()%>, document.frmAltFornecedor)">
                            <a href="/sgab/core/fornecedor/inserir.jsp">Inserir Fornecedor</a>    
                        </td>
                    </tr>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>
