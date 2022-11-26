package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Controller.Client.View;
import View.MainView;


public class SocketHandle {

	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	private Socket socket;

	public void run() {
		try {
			socket = new Socket("localhost", 1234);

			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			String message ="";

			while (true) {
				message = dataInputStream.readUTF();
				
				String[] mesageSlip = message.split(",");
				
				if (message.equals("End")) {
					break;
				}
				
				if (mesageSlip[0].equals("login-succsess")) {
					System.out.println("Dang nhap thanh cong");
					Client.closeView(Client.View.LOGIN);
					Client.openView(Client.View.MAINVIEW);
				
				}
				if (mesageSlip[0].equals("regis-succsess")) {
					System.out.println("Dang ký thành công");
					Client.closeView(View.REGISTER);
					Client.openView(View.LOGIN);
				
				}
				if (mesageSlip[0].equals("login-false")) {
					
					System.out.println("Dang nhap that bai");
					
				}
				if (mesageSlip[0].equals("delete-success")) {
					System.out.println("Xoa thanh cong");
				}
				if (mesageSlip[0].equals("add-success")) {
					System.out.println("Them thanh cong");
				}
				if (mesageSlip[0].equals("update-success")) {
					System.out.println("Sua thanh cong");
				}
				else {
					System.out.println("Khong nhan duoc reqest");
				}
				
			}
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public DataInputStream getDataInputStream() {
		return dataInputStream;
	}

	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}
	public ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}
	public DataOutputStream getDaOutputStream() {
		return dataOutputStream;
	}

	public DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}

	public void setDataOutputStream(DataOutputStream dataOutputStream) {
		this.dataOutputStream = dataOutputStream;
	}

	public void setDataInputStream(DataInputStream dataInputStream) {
		this.dataInputStream = dataInputStream;
	}

	public void setObjectInputStream(ObjectInputStream objectInputStream) {
		this.objectInputStream = objectInputStream;
	}

	public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
		this.objectOutputStream = objectOutputStream;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
