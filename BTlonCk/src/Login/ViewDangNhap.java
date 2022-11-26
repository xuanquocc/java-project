package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Client;
import Controller.Client.View;
import View.MainView;

public class ViewDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JPasswordField tfpass;
	private ResultSet rs;
	JLabel lblNewLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDangNhap frame = new ViewDangNhap();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public ImageIcon Resize(String mu) {
		ImageIcon imgicon = new ImageIcon(mu);
		Image img = imgicon.getImage();
		Image img1 = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon im = new ImageIcon(img1);
		return im;
	}
	
	public ViewDangNhap() {

		this.dispose();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbuser = new JLabel("User");
		lbuser.setBounds(29, 81, 80, 23);
		lbuser.setForeground(Color.WHITE);
		lbuser.setHorizontalAlignment(SwingConstants.CENTER);
		lbuser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbuser);

		tfuser = new JTextField();
		tfuser.setBounds(119, 81, 327, 23);
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(tfuser);
		tfuser.setColumns(10);

		JLabel lbpass = new JLabel("PassWord");
		lbpass.setForeground(Color.WHITE);
		lbpass.setBounds(10, 141, 80, 23);
		lbpass.setHorizontalAlignment(SwingConstants.CENTER);
		lbpass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lbpass);

		tfpass = new JPasswordField();
		tfpass.setBounds(116, 141, 327, 23);
		tfpass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfpass.setColumns(10);
		contentPane.add(tfpass);

		JButton btdangnhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btdangnhap.setBounds(69, 209, 150, 32);
		btdangnhap.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("loginicon.png"))));
		btdangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				try {
//					String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=quanlidangkii;"
//							+ "user=sa;password=sa";
//					Connection conn = DriverManager.getConnection(dbURL);
//					String sql = "Select * from account where username = ?";
//					PreparedStatement statement = conn.prepareStatement(sql);
//					statement.setString(1, tfuser.getText());
//					ResultSet rs = statement.executeQuery();
//					while (rs.next()) {
//						if (tfuser.getText().equals(rs.getString("username"))
//								&& tfpass.getText().equals(rs.getString("password"))) {
//							new MainView();
//							dispose();
//						}
//					}
//				} catch (Exception e1) {
//
//					e1.printStackTrace();
//				}
				Client.sendAccount(tfuser.getText(),tfpass.getText());
			}
		});

		btdangnhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btdangnhap);

		JButton btdangki = new JButton("Đăng kí");
		btdangki.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("dangkiicon.png"))));
		btdangki.setBounds(302, 209, 150, 32);
		btdangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.openView(View.REGISTER);
				Client.closeView(View.LOGIN);
			}
		});
		btdangki.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btdangki);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(482, 0, 438, 400);
		lblNewLabel.setIcon(Resize("D:\\ảnh\\pngtree-user-login-or-authenticate-icon-on-gray-background-flat-icon-ve-png-image_1742031.jpg"));
		
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Đăng Nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(45, 0, 407, 71);
		contentPane.add(lblNewLabel_1);

	}
}
