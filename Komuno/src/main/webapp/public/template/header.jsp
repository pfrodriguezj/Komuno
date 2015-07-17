<%@page import="co.com.silex.dto.CopropiedadDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="masthead">
    <h3 class="muted">
       	<spring:message code='menu.message'/>
    </h3>


                 <ul class="nav nav-pills" role="tablist">
                <!--  MENU CON COPROPIEDAD SELECCIONADA -->
                <%if (request.getSession() != null && request.getSession().getAttribute("copropiedad") != null){
                CopropiedadDto cDto = (CopropiedadDto)request.getSession().getAttribute("copropiedad");%>
                    <li role="presentation" class="active dropdown">
   						<a id="menu_copropiedad" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<%=cDto%>
          					<span class="caret"></span>
				        </a>
                    	<ul id="menuCopropiedad" class="dropdown-menu" aria-labelledby="menu_copropiedad">
                    		<li>
		                        <a href='<c:url value="/protected/copropiedades/ver/"/><%=cDto.getId()%>' title='<%=cDto%>'>
		                            <spring:message code='menu.copropiedad'/>
		                        </a>
	                        </li>
	                        <li>
   		                        <a href='<c:url value="/protected/copropiedades/ver_consejos/"/>' title='Consejos y comit&eacute;s'>
		                            <spring:message code='menu.consejos'/>
		                        </a>
	                        </li>
	                        <li><a href="#"><spring:message code='menu.servicios'/></a></li>
	                        <li><a href="#"><spring:message code='menu.proyectos'/></a></li>
                        </ul>
                    </li>

					<li role="presentation" class="dropdown">
						<a id="menu_comunidad" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<spring:message code='menu.comunidad'/>
          					<span class="caret"></span>
				        </a>
				        <ul id="menuComunidad" class="dropdown-menu" aria-labelledby="menu_comunidad">
				        	 <li>
				        	 	<a href='<c:url value="/protected/copropiedades/ver_unidades"/>' title='Unidades'>
				        	 		<spring:message code='menu.unidades'/>
				        	 	</a>
			        	 	 </li>
				        	 <li>
				        	 	<a href='<c:url value="/protected/persona/personas_page"/>' title='Personas'>
				        	 		<spring:message code='menu.personas'/>
				        	 	</a>
				        	 </li>
				        	 <li><a href="#"><spring:message code='menu.vehiculos'/></a></li>
				        	 <li><a href="#"><spring:message code='menu.mascotas'/></a></li>
				       	</ul>
					</li>
					
					<li role="presentation" class="dropdown">
						<a id="menu_finanzas" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<spring:message code='menu.finanzas'/>
          					<span class="caret"></span>
				        </a>
				        <ul id="menuFinanzas" class="dropdown-menu" aria-labelledby="menu_finanzas">
				        	 <li>
				        	 	<a href='<c:url value="/protected/presupuesto/ver_presupuesto"/>' title='Ver presupuesto'>
				        	 		<spring:message code='menu.presupuesto'/>
				        	 	</a>
				        	 </li>
				        	 <li><a href="#"><spring:message code='menu.egresos'/></a></li>
				        	 <li><a href="#"><spring:message code='menu.ingresos'/></a></li>
				        	 <li><a href="#"><spring:message code='menu.cartera'/></a></li>
				       	</ul>
					</li>                    
           			
                    <li>
	                    	<a title='<spring:message code="header.copropiedades"/>' 
	                    		href="<c:url value='/protected/copropiedades'/>"
	                    			>
	                   			<spring:message code="header.copropiedades"/>
	               			</a>
           			</li>
       			<%} else {%>
           			<!--  MENU SIN COPROPIEDAD SELECCIONADA -->
           			<li>
                        <a href="<c:url value="/"/>" title='<spring:message code="header.home"/>'>
                            <spring:message code="header.home"/>
                        </a>
           			</li>
                    <li>
	                    	<a title='<spring:message code="header.copropiedades"/>' 
	                    		href="<c:url value='/protected/copropiedades'/>"
	                    			>
	                   			<spring:message code="header.copropiedades"/>
	               			</a>
           			</li>
       			<%} %>
       				<li><a href="<c:url value='/logout' />" title='<spring:message code="header.logout"/>'><spring:message code="header.logout"/>&nbsp;(${user.name})</a></li>
                </ul>
</div>