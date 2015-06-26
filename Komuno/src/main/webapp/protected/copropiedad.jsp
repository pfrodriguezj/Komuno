<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well form-horizontal">
        <blockquote class="col-lg-12 form-title">
            <strong class="col-lg-12 form-title" style="display: inline;">
                ${model.copropiedad.nombre}
            </strong>
        </blockquote>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">NIT</label>
			<div class="col-lg-10">
				<input id="nit" name="nit" class="form-control" value="${model.copropiedad.nit}"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="direccion" class="col-lg-2 control-label">DIRECCION</label>
			<div class="col-lg-10">
				<input id="direccion" name="direccion" class="form-control" value="calle larga"/>
			</div>
		</div>

		<div class="form-group">
			<label for="telefono" class="col-lg-2 control-label">TELEFONO</label>
			<div class="col-lg-10">
				<input id="telefono" name="telefono" class="form-control" value="1982371"/>
			</div>
		</div>
</div>

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

        <link href="<c:url value='/resources/css/jquery.dataTables.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>

       	
       	<script>
			$(document).ready(function() {
			    $('#tablaUnidades').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/unidades_residenciales/lst'/>",
			        'aoColumns': [
			                      { 'mData': 'nombreUnidad' ,
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 var url = "<c:url value='/protected/unidades_residenciales/ver/'/>" + oData.id;
						                 $(nTd).html("<a href="+url+">"+oData.nombreUnidad+"</a>");
			             			}
			                      }, 
			                      { 'mData': 'id',
						        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
						        		 var url = "<c:url value='/protected/unidades_residenciales/ver/'/>" + oData.id;
						                 $(nTd).html("<a href="+url+">"+oData.nombreUnidad+"</a>");
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
