<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="well form-horizontal">
        <blockquote class="col-lg-12 form-title">
            <strong class="col-lg-12 form-title" style="display: inline;">
                ${model.consejo.nombre}
            </strong>
        </blockquote>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">AGENDA</label>
		</div>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">ACTAS</label>
		</div>
		<div class="form-group">
			<label for="nit" class="col-lg-2 control-label">OTROS DOCUMENTOS</label>
		</div>
		
</div>
		
        <div id="miembrosContenedor">
	        <div class="row">
		        <!-- DataTable -->
		        <div class="col-lg-12 text-right" style="overflow-x: auto;">
		          <table id="tablaMiembros"
		            class="table table-striped table-bordered table-hover">
		            <thead>
		              <tr class="table-header">
		                <th>NOMBRE</th>
		                <th>TELEFONO</th>
		                <th>EMAIL</th>
		              </tr>
		            </thead>
		            <tbody></tbody>
		          </table>
		          <div class="text-center text-warning" id="tablaMiembrosNoRegistros"></div>
		        </div>
        	</div>
       	</div>

        <link href="<c:url value='/resources/css/jquery.dataTables.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>


       	<script>
			$(document).ready(function() {
			    $('#tablaMiembros').dataTable( {
			        "bProcessing": true,
			        "bServerSide": false,
			        "bJQueryUI": true,
			        "sAjaxSource": "<c:url value='/protected/miembro_consejo/lst/'/>${model.consejo.id}",
			        'aoColumns': [
			                      { 'mData': 'persona.nombre' }, 
			                      { 'mData': 'persona.telefono'},
			                      { 'mData': 'persona.email'}]
			    } );
			});

			</script>
