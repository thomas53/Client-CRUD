package com.model;

import java.io.Serializable;

public class ModelPegawai implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idpegawai;
	private String nama;
	private String alamat;
	private String jenis_kelamin;
	private String fileFoto;
	private ModelGolongan golongan;
	
	public ModelPegawai(){}

	public ModelPegawai(String nama, String alamat, String jenis_kelamin,String fileFoto, ModelGolongan golongan) {
		this.nama = nama;
		this.alamat = alamat;
		this.jenis_kelamin = jenis_kelamin;
		this.fileFoto = fileFoto;
		this.golongan = golongan;
	}

	public int getIdpegawai() {
		return idpegawai;
	}

	public void setIdpegawai(int idpegawai) {
		this.idpegawai = idpegawai;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public String getFileFoto() {
		return fileFoto;
	}

	public void setFileFoto(String fileFoto) {
		this.fileFoto = fileFoto;
	}

	public ModelGolongan getGolongan() {
		return golongan;
	}

	public void setGolongan(ModelGolongan golongan) {
		this.golongan = golongan;
	}
	
	
}
