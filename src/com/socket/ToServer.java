package com.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.model.ModelPegawai;

public class ToServer {
	public int send(String act,ModelPegawai peg){
		String serverName = "127.0.0.1";
		int port = 8888;
		int msg = 0;
		
		try {
			Socket client = new Socket(serverName,port);
			
			// set aksi
			DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());
			dataOut.writeUTF(act);
			
			// set data
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ModelPegawai pegawai = peg;
			out.writeObject(pegawai);
			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			msg = (int) in.readObject();
			client.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}
	
	public List<ModelPegawai> ambilPegawai(String act){
		List<ModelPegawai> res = new ArrayList<ModelPegawai>();
		
		String serverName = "127.0.0.1";
		int port = 8888;
		
		try {
			Socket client = new Socket(serverName,port);
			
			// set aksi
			DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());
			dataOut.writeUTF(act);
			
			// get data
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			res = (List<ModelPegawai>) in.readObject();
			
			client.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public ModelPegawai ambilPegawaiById(int id){
		ModelPegawai res = new ModelPegawai();
		
		String serverName = "127.0.0.1";
		int port = 8888;
		
		try {
			Socket client = new Socket(serverName,port);
			
			// set aksi
			DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());
			dataOut.writeUTF("getId");
			
			// set data
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ModelPegawai pegawai = new ModelPegawai();
			pegawai.setIdpegawai(id);
			out.writeObject(pegawai);
			
			// get data
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			res = (ModelPegawai) in.readObject();
			
			client.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}
