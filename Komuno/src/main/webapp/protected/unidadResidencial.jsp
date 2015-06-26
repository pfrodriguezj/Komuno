<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well form-horizontal">
        <blockquote class="col-lg-12 form-title">
            <strong class="col-lg-12 form-title" style="display: inline;">
                ${model.unidad.nombreUnidad}
            </strong>
        </blockquote>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">PROPIETARIO</label>
			<div class="col-lg-10">
				<input id="nombrePropietario" name="nombrePropietario" class="form-control" value="${model.unidad.propietario.nombre}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">TELEFONO</label>
			<div class="col-lg-10">
				<input id="nombrePropietario" name="nombrePropietario" class="form-control" value="${model.unidad.propietario.telefono}"/>
			</div>
		</div>
</div>
		
<div class="container">
	<h2> RESIDENTES</h2>
	tabla de residentes
</div>

        <div id="historialPagosContenedor">
	        <div class="row">
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaHistorialPagos"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>MES</th>
		                <th>AÑO</th>
		                <th>VALOR</th>
		                <th>COMPROBANTE</th>
		                <th>FECHA DE PAGO</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaHistorialPagosNoRegistros"></div>
		        </div>
        	</div>
       	</div>

        <link href="<c:url value='/resources/css/jquery.dataTables.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>


       	<script>
			$(document).ready(function() {
			    $('#tablaHistorialPagos').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/pago_cuota/lst/'/>${model.unidad.id}",
			        'aoColumns': [
			                      { 'mData': 'mes' }, 
			                      { 'mData': 'anyo'},
			                      { 'mData': 'valor'},
			                      { 'mData': 'comprobante'},
			                      { 'mData': 'fechaPago'}]
			    } );
			});

			</script>
