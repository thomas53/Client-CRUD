package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ModelPegawai;
import com.socket.ToServer;

/**
 * Servlet implementation class TambahData
 */
@WebServlet("/TambahData")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// pesan yang dikirim ke server
		ModelPegawai pegawai = new ModelPegawai();
		pegawai.setNama(request.getParameter("nama"));
		pegawai.setJenkel(request.getParameter("jenkel"));
		pegawai.setAlamat(request.getParameter("alamat"));
		
		// mengirim pesan ke server
		String hasil = new ToServer().send("ins",pegawai);
		request.setAttribute("msg",	hasil);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}

}
