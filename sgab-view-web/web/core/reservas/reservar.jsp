<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/core/header.jsp" %>

<!-- 
%@page import="sgab.model.dto.Exemplar" %>
% 
    Exemplar exemplarAlvo = (Exemplar) request.getSession().getAttribute("exemplarAlvo");
    String justificativa = request.getParameter("justificativa");
    Long quantidade = null;
    if(request.getParameter("quantidadeDesejada") != null)
        quantidade = Long.parseLong(request.getParameter("quantidadeDesejada"));
%>
-->
<center><h3>Consulta de Reserva</h3></center>
      <section id="form">
        <div id="caixa-form">
          <form id="AlteraExemplar" name="AlteraExemplar" method="post">
            <input type="hidden" name="table" value="Exemplar">
            <input type="hidden" name="acao" value="alterar">
            <input type="hidden" name="exemplarId" value="">
            
            <center><h3>Exemplar</h3></center>
            <label for="categoria">Categoria</label>
            <select disabled name="categoria" id="categoria">
              <option value="livro">Livro</option>
              <option value="mapa">Mapa</option>
              <option value="docComputacional">Documento computacional</option>
            </select>
            <label for="titulo">Título</label>
            <input
              type="text"
              disabled
              id="titulo"
              name="titulo"
              value=""
            />
           
            <label>Autores</label>
            <input id="autores-input" type="hidden" name="autores" value="">
            <div id="autores" style="padding-top: 10px;">
                <!-- 
                % for(Autor autorAtual:exemplarAlvo.getAutor()){ %>
                    
                % } %>
                -->
                <div class="acoes" id=""><span></span></div>
            </div>
            
            <label>Assuntos</label>
            <input id="assuntos-input" type="hidden" name="assuntos" value="">
            <div id="assuntos" style="padding-top: 10px;">
                <!-- 
                % for(Assunto assuntoAtual:exemplarAlvo.getAssunto()){ %>
                    
                % } %>
                -->
                <div class="acoes" id=""><span></span></div>
            </div>

            <label for="nota">Nota</label>
            <input
              type="text"
              disabled
              style="height: 5em;"
              id="nota"
              name="nota"
              value=""
            />
            <div class="divisao">
              <div>
                <label for="ano">Ano de publicação</label>
                <input
                  type="number"  
                  disabled
                  id="ano"
                  name="ano"
                  value=
                />
              </div>
              <div>
                <label for="editora">Editora</label>
                <input
                  type="text"
                  disabled
                  id="editora"
                  name="editora"
                  value=""
                />
              </div>
            </div>
            <label for="cidEditora">Cidade da Editora</label>
            <input
              type="text"
              disabled
              id="cidEditora"
              name="cidEditora"
              value=""
            />
            <div class="divisao">
              <div>
                <label for="edicao">Edição</label>
                <input
                  type="number"
                  disabled
                  id="edicao"
                  name="edicao"
                  value=""
                />
              </div>
              <div>
                <label for="volume">Volume</label>
                <input
                  type="number"
                  disabled
                  id="volume"
                  name="volume"
                  value=""
                />
              </div>
              
            </div>
            <div class="buttons">
                <button type="button" id="alterar"><a href="/sgab/main?acao=">Confirmar Reserva</a></button>
            </div>
          </form>
        </div>
      </section>

<%@include file="/core/footer.jsp" %>