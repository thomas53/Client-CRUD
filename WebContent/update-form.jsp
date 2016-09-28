<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="EditData" method="POST">
			<table style="text-align:left">
				<tr>
					<td>Nama</td>
					<td>:</td>
					<td>
						<input type="hidden" name="idpegawai" value="${idpegawai}">
						<input type="text" name="nama" value="${nama}"/>
					</td>
				</tr>
				<tr>
					<td>Jenis Kelamin</td>
					<td>:</td>
					<td>
						<input type="text" name="jenkel" value="${jenkel}">
					</td>
				</tr>
				<tr>
					<td>Alamat</td>
					<td>:</td>
					<td><textarea rows="5" cols="30" name="alamat">${alamat}</textarea></td>
				</tr>
				<tr>
					<td>Golongan</td>
					<td>:</td>
					<td>
						<select name="golongan">
							<c:set var="daftarGolongan" value="${daftarGolongan}"/>
							<c:set var="golongan" value="${golongan}"/>
							<c:forEach items="${daftarGolongan}" var="gol">
								<c:if test="${gol.id==golongan}">
									<option selected value="${gol.id}">${gol.nama_golongan}</option>
								</c:if>
								<c:if test="${gol.id!=golongan}">
									<option value="${gol.id}">${gol.nama_golongan}</option>
								</c:if>
							</c:forEach>
						</select> 
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>
						<input type="submit" value="kirim">
						<input type="submit" name="batal" value="batal">
					</td>
				</tr>
			</table>		
		</form>
	</center>
	
</body>
</html>