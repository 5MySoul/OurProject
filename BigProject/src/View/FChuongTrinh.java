package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FChuongTrinh extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnView;
	private JMenu mnHelp;
	private JMenuItem mntmReportBug;
	private JMenuItem mntmContactUs;
	private JMenuItem mntmManual;
	private JMenuItem mntmSignOut;
	private JMenuItem mntmNew;
	private JMenuItem mntmExit;
	private JMenuItem mntmBooksList;
	private JMenuItem mntmMembers;
	private JMenuItem mntmUsers;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnTimTheoTen;
	private JButton btnTimTheomaSach;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JTable tblDSTimKiem;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JTable tblDSDangChon;
	private JButton btnChon;
	private JButton btnBoChon;
	private JButton btnMuon;
	private JButton btnTra;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JPanel panel_1_1;
	private JList lstDSTLMuon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FChuongTrinh frame = new FChuongTrinh();
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
	public FChuongTrinh() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Qu\u1EA3n l\u00FD th\u01B0 vi\u1EC7n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 466);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTabbedPane());
		contentPane.add(getPanel_3());
		contentPane.add(getBtnChon());
		contentPane.add(getBtnBoChon());
		contentPane.add(getBtnMuon());
		contentPane.add(getBtnTra());
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnView());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNew());
			mnFile.add(getMntmSignOut());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnView() {
		if (mnView == null) {
			mnView = new JMenu("View");
			mnView.add(getMntmBooksList());
			mnView.add(getMntmMembers());
			mnView.add(getMntmUsers());
		}
		return mnView;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmReportBug());
			mnHelp.add(getMntmContactUs());
			mnHelp.add(getMntmManual());
		}
		return mnHelp;
	}
	private JMenuItem getMntmReportBug() {
		if (mntmReportBug == null) {
			mntmReportBug = new JMenuItem("Report bug");
		}
		return mntmReportBug;
	}
	private JMenuItem getMntmContactUs() {
		if (mntmContactUs == null) {
			mntmContactUs = new JMenuItem("Contact Us");
		}
		return mntmContactUs;
	}
	private JMenuItem getMntmManual() {
		if (mntmManual == null) {
			mntmManual = new JMenuItem("Manual");
		}
		return mntmManual;
	}
	private JMenuItem getMntmSignOut() {
		if (mntmSignOut == null) {
			mntmSignOut = new JMenuItem("Sign Out");
		}
		return mntmSignOut;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
		}
		return mntmNew;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}
	private JMenuItem getMntmBooksList() {
		if (mntmBooksList == null) {
			mntmBooksList = new JMenuItem("Books List");
		}
		return mntmBooksList;
	}
	private JMenuItem getMntmMembers() {
		if (mntmMembers == null) {
			mntmMembers = new JMenuItem("Members");
		}
		return mntmMembers;
	}
	private JMenuItem getMntmUsers() {
		if (mntmUsers == null) {
			mntmUsers = new JMenuItem("Users");
		}
		return mntmUsers;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 22, 344, 359);
			tabbedPane.addTab("M\u01AF\u1EE2N", null, getPanel(), null);
			tabbedPane.addTab("TR\u1EA2", null, getPanel_1(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnTimTheoTen());
			panel.add(getBtnTimTheomaSach());
			panel.add(getPanel_2());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
			panel_1.add(getTextField());
			panel_1.add(getPanel_1_1());
		}
		return panel_1;
	}
	private JButton getBtnTimTheoTen() {
		if (btnTimTheoTen == null) {
			btnTimTheoTen = new JButton("T\u00ECm theo t\u00EAn t\u00E0i li\u1EC7u");
			btnTimTheoTen.setBounds(10, 11, 150, 23);
		}
		return btnTimTheoTen;
	}
	private JButton getBtnTimTheomaSach() {
		if (btnTimTheomaSach == null) {
			btnTimTheomaSach = new JButton("T\u00ECm theo m\u00E3 t\u00E0i li\u1EC7u");
			btnTimTheomaSach.setBounds(170, 11, 150, 23);
		}
		return btnTimTheomaSach;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 57, 319, 262);
			panel_2.add(getScrollPane_1());
		}
		return panel_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 21, 299, 232);
			scrollPane_1.setViewportView(getTblDSTimKiem());
		}
		return scrollPane_1;
	}
	private JTable getTblDSTimKiem() {
		if (tblDSTimKiem == null) {
			tblDSTimKiem = new JTable();
		}
		return tblDSTimKiem;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(153, 180, 209)), "Danh s\u00E1ch t\u00E0i li\u1EC7u \u0111ang ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_3.setBounds(463, 28, 397, 359);
			panel_3.add(getScrollPane());
		}
		return panel_3;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 22, 377, 326);
			scrollPane.setViewportView(getTblDSDangChon());
		}
		return scrollPane;
	}
	private JTable getTblDSDangChon() {
		if (tblDSDangChon == null) {
			tblDSDangChon = new JTable();
		}
		return tblDSDangChon;
	}
	private JButton getBtnChon() {
		if (btnChon == null) {
			btnChon = new JButton("Ch\u1ECDn");
			btnChon.setBounds(364, 76, 89, 23);
		}
		return btnChon;
	}
	private JButton getBtnBoChon() {
		if (btnBoChon == null) {
			btnBoChon = new JButton("B\u1ECF ch\u1ECDn");
			btnBoChon.setBounds(364, 128, 89, 23);
		}
		return btnBoChon;
	}
	private JButton getBtnMuon() {
		if (btnMuon == null) {
			btnMuon = new JButton("M\u01B0\u1EE3n");
			btnMuon.setBounds(364, 186, 89, 23);
		}
		return btnMuon;
	}
	private JButton getBtnTra() {
		if (btnTra == null) {
			btnTra = new JButton("Tr\u1EA3");
			btnTra.setBounds(364, 243, 89, 23);
		}
		return btnTra;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("M\u00E3 th\u1EBB:");
			lblNewLabel.setBounds(10, 15, 63, 22);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(83, 11, 249, 30);
		}
		return textField;
	}
	private JPanel getPanel_1_1() {
		if (panel_1_1 == null) {
			panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBorder(new TitledBorder(null, "T\u00E0i li\u1EC7u \u0111ang m\u01B0\u1EE3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1_1.setBounds(10, 70, 322, 281);
			panel_1_1.add(getLstDSTLMuon());
		}
		return panel_1_1;
	}
	private JList getLstDSTLMuon() {
		if (lstDSTLMuon == null) {
			lstDSTLMuon = new JList();
			lstDSTLMuon.setBounds(10, 21, 302, 249);
		}
		return lstDSTLMuon;
	}
}
