<%@page import="com.socket.ToServer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.ModelPegawai"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${msg}
	<form action="TambahData" method="POST">
		Nama : <br>
		<input type="text" name="nama"/><br>
		Jenis Kelamin : <br>
		<input type="radio" id="l" checked=true name="jenkel" value="Laki-Laki"><label for="l">Laki-Laki</label>
		<input type="radio" id="p" name="jenkel" value="Perempuan"><label for="p">Perempuan</label><br>
		Alamat : <br>
		<textarea rows="5" cols="30" name="alamat"></textarea><br>
		<input type="submit" value="kirim">
	</form>
	
	<table border=1>
		<thead>
			<tr>
				<th>Nama</th>
				<th>Jenis Kelamin</th>
				<th>Alamat</th>
				<th>Aksi</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<ModelPegawai> daftarPegawai = new ArrayList<ModelPegawai>();
				daftarPegawai = new ToServer().ambilPegawai("get");
				for (ModelPegawai pegawai : daftarPegawai) {
					out.print("<tr>");
					out.print("<td>"+pegawai.getNama()+"</td>");
					out.print("<td>"+pegawai.getJenkel()+"</td>");
					out.print("<td>"+pegawai.getAlamat()+"</td>");
					out.print("<td>");
					out.print("<a href='EditData?id="+pegawai.getIdPegawai()+"'>edit</a>  ");
					out.print("<a href='DeleteData?id="+pegawai.getIdPegawai()+"'>delete</a>  ");
					out.print("</td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>