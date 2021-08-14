package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.XuLyMuonTra;
import Controller.XuLyTaiLieu;
import models.MuonTra;
import models.TaiLieu;
import models.V_MuonTra;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FChuongTrinh extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmReportBug;
	private JMenuItem mntmContactUs;
	private JMenuItem mntmManual;
	private JMenuItem mntmSignOut;
	private JMenuItem mntmNew;
	private JMenuItem mntmExit;
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
	private JTextField txtMaThe;
	private JPanel panel_1_1;

	// Khai báo model, arraylist
	DefaultTableModel tblModelDSTimKiem = new DefaultTableModel();
	DefaultTableModel tblModelDSDangChon = new DefaultTableModel();
	DefaultTableModel tblModelTLMuon = new DefaultTableModel();
	ArrayList<TaiLieu> dsTL = new ArrayList<>();
	ArrayList<TaiLieu> dsTLTamThoi = new ArrayList<>();
	ArrayList<V_MuonTra> dsMuon = new ArrayList<V_MuonTra>();
	// Khai báo biến
	TaiLieu tl;
	TaiLieu temp = new TaiLieu();
	int[] id_1, id_2;

	// Khai báo controllers
	XuLyTaiLieu xlTL = new XuLyTaiLieu();
	XuLyMuonTra xlMT = new XuLyMuonTra();
	private JTextField txtTimkiem;
	private JScrollPane scrollPane_2;
	private JTable tblTLDangMuon;
	private JMenu mnView;
	private JMenuItem mntmStorage;

	// khai báo phương thức
	void loadDSTL() {
		dsTL = xlTL.findAll();
		for (TaiLieu doc : dsTL) {
			Object obj[] = { doc.getMaTL(), doc.getTenTL() };
			tblModelDSTimKiem.addRow(obj);
		}
	}

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

		loadDSTL();
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
			mntmManual = new JMenuItem("About Us");
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
			mntmNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FChuongTrinh ct = new FChuongTrinh();
					ct.show();
					setVisible(false);
					dispose();
				}
			});
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
			panel.add(getTxtTimkiem());
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
			panel_1.add(getTxtMaThe());
			panel_1.add(getPanel_1_1());
		}
		return panel_1;
	}

	private JButton getBtnTimTheoTen() {
		if (btnTimTheoTen == null) {
			btnTimTheoTen = new JButton("T\u00ECm theo t\u00EAn t\u00E0i li\u1EC7u");
			btnTimTheoTen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String chuoitk = txtTimkiem.getText();
					dsTL = xlTL.findTaiLieuByTENTL(chuoitk);
					tblModelDSTimKiem.setRowCount(0);
					for (TaiLieu doc : dsTL) {
						Object obj[] = { doc.getMaTL(), doc.getTenTL() };
						tblModelDSTimKiem.addRow(obj);
					}
				}
			});
			btnTimTheoTen.setBounds(10, 45, 150, 23);
		}
		return btnTimTheoTen;
	}

	private JButton getBtnTimTheomaSach() {
		if (btnTimTheomaSach == null) {
			btnTimTheomaSach = new JButton("T\u00ECm theo m\u00E3 t\u00E0i li\u1EC7u");
			btnTimTheomaSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String chuoitk = txtTimkiem.getText();
					dsTL = xlTL.findTaiLieuByMATL(chuoitk);
					tblModelDSTimKiem.setRowCount(0);
					for (TaiLieu doc : dsTL) {
						Object obj[] = { doc.getMaTL(), doc.getTenTL() };
						tblModelDSTimKiem.addRow(obj);
					}
				}
			});
			btnTimTheomaSach.setBounds(179, 45, 150, 23);
		}
		return btnTimTheomaSach;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 t\u00ECm ki\u1EBFm", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 79, 319, 240);
			panel_2.add(getScrollPane_1());
		}
		return panel_2;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 21, 299, 208);
			scrollPane_1.setViewportView(getTblDSTimKiem());
		}
		return scrollPane_1;
	}

	private JTable getTblDSTimKiem() {
		if (tblDSTimKiem == null) {
			tblDSTimKiem = new JTable();
			tblDSTimKiem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					id_1 = tblDSTimKiem.getSelectedRows();

				}
			});
			tblModelDSTimKiem.addColumn("Mã TL");
			tblModelDSTimKiem.addColumn("Tên TL");
			tblDSTimKiem.setModel(tblModelDSTimKiem);
		}
		return tblDSTimKiem;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(153, 180, 209)),
					"Danh s\u00E1ch t\u00E0i li\u1EC7u \u0111ang ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP,
					null, new Color(0, 0, 0)));
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
			tblDSDangChon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					id_2 = tblDSDangChon.getSelectedRows();
				}
			});
			tblModelDSDangChon.addColumn("Mã TL");
			tblModelDSDangChon.addColumn("Tên TL");
			tblDSDangChon.setModel(tblModelDSDangChon);
		}
		return tblDSDangChon;
	}

	private JButton getBtnChon() {
		if (btnChon == null) {
			btnChon = new JButton("Ch\u1ECDn");
			btnChon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int selectedIndex = tabbedPane.getSelectedIndex();
					if (selectedIndex == 0) {
						for (int i = 0; i < id_1.length; i++) {
							temp = dsTL.get(id_1[i]);
							Object obj[] = { temp.getMaTL(), temp.getTenTL() };
							tblModelDSDangChon.addRow(obj);
							dsTLTamThoi.add(temp);
						}
					} else {
						for (int i = 0; i < id_1.length; i++) {
							V_MuonTra vm = new V_MuonTra();
							vm = dsMuon.get(id_1[i]);
							Object obj[] = { vm.getMatailieu(), vm.getTenTL() };
							tblModelDSDangChon.addRow(obj);
							dsTLTamThoi.add(temp);
						}
					}
				}
			});
			btnChon.setBounds(364, 76, 89, 23);
		}
		return btnChon;
	}

	private JButton getBtnBoChon() {
		if (btnBoChon == null) {
			btnBoChon = new JButton("B\u1ECF ch\u1ECDn");
			btnBoChon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					for (int i = id_2.length - 1; i >= 0; i--) {
						dsTLTamThoi.remove(id_2[i]);
						tblModelDSDangChon.removeRow(id_2[i]);
					}
				}
			});
			btnBoChon.setBounds(364, 128, 89, 23);
		}
		return btnBoChon;
	}

	private JButton getBtnMuon() {
		if (btnMuon == null) {
			btnMuon = new JButton("M\u01B0\u1EE3n");
			btnMuon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedIndex = tabbedPane.getSelectedIndex();
					if (selectedIndex != 0) {
						JOptionPane.showMessageDialog(rootPane, "Bạn đang thao tác với chức năng trả");
					} else {
						 Calendar c1 = Calendar.getInstance();
					     Calendar c2 = Calendar.getInstance();
						String m = JOptionPane.showInputDialog("Show me your ID");

				        c1.setTime(new Date());
				        c2.setTime(new Date());
				        c2.add(Calendar.MONTH, 2); 
						for (int j = 0; j < id_2.length; j++) {
							tl = dsTLTamThoi.get(id_2[j]);
							MuonTra mt = new MuonTra(m, tl, 1, c1.getTime(), c2.getTime());
							xlMT.insert(mt);
						}
					}
				}
			});
			btnMuon.setBounds(364, 186, 89, 23);
		}
		return btnMuon;
	}

	private JButton getBtnTra() {
		if (btnTra == null) {
			btnTra = new JButton("Tr\u1EA3");
			btnTra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int selectedIndex = tabbedPane.getSelectedIndex();
					if (selectedIndex != 1) {
						JOptionPane.showMessageDialog(rootPane, "Bạn đang thao tác với chức năng mượn");
					} else {
						for (int i = 0; i < id_2.length; i++) {
							temp = dsTL.get(id_2[i]);
							tblModelDSDangChon.removeRow(id_2[i]);
							dsTLTamThoi.remove(temp);
							xlMT.delete(temp.getMaTL());
						}
					}

				}
			});
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

	private JTextField getTxtMaThe() {
		if (txtMaThe == null) {
			txtMaThe = new JTextField();
			txtMaThe.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						tblModelTLMuon.setRowCount(0);
						dsMuon = xlMT.findByMaThe(txtMaThe.getText());
						for (V_MuonTra v : dsMuon) {
							Object obj[] = {v.getTenTL(), v.getNgayMuon(), v.getNgayTra()};
							tblModelTLMuon.addRow(obj);
						}
					}
				}
			});
			txtMaThe.setColumns(10);
			txtMaThe.setBounds(83, 11, 249, 30);
		}
		return txtMaThe;
	}

	private JPanel getPanel_1_1() {
		if (panel_1_1 == null) {
			panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBorder(new TitledBorder(null, "T\u00E0i li\u1EC7u \u0111ang m\u01B0\u1EE3n",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1_1.setBounds(10, 70, 322, 281);
			panel_1_1.add(getScrollPane_2());
		}
		return panel_1_1;
	}

	private JTextField getTxtTimkiem() {
		if (txtTimkiem == null) {
			txtTimkiem = new JTextField();
			txtTimkiem.setBounds(20, 11, 300, 23);
			txtTimkiem.setColumns(10);
		}
		return txtTimkiem;
	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(10, 22, 302, 231);
			scrollPane_2.setViewportView(getTblTLDangMuon());
		}
		return scrollPane_2;
	}

	private JTable getTblTLDangMuon() {
		if (tblTLDangMuon == null) {
			tblTLDangMuon = new JTable();
			tblTLDangMuon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					id_2 = tblTLDangMuon.getSelectedRows();
				}
			});
			tblModelTLMuon.addColumn("Tên TL");
			tblModelTLMuon.addColumn("Ngày mượn");
			tblTLDangMuon.setModel(tblModelTLMuon);
		}
		return tblTLDangMuon;
	}
	private JMenu getMnView() {
		if (mnView == null) {
			mnView = new JMenu("View");
			mnView.add(getMntmStorage());
		}
		return mnView;
	}
	private JMenuItem getMntmStorage() {
		if (mntmStorage == null) {
			mntmStorage = new JMenuItem("Storage");
			mntmStorage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		}
		return mntmStorage;
	}
}
