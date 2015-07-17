<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
	<div class="well form col-lg-12">
	        <blockquote class="col-lg-6 form-title">
	            <strong class="col-lg-12 form-title" style="display: inline;">
	                <spring:message code="header.personas.directorio"/>
	            </strong>
	        </blockquote>
	</div>
</div>

        <div id="personasContenedor form-inline col-lg-12">
	        <div class="row well">
	        
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaPersonas"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>NOMBRE</th>
		                <th>TIPO DOCUMENTO</th>
		                <th>DOCUMENTO</th>
		                <th>TELEFONO</th>
		                <th>EMAIL</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaPersonasNoRegistros"></div>
		        </div>
        	</div>
       	</div>



<!-- Modal Mod Persona-->
<div class="modal fade" id="modPersonaModal" tabindex="-1" role="dialog" aria-labelledby="modPersonaModalLabel">
  <div class="modal-dialog" role="document">
  	<c:url value='/protected/persona/save' var="url"/>
  	<form:form method="POST" action="${url}" commandName="persona">
  									
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modPersonaModalLabel">Registrar Persona</h4>
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
							<form:select path="tipoDocumento" items="${model.tipoDocumento}" class="form-control"/>
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

     	<link href="<c:url value='/resources/css/jquery.dataTables.min.css'/>" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
       	
       	    <script>
				$(document).ready(function() {
	       	
	     				$('#tablaPersonas').dataTable( {
				        "bProcessing": true,
				        "bServerSide": false,
				        "bJQueryUI": true,
				        "sAjaxSource": "<c:url value='/protected/persona/lst_copropiedad/'/>",
					        'aoColumns': [
				                      { 'mData': 'nombre' , 'sClass' : 'left',
				             			"mRender": function ( data, type, full ) {
				             		        return data + "<input type='hidden' value='" + full.id + "' />";
				             		      }
				                      },
				                      { 'mData': 'tipoDocumento' ,  'mRender': function (val, type, row) {
				                    	  var tipoDoc = '';
				                    	  if (val == '1'){
				                    		  tipoDoc = 'Cédula';
				                    	  }
				                    	  if (val == '2'){
				                    		  tipoDoc = 'Registro Civil';
				                    	  }
				                    	  if (val == '3'){
				                    		  tipoDoc = 'Tarjeta de identidad';
				                    	  }
				                    	  if (val == '4'){
				                    		  tipoDoc = 'NIT';
				                    	  }
				                    	  if (val == '5'){
				                    		  tipoDoc = 'NUIP';
				                    	  }
				                    	  if (val == '6'){
				                    		  tipoDoc = 'Cédula de extranjería';
				                    	  }
				                    	  
				                          return tipoDoc;
				                      	}
				                      },
				                      { 'mData': 'documento', 'sClass' : 'left'},
				                      { 'mData': 'telefono', 'sClass' : 'left'},
				                      { 'mData': 'email', 'sClass' : 'left'}
				                      ]
				    	} );
	     				
	     				$('#tablaPersonas tbody').on( 'click', 'tr', function () {
	     					cargarModalPersona($(this).find("input").val());
	     					$("#modPersonaModal").modal("show");
	     				} );
				});
				
				function cargarModalPersona(id) {
					var url = "<c:url value='/protected/persona/ver/'/>" + id;
					
					$.ajax({
						type : "GET",
						url : url,
						contentType : 'application/json; charset=utf-8',
						dataType : "json",
						success : function(objResponse) {
								$("#modPersonaModal").find("#id").val(objResponse.id);
				        		$("#modPersonaModal").find("#nombre").val(objResponse.nombre);
				        		$("#modPersonaModal").find("#tipoDocumento").val(objResponse.tipoDocumento);
				        		$("#modPersonaModal").find("#documento").val(objResponse.documento);
				        		$("#modPersonaModal").find("#telefono").val(objResponse.telefono);
				        		$("#modPersonaModal").find("#email").val(objResponse.email);
						},
						error : function(objRequest) {
							alert("error al cargar datos de persona");
						}
					});
				}
			</script>