<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
	<div class="well form col-lg-12">
	        <blockquote class="col-lg-6 form-title">
	            <strong class="col-lg-12 form-title" style="display: inline;">
	                <spring:message code="header.presupuesto"/>
	            </strong>
	        </blockquote>
	        
			<div class="form-group col-lg-6">
				<label for="totalCuotas" class="col-lg-2 control-label">Ingresos</label>
				<div class="col-lg-4">
					<input id="totalCuotas" name="totalCuotas" class="form-control" value="${model.cuotasTotales}" readonly="readonly"/>
				</div>
				<label for="totalPresupuesto" class="col-lg-2 control-label">Gastos</label>
				<div class="col-lg-4">
					<input id="sumPresupuesto" name="sumPresupuesto" class="form-control" value="${model.sumPresupuesto}" readonly="readonly"/>
				</div>
			</div>
			<div class="col-lg-12">
	        	<button type="button" class="btn btn-success col-lg-4" data-toggle="modal" data-target="#modPresupuestoModal">Nuevo &iacute;tem de presupuesto</button>
	        </div>
	</div>
</div>

<div class="row">
	<div class="well form col-lg-12">
	        <blockquote class="col-lg-6 form-title">
	            <strong class="col-lg-12 form-title" style="display: inline;">
	                <spring:message code="header.ejecucion"/>	(${model.mes})
	            </strong>
	        </blockquote>
	        
	   		<div class="form-group col-lg-6">
				<label for="totalCuotas" class="col-lg-2 control-label">Ingresos</label>
				<div class="col-lg-4">
					<input id="sumIngresosMes" name="sumIngresosMes" class="form-control" value="${model.sumIngresosMes}" readonly="readonly"/>
				</div>
				<label for="totalPresupuesto" class="col-lg-2 control-label">Egresos</label>
				<div class="col-lg-4">
					<input id="sumEgresosMes" name="sumEgresosMes" class="form-control" value="${model.sumEgresosMes}" readonly="readonly"/>
				</div>
			</div>		
	</div>
</div>

        <div id="presupuestoGastosContenedor form-inline col-lg-12">
	        <div class="row well">
	                <blockquote class="col-lg-12 form-title">
            			<strong class="col-lg-12 form-title" style="display: inline;">
	                		Gastos presupuestados	
            			</strong>
    			    </blockquote>
	        
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaGastosPresupuesto"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>CONCEPTO</th>
		                <th>PERIODICIDAD</th>
		                <th>VALOR</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaGastosPresupuestoNoRegistros"></div>
		        </div>
        	</div>
       	</div>

        <div id="presupuestoIngresosContenedor form-inline">
	        <div class="row well">
	                <blockquote class="col-lg-12 form-title">
            			<strong class="col-lg-12 form-title" style="display: inline;">
	                		Ingresos presupuestados	
            			</strong>
    			    </blockquote>
	        
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaIngresosPresupuesto"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>CONCEPTO</th>
		                <th>PERIODICIDAD</th>
		                <th>VALOR</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaIngresosPresupuestoNoRegistros"></div>
		        </div>
        	</div>
       	</div>


<!-- Modal Mod Presupuesto-->
<div class="modal fade" id="modPresupuestoModal" tabindex="-1" role="dialog" aria-labelledby="modPresupuestoModalLabel">
  <div class="modal-dialog" role="document">
  	<c:url value='/protected/presupuesto/save' var="url"/>
  	<form:form method="POST" action="${url}" commandName="itemPresupuesto">
  									
    <div class="modal-content">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modPresupuestoModalLabel">Crear Item Presupuestal</h4>
      </div>
      <div class="modal-body">
			<div class="well form-inline">

				<div class="form-group">
					
						<form:hidden path="id" />
						<label for="concepto_item" class="col-lg-4 control-label">CONCEPTO</label>
						<div class="col-lg-8">
							<form:input path="concepto" class="form-control" />
						</div>
						<label for="periodicidad" class="col-lg-4">PERIODICIDAD</label>
						<div class="col-lg-8">
							<form:select path="periodicidad" items="${model.listPeriodicidad}" class="form-control"/>
						</div>
						<label for="valorPrevisto" class="col-lg-4 control-label">VALOR</label>
						<div class="col-lg-8">
							<form:input path="valorPrevisto" class="form-control"/>
						</div>
						<label for="tipoItem" class="col-lg-4 control-label">TIPO DE ITEM</label>
						<div class="col-lg-8">
			                	<div class="radio-inline"  style="padding-top:0;">
				                    <label class="radio-inline" style="padding-top:0;">
									  <form:radiobutton path="tipoItem" id="esGasto" value="G"/> Gasto
									</label>
								</div>
								<div class="radio-inline" style="padding-top:0;">
									<label class="radio-inline" style="padding-top:0;">
									  <form:radiobutton path="tipoItem" id="esIngreso" value="I"/> Ingreso
									</label>
								</div>
						</div>
						
				</div>		


			</div>        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" onclick="javaScript:document.forms[0].submit()">Guardar Presupuesto</button>
      </div>
    </div>
    </form:form>
  </div>
</div>

     	<link href="<c:url value='/resources/css/jquery.dataTables.min.css'/>" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
       	
       	    <script>
				$(document).ready(function() {
	       	
	     				$('#tablaGastosPresupuesto').dataTable( {
				        "bProcessing": true,
				        "bServerSide": false,
				        "bJQueryUI": true,
				        "sAjaxSource": "<c:url value='/protected/presupuesto/lstGastosPresupuesto/'/>",
					        'aoColumns': [
				                      { 'mData': 'concepto' , 'sClass' : 'left',
				             			"mRender": function ( data, type, full ) {
				             		        return data + "<input type='hidden' value='" + full.id + "' />";
				             		      }
				                      },
				                      { 'mData': 'periodicidad' ,  'mRender': function (val, type, row) {
				                          return val == 'D' ? "Diaria" : (val == 'M' ? "Mensual": "Anual");
				                      	}
				                      },
				                      { 'mData': 'valorPrevisto', 'mRender': $.fn.dataTable.render.number( ',', '.', 0, '$' )   
				                      }
				                      ]
				    	} );
	     				
	     				$('#tablaGastosPresupuesto tbody').on( 'click', 'tr', function () {
	     					cargarModalItemPresupuesto($(this).find("input").val());
	     					$("#modPresupuestoModal").modal("show");
	     				} );
	     				
	     				$('#tablaIngresosPresupuesto').dataTable( {
					        "bProcessing": true,
					        "bServerSide": false,
					        "bJQueryUI": true,
					        "sAjaxSource": "<c:url value='/protected/presupuesto/lstIngresosPresupuesto/'/>",
						        'aoColumns': [
					                      { 'mData': 'concepto' , 'sClass' : 'left',
					             			"mRender": function ( data, type, full ) {
					             		        return data + "<input type='hidden' value='" + full.id + "' />";
					             		      }
					                      },
					                      { 'mData': 'periodicidad' ,  'mRender': function (val, type, row) {
					                          return val == 'D' ? "Diaria" : (val == 'M' ? "Mensual": "Anual");
					                      	}
					                      },
					                      { 'mData': 'valorPrevisto', 'mRender': $.fn.dataTable.render.number( ',', '.', 0, '$' )   
					                      }
					                      ]
					    	} );
		     				
		     				$('#tablaIngresosPresupuesto tbody').on( 'dblclick', 'tr', function () {
		     					cargarModalItemPresupuesto($(this).find("input").val());
		     					$("#modPresupuestoModal").modal("show");
		     				} );

				});
				
				function cargarModalItemPresupuesto(item) {
					var url = "<c:url value='/protected/presupuesto/ver_item/'/>" + item;
					
					$.ajax({
						type : "GET",
						url : url,
						contentType : 'application/json; charset=utf-8',
						dataType : "json",
						success : function(objResponse) {
								$("#modPresupuestoModal").find("#id").val(objResponse.id);
				        		$("#modPresupuestoModal").find("#concepto").val(objResponse.concepto);
				        		$("#modPresupuestoModal").find("#periodicidad").val(objResponse.periodicidad);
				        		$("#modPresupuestoModal").find("#valorPrevisto").val(objResponse.valorPrevisto);
				        		if(objResponse.tipoItem == 'G'){
				        			$("#modPresupuestoModal").find("#esGasto").attr("checked","checked");
				        		} else {
				        			$("#modPresupuestoModal").find("#esIngreso").attr("checked","checked");
				        		}
						},
						error : function(objRequest) {
							alert("error al cargar item de presupuesto");
						}
					});
				}

				
				
			</script>