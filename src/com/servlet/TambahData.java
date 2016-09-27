package com.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.FileItem;

import sun.misc.IOUtils;

import com.model.ModelFile;
import com.model.ModelPegawai;
import com.socket.ToServer;

/**
 * Servlet implementation class TambahData
 */
@WebServlet("/TambahData")
@MultipartConfig
public class TambahData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TambahData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public static byte[] loadFileAsBytesArray(String fileName) throws Exception {
		 
        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;
 
    }
	
	public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {
		 
        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();
 
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// pesan yang dikirim ke server
		ModelPegawai pegawai = new ModelPegawai();
		pegawai.setNama(request.getParameter("nama"));
		pegawai.setJenis_kelamin(request.getParameter("jenkel"));
		pegawai.setAlamat(request.getParameter("alamat"));
		
		// mengambil gambar
		Part foto = request.getPart("fileFoto");
		String disposition = foto.getHeader("Content-Disposition");
		String pathFile = disposition.replaceFirst("(?i)^.*filename=\"([^\"]+)\".*$", "$1");
		File myFile = new File(pathFile);
		byte[] base64 = null;
		ModelFile fileFoto = new ModelFile();
		
		// convert base64
		InputStream isGambar = foto.getInputStream();
        base64 = IOUtils.readFully(isGambar, -1, true);
		pegawai.setFileFoto("data:" + foto.getContentType() + ";base64," + Base64.encodeBase64String(base64));

		
		// mengirim pesan ke server
		int hasil = new ToServer().send("ins",pegawai);
		
		if(hasil==1){
			request.setAttribute("scsMsg",	"Data Berhasil Ditambahkan");
		}else{
			request.setAttribute("errMsg",	"Data Gagal Ditambahkan");
		}
		response.sendRedirect("Index");


//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
//		rd.forward(request, response);
		
	}

}
