package Service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Model.MotoBike;
import Model.Oto;

public class AccountService{
	static Connection connection = DAOconnect.connect();
	public static boolean checkAccount(String accountName, String pass) {
		try {
			String sql = "Select * from account where username ='"+accountName+"' and password ='"+pass+"'";
			java.sql.Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(accountName) && rs.getString(3).equals(pass)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Boolean regisAccount(String name, String gmail, String pass) {

		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=quanlidangkii;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			
			String sql = "INSERT INTO account values('" + name + "','" + gmail + "','" + pass  + "')";
			java.sql.Statement statement =  conn.createStatement();
			int n =  statement.executeUpdate(sql);
			
			if(n!=0 ) {
				JOptionPane.showMessageDialog(null, "Đăng kí thành công");
			}
			return true;
		}catch(Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}
	public static String deletemoto(String id) {
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "delete from Moto where id=?";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, id);
			statement.execute();
			return "delete-success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "delete-fail";
		}
	}
	
	public static String insertmoto(MotoBike moto) {
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "insert into Moto(hoten,ngaysinh,sodienthoai,loaixe,phankhoi,hangxe,biensoxe,id,thang) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, moto.getHoten());
			statement.setString(2, moto.getNgaysinh());
			statement.setString(3, moto.getSodienthoai());
			statement.setString(4, moto.getLoaixe());
			statement.setString(5, moto.getPhankhoi());
			statement.setString(6, moto.getHangxe());
			statement.setString(7, moto.getBiensoxe());
			statement.setInt(8, moto.getId());
			statement.setInt(9, moto.getThang());
			statement.execute();
			return "add-success";
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "add-fail";
	}

	public static String updatemoto(MotoBike moto) {
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "update Moto set hoten=?,ngaysinh=?,sodienthoai=?,loaixe=?,phankhoi=?,hangxe=?,biensoxe=?, thang=? where id=? ";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, moto.getHoten());
			statement.setString(2, moto.getNgaysinh());
			statement.setString(3, moto.getSodienthoai());
			statement.setString(4, moto.getLoaixe());
			statement.setString(5, moto.getPhankhoi());
			statement.setString(6, moto.getHangxe());
			statement.setString(7, moto.getBiensoxe());
			statement.setInt(8, moto.getThang());
			statement.setInt(9, moto.getId());
			statement.execute();
			return "update-success";
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "update-fail";
	}
}



