package Controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MotoBike;
import Model.Oto;

public class VehicleModify {

	public static ArrayList<MotoBike> findMoto() {

		ArrayList<MotoBike> motolist = new ArrayList<>();

		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			java.sql.Statement statement = conn.createStatement();
			String sql = "select * from Moto";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				MotoBike moto = new MotoBike(rs.getString("hoten"), rs.getString("ngaysinh"),
						rs.getString("sodienthoai"), rs.getString("loaixe"), rs.getString("phankhoi"),
						rs.getString("hangxe"), rs.getString("biensoxe"), rs.getInt("id"), rs.getInt("thang"));
				motolist.add(moto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return motolist;
	}

	public static ArrayList<Oto> findOto() {

		ArrayList<Oto> otolist = new ArrayList<>();

		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			java.sql.Statement statement = conn.createStatement();
			String sql = "select * from Oto";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Oto oto = new Oto(rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("sodienthoai"),
						rs.getString("loaixe"), rs.getString("phankhoi"), rs.getInt("chongoi"), rs.getString("hangxe"),
						rs.getString("biensoxe"), rs.getInt("id"), rs.getInt("thang"));
				otolist.add(oto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return otolist;
	}

	public static void insertmoto(MotoBike moto) {
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

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static void insertoto(Oto oto) {
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "insert into Oto(hoten,ngaysinh,sodienthoai,loaixe,phankhoi,hangxe,biensoxe,chongoi,id,thang) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, oto.getHoten());
			statement.setString(2, oto.getNgaysinh());
			statement.setString(3, oto.getSodienthoai());
			statement.setString(4, oto.getLoaixe());
			statement.setString(5, oto.getPhankhoi());
			statement.setString(6, oto.getHangxe());
			statement.setString(7, oto.getBiensoxe());
			statement.setInt(8, oto.getChongoi());
			statement.setInt(9, oto.getId());
			statement.setInt(10, oto.getThang());
			statement.execute();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static void updatemoto(MotoBike moto) {
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

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static void updateoto(Oto oto) {
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "update Oto set hoten=?,ngaysinh=?,sodienthoai=?,loaixe=?,phankhoi=?,hangxe=?,biensoxe=?,chongoi=?, thang=? where id=? ";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, oto.getHoten());
			statement.setString(2, oto.getNgaysinh());
			statement.setString(3, oto.getSodienthoai());
			statement.setString(4, oto.getLoaixe());
			statement.setString(5, oto.getPhankhoi());
			statement.setString(6, oto.getHangxe());
			statement.setString(7, oto.getBiensoxe());
			statement.setInt(8, oto.getChongoi());
			statement.setInt(9, oto.getThang());
			statement.setInt(10, oto.getId());
			
			statement.execute();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

//	public static void deletemoto(int id) {
//		try {
//			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
//			Connection conn = DriverManager.getConnection(dbURL);
//			String sql = "delete from Moto where id=?";
//			PreparedStatement statement = conn.prepareCall(sql);
//			statement.setInt(1, id);
//			statement.execute();
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//	}

	public static void deleteoto(int id) {
		PreparedStatement statement = null;
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "delete from Oto where id=?";
			statement = conn.prepareCall(sql);
			statement.setInt(1, id);
			statement.execute();

			statement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static ArrayList<Oto> findByOto(String hoten, String id) {

		ArrayList<Oto> otolist = new ArrayList<>();

		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "select * from Oto where hoten like ? and id = ?";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, "%" + hoten + "%");
			statement.setString(2, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Oto oto = new Oto(rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("sodienthoai"),
						rs.getString("loaixe"), rs.getString("phankhoi"), rs.getInt("chongoi"), rs.getString("hangxe"),
						rs.getString("biensoxe"), rs.getInt("id"), rs.getInt("thang"));
				otolist.add(oto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return otolist;
	}

	public static ArrayList<MotoBike> findByMoto(String hoten, String id) {

		ArrayList<MotoBike> motolist = new ArrayList<>();

		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Quanlidangki;" + "user=sa;password=sa";
			Connection conn = DriverManager.getConnection(dbURL);
			String sql = "select * from Moto where hoten like ? and id = ?";
			PreparedStatement statement = conn.prepareCall(sql);
			statement.setString(1, "%" + hoten + "%");
			statement.setString(2, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				MotoBike moto = new MotoBike(rs.getString("hoten"), rs.getString("ngaysinh"),
						rs.getString("sodienthoai"), rs.getString("loaixe"), rs.getString("phankhoi"),
						rs.getString("hangxe"), rs.getString("biensoxe"), rs.getInt("id"), rs.getInt("thang"));
				motolist.add(moto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return motolist;
	}
}
