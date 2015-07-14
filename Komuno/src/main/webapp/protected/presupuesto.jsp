<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="well form-inline">
        <blockquote class="col-lg-8 form-title">
            <strong class="col-lg-12 form-title" style="display: inline;">
                <%=request.getSession().getAttribute("copropiedad") %> - <spring:message code="header.presupuesto"/>
            </strong>
            
        </blockquote>
        <button type="button" class="btn btn-success col-lg-4" data-toggle="modal" data-target="#modPresupuestoModal">Modificar presupuesto</button>
        
		<div class="form-group">
			<label for="totalCuotas" class="col-lg-2 control-label">INGRESO PRESUPUESTADO</label>
			<div class="col-lg-4">
				<input id="totalCuotas" name="totalCuotas" class="form-control" value="${model.cuotasTotales}" readonly="readonly"/>
			</div>
			<label for="totalPresupuesto" class="col-lg-2 control-label">GASTO PRESUPUESTADO</label>
			<div class="col-lg-4">
				<input id="sumPresupuesto" name="sumPresupuesto" class="form-control" value="${model.sumPresupuesto}" readonly="readonly"/>
			</div>
		</div>		
</div>

<div class="well form-inline">
        <blockquote class="col-lg-12 form-title">
            <strong class="col-lg-12 form-title" style="display: inline;">
                <%=request.getSession().getAttribute("copropiedad") %> - <spring:message code="header.ejecucion"/>	
            </strong>
        </blockquote>
        
   		<div class="form-group">
			<label for="totalCuotas" class="col-lg-2 control-label">TOTAL INGRESOS ${model.mes}</label>
			<div class="col-lg-4">
				<input id="sumIngresosMes" name="sumIngresosMes" class="form-control" value="${model.sumIngresosMes}" readonly="readonly"/>
			</div>
			<label for="totalPresupuesto" class="col-lg-2 control-label">TOTAL EGRESOS ${model.mes}</label>
			<div class="col-lg-4">
				<input id="sumEgresosMes" name="sumEgresosMes" class="form-control" value="${model.sumEgresosMes}" readonly="readonly"/>
			</div>
		</div>		
</div>

        <div id="presupuestoContenedor form-inline">
	        <div class="row well">
	                <blockquote class="col-lg-12 form-title">
            			<strong class="col-lg-12 form-title" style="display: inline;">
	                		Gastos presupuestados	
            			</strong>
    			    </blockquote>
	        
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaPresupuesto"
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
		          <div class="text-center text-warning" id="tablaPresupuestoNoRegistros"></div>
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
					
						<label for="concepto_item" class="col-lg-4 control-label">CONCEPTO</label>
						<div class="col-lg-8">
							<form:input path="concepto" class="form-control" />
						</div>
						<label for="totalPresupuesto" class="col-lg-4">PERIODICIDAD</label>
						<div class="col-lg-8">
							<form:select path="periodicidad" items="${model.listPeriodicidad}" class="form-control"/>
						</div>
						<label for="totalPresupuesto" class="col-lg-4 control-label">VALOR</label>
						<div class="col-lg-8">
							<form:input path="valorPrevisto" class="form-control"/>
						</div>
						<label for="totalPresupuesto" class="col-lg-4 control-label">TIPO DE ITEM</label>
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
	       	
	     				$('#tablaPresupuesto').dataTable( {
				        "bProcessing": true,
				        "bServerSide": false,
				        "bJQueryUI": true,
				        "sAjaxSource": "<c:url value='/protected/presupuesto/lst/'/>${model.copropiedad.id}",
				        'aoColumns': [
				                      { 'mData': 'concepto' ,
							        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
							        		 var url = "<c:url value='/protected/gasto_presupuesto/ver/'/>" + oData.id;
							                 $(nTd).html("<a href="+url+">"+oData.concepto+"</a>");
				             			}
				                      },
				                      { 'mData': 'periodicidad' 
				                      },
				                      { 'mData': 'valorPrevisto' 
				                      }]
				    	} );
				});
			</script>