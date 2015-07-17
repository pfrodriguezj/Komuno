<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="well form-horizontal">
        <blockquote class="col-lg-12 form-title">
            <strong class="col-lg-12 form-title" style="display: inline;">
                <spring:message code="header.copropiedad.generales"/>
            </strong>
        </blockquote>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">NIT</label>
			<div class="col-lg-4">
				<input id="nit" name="nit" class="form-control" value="${model.copropiedad.nit}"/>
			</div>

			<label for="direccion" class="col-lg-2 control-label">DIRECCION</label>
			<div class="col-lg-4">
				<input id="direccion" name="direccion" class="form-control" value="calle larga"/>
			</div>
		</div>

		<div class="form-group">
			<label for="telefono" class="col-lg-2 control-label">TELEFONO</label>
			<div class="col-lg-10">
				<input id="telefono" name="telefono" class="form-control" value="1982371"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="totalCuotas" class="col-lg-2 control-label">TOTAL CUOTAS</label>
			<div class="col-lg-4">
				<input id="totalCuotas" name="totalCuotas" class="form-control" value="${model.cuotasTotales}" readonly="readonly"/>
			</div>

			<label for="cuotasMora" class="col-lg-2 control-label">TOTAL CUOTAS EN MORA</label>
			<div class="col-lg-4">
				<input id="cuotasMora" name="cuotasMora" class="form-control" value="${model.cuotasMora}" readonly="readonly"/>
			</div>
		</div>

		<div class="form-group">
			<label for="totalPresupuesto" class="col-lg-2 control-label">TOTAL PRESUPUESTO</label>
			<div class="col-lg-4">
				<input id="sumPresupuesto" name="sumPresupuesto" class="form-control" value="${model.sumPresupuesto}" readonly="readonly"/>
			</div>
			
			<label for="totalPresupuesto" class="col-lg-2 control-label">PAGOS ULTIMO MES</label>
			<div class="col-lg-4">
				<input id="sumPresupuesto" name="sumPresupuesto" class="form-control" value="pendiente" readonly="readonly"/>
			</div>
		</div>
		
			<div class="row">
	        	<button type="button" class="btn btn-success col-lg-2" data-toggle="modal" data-target="#modPresupuestoModal">Generar recibos</button>
	        	<div class="col-lg-1"></div>
	        	<button type="button" class="btn btn-success col-lg-2" data-toggle="modal" data-target="#modPresupuestoModal">Enviar mensaje</button>
	        	<div class="col-lg-1"></div>
	        	<button type="button" class="btn btn-success col-lg-2" data-toggle="modal" data-target="#modPresupuestoModal">Ver documentos</button>
	        	
	        </div>
</div>






