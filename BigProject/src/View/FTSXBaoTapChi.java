package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.XuLyTaiLieu;
import models.ChiTietBao_TapChi;
import models.LoaiTaiLieu;
import models.TaiLieu;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FTSXBaoTapChi extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTL;
	private JTextField txtTenTL;
	private JTable tblTaiLieuBao;
	DefaultTableModel tblModelTaiLieuBao = new DefaultTableModel();
	DefaultTableModel tblModelChiTietBao = new DefaultTableModel();
	ArrayList<TaiLieu> dsTaiLieuBao = new ArrayList<>();
	ArrayList<ChiTietBao_TapChi> dsChiTietBao = new ArrayList<>();
	XuLyTaiLieu xlTaiLieu = new XuLyTaiLieu();
	TaiLieu taiLieu;
	ChiTietBao_TapChi chiTietBao;
	LoaiTaiLieu loaiTaiLieu;
	int idTable;
	private JTextField txtMaTL_ChiTiet;
	private JTextField txtNamPH;
	private JTextField txtKyXB;
	private JTable tblChiTietBao;
	
	public void loadDSTaiLieuBao(){
		dsTaiLieuBao = xlTaiLieu.findAllTaiLieuBao();
		for(TaiLieu ls:dsTaiLieuBao){
			Object obj[]={ls.getMaTL(), ls.getTenTL()};
			tblModelTaiLieuBao.addRow(obj);
		}
	}
	
	public void loadDSChiTietBao(){
		dsChiTietBao = xlTaiLieu.findAllChiTietBao();
		for(ChiTietBao_TapChi ls:dsChiTietBao){
			Object obj[]={ls.getMatl(), ls.getNamPhatHanh(), ls.getKyxb()};
			tblModelChiTietBao.addRow(obj);
		}
	}

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTSXBaoTapChi frame = new FTSXBaoTapChi();
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
	public FTSXBaoTapChi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00E0i li\u1EC7u b\u00E1o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 21, 368, 509);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMTiLiu = new JLabel("M\u00E3 t\u00E0i li\u1EC7u");
		lblMTiLiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTiLiu.setBounds(10, 51, 73, 26);
		panel.add(lblMTiLiu);
		
		txtMaTL = new JTextField();
		txtMaTL.setBounds(92, 45, 186, 32);
		panel.add(txtMaTL);
		txtMaTL.setColumns(10);
		
		JLabel lblTnTiLiu = new JLabel("T\u00EAn t\u00E0i li\u1EC7u");
		lblTnTiLiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnTiLiu.setBounds(10, 97, 73, 26);
		panel.add(lblTnTiLiu);
		
		txtTenTL = new JTextField();
		txtTenTL.setColumns(10);
		txtTenTL.setBounds(92, 91, 186, 32);
		panel.add(txtTenTL);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 347, 302);
		panel.add(scrollPane);
		
		tblTaiLieuBao = new JTable();
		tblTaiLieuBao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int idTable = tblTaiLieuBao.getSelectedRow();
				if(idTable>=0){
					taiLieu = dsTaiLieuBao.get(idTable);
					txtMaTL.setText(taiLieu.getMaTL());
					txtTenTL.setText(taiLieu.getTenTL());
				}
			}
		});
		scrollPane.setViewportView(tblTaiLieuBao);
		tblModelTaiLieuBao.addColumn("Mã tài liệu");
		tblModelTaiLieuBao.addColumn("Tên tài liệu");
		tblTaiLieuBao.setModel(tblModelTaiLieuBao);
		
		
		JButton btnThemTL = new JButton("Th\u00EAm");
		btnThemTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matl = txtMaTL.getText();
				String tentl = txtTenTL.getText();
				taiLieu = new TaiLieu (matl, tentl, loaiTaiLieu);
				Object obj [] = {matl, tentl};
				tblModelTaiLieuBao.addRow(obj);
				xlTaiLieu.insertTaiLieuBao(taiLieu);
				
				tblModelTaiLieuBao.setRowCount(0);
				loadDSTaiLieuBao();
			}
		});
		btnThemTL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemTL.setBounds(10, 133, 97, 35);
		panel.add(btnThemTL);
		
		JButton btnSuaTL = new JButton("S\u1EEDa");
		btnSuaTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTable = tblTaiLieuBao.getSelectedRow();
				String matl = txtMaTL.getText();
				String tentl = txtTenTL.getText();
				
				taiLieu.setTenTL(tentl);
				tblModelTaiLieuBao.setValueAt(tentl, idTable, 1);
				xlTaiLieu.updateTaiLieuBao(taiLieu);
			}
		});
		btnSuaTL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaTL.setBounds(115, 131, 97, 35);
		panel.add(btnSuaTL);
		
		JButton btnXoaTL = new JButton("X\u00F3a");
		btnXoaTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idTable = tblTaiLieuBao.getSelectedRow();
				if (idTable >= 0) {
				
					tblModelTaiLieuBao.removeRow(idTable);
					
					xlTaiLieu.deleteTaiLieuBao(taiLieu);
					tblModelChiTietBao.setRowCount(0);
					loadDSChiTietBao();
			}
			}
		});
		btnXoaTL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTL.setBounds(218, 131, 97, 35);
		panel.add(btnXoaTL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt B\u00E1o - T\u1EA1p ch\u00ED", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(410, 34, 341, 496);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMTiLiu_1 = new JLabel("Mã tài liệu");
		lblMTiLiu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTiLiu_1.setBounds(21, 37, 73, 26);
		panel_1.add(lblMTiLiu_1);
		
		txtMaTL_ChiTiet = new JTextField();
		txtMaTL_ChiTiet.setColumns(10);
		txtMaTL_ChiTiet.setBounds(140, 31, 180, 32);
		panel_1.add(txtMaTL_ChiTiet);
		
		txtNamPH = new JTextField();
		txtNamPH.setColumns(10);
		txtNamPH.setBounds(140, 73, 180, 32);
		panel_1.add(txtNamPH);
		
		JLabel lblMTiLiu_1_1 = new JLabel("Năm phát hành");
		lblMTiLiu_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTiLiu_1_1.setBounds(21, 79, 114, 26);
		panel_1.add(lblMTiLiu_1_1);
		
		txtKyXB = new JTextField();
		txtKyXB.setColumns(10);
		txtKyXB.setBounds(140, 115, 180, 32);
		panel_1.add(txtKyXB);
		
		JLabel lblMTiLiu_1_2 = new JLabel("Kỳ xuất bản");
		lblMTiLiu_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTiLiu_1_2.setBounds(21, 121, 102, 26);
		panel_1.add(lblMTiLiu_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 240, 309, 235);
		panel_1.add(scrollPane_1);
		
		tblChiTietBao = new JTable();
		tblChiTietBao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int idTable = tblChiTietBao.getSelectedRow();
				if(idTable>=0){
					chiTietBao = dsChiTietBao.get(idTable);
					txtMaTL_ChiTiet.setText(chiTietBao.getMatl());
					txtNamPH.setText(Integer.toString(chiTietBao.getNamPhatHanh()));
					txtKyXB.setText(Integer.toString(chiTietBao.getKyxb()));
				}
				
			}
		});
		scrollPane_1.setViewportView(tblChiTietBao);
		tblModelChiTietBao.addColumn("Mã tài liệu");
		tblModelChiTietBao.addColumn("Năm phát hành");
		tblModelChiTietBao.addColumn("Kỳ xuất bản");
		tblChiTietBao.setModel(tblModelChiTietBao);
		
		JButton btnThemCT = new JButton("Thêm");
		btnThemCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String matl = txtMaTL_ChiTiet.getText();
				int namph = Integer.parseInt(txtNamPH.getText());
				int kyxb = Integer.parseInt(txtKyXB.getText());
				chiTietBao = new ChiTietBao_TapChi(matl, namph, kyxb);
				Object obj [] = {matl, namph, kyxb};
				tblModelChiTietBao.addRow(obj);
				xlTaiLieu.insertChiTietBao(chiTietBao);
				
			}
		});
		btnThemCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemCT.setBounds(21, 184, 97, 35);
		panel_1.add(btnThemCT);
		
		JButton btnSuaCT = new JButton("Sửa");
		btnSuaCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTable = tblChiTietBao.getSelectedRow();
				int namph = Integer.parseInt(txtNamPH.getText());
				int kyxb = Integer.parseInt(txtKyXB.getText());
				
				chiTietBao.setNamPhatHanh(namph);
				chiTietBao.setKyxb(kyxb);
				tblModelChiTietBao.setValueAt(namph, idTable, 1);
				tblModelChiTietBao.setValueAt(kyxb, idTable, 2);
				
				xlTaiLieu.updateChiTietBao(chiTietBao);
			}
		});
		btnSuaCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaCT.setBounds(127, 184, 97, 35);
		panel_1.add(btnSuaCT);
		
		JButton btnXoaCT = new JButton("Xóa");
		btnXoaCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTable = tblChiTietBao.getSelectedRow();
				if (idTable >= 0) {
				
					tblModelChiTietBao.removeRow(idTable);
					
					xlTaiLieu.deleteChiTietBao(chiTietBao);
					
				}
			}
		});
		btnXoaCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaCT.setBounds(233, 184, 97, 35);
		panel_1.add(btnXoaCT);
		loadDSTaiLieuBao();
		loadDSChiTietBao();
	}
}
