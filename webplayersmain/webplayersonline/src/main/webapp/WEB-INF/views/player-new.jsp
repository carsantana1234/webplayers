<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springformul"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Player</title>
<script src='<spring:url value="/js/jquery-1.10.2.js"/>' type="text/javascript"><!--mce:0--><!--mce:0--></script>
<script src='<spring:url value="/js/jquery.validate-1.11.1.js"/>' type="text/javascript"><!--mce:1--><!--mce:1--></script>

<STYLE type="text/css">

div {
	display: table;
	display: table-cell;
	display: table-column;
	display: table-colgroup;
	display: table-header-group;
	display: table-row-group;
	display: table-footer-group;
	display: table-row;
	display: table-caption;
}

</STYLE>

<script type="text/javascript">
 <%--
	$(function() {
		$('#registro').validate({
			rules : {
				name : {
					required : true
				//para validar campo vacio
				// email    : true  //para validar formato email
				},
				apellido : {
					required : true
				//minlength : 3, //para validar campo con minimo 3 caracteres
				//maxlength : 9  //para validar campo con maximo 9 caracteres
				},
				edad : {
					required : true,
					number : true
				//para validar campo solo numeros
				},
				idVisible : {
					required : true,
				}

			},
			messages : {
				name : {
					required : "Introducir el nombre"
				},
				apellido : {
					required : "Introducir el apellido"
				},
				edad : {
					required : "Introducir la edad",
					number : "Escribir edad en numeros"
				//para validar campo solo numeros
				},
				idVisible : {
					required : "Seleccionar un estado de visibilidad",
				}

			},
			submitHandler : function(form) {
				form.submit(); 
				alert('El formulario ha sido validado correctamente!');
			}
		});
	});
	--%>
</script>

</head>
<body>

<div>
		<springformul:form method="POST" commandName="entityPlayer" enctype="multipart/form-data" action="${pageContext.request.contextPath}/players/create">
			<spring:message code="form.create.field.name"/> 
			<springformul:input path="name" />
			<springformul:errors path="name" cssStyle="color:red" /> 
			<br/>
			<spring:message code="form.create.field.surname"/> 
			<springformul:input path="surName" />
			<springformul:errors path="surName" cssStyle="color:red" /> 
			<br/>
			<spring:message code="form.create.field.age"/> 
			<springformul:input path="age"/>
			<springformul:errors path="age" cssStyle="color:red" /> 
			<br/>
			<spring:message code="form.create.field.photo"/> 
			<springformul:input type="file" path="photoFile" /> 
			<br/>
			<!--<springformul:select path="state">
				<springformul:option value="" label="--Please Select" />
				<springformul:options items="${listaVisible}" itemValue="id"
					itemLabel="estado" />
			</springformul:select> 
			<springformul:errors path="state" cssStyle="color:red" /> -->
			<%-- <c:forEach var="listaV" items="${listaVisible}"> </c:forEach>--%>
			<input type="submit" value='<spring:message code="form.create.field.create"/>'> 

		</springformul:form>
	</div>
	
	
</body>
</html>