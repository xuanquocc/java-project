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
import Controller.VehicleModify;
import Model.Oto;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField tfhoten;
	private JTextField tfngaysinh;
	private JTextField tfsodienthoai;
	private JTextField tfphankhoi;
	private JTextField tfchongoi;
	private JTextField tfhangxe;
	private JTextField tfbiensoxe;
	JLabel lblNewLabel_1;
	public Object[] col = { "Số thứ tự", "Họ tên", "Ngày sinh", "Số điện thoại", "Loại xe ", "Phân khối", "Chỗ ngồi",
			"Hãng xe", "Biển số xe", "ID", "Tháng đăng kí" };
	public DefaultTableModel dfTb = new DefaultTableModel(col, 0);
	public JTable tboto = new JTable(dfTb);
	private JTextField tfloaixe;
	ArrayList<Oto> otolist = new ArrayList<>();
	private JTextField tfid;
	private JTextField tfthang;
	ArrayList<Oto> list = VehicleModify.findOto();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					View frame = new View();
//					frame.setVisible(true);
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

	public void show1() {

		otolist = VehicleModify.findOto();
		dfTb.setRowCount(0);

		for (Oto oto : otolist) {
			dfTb.addRow(new Object[] { dfTb.getRowCount() + 1, oto.getHoten(), oto.getNgaysinh(), oto.getSodienthoai(),
					oto.getLoaixe(), oto.getPhankhoi(), oto.getChongoi(), oto.getHangxe(), oto.getBiensoxe(),
					oto.getId(), oto.getThang() });
		}
	}

	public View() {
//		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 692);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1095, 417);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbhovaten = new JLabel("H\u1ECD v\u00E0 ten");
		lbhovaten.setForeground(Color.BLACK);
		lbhovaten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbhovaten.setHorizontalAlignment(SwingConstants.CENTER);

		lbhovaten.setBounds(21, 71, 118, 24);
		panel.add(lbhovaten);

		tfhoten = new JTextField();
		tfhoten.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfhoten.setBounds(162, 71, 198, 24);
		panel.add(tfhoten);

		JLabel lblNgaySinh = new JLabel("Ng\u00E0y Sinh");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgaySinh.setBounds(21, 121, 118, 24);
		panel.add(lblNgaySinh);

		tfngaysinh = new JTextField();
		tfngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfngaysinh.setBounds(162, 121, 198, 24);
		panel.add(tfngaysinh);

		JLabel lbsodienthoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lbsodienthoai.setForeground(Color.BLACK);
		lbsodienthoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbsodienthoai.setHorizontalAlignment(SwingConstants.CENTER);
		lbsodienthoai.setBounds(21, 165, 118, 24);
		panel.add(lbsodienthoai);

		tfsodienthoai = new JTextField();
		tfsodienthoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfsodienthoai.setBounds(162, 165, 198, 24);
		panel.add(tfsodienthoai);

		JLabel lbphankhoi = new JLabel("Mã lực");
		lbphankhoi.setForeground(Color.BLACK);
		lbphankhoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphankhoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbphankhoi.setBounds(21, 313, 118, 24);
		panel.add(lbphankhoi);

		tfphankhoi = new JTextField();
		tfphankhoi.setBounds(162, 316, 198, 24);
		panel.add(tfphankhoi);

		JLabel lbchongoi = new JLabel("Số chỗ ngồi ");
		lbchongoi.setForeground(Color.BLACK);
		lbchongoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbchongoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbchongoi.setBounds(21, 362, 135, 24);
		panel.add(lbchongoi);

		tfchongoi = new JTextField();
		tfchongoi.setBounds(162, 365, 198, 24);
		panel.add(tfchongoi);

		JLabel lbhangxe = new JLabel("H\u00E3ng xe");
		lbhangxe.setForeground(Color.BLACK);
		lbhangxe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbhangxe.setHorizontalAlignment(SwingConstants.CENTER);
		lbhangxe.setBounds(402, 71, 118, 24);
		panel.add(lbhangxe);

		tfhangxe = new JTextField();
		tfhangxe.setBounds(530, 74, 198, 24);
		panel.add(tfhangxe);

		JLabel lbbiensoxe = new JLabel("Biển số xe");
		lbbiensoxe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbbiensoxe.setForeground(Color.BLACK);
		lbbiensoxe.setHorizontalAlignment(SwingConstants.CENTER);
		lbbiensoxe.setBounds(402, 121, 118, 24);
		panel.add(lbbiensoxe);

		tfbiensoxe = new JTextField();
		tfbiensoxe.setBounds(530, 124, 198, 24);
		panel.add(tfbiensoxe);

		JLabel lbloaixe = new JLabel("Loại xe");
		lbloaixe.setForeground(Color.BLACK);
		lbloaixe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbloaixe.setHorizontalAlignment(SwingConstants.CENTER);
		lbloaixe.setBounds(21, 267, 118, 24);
		panel.add(lbloaixe);

		tfloaixe = new JTextField();
		tfloaixe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfloaixe.setBounds(162, 269, 198, 24);
		panel.add(tfloaixe);

		JLabel lbid = new JLabel("ID");
		lbid.setForeground(Color.BLACK);
		lbid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbid.setHorizontalAlignment(SwingConstants.CENTER);
		lbid.setBounds(21, 215, 118, 24);
		panel.add(lbid);

		tfid = new JTextField();
		tfid.setBounds(162, 216, 198, 24);
		panel.add(tfid);

		JLabel lblNewLabel = new JLabel("Quản Lí Đăng Kí Oto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(357, 10, 374, 30);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 412, 1094, 5);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 1094, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btxuat = new JButton("Xuất");
		btxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("Oto");

					XSSFRow row = null;
					Cell cell = null;

					row = sheet.createRow(3);

					cell = row.createCell(0, CellType.STRING);
					cell.setCellValue("STT");

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue("Họ và tên");

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue("Ngày sinh");

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue("Số điện thoại");

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue("Loại xe");

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue("Phân khối");

					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue("Chỗ ngồi");

					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue("Hãng xe");

					cell = row.createCell(8, CellType.STRING);
					cell.setCellValue("Biển số xe");

					cell = row.createCell(9, CellType.STRING);
					cell.setCellValue("ID");

					cell = row.createCell(10, CellType.STRING);
					cell.setCellValue("Tháng");

					ArrayList<Oto> listItem = list;
					if (listItem != null) {
						int s = listItem.size();
						for (int i = 0; i < s; i++) {
							Oto oto1 = listItem.get(i);

							row = sheet.createRow(4 + i);

							cell = row.createCell(0, CellType.NUMERIC);
							cell.setCellValue(i + 1);

							cell = row.createCell(1, CellType.STRING);
							cell.setCellValue(oto1.getHoten());

							cell = row.createCell(2, CellType.STRING);
							cell.setCellValue(oto1.getNgaysinh());

							cell = row.createCell(3, CellType.STRING);
							cell.setCellValue(oto1.getSodienthoai());

							cell = row.createCell(4, CellType.STRING);
							cell.setCellValue(oto1.getLoaixe());

							cell = row.createCell(5, CellType.STRING);
							cell.setCellValue(oto1.getPhankhoi());

							cell = row.createCell(6, CellType.NUMERIC);
							cell.setCellValue(oto1.getChongoi());

							cell = row.createCell(7, CellType.STRING);
							cell.setCellValue(oto1.getHangxe());

							cell = row.createCell(8, CellType.STRING);
							cell.setCellValue(oto1.getBiensoxe());

							cell = row.createCell(9, CellType.NUMERIC);
							cell.setCellValue(oto1.getId());

							cell = row.createCell(10, CellType.NUMERIC);
							cell.setCellValue(oto1.getThang());

						}
						// lưu file
						File f = new File("D:/oto.xlsx");
						FileOutputStream fis = new FileOutputStream(f);
						workbook.write(fis);
						fis.close();
					}
					JOptionPane.showMessageDialog(btxuat, "Xuất thành công");
				} 
				
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		btxuat.setBounds(808, 10, 120, 30);
		panel_2.add(btxuat);
		btxuat.setForeground(Color.BLACK);
		btxuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btxuat.setBackground(Color.WHITE);

		JButton btthongke = new JButton("Thống kê");
		btthongke.setBounds(964, 10, 120, 30);
		panel_2.add(btthongke);
		btthongke.addActionListener(new ActionListener() {
			BarRenderer redenrer;
			CategoryPlot plot;

			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "select * from thongkeoto";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(Connect.connect(), sql);
					JFreeChart chart = ChartFactory.createLineChart("Thống kê", "thang", "soluong", dataset,
							PlotOrientation.VERTICAL, false, true, true);
					redenrer = null;
					plot = null;
					redenrer = new BarRenderer();
					ChartFrame cframe = new ChartFrame("Thống kê", chart);
					cframe.setVisible(true);
					cframe.setSize(920, 780);

				} catch (Exception e2) {

				}
				setDefaultCloseOperation(ChartFrame.DISPOSE_ON_CLOSE);
			}
		});
		btthongke.setForeground(Color.BLACK);
		btthongke.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btthongke.setBackground(Color.WHITE);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(21, 58, 719, 3);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(21, 58, 1, 344);
		panel.add(panel_4);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.BLACK);
		panel_4_1.setBounds(738, 58, 1, 344);
		panel.add(panel_4_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(21, 403, 719, 3);
		panel.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(750, 48, 344, 369);
		panel.add(panel_6);
		panel_6.setLayout(null);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 345, 359);
		lblNewLabel_1.setIcon(Resize("D:\\ảnh\\2015-w-motors-supersport-10800x0w-1514409569053.jpg"));

		panel_6.add(lblNewLabel_1);

		JLabel lbthang = new JLabel("Tháng");
		lbthang.setHorizontalAlignment(SwingConstants.CENTER);
		lbthang.setForeground(Color.BLACK);
		lbthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbthang.setBounds(402, 165, 118, 24);
		panel.add(lbthang);

		tfthang = new JTextField();
		tfthang.setBounds(530, 170, 198, 24);
		panel.add(tfthang);

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 417, 1095, 244);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JScrollPane sc = new JScrollPane(tboto);
		sc.setBounds(0, 0, 955, 243);
		panel2.add(sc);
		tboto.setModel(dfTb);

		JButton btreset = new JButton("Clear");
		btreset.setBackground(new Color(70, 130, 180));
		btreset.setForeground(Color.WHITE);
		btreset.setIcon(new ImageIcon("D:\\ảnh\\reset_30px.png"));
		btreset.setBounds(965, 5, 120, 29);
		panel2.add(btreset);
		btreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfhoten.setText("");
				tfngaysinh.setText("");
				tfsodienthoai.setText("");
				tfloaixe.setText("");
				tfchongoi.setText("");
				tfphankhoi.setText("");
				tfhangxe.setText("");
				tfbiensoxe.setText("");
				tfchongoi.setText("");
				tfid.setText("");
				tfthang.setText("");
			}
		});
		btreset.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btsua = new JButton("Sửa");
		btsua.setBackground(new Color(70, 130, 180));
		btsua.setForeground(Color.WHITE);
		btsua.setIcon(new ImageIcon("D:\\ảnh\\edit_24px.png"));
		btsua.setBounds(965, 44, 120, 29);
		panel2.add(btsua);
		btsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoten = tfhoten.getText();
				String ngaysinh = tfngaysinh.getText();
				String sodienthoai = tfsodienthoai.getText();
				String loaixe = tfloaixe.getText();
				String phankhoi = tfphankhoi.getText();
				String hangxe = tfhangxe.getText();
				String biensoxe = tfbiensoxe.getText();
				int chongoi = Integer.parseInt(tfchongoi.getText());
				int id = Integer.parseInt(tfid.getText());
				int thang = Integer.parseInt(tfthang.getText());
				Oto oto = new Oto(hoten, ngaysinh, sodienthoai, loaixe, phankhoi, chongoi, hangxe, biensoxe, id, thang);
				JOptionPane.showMessageDialog(btsua, "Bạn có muón sửa ?");
				VehicleModify.updateoto(oto);
				show1();
			}
		});
		btsua.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btxoa = new JButton("Xoá");
		btxoa.setBackground(new Color(70, 130, 180));
		btxoa.setForeground(Color.WHITE);
		btxoa.setIcon(new ImageIcon("D:\\ảnh\\eraser_24px.png"));
		btxoa.setBounds(965, 83, 120, 29);
		panel2.add(btxoa);
		btxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectIndex = tboto.getSelectedRow();
				if (selectIndex >= 0) {
					Oto oto = otolist.get(selectIndex);
					int option = JOptionPane.showConfirmDialog(btxoa, "Bạn có muốn xoá tên này ?");
					if (option == 0) {
						VehicleModify.deleteoto(oto.getId());
						show1();

					}
				}

			}
		});
		btxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton bttim = new JButton("Tìm");
		bttim.setBackground(new Color(70, 130, 180));
		bttim.setForeground(Color.WHITE);
		bttim.setIcon(new ImageIcon("D:\\ảnh\\search_24px.png"));
		bttim.setBounds(965, 125, 120, 29);
		panel2.add(bttim);
		
		bttim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(bttim, "Nhập tên bạn muốn tìm");
				String idoto = JOptionPane.showInputDialog(bttim, "nhap id");
				dfTb.setRowCount(0);


				if (input.length() > 0) {



					otolist = VehicleModify.findByOto(input, idoto);
					for (Oto oto1 : otolist) {
						dfTb.addRow(new Object[] { dfTb.getRowCount() + 1, oto1.getHoten(), oto1.getNgaysinh(),
								oto1.getSodienthoai(), oto1.getLoaixe(), oto1.getPhankhoi(), oto1.getChongoi(),
								oto1.getHangxe(), oto1.getBiensoxe(), oto1.getId(), oto1.getThang() });
					}
					
				} else {
					JOptionPane.showMessageDialog(bttim, "vui lòng nhập đầy đủ thông tin ");
				}
			}
		});
		bttim.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btdangki = new JButton("Đăng kí");
		btdangki.setBackground(new Color(70, 130, 180));
		btdangki.setIcon(new ImageIcon("D:\\ảnh\\checkmark_26px.png"));
		btdangki.setForeground(Color.WHITE);
		btdangki.setBounds(965, 164, 120, 30);
		panel2.add(btdangki);
		btdangki.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btrefresh = new JButton("Refresh");
		btrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dfTb = (DefaultTableModel) tboto.getModel();
				dfTb.setRowCount(0);
				show1();
			}
		});
		btrefresh.setForeground(Color.WHITE);
		btrefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btrefresh.setBackground(new Color(70, 130, 180));
		btrefresh.setBounds(965, 204, 120, 30);
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
				int chongoi = Integer.parseInt(tfchongoi.getText());
				int id = Integer.parseInt(tfid.getText());
				int thang = Integer.parseInt(tfthang.getText());
				Oto oto = new Oto(hoten, ngaysinh, sodienthoai, loaixe, phankhoi, chongoi, hangxe, biensoxe, id, thang);

				VehicleModify.insertoto(oto);
				show1();
			}
		});
		tboto.getSelectionModel().addListSelectionListener(event -> {
			int row = tboto.getSelectedRow();
			if (row >= 0) {
				tfhoten.setText(tboto.getModel().getValueAt(row, 1).toString());
				tfngaysinh.setText(tboto.getModel().getValueAt(row, 2).toString());
				tfsodienthoai.setText(tboto.getModel().getValueAt(row, 3).toString());
				tfloaixe.setText(tboto.getModel().getValueAt(row, 4).toString());
				tfphankhoi.setText(tboto.getModel().getValueAt(row, 5).toString());
				tfchongoi.setText(tboto.getModel().getValueAt(row, 6).toString());
				tfhangxe.setText(tboto.getModel().getValueAt(row, 7).toString());
				tfbiensoxe.setText(tboto.getModel().getValueAt(row, 8).toString());
				tfid.setText(tboto.getModel().getValueAt(row, 9).toString());
				tfthang.setText(tboto.getModel().getValueAt(row, 10).toString());

			}
		});
		show1();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
