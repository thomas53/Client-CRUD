package com.model;

import java.io.Serializable;

public class ModelGolongan implements Serializable{
	private int id;
	private String nama_golongan;
	private int gaji;
	
	public ModelGolongan(){}
	
	public ModelGolongan(int id, String nama_golongan, int gaji) {
		this.id = id;
		this.nama_golongan = nama_golongan;
		this.gaji = gaji;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama_golongan() {
		return nama_golongan;
	}

	public void setNama_golongan(String nama_golongan) {
		this.nama_golongan = nama_golongan;
	}

	public int getGaji() {
		return gaji;
	}

	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
	
}
