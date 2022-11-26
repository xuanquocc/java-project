package View;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainView frame = new MainView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public MainView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 776, 224);
		contentPane.add(panel);
				panel.setLayout(null);

				JButton btoto = new JButton("Đăng kí oto");
			
				btoto.setBounds(56, 75, 197, 41);
				panel.add(btoto);
				btoto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							View frame = new View();
							frame.setVisible(true);
							
						} catch (Exception n) {
							n.printStackTrace();
						}
					}

				});
				btoto.setIcon(
						new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("caricon.png"))));
				btoto.setForeground(new Color(0, 0, 0));
				btoto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
				JButton btthoat = new JButton("Thoát");
				btthoat.setBounds(521, 75, 197, 41);
				btthoat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				
						JButton btxemay = new JButton("Đăng kí xe máy");
						btxemay.setBounds(288, 75, 197, 41);
						panel.add(btxemay);
						btxemay.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									ViewMoto vt = new ViewMoto();
									vt.setVisible(true);
									MainView mv = new MainView();
									mv.dispose();
									
									
								} catch (Exception n) {
									n.printStackTrace();
								}
							}
						});
						btxemay.setIcon(
								new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("motoicon.png"))));
						btxemay.setForeground(Color.BLUE);
						btxemay.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btthoat.setIcon(
						new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("exiticon.png"))));
				panel.add(btthoat);
				btthoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btthoat.setForeground(Color.RED);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}