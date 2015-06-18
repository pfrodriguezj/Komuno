<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
<head>
        <title><spring:message  code="project.title" /></title>
        <link href="<c:url value='/resources/css/bootstrap.min.css'  />" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/project_style.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery-1.11.3.min.js' />"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header" />

            <tiles:insertAttribute name="body" />
        </div>

        <tiles:insertAttribute name="footer" />
    </body>
</html>