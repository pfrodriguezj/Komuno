<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div id="copropiedadesContenedor">
	        <div class="row">
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaCopropiedades"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>NOMBRE</th>
		                <th>NIT</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaCopropiedadesNoRegistros"></div>
		        </div>
        	</div>
       	</div>

        <link href="<c:url value='/resources/css/jquery.dataTables.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>

       	
       	<script>
			$(document).ready(function() {
			    $('#tablaCopropiedades').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/copropiedades/lst'/>",
			        'aoColumns': [
			                      { 'mData': 'nombre' ,
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 var url = "<c:url value='/protected/copropiedades/ver/'/>" + oData.nit;
						                 $(nTd).html("<a href="+url+">"+oData.nombre+"</a>");
			             			}
			                      }, 
			                      { 'mData': 'nit',
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 var url = "<c:url value='/protected/copropiedades/ver/'/>" + oData.nit;
						                 $(nTd).html("<a href="+url+">"+oData.nit+"</a>");
			             			}
			        			}]
			    } );
			});

			</script>
