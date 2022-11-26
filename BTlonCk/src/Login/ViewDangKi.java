package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Client;

import javax.swing.SwingConstants;

public class ViewDangKi extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JTextField tfgmail;
	private JTextField tfpassword;
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDangKi frame = new ViewDangKi();
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
	
	public ViewDangKi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 556, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0, 0, 542, 297);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lbuser = new JLabel("User");
		lbuser.setForeground(Color.WHITE);
		lbuser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbuser.setBounds(10, 52, 84, 24);
		panel1.add(lbuser);

		tfuser = new JTextField();
		tfuser.setBounds(172, 54, 246, 24);
		panel1.add(tfuser);
		tfuser.setColumns(10);

		JLabel lbgmail = new JLabel("Gmail");
		lbgmail.setForeground(Color.WHITE);
		lbgmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbgmail.setBounds(10, 103, 84, 24);
		panel1.add(lbgmail);

		tfgmail = new JTextField();
		tfgmail.setColumns(10);
		tfgmail.setBounds(172, 105, 246, 24);
		panel1.add(tfgmail);

		JLabel lbpassword = new JLabel("Password");
		lbpassword.setForeground(Color.WHITE);
		lbpassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbpassword.setBounds(10, 154, 84, 24);
		panel1.add(lbpassword);

		tfpassword = new JTextField();
		tfpassword.setColumns(10);
		tfpassword.setBounds(172, 156, 246, 24);
		panel1.add(tfpassword);

		
		
		JButton btdangki = new JButton("Đăng kí");
		btdangki.setBounds(115, 218, 104, 30);
		panel1.add(btdangki);
		btdangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dk = JOptionPane.showConfirmDialog(btdangki, "Bạn có muốn đăng kí", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (dk != JOptionPane.YES_OPTION) {
					return;
				}
				if(tfpassword.getText().length()>=6) {
					Client.sendAccount1(tfuser.getText(), tfgmail.getText(), tfpassword.getText());
				}else if(tfpassword.getText().length()<6) {
					JOptionPane.showMessageDialog(btdangki, "Mật khẩu yếu");
				}
				
				if(tfuser.getText().equals("")|tfgmail.getText().equals("")|tfpassword.getText().equals("")) {
					JOptionPane.showMessageDialog(btdangki, "Không được để thông tin trống");
				}
			}

		});
		btdangki.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btthoat = new JButton("Đăng nhập");
		btthoat.setBounds(334, 218, 104, 30);
		panel1.add(btthoat);
		btthoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ViewDangNhap vdn = new ViewDangNhap();
				vdn.setVisible(true);
				dispose();
			}
		});
		btthoat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÍ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 0, 323, 44);
		panel1.add(lblNewLabel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
