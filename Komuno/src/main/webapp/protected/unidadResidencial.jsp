<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
	<div class="row">
		<div class="col-lg-8">
			<div class="well form-horizontal">
		        <blockquote class="col-lg-12 form-title">
		            <strong class="col-lg-12 form-title" style="display: inline;">
		                APARTAMENTO ${model.unidad.nombreUnidad}
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
				<div class="form-group">
					<label for="estadoCuenta" class="col-lg-2 control-label">SALDO</label>
					<div class="col-lg-10">
						<input id="estadoCuenta" name="estadoCuenta" class="form-control" value="${model.unidad.estadoCuenta}" readonly/>
					</div>
				</div>
				<div class="form-group">
					<label for="intereses" class="col-lg-2 control-label">INTERESES</label>
					<div class="col-lg-10">
						<input id="intereses" name="intereses" class="form-control" value="pendiente" readonly/>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
				<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Mascotas</button>
	        	<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Multas y sanciones</button>
	        	<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Inconformidades</button>
	        	<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Estado de cuenta</button>
	        	<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Servicios y áreas comunes</button>
		</div>
	</div>	
</div>

        <div id="residentesContenedor form-inline col-lg-12">
	        <div class="row well">
   	                <blockquote class="col-lg-10 form-title">
            			<strong class="col-lg-12 form-title" style="display: inline;">
	                		Residentes	
            			</strong>
    			    </blockquote>
    			    <button type="button" class="btn btn-success col-lg-2" data-toggle="modal" data-target="#residenteModal">Nuevo Residente</button>
	        
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaResidentes"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>NOMBRE</th>
		                <th>DOCUMENTO</th>
		                <th>TELEFONO</th>
		                <th>EMAIL</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaHistorialPagosNoRegistros"></div>
		        </div>
        	</div>
       	</div>

        <div id="historialPagosContenedor form-inline col-lg-12">
	        <div class="row well">
	        		<blockquote class="col-lg-10 form-title">
            			<strong class="col-lg-12 form-title" style="display: inline;">
	                		Historial de pagos	
            			</strong>
    			    </blockquote>
    			    <button type="button" class="btn btn-success col-lg-2" data-toggle="modal" data-target="#pagoModal">Nuevo Pago</button>
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
			    $('#tablaResidentes').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/residente/lst/'/>${model.unidad.id}",
			        'aoColumns': [
			                      { 'mData': 'residente.nombre' }, 
			                      { 'mData': 'residente.documento'},
			                      { 'mData': 'residente.telefono'},
			                      { 'mData': 'residente.email'}]
			    } );
			    
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
