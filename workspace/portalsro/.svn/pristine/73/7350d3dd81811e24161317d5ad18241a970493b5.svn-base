    <%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
    <%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
    
    <f:subview id="menu">
        <f:loadBundle basename="resources.pages" var="config" />
        <h:graphicImage alt="ECT" url="images/logo.jpg" styleClass="logo" />
        
        <f:verbatim>
            <div class="date">
            <h5>
        </f:verbatim>
                <h:outputText value="#{date}" > 
                    <f:convertDateTime pattern="EEEE," />
                </h:outputText>
                <f:verbatim>
            </h5>
                <h5>
            </f:verbatim>            
            
                <h:outputText value="#{date}" > 
                    <f:convertDateTime dateStyle="long"  />
                </h:outputText>
     
                <f:verbatim>
            </h5>
        </div>
            <p>
        </f:verbatim>
            <h:outputText value="#{config.menuTrans}" />
            <f:verbatim>
        </p>
            <ul>
            <li>
        </f:verbatim>
                <h:outputLink value="faces/ultimaTransmissao.jsp" title="#{config.ultimaTransmissaoHint}">
                    <h:outputText value="#{config.ultimaTransmissaoTitle}" />
                </h:outputLink>
                <f:verbatim>
            </li>
                <li>
            </f:verbatim>
                <h:outputLink value="faces/semTransmissao.jsp" title="#{config.semTransmissaoHint}">
                    <h:outputText value="#{config.semTransmissaoTitle}" />
                </h:outputLink>
                <f:verbatim>
            </li>
                <li>
            </f:verbatim>
                <h:outputLink value="faces/controleTransmissao.jsp" title="#{config.controleTransmissaoHint}">
                    <h:outputText value="#{config.controleTransmissaoTitle}" />
                </h:outputLink>
                <f:verbatim>
            </li>
        </ul>
            
            
        
       <p>
        </f:verbatim>
            <h:outputText value="#{config.pendencia}" />
            <f:verbatim>
        </p>
             <ul>
            <li>
        </f:verbatim>
                <h:outputLink value="faces/pendenciaBaixa.jsp" title="#{config.pendenciaHint}">
                    <h:outputText value="#{config.pendenciaBaixaTitle}" />
                </h:outputLink>
                <f:verbatim>
            </li>
        </ul>   
        
            <p>
                <a href="http://validator.w3.org/check?uri=referer" class="w3c"><img
                src="images/valid-html401.png"
                alt="Valid HTML 4.01 Transitional" height="31" width="88" class="w3c" /></a>
            </p> 
            
            <p>
                <a class="w3c" href="http://jigsaw.w3.org/css-validator/"> 
                    <img src="images/vcss"
                    alt="Valid CSS!" height="31" width="88" class="w3c2" />
                </a>
            </p>
            
            
            
        </f:verbatim>
    </f:subview>