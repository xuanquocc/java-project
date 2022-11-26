package Controller;

import java.io.IOException;

import Login.ViewDangKi;
import Login.ViewDangNhap;
import Model.MotoBike;
import View.MainView;


public class Client {

	public static ViewDangNhap loginView;
	public static MainView mainView;
	public static ViewDangKi registerView;
	public static SocketHandle socketHandle;
	
	public enum View {
		LOGIN, MAINVIEW, REGISTER
	}
	
	public static void closeView(View viewName) {
		
		if (viewName != null) {
			switch (viewName) {
			case LOGIN:
				loginView.dispose();
				break;
			case REGISTER:
				registerView.dispose();
				break;
			case MAINVIEW:
				mainView.dispose();
				break;
			}
		}

	}
	
	public static void sendAccount(String account, String password) {
		String s1 = account + "," +password;
		
		String s2 = EnCryption.enCryption(s1);

		try {
			socketHandle.getDaOutputStream().writeUTF("request-login,"+s2);
			socketHandle.getDaOutputStream().flush();
			System.out.println("chuoi "+s2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendAccount1(String account,String gmail, String password) {
		String s1 = account+ "," +gmail + "," +password;
		
		String s2 = EnCryption.enCryption(s1);

		try {
			socketHandle.getDaOutputStream().writeUTF("request-regis,"+s2);
			socketHandle.getDaOutputStream().flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteAccount( String id) {
		try {
			socketHandle.getDaOutputStream().writeUTF("request-delete,"+id);
			socketHandle.getDaOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addAccount(String obj) {
		try {
			socketHandle.getDaOutputStream().writeUTF("request-add,"+obj);
			socketHandle.getDaOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateAccount(String obj) {
		try {
			socketHandle.getDaOutputStream().writeUTF("request-update,"+obj);
			socketHandle.getDaOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void openView(View viewName) {
		if (viewName != null) {
			switch (viewName) {
			case LOGIN:
				loginView = new ViewDangNhap();
				loginView.setVisible(true);
				break;
			case MAINVIEW:
				mainView = new MainView();
				mainView.setVisible(true);
				break;
			case REGISTER:
				registerView = new ViewDangKi();
				registerView.setVisible(true);
				break;
			}
		}
	}
	public void initView() {
		loginView = new ViewDangNhap();
		loginView.setVisible(true);
		
		socketHandle = new SocketHandle();
		socketHandle.run();
	}
	public static void main(String[] args) {
		new Client().initView();
	}
}
