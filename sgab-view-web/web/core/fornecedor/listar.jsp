<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="sgab.model.dto.Fornecedor" %>
<%@page import="java.util.List" %>

<%@include file="/core/header.jsp" %>

        <center>
            <h3>Lista de Fornecedores </h3>
            <a href="/sgab/core/fornecedor/inserir.jsp">Novo Fornecedor</a>
            <form name="frmFornecedor" method="post">
                <input type="hidden" name="table" value="Fornecedor">
                <input type="hidden" name="uOrgCnpj" value="">
                
                <table id="Fornecedor">
                    <tr>
                        <th>
                            Código
                        </th>
                        <th>
                            Nome
                        </th>
                        <th>
                            Endereço
                        </th>
                        <th>
                            &nbsp; &nbsp;
                        </th>
                    </tr>
                    <%
                        List<Fornecedor> listFornecedor = (List<Fornecedor>) request.getAttribute("listFornecedor");
                        for (Fornecedor uOrg: listFornecedor) {
                    %>
                        <tr>
                            <td>
                                <a href="/sgab/main?acao=FornecedorAlterar&uOrgId=<%=uOrg.getCnpj()%>"><%=uOrg.getCnpj()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=FornecedorAlterar&uOrgId=<%=uOrg.getCnpj()%>"><%=uOrg.getNomeFornecedor()%></a>
                            </td>
                            <td>
                                <a href="/sgab/main?acao=FornecedorAlterar&uOrgId=<%=uOrg.getCnpj()%>"><%=uOrg.getEndereco()%></a>
                            </td>
                            <td>
                                <input type="button" value="Excluir" onclick="excluir(<%=uOrg.getCnpj()%>,document.frmFornecedor)">
                            </td>
                        </tr>
                    <%  } %>
                </table>
            </form>
        </center> 
        <%@include file="/core/footer.jsp" %>