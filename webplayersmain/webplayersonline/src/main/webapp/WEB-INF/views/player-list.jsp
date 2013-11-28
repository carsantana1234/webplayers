<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Players List</title>

</head>
<body bgcolor="#333333">

	<table border="0" bgcolor="#000000">

		<c:forEach var="player" items="${playerslist}">
			<tr>
				<td align="right">

					<table align="right">
						<tr>
							<td align="right"><font color="#ffffff" face="Verdana">${player.name}</font></td>
						</tr>
						<tr>
							<td align="right"><font color="#ffffff" face="Verdana"
								size="2">${player.surName}</font></td>
						</tr>
						<tr>
							<td align="right"><font color="#ffffff" face="Verdana"
								size="2">${player.age}</font></td>
						</tr>
					</table>

				</td>
				<td>
					<table>
						<tr>
							<td><img
								src="data:image/png;base64,${player.photoBase64String}"
								title="${player.name} ${player.surName}" width="115px" /></td>
						</tr>
						<tr>

							<td align="right">

								<table width="10px" border="0" align="right">

									<tr>
										<td width="5px"><a
											href="${pageContext.request.contextPath}/players/edit/${player.id}"><img
												src='<spring:url value="/images/edit.png"/>' border="0"
												title="edit" /></a></td>
										<td width="5px"><a
											href="${pageContext.request.contextPath}/players/delete/${player.id}"><img
												src='<spring:url value="/images/delete.png"/>' border="0"
												title="delete" /></a></td>

									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td bgcolor="#cc3333" colspan="4">&nbsp;</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10"><a
				href="${pageContext.request.contextPath}/players/create">New</a></td>
		</tr>
	</table>

</body>
</html>