<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<div class="well form col-lg-12">
	        <blockquote class="col-lg-6 form-title">
	            <strong class="col-lg-6 form-title" style="display: inline;">
	                <spring:message code="header.unidades" />
	            </strong>
	        </blockquote>
	</div>

	
		<div class="row">
	        <div id="unidadesContenedor">
		        <div class="row">
			        <!-- DataTable -->
			        <div class="col-lg-12 text-right" style="overflow-x: auto;">
			          <table id="tablaUnidades"
			            class="table table-striped table-bordered table-hover">
			            <thead>
			              <tr class="table-header">
			                <th>UNIDAD</th>
			                <th>PROPIETARIO</th>
			                <th>SALDO</th>
			                <th>CUOTA</th>
			              </tr>
			            </thead>
			            <tbody></tbody>
			          </table>
			          <div class="text-center text-warning" id="tablaUnidadesNoRegistros"></div>
			        </div>
	        	</div>
	       	</div>
	</div>
	
        <link href="<c:url value='/resources/css/jquery.dataTables.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>


       	<script>
			$(document).ready(function() {
			    $('#tablaUnidades').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/unidades_residenciales/lst/'/>${model.copropiedad.id}",
			        'aoColumns': [
			                      { 'mData': 'nombreUnidad' ,
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 var url = "<c:url value='/protected/unidades_residenciales/ver/'/>" + oData.id;
						                 $(nTd).html("<a href="+url+">"+oData.nombreUnidad+"</a>");
			             			}
			                      }, 
			                      { 'mData': 'propietario',
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 if(oData.propietario != null){
							        		 var url = "<c:url value='/protected/unidades_residenciales/ver/'/>" + oData.id;
							                 $(nTd).html("<a href="+url+">"+oData.propietario.nombre+"</a>");
						        		 }
			             			}
			                      },
			                      { 'mData': 'estadoCuenta',
							        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
							        		 var url = "<c:url value='/protected/unidades_residenciales/ver/'/>" + oData.id;
							                 $(nTd).html("<a href="+url+">"+oData.estadoCuenta+"</a>");
				             		}
			        			  },
			                      { 'mData': 'valorCuota',
							        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
							        		 var url = "<c:url value='/protected/unidades_residenciales/ver/'/>" + oData.id;
							                 $(nTd).html("<a href="+url+">"+oData.valorCuota+"</a>");
				             			}
			        			  }]
			    } );
			});
			</script>
