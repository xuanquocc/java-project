package View;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import Connect.Connect;
import Controller.Client;
import Controller.VehicleModify;
import Model.MotoBike;

public class ViewMoto extends JFrame {

	private JPanel contentPane;
	private JTextField tfhoten;
	private JTextField tfngaysinh;
	private JTextField tfsodienthoai;
	private JTextField tfphankhoi;
	private JTextField tfhangxe;
	private JTextField tfbiensoxe;
	JLabel lblNewLabel_1;
	public Object[] col = { "Số thứ tự", "Họ tên", "Ngày sinh", "Số điện thoại", "Loại xe ", "Phân khối", "Hãng xe",
			"Biển số xe", "ID" ,"Tháng Đăng kí"};
	public DefaultTableModel dfTb = new DefaultTableModel(col, 0);
	public JTable tbmoto = new JTable(dfTb);
	private JTextField tfloaixe;
	ArrayList<MotoBike> motolist = new ArrayList<>();
	private JTextField tfid;
	private JTextField tfthang;
	ArrayList<MotoBike> list = VehicleModify.findMoto() ;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewMoto vt = new ViewMoto();
//					vt.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public ImageIcon Resize(String mu) {
		ImageIcon imgicon = new ImageIcon(mu);
		Image img = imgicon.getImage();
		Image img1 = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon im = new ImageIcon(img1);
		return im;
	}
	
	public ViewMoto() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 662);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();

		panel1.setBounds(0, 0, 1062, 356);

		panel1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lbhoten = new JLabel("H\u1ECD v\u00E0 ten");
		lbhoten.setForeground(Color.DARK_GRAY);
		lbhoten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbhoten.setHorizontalAlignment(SwingConstants.CENTER);

		lbhoten.setBounds(21, 104, 118, 24);
		panel1.add(lbhoten);

		tfhoten = new JTextField();
		tfhoten.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfhoten.setBounds(162, 106, 205, 24);
		panel1.add(tfhoten);

		JLabel lblngaySinh = new JLabel("Ng\u00E0y Sinh");
		lblngaySinh.setForeground(Color.DARK_GRAY);
		lblngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblngaySinh.setHorizontalAlignment(SwingConstants.CENTER);

		lblngaySinh.setBounds(21, 155, 118, 24);
		panel1.add(lblngaySinh);

		tfngaysinh = new JTextField();
		tfngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tfngaysinh.setBounds(162, 157, 205, 24);
		panel1.add(tfngaysinh);

		JLabel lbsodienthoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lbsodienthoai.setForeground(Color.DARK_GRAY);
		lbsodienthoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbsodienthoai.setHorizontalAlignment(SwingConstants.CENTER);
		;
		lbsodienthoai.setBounds(21, 211, 118, 24);
		panel1.add(lbsodienthoai);

		tfsodienthoai = new JTextField();
		tfsodienthoai.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tfsodienthoai.setBounds(162, 213, 205, 24);
		panel1.add(tfsodienthoai);

		JLabel lbphankhoi = new JLabel("Phân khối");
		lbphankhoi.setForeground(Color.DARK_GRAY);
		lbphankhoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphankhoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbphankhoi.setBounds(414, 104, 118, 24);
		panel1.add(lbphankhoi);

		tfphankhoi = new JTextField();
		tfphankhoi.setBounds(542, 107, 205, 24);
		panel1.add(tfphankhoi);

		JLabel lbhangxe = new JLabel("H\u00E3ng xe");
		lbhangxe.setForeground(Color.DARK_GRAY);
		lbhangxe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbhangxe.setHorizontalAlignment(SwingConstants.CENTER);
		lbhangxe.setBounds(414, 155, 118, 24);
		panel1.add(lbhangxe);

		tfhangxe = new JTextField();
		tfhangxe.setBounds(542, 158, 205, 24);
		panel1.add(tfhangxe);

		JLabel lbbiensoxe = new JLabel("Biển số xe");
		lbbiensoxe.setForeground(Color.DARK_GRAY);
		lbbiensoxe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbbiensoxe.setHorizontalAlignment(SwingConstants.CENTER);
		lbbiensoxe.setBounds(414, 211, 118, 24);
		panel1.add(lbbiensoxe);

		tfbiensoxe = new JTextField();
		tfbiensoxe.setBounds(542, 214, 205, 24);
		panel1.add(tfbiensoxe);

		JLabel lbloaixe = new JLabel("Loại xe");
		lbloaixe.setForeground(Color.DARK_GRAY);
		lbloaixe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbloaixe.setHorizontalAlignment(SwingConstants.CENTER);
		lbloaixe.setBounds(21, 301, 118, 24);
		panel1.add(lbloaixe);

		tfloaixe = new JTextField();
		tfloaixe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfloaixe.setBounds(162, 303, 205, 24);
		panel1.add(tfloaixe);

		JLabel lbid = new JLabel("ID");
		lbid.setForeground(Color.DARK_GRAY);
		lbid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbid.setHorizontalAlignment(SwingConstants.CENTER);
		lbid.setBounds(21, 256, 118, 24);
		panel1.add(lbid);

		tfid = new JTextField();
		tfid.setBounds(162, 259, 205, 24);
		panel1.add(tfid);

		JLabel lblNewLabel = new JLabel("Quản Lí Đăng Kí Xe Máy");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(322, 10, 351, 34);
		panel1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1061, 48);
		panel1.add(panel);
		panel.setLayout(null);
		
		JButton btthongke = new JButton("Thống kê");
		btthongke.setBounds(931, 10, 120, 34);
		panel.add(btthongke);
		btthongke.addActionListener(new ActionListener() {
			private BarRenderer redenrer;
			private CategoryPlot plot;

			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "select * from thongke";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(Connect.connect(),sql);
					JFreeChart chart = ChartFactory.createLineChart("Thống kê", "thang", "soluong", dataset,PlotOrientation.VERTICAL, false,true, true);
					redenrer = null;
					plot = null; 
					redenrer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Thống kê", chart);
					frame.setVisible(true);
					frame.setSize(400,650);
					frame.setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e2) {
					
				}
			}
		});
		btthongke.setForeground(Color.WHITE);
		btthongke.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btthongke.setBackground(Color.RED);
		
		JButton btxuat = new JButton("Xuất");
		btxuat.addActionListener(new ActionListener() {
			private XSSFWorkbook workbook;

			public void actionPerformed(ActionEvent e) {
				try {
					workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("Oto");
					
					XSSFRow row = null;
					Cell cell = null; 
					
					row = sheet.createRow(3);
					
					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue("STT");
					
					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue("Họ và tên");
					
					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue("Ngày sinh");
					
					cell = row.createCell(3,CellType.STRING);
					cell.setCellValue("Số điện thoại");
					
					cell = row.createCell(4,CellType.STRING);
					cell.setCellValue("Loại xe");
					
					cell = row.createCell(5,CellType.STRING);
					cell.setCellValue("Phân khối");
					
					
					cell = row.createCell(6,CellType.STRING);
					cell.setCellValue("Hãng xe");
					
					cell = row.createCell(7,CellType.STRING);
					cell.setCellValue("Biển số xe");
					
					cell = row.createCell(8,CellType.STRING);
					cell.setCellValue("ID");
					
					cell = row.createCell(9,CellType.STRING);
					cell.setCellValue("Tháng");
					
					ArrayList<MotoBike> listItem = list;
					if(listItem != null) {
						int s = listItem.size();
						for(int i=0 ;  i<s; i++ ) {
							MotoBike moto1 = listItem.get(i); 
							
							row = sheet.createRow(4 + i);
							
							cell = row.createCell(0,CellType.NUMERIC);
							cell.setCellValue(i + 1);
							
							cell = row.createCell(1,CellType.STRING);
							cell.setCellValue(moto1.getHoten());
							
							cell = row.createCell(2,CellType.STRING);
							cell.setCellValue(moto1.getNgaysinh());
							
							cell = row.createCell(3,CellType.STRING);
							cell.setCellValue(moto1.getSodienthoai());
							
							cell = row.createCell(4,CellType.STRING);
							cell.setCellValue(moto1.getLoaixe());
							
							cell = row.createCell(5,CellType.STRING);
							cell.setCellValue(moto1.getPhankhoi());
							
							
							cell = row.createCell(6,CellType.STRING);
							cell.setCellValue(moto1.getHangxe());
							
							cell = row.createCell(7,CellType.STRING);
							cell.setCellValue(moto1.getBiensoxe());
							
							cell = row.createCell(8,CellType.NUMERIC);
							cell.setCellValue(moto1.getId());
							
							cell = row.createCell(9,CellType.NUMERIC);
							cell.setCellValue(moto1.getThang());
							
						}
						//lưu file
						File f = new File("D:/moto.xlsx");
						FileOutputStream fis = new FileOutputStream(f);
						workbook.write(fis);
						fis.close();
					}
					}catch(Exception ex) {	
						ex.printStackTrace();
					}
					}
					
				
			}
		);
		btxuat.setForeground(Color.WHITE);
		btxuat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btxuat.setBackground(Color.RED);
		btxuat.setBounds(792, 10, 120, 34);
		panel.add(btxuat);

		JPanel panel124 = new JPanel();
		panel124.setBounds(0, 351, 1061, 5);
		panel1.add(panel124);
		panel124.setBackground(Color.BLACK);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(21, 68, 745, 5);
		panel1.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(21, 68, 3, 273);
		panel1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(21, 337, 745, 4);
		panel1.add(panel_3);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(763, 68, 3, 273);
		panel1.add(panel_2_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(776, 47, 285, 299);
		panel1.add(panel_4);
		panel_4.setLayout(null);

	    lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 285, 299);
		lblNewLabel_1.setIcon(Resize("D:\\ảnh\\yamaha-r1-superbike-road-night-hd-wallpaper.jpg"));
		panel_4.add(lblNewLabel_1);
		
		JLabel lbthang = new JLabel("Tháng");
		lbthang.setHorizontalAlignment(SwingConstants.CENTER);
		lbthang.setForeground(Color.DARK_GRAY);
		lbthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbthang.setBounds(414, 256, 118, 24);
		panel1.add(lbthang);
		
		tfthang = new JTextField();
		tfthang.setBounds(542, 261, 205, 24);
		panel1.add(tfthang);

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 345, 1062, 280);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JScrollPane sc = new JScrollPane(tbmoto);
		tbmoto.setModel(dfTb);
		sc.setBounds(3, 10, 894, 270);
		panel2.add(sc);

		JButton btdangki = new JButton("Đăng kí");
		btdangki.setIcon(new ImageIcon("D:\\ảnh\\checkmark_26px.png"));
		btdangki.setBounds(907, 21, 145, 34);
		panel2.add(btdangki);
		btdangki.setBackground(new Color(70, 130, 180));
		btdangki.setForeground(Color.WHITE);
		btdangki.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btreset = new JButton("Clear");
		btreset.setForeground(Color.WHITE);
		btreset.setIcon(new ImageIcon("D:\\ảnh\\reset_30px.png"));
		btreset.setBounds(907, 65, 145, 34);
		panel2.add(btreset);
		btreset.setBackground(new Color(70, 130, 180));
		btreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfhoten.setText("");
				tfngaysinh.setText("");
				tfsodienthoai.setText("");
				tfloaixe.setText("");
				tfphankhoi.setText("");
				tfhangxe.setText("");
				tfbiensoxe.setText("");
				tfid.setText("");
				tfthang.setText("");
			}
		});
		btreset.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btsua = new JButton("Sửa");
		btsua.setIcon(new ImageIcon("D:\\ảnh\\edit_24px.png"));
		btsua.setBounds(907, 109, 145, 34);
		panel2.add(btsua);
		btsua.setForeground(Color.WHITE);
		btsua.setBackground(new Color(70, 130, 180));
		btsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten = tfhoten.getText();
				String ngaysinh = tfngaysinh.getText();
				String sodienthoai = tfsodienthoai.getText();
				String loaixe = tfloaixe.getText();
				String phankhoi = tfphankhoi.getText();
				String hangxe = tfhangxe.getText();
				String biensoxe = tfbiensoxe.getText();
				int id = Integer.parseInt(tfid.getText());
				int thang = Integer.parseInt(tfthang.getText());
				
				JOptionPane.showMessageDialog(btsua, "Bạn có muón sửa ?");
//				VehicleModify.updatemoto(moto);
				Client.updateAccount(hoten + "," + ngaysinh + "," + sodienthoai + "," + loaixe + "," + phankhoi + "," + hangxe + "," + biensoxe + "," + id + "," + thang);
				show2();
			}
		});
		btsua.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btxoa = new JButton("Xoá");
		btxoa.setForeground(Color.WHITE);
		btxoa.setIcon(new ImageIcon("D:\\ảnh\\eraser_24px.png"));
		btxoa.setBounds(907, 153, 145, 34);
		panel2.add(btxoa);
		btxoa.setBackground(new Color(70, 130, 180));
		btxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectIndex = tbmoto.getSelectedRow();
				if (selectIndex >= 0) {
					MotoBike moto = motolist.get(selectIndex);
					Client.deleteAccount(String.valueOf(moto.getId()));
					int option = JOptionPane.showConfirmDialog(btxoa, "Bạn có muốn xoá tên này ?");
					if (option == 0) {
					//	VehicleModify.deletemoto(moto.getId());
						show2();

					}
				}

			}
		});
		btxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton bttim = new JButton("Tìm");
		bttim.setForeground(Color.WHITE);
		bttim.setIcon(new ImageIcon("D:\\ảnh\\search_24px.png"));
		bttim.setBounds(907, 197, 145, 34);
		panel2.add(bttim);
		bttim.setBackground(new Color(70, 130, 180));
		bttim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(bttim, "Nhập tên bạn muốn tìm");
				String idmoto = JOptionPane.showInputDialog(bttim, " Nhập id");
				dfTb.setRowCount(0);
				if (input.length() > 0) {
					motolist = VehicleModify.findByMoto(input,idmoto);
					for (MotoBike moto : motolist) {
						dfTb.addRow(new Object[] { dfTb.getRowCount() + 1, moto.getHoten(), moto.getNgaysinh(),
								moto.getSodienthoai(), moto.getLoaixe(), moto.getPhankhoi(), moto.getHangxe(),
								moto.getBiensoxe(), moto.getId() });
					}
				}else{
					JOptionPane.showMessageDialog(bttim, "Không tìm thấy");
				}
			}
		});
		bttim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btrefresh = new JButton("Refresh");
		btrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dfTb = (DefaultTableModel) tbmoto.getModel();
				dfTb.setRowCount(0);
				show2();
			}
		});
		btrefresh.setForeground(Color.WHITE);
		btrefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btrefresh.setBackground(new Color(70, 130, 180));
		btrefresh.setBounds(907, 241, 145, 34);
		panel2.add(btrefresh);
		btdangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten = tfhoten.getText();
				String ngaysinh = tfngaysinh.getText();
				String sodienthoai = tfsodienthoai.getText();
				String loaixe = tfloaixe.getText();
				String phankhoi = tfphankhoi.getText();
				String hangxe = tfhangxe.getText();
				String biensoxe = tfbiensoxe.getText();
				int id = Integer.parseInt(tfid.getText()); 
				int thang = Integer.parseInt(tfthang.getText());
	
				Client.addAccount(hoten + "," + ngaysinh + "," + sodienthoai + "," + loaixe + "," + phankhoi + "," + hangxe + "," + biensoxe + "," + id + "," + thang);
				show2();
			}
		});
		show2();
		tbmoto.getSelectionModel().addListSelectionListener(event -> {
			int row = tbmoto.getSelectedRow();
			if (row >= 0) {
				tfhoten.setText(tbmoto.getModel().getValueAt(row, 1).toString());
				tfngaysinh.setText(tbmoto.getModel().getValueAt(row, 2).toString());
				tfsodienthoai.setText(tbmoto.getModel().getValueAt(row, 3).toString());
				tfloaixe.setText(tbmoto.getModel().getValueAt(row, 4).toString());
				tfphankhoi.setText(tbmoto.getModel().getValueAt(row, 5).toString());
				tfhangxe.setText(tbmoto.getModel().getValueAt(row, 6).toString());
				tfbiensoxe.setText(tbmoto.getModel().getValueAt(row, 7).toString());
				tfid.setText(tbmoto.getModel().getValueAt(row, 8).toString());
				tfthang.setText(tbmoto.getModel().getValueAt(row, 9).toString());
			}
		});
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void show2() {

		motolist = VehicleModify.findMoto();
		dfTb.setRowCount(0);

		for (MotoBike moto : motolist) {
			dfTb.addRow(
					new Object[] { dfTb.getRowCount() + 1, moto.getHoten(), moto.getNgaysinh(), moto.getSodienthoai(),
							moto.getLoaixe(), moto.getPhankhoi(), moto.getHangxe(), moto.getBiensoxe(), moto.getId(), moto.getThang() });
		}
	}
}
