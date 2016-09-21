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
 * Servlet implementation class EditData
 */
@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ModelPegawai pegawai = new ToServer().ambilPegawaiById(id);
		
		request.setAttribute("idpegawai", pegawai.getIdPegawai());
		request.setAttribute("nama", pegawai.getNama());
		request.setAttribute("jenkel", pegawai.getJenkel());
		request.setAttribute("alamat", pegawai.getAlamat());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/update-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("batal")==null){
			// pesan yang dikirim ke server
			ModelPegawai pegawai = new ModelPegawai();
			pegawai.setIdPegawai(Integer.parseInt(request.getParameter("idpegawai")));
			pegawai.setNama(request.getParameter("nama"));
			pegawai.setJenkel(request.getParameter("jenkel"));
			pegawai.setAlamat(request.getParameter("alamat"));
			
			// mengirim pesan ke server
			String hasil = new ToServer().send("upd",pegawai);
			request.setAttribute("msg",	hasil);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
