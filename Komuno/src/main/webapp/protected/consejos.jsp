<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<div class="well form col-lg-12">
	        <blockquote class="col-lg-6 form-title">
	            <strong class="col-lg-6 form-title" style="display: inline;">
	                <spring:message code="header.consejos.comites" />
	            </strong>
	        </blockquote>
	</div>

	
		<div class="row">
        <div id="consejosContenedor">
	        <div class="row">
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaConsejos"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>CONSEJO</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaConsejosNoRegistros"></div>
		        </div>
        	</div>
       	</div>
	</div>
	
        <link href="<c:url value='/resources/css/jquery.dataTables.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>

       	
       	<script>
			$(document).ready(function() {
				
			    $('#tablaConsejos').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/consejo/lst/'/>",
			        'aoColumns': [
			                      { 'mData': 'nombre' ,
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 var url = "<c:url value='/protected/consejo/ver/'/>" + oData.id;
						                 $(nTd).html("<a href="+url+">"+oData.nombre+"</a>");
			             			}
			                      }]
			    } );
			});

			</script>
