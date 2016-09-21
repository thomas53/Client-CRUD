<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EditData" method="POST">
		<input type="hidden" name="idpegawai" value="${idpegawai}">
		Nama : <br>
		<input type="text" name="nama" value="${nama}"/><br>
		Jenis Kelamin : <br>
		<input type="text" name="jenkel" value="${jenkel}"><br>
		Alamat : <br>
		<textarea rows="5" cols="30" name="alamat">${alamat}</textarea><br>
		<input type="submit" value="kirim">
		<input type="submit" name="batal" value="batal">
	</form>
</body>
</html>