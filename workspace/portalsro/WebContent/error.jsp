<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <f:loadBundle basename="resources.pages" var="config" />
    
    <html >
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
            <link rel="stylesheet" href="styles/menu2.css" >
            <link rel="stylesheet" href="styles/basic.css" >
            <title><h:outputText value="#{config.app}" /></title>
        </head>
        <body>
            <div>
                <div class="content" >
                    <br/>
                    <jsp:include page="header.jsp" flush="false" />
                    <br/>
                    
                    <h:messages id="globalError" errorClass="error" />
                    
                </div>
                <jsp:include flush="false" page="footer.html" />
            </div>
        </body>
    </html>
</f:view>

