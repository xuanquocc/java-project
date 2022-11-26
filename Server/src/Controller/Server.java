package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import Model.Account;
import Model.MotoBike;
import Service.AccountService;

public class Server {
	private static DataInputStream dataInputStream;
	private static DataOutputStream dataOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;

	public static void main(String[] args) {
		try {

			ServerSocket serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			System.out.println("Ket noi thanh cong");

			try {
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			while (true) {
				String messages = dataInputStream.readUTF();
				String[] messagesSlip = messages.split(",");
				
				if (messagesSlip[0].equals("request-login")) {
					String string = Decryption.getAccount(messagesSlip[1]);
					String[] account = string.split(",");
					Account acc = new Account(account[0].trim(), account[1].trim());
					
					Boolean check = AccountService.checkAccount(acc.getNameAccount(),acc.getPassword());
					
					if (check == true) {
						dataOutputStream.writeUTF("login-succsess");
						dataOutputStream.flush();
					} else {
						dataOutputStream.writeUTF("login-false");
						dataOutputStream.flush();
					}
				}
			
				if (messagesSlip[0].trim().equals("request-regis")) {
					String string = Decryption.getAccount(messagesSlip[1]);
					String[] account = string.split(",");
					Account acc = new Account(account[0].trim(), account[1].trim(),account[2].trim());
					Boolean check = AccountService.regisAccount(acc.getNameAccount(),acc.getGmail(),acc.getPassword());
					if (check == true) {
						dataOutputStream.writeUTF("regis-succsess");
						dataOutputStream.flush();
					} else {
						dataOutputStream.writeUTF("regis-false");
						dataOutputStream.flush();
					}
				}
				if (messagesSlip[0].trim().equals("request-delete")) {
					String result = AccountService.deletemoto(messagesSlip[1]);
					dataOutputStream.writeUTF(result);
					dataOutputStream.flush();
				}
				if (messagesSlip[0].trim().equals("request-add")) {
					try {
						MotoBike motoBike = new MotoBike(messagesSlip[1], messagesSlip[2], messagesSlip[3], messagesSlip[4], messagesSlip[5], messagesSlip[6], messagesSlip[7],Integer.parseInt(messagesSlip[8]),Integer.parseInt(messagesSlip[9]));
						System.out.println(motoBike);
						String result = AccountService.insertmoto(motoBike);
						System.out.println(result);
						dataOutputStream.writeUTF(result);
						dataOutputStream.flush();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (messagesSlip[0].trim().equals("request-update")) {
					try {
						MotoBike motoBike = new MotoBike(messagesSlip[1], messagesSlip[2], messagesSlip[3], messagesSlip[4], messagesSlip[5], messagesSlip[6], messagesSlip[7],Integer.parseInt(messagesSlip[8]),Integer.parseInt(messagesSlip[9]));
						System.out.println(motoBike);
						String result = AccountService.updatemoto(motoBike);
						System.out.println(result);
						dataOutputStream.writeUTF(result);
						dataOutputStream.flush();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Khong nhan duoc reqest");
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
