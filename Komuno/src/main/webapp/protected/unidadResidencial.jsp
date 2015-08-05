<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	        	<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Cartera y Cobranza</button>
	        	<button type="button" class="btn btn-success col-lg-12" data-toggle="modal" data-target="#modPresupuestoModal">Mensajes</button>
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
    			    <button id="nuevoResidente" type="button" class="btn btn-success col-lg-2" data-toggle="modal" data-target="#residenteModal">Nuevo Residente</button>
	        
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

<!-- Modal Mod Residente-->
<!-- TODO: CREAR UN COMPONENTE PARA MANEJAR PERSONAS DESDE RESIDENTES, PROPIETARIOS, ADMINISTRADORES, ETC. -->
<div class="modal fade" id="modPersonaModal" tabindex="-1" role="dialog" aria-labelledby="modPersonaModalLabel">
  <div class="modal-dialog" role="document">
  	<c:url value='/protected/unidades_residenciales/save_residente/${model.unidad.id}' var="url"/>
  	<form:form method="POST" action="${url}" commandName="residente">
  									
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modPersonaModalLabel">Registrar Residente</h4>
      </div>
      <div class="modal-body">
			<div class="well form-inline">

				<div class="form-group">
						<form:hidden path="id" />
						<label for="nombre" class="col-lg-4 control-label">NOMBRE</label>
						<div class="col-lg-8">
							<form:input path="nombre" class="form-control" />
						</div>
						<label for="tipoDocumento" class="col-lg-4">TIPO DOCUMENTO</label>
						<div class="col-lg-8">
							<form:select path="tipoDocumento" items="${model.listTipoDocumento}" class="form-control"/>
						</div>
						<label for="documento" class="col-lg-4 control-label">DOCUMENTO</label>
						<div class="col-lg-8">
							<form:input path="documento" class="form-control"/>
						</div>
						<label for="telefono" class="col-lg-4 control-label">TELEFONO</label>
						<div class="col-lg-8">
							<form:input path="telefono" class="form-control"/>						
						</div>
						<label for="email" class="col-lg-4 control-label">EMAIL</label>
						<div class="col-lg-8">
							<form:input path="email" class="form-control"/>						
						</div>
				</div>		
			</div>        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" onclick="javaScript:document.forms[0].submit()">Guardar</button>
      </div>
    </div>
    </form:form>
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
			                      { 'mData': 'residente.nombre' , 'sClass' : 'left',
			             			"mRender": function ( data, type, full ) {
			             		        return data + "<input type='hidden' value='" + full.id + "' />";
			             			}
			                      },
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
			    
 				$('#tablaResidentes tbody').on( 'click', 'tr', function () {
 					cargarModalPersona($(this).find("input").val());
 					$("#modPersonaModal").modal("show");
 				} );

			});

				$('#nuevoResidente').on( 'click', function () {
 					cargarModalPersona(null);
 					$("#modPersonaModal").modal("show");
 				} );

				
				function cargarModalPersona(id) {
					
					if( id != null){
						var url = "<c:url value='/protected/residente/ver/'/>" + id;
						
						$.ajax({
							type : "GET",
							url : url,
							contentType : 'application/json; charset=utf-8',
							dataType : "json",
							success : function(objResponse) {
									$("#modPersonaModal").find("#id").val(objResponse.residente.id);
					        		$("#modPersonaModal").find("#nombre").val(objResponse.residente.nombre);
					        		$("#modPersonaModal").find("#tipoDocumento").val(objResponse.residente.tipoDocumento);
					        		$("#modPersonaModal").find("#documento").val(objResponse.residente.documento);
					        		$("#modPersonaModal").find("#telefono").val(objResponse.residente.telefono);
					        		$("#modPersonaModal").find("#email").val(objResponse.residente.email);
							},
							error : function(objRequest) {
								alert("error al cargar datos de persona");
							}
						});
					} else {
						$("#modPersonaModal").find("#id").val("");
		        		$("#modPersonaModal").find("#nombre").val("");
		        		$("#modPersonaModal").find("#tipoDocumento").val("");
		        		$("#modPersonaModal").find("#documento").val("");
		        		$("#modPersonaModal").find("#telefono").val("");
		        		$("#modPersonaModal").find("#email").val("");
					}
				}
			</script>
