<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="masthead">
    <h3 class="muted">
       	<spring:message code='header.message'/>
    </h3>

    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li>
                    <%if (request.getSession() != null && request.getSession().getAttribute("copropiedad") != null){%>
                        <a href="<c:url value="/"/>" title='<%=request.getSession().getAttribute("copropiedad")%>'>
                            <%=request.getSession().getAttribute("copropiedad")%>
                        </a>
    				<%} else { %>
                        <a href="<c:url value="/"/>" title='<spring:message code="header.home"/>'>
                            <spring:message code="header.home"/>
                        </a>
        			<%}  %>
                    </li>
                    <li>
                    	<a title='<spring:message code="header.copropiedades"/>' 
                    		href="<c:url value='/protected/copropiedades'/>"
                    			>
                   			<spring:message code="header.copropiedades"/>
               			</a>
           			</li>
                    <li>
                    	<a title='<spring:message code="header.personas"/>' 
                    		href="<c:url value='/protected/personas'/>"
                    			>
                   			<spring:message code="header.personas"/>
               			</a>
           			</li>
                </ul>
                <ul class="nav pull-right">
                    <li><a href="<c:url value='/logout' />" title='<spring:message code="header.logout"/>'><spring:message code="header.logout"/>&nbsp;(${user.name})</a></li>
                </ul>
            </div>
        </div>
    </div>
    
</div>