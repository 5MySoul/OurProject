package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.XuLyTacGia;
import Controller.XuLyTaiLieu;
import models.ChiTietSach;
import models.DanhMucSach;
import models.LoaiTaiLieu;
import models.TacGia;
import models.TaiLieu;
import models.ThongTinBao_TapChi;
import models.ThongTinSach;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class FTSXSach2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSach;
	private JTextField txtMaTG;
	private JTextField txtNamXB;
	private JTextField txtLanXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtKhoGiay;
	private JTextField txtGia;
	private JTextField txtCD;
	private JTextField txtSoLuong;
	private JTable tblChiTietSach;
	
	DefaultTableModel tblModelChiTietSach = new DefaultTableModel();
	DefaultTableModel tblModelTaiLieu = new DefaultTableModel();
	DefaultTableModel tblModelDanhMucSach = new DefaultTableModel();
	DefaultListModel <TacGia> lstModelTacGia = new DefaultListModel<>();
	DefaultListModel <ChiTietSach> lstModelChiTietSach = new DefaultListModel<>();
	ArrayList<ChiTietSach> dsChiTietSach = new ArrayList<>();
	ArrayList<TaiLieu> dsTaiLieuSach = new ArrayList<>();
	ArrayList<TacGia> dsTacGia = new ArrayList<>();
	ChiTietSach chiTietSach;
	DanhMucSach danhMucSach;
	TaiLieu taiLieu;
	LoaiTaiLieu loaiTaiLieu;
	XuLyTaiLieu xlTaiLieu = new XuLyTaiLieu();
	XuLyTacGia xlTacGia = new XuLyTacGia();
	TacGia tacGia;
	int idTable;
	private JTextField txtMaTL;
	private JTextField txtTenTL;
	private JTable tblTaiLieu;
	private JTextField txtMaSachDMS;
	private JTextField txtMaTLDMS;
	private JTextField txtTinhTrangDMS;
	private JTable tblDanhMucSach;
	
	
	public void loadDSTacGia(){
		
		dsTacGia = xlTacGia.findAll();
		for(TacGia ls:dsTacGia){
			lstModelTacGia.addElement(ls);
			//ls.setDauSachs(xlLoaiSach.findDauSachByID(ls.getMaLoai()));
			ls.setChiTietSachs(xlTacGia.findChiTietSachByID(ls.getMaTacGia()));
		}
	}
	
	public void loadDSTaiLieuSach(){
		
		dsTaiLieuSach = xlTaiLieu.findAllTaiLieuSach();
		for(TaiLieu ls:dsTaiLieuSach){
			Object obj [] = {ls.getMaTL(), ls.getTenTL()};
			tblModelTaiLieu.addRow(obj);
		}
	}
	
	public void loadDSMaSach_DMS(){
		
		dsChiTietSach = xlTaiLieu.findAllMaSach();
		for(ChiTietSach ls:dsChiTietSach){
			lstModelChiTietSach.addElement(ls);
			ls.setDanhMucSachs(xlTaiLieu.findAllMaTLByIDMaSach(ls.getMaSach()));
		}
	}
	/*public void loadDSChiTietSach(){
		dsChiTietSach = xlTaiLieu.findAllChiTietSach();
		for(ChiTietSach ls:dsChiTietSach){
			
			Object obj [] = {ls.getMaSach(), ls.getNamXB(), ls.getLanXB(), ls.getNhaXB(), ls.getSoTrang(), ls.getKhoGiay(), ls.getGia(), ls.getCoCD(), ls.getSoLuongSach()};
			tblModelChiTietSach.addRow(obj);
			
		}
	}*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTSXSach2 frame = new FTSXSach2();
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
	public FTSXSach2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 21, 544, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMSch = new JLabel("M\u00E3 s\u00E1ch");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch.setBounds(10, 74, 63, 26);
		panel.add(lblMSch);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(123, 69, 138, 32);
		panel.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblNmXutBn = new JLabel("N\u0103m xu\u1EA5t b\u1EA3n");
		lblNmXutBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmXutBn.setBounds(10, 113, 105, 26);
		panel.add(lblNmXutBn);
		
		txtNamXB = new JTextField();
		txtNamXB.setColumns(10);
		txtNamXB.setBounds(123, 108, 138, 32);
		panel.add(txtNamXB);
		
		JLabel lblLnXutBn = new JLabel("L\u1EA7n xu\u1EA5t b\u1EA3n");
		lblLnXutBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLnXutBn.setBounds(10, 153, 92, 26);
		panel.add(lblLnXutBn);
		
		txtLanXB = new JTextField();
		txtLanXB.setColumns(10);
		txtLanXB.setBounds(123, 148, 138, 32);
		panel.add(txtLanXB);
		
		JLabel lblNhXutBn = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n");
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhXutBn.setBounds(10, 196, 92, 26);
		panel.add(lblNhXutBn);
		
		txtNhaXB = new JTextField();
		txtNhaXB.setColumns(10);
		txtNhaXB.setBounds(123, 191, 138, 32);
		panel.add(txtNhaXB);
		
		JLabel lblSTrang = new JLabel("S\u1ED1 trang");
		lblSTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSTrang.setBounds(10, 236, 81, 26);
		panel.add(lblSTrang);
		
		txtSoTrang = new JTextField();
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(123, 231, 138, 32);
		panel.add(txtSoTrang);
		
		JLabel lblKhGiy = new JLabel("Kh\u1ED5 gi\u1EA5y");
		lblKhGiy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhGiy.setBounds(10, 279, 81, 26);
		panel.add(lblKhGiy);
		
		txtKhoGiay = new JTextField();
		txtKhoGiay.setColumns(10);
		txtKhoGiay.setBounds(123, 274, 138, 32);
		panel.add(txtKhoGiay);
		
		JLabel lblMTcGi_5_1 = new JLabel("Gi\u00E1");
		lblMTcGi_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTcGi_5_1.setBounds(10, 319, 81, 26);
		panel.add(lblMTcGi_5_1);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(123, 314, 138, 32);
		panel.add(txtGia);
		
		JLabel lblMTcGi_5_2 = new JLabel("C\u00F3 CD ?");
		lblMTcGi_5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTcGi_5_2.setBounds(10, 358, 81, 26);
		panel.add(lblMTcGi_5_2);
		
		txtCD = new JTextField();
		txtCD.setColumns(10);
		txtCD.setBounds(123, 353, 138, 32);
		panel.add(txtCD);
		
		JLabel lblMTcGi_5_3 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblMTcGi_5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTcGi_5_3.setBounds(10, 398, 81, 26);
		panel.add(lblMTcGi_5_3);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(123, 393, 138, 32);
		panel.add(txtSoLuong);
		
		JButton btnThemCTS = new JButton("Th\u00EAm");
		btnThemCTS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String masach = txtMaSach.getText();
				
				
				int namxb = Integer.parseInt(txtNamXB.getText());
				int lanxb = Integer.parseInt(txtLanXB.getText());
				String nhaxb = txtNhaXB.getText();
				int sotrang = Integer.parseInt(txtSoTrang.getText());
				String khogiay = txtKhoGiay.getText();
				int gia = Integer.parseInt(txtGia.getText());
				String cd = txtCD.getText();
				int sl = Integer.parseInt(txtSoLuong.getText());
				
				chiTietSach = new ChiTietSach (masach, tacGia, namxb, lanxb, nhaxb, sotrang, khogiay, gia, cd, sl);
				Object obj [] = {masach, namxb, lanxb, nhaxb, sotrang, khogiay, gia, cd, sl};
				tblModelChiTietSach.addRow(obj);
				xlTaiLieu.insert(chiTietSach);
				
				lstModelChiTietSach.setSize(0);
				
				loadDSMaSach_DMS();
			}
		});
		btnThemCTS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemCTS.setBounds(20, 464, 81, 35);
		panel.add(btnThemCTS);
		
		JButton btnSuaCTS = new JButton("S\u1EEDa");
		btnSuaCTS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int namxb = Integer.parseInt(txtNamXB.getText());
				int lanxb = Integer.parseInt(txtLanXB.getText());
				String nhaxb = txtNhaXB.getText();
				int sotrang = Integer.parseInt(txtSoTrang.getText());
				String khogiay = txtKhoGiay.getText();
				int gia = Integer.parseInt(txtGia.getText());
				String cd = txtCD.getText();
				int sl = Integer.parseInt(txtSoLuong.getText());
				
				chiTietSach.setNamXB(namxb);
				chiTietSach.setLanXB(lanxb);
				chiTietSach.setNhaXB(nhaxb);
				chiTietSach.setSoTrang(sotrang);
				chiTietSach.setKhoGiay(khogiay);
				chiTietSach.setGia(gia);
				chiTietSach.setCoCD(cd);
				chiTietSach.setSoLuongSach(sl);
				
				
				tblModelChiTietSach.setValueAt(namxb, idTable, 1);
				tblModelChiTietSach.setValueAt(lanxb, idTable, 2);
				tblModelChiTietSach.setValueAt(nhaxb, idTable, 3);
				tblModelChiTietSach.setValueAt(sotrang, idTable, 4);
				tblModelChiTietSach.setValueAt(khogiay, idTable, 5);
				tblModelChiTietSach.setValueAt(gia, idTable, 6);
				tblModelChiTietSach.setValueAt(cd, idTable, 7);
				tblModelChiTietSach.setValueAt(sl, idTable, 8);
				
				xlTaiLieu.update(chiTietSach);
			}
		});
		btnSuaCTS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaCTS.setBounds(110, 464, 71, 35);
		panel.add(btnSuaCTS);
		
		JButton btnXoaCTS = new JButton("X\u00F3a");
		btnXoaCTS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idTable = tblChiTietSach.getSelectedRow();
				if (idTable >= 0) {
				
					tblModelChiTietSach.removeRow(idTable);
					tacGia.getChiTietSachs().remove(idTable);
					//Xóa trong CSDL
					xlTaiLieu.delete(chiTietSach);
			}
				
			}
				
				
		});
		btnXoaCTS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaCTS.setBounds(190, 464, 71, 35);
		panel.add(btnXoaCTS);
		
		JLabel lblMTcGi = new JLabel("M\u00E3 t\u00E1c gi\u1EA3");
		lblMTcGi.setBounds(10, 36, 81, 26);
		panel.add(lblMTcGi);
		lblMTcGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtMaTG = new JTextField();
		txtMaTG.setBounds(123, 31, 138, 32);
		panel.add(txtMaTG);
		txtMaTG.setEditable(false);
		txtMaTG.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(296, 40, 225, 182);
		panel.add(panel_1);
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 32, 193, 129);
		panel_1.add(scrollPane_1);
		
		JList lstTacGia = new JList();
		lstTacGia.setBorder(null);
		lstTacGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = lstTacGia.getSelectedIndex();
				
				if(index>=0){
					tacGia=dsTacGia.get(index);
					txtMaTG.setText(tacGia.getMaTacGia());
					//txtMaLoai.setText(Integer.toString(loaiSach.getMaLoai()));
					//txtTenLoai.setText(loaiSach.getTenLoai());
					// Hiển thị list sách của theo danh mục sách trên jtable
					//Xóa danh mục hiện có trên jtable
					tblModelChiTietSach.setRowCount(0);
					 if(tacGia.getChiTietSachs()!=null){
						 for(ChiTietSach ls:tacGia.getChiTietSachs()){
							 Object obj [] = {ls.getMaSach(), ls.getNamXB(), ls.getLanXB(), ls.getNhaXB(), ls.getSoTrang(), ls.getKhoGiay(), ls.getGia(), ls.getCoCD(), ls.getSoLuongSach()};
							 tblModelChiTietSach.addRow(obj);
						 }
							 
							 
					 }
					
					
					
					
				}
			}
		});
		scrollPane_1.setViewportView(lstTacGia);
		lstTacGia.setModel(lstModelTacGia);
		
		JLabel lblNewLabel = new JLabel("Tác giả");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 0, 92, 26);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 562, 544, 191);
		contentPane.add(scrollPane);
		
		tblChiTietSach = new JTable();
		tblChiTietSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int idTable = tblChiTietSach.getSelectedRow();
				//chiTietSach = dsChiTietSach.get(idTable);
				chiTietSach = tacGia.getChiTietSachs().get(idTable);
				if(idTable >=0){
					txtMaTG.setText(tacGia.getMaTacGia());
					txtMaSach.setText(chiTietSach.getMaSach());
					//txtMaTG.setText(chiTietSach.getTacGia().getMaTacGia());
					txtNamXB.setText(Integer.toString(chiTietSach.getNamXB()));
					txtLanXB.setText(Integer.toString(chiTietSach.getLanXB()));
					txtNhaXB.setText(chiTietSach.getNhaXB());
					txtSoTrang.setText(Integer.toString(chiTietSach.getSoTrang()));
					txtKhoGiay.setText(chiTietSach.getKhoGiay());
					txtGia.setText(Integer.toString(chiTietSach.getGia()));
					txtCD.setText(chiTietSach.getCoCD());
					txtSoLuong.setText(Integer.toString(chiTietSach.getSoLuongSach()));
				}
			}
		});
		scrollPane.setViewportView(tblChiTietSach);
		tblModelChiTietSach.addColumn("Mã sách");
		//tblModelChiTietSach.addColumn("Mã TG");
		tblModelChiTietSach.addColumn("Năm XB");
		tblModelChiTietSach.addColumn("Lần XB");
		tblModelChiTietSach.addColumn("Nhà XB");
		tblModelChiTietSach.addColumn("Số trang");
		tblModelChiTietSach.addColumn("Khổ giấy");
		tblModelChiTietSach.addColumn("Giá");
		tblModelChiTietSach.addColumn("Có CD ?");
		tblModelChiTietSach.addColumn("Số lượng");
		tblChiTietSach.setModel(tblModelChiTietSach);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E0i li\u1EC7u s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(586, 21, 381, 333);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtMaTL = new JTextField();
		txtMaTL.setBounds(97, 30, 139, 32);
		panel_2.add(txtMaTL);
		txtMaTL.setColumns(10);
		
		JLabel lblMTiLiu = new JLabel("Mã tài liệu");
		lblMTiLiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTiLiu.setBounds(21, 35, 72, 26);
		panel_2.add(lblMTiLiu);
		
		JLabel lblTnTiLiu = new JLabel("Tên tài liệu");
		lblTnTiLiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnTiLiu.setBounds(21, 76, 72, 26);
		panel_2.add(lblTnTiLiu);
		
		txtTenTL = new JTextField();
		txtTenTL.setColumns(10);
		txtTenTL.setBounds(97, 71, 139, 32);
		panel_2.add(txtTenTL);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 123, 360, 199);
		panel_2.add(scrollPane_2);
		
		tblTaiLieu = new JTable();
		tblTaiLieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int idTable = tblTaiLieu.getSelectedRow();
				taiLieu = dsTaiLieuSach.get(idTable);
				if(idTable>=0){
					txtMaTL.setText(taiLieu.getMaTL());
					txtTenTL.setText(taiLieu.getTenTL());
				}
			}
		});
		scrollPane_2.setViewportView(tblTaiLieu);
		tblModelTaiLieu.addColumn("Mã tài liệu");
		tblModelTaiLieu.addColumn("Tên tài liệu");
		tblTaiLieu.setModel(tblModelTaiLieu);
		
		JButton btnThemTL = new JButton("Thêm");
		btnThemTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matl = txtMaTL.getText();
				String tentl = txtTenTL.getText();
				taiLieu = new TaiLieu (matl, tentl, loaiTaiLieu);
				Object obj [] = {matl, tentl};
				tblModelTaiLieu.addRow(obj);
				xlTaiLieu.insertTaiLieu(taiLieu);
			}
		});
		btnThemTL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemTL.setBounds(240, 29, 130, 35);
		panel_2.add(btnThemTL);
		
		JButton btnSuaTL = new JButton("Sửa");
		btnSuaTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTable = tblTaiLieu.getSelectedRow();
				String matl = txtMaTL.getText();
				String tentl = txtTenTL.getText();
				
				taiLieu.setTenTL(tentl);
				tblModelTaiLieu.setValueAt(tentl, idTable, 1);
				xlTaiLieu.updateTaiLieu(taiLieu);
			}
		});
		btnSuaTL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuaTL.setBounds(240, 70, 65, 35);
		panel_2.add(btnSuaTL);
		
		JButton btnXoaTL = new JButton("Xóa");
		btnXoaTL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTable = tblTaiLieu.getSelectedRow();
				if (idTable >= 0) {
				
					tblModelTaiLieu.removeRow(idTable);
					//tacGia.getChiTietSachs().remove(idTable);
					//Xóa trong CSDL
					xlTaiLieu.deleteTaiLieu(taiLieu);
					//tblModelChiTietSach.setRowCount(0);
			}
			}
		});
		btnXoaTL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaTL.setBounds(305, 70, 65, 35);
		panel_2.add(btnXoaTL);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Danh m\u1EE5c s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(586, 375, 381, 378);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(221, 48, 139, 165);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 139, 165);
		panel_4.add(scrollPane_3);
		
		JList lstMaSachDMS = new JList();
		lstMaSachDMS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = lstMaSachDMS.getSelectedIndex();
				
				if(index>=0){
					chiTietSach=dsChiTietSach.get(index);
					txtMaSachDMS.setText(chiTietSach.getMaSach());
					
					
					tblModelDanhMucSach.setRowCount(0);
					 if(chiTietSach.getDanhMucSachs()!=null){
						 for(DanhMucSach ls:chiTietSach.getDanhMucSachs()){
							 Object obj [] = {ls.getMatl(),chiTietSach, ls.getTinhTrang() };
							 tblModelDanhMucSach.addRow(obj);
						 }
							 
							 
					 }
					
					
					
					
				}
				
			}
		});
		scrollPane_3.setViewportView(lstMaSachDMS);
		lstMaSachDMS.setModel(lstModelChiTietSach);
		
		JLabel lblListMSch = new JLabel("List mã sách");
		lblListMSch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListMSch.setBounds(247, 21, 75, 26);
		panel_3.add(lblListMSch);
		
		JLabel lblMSch_1 = new JLabel("Mã sách");
		lblMSch_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch_1.setBounds(10, 48, 66, 26);
		panel_3.add(lblMSch_1);
		
		txtMaSachDMS = new JTextField();
		txtMaSachDMS.setEditable(false);
		txtMaSachDMS.setBounds(89, 48, 111, 32);
		panel_3.add(txtMaSachDMS);
		txtMaSachDMS.setColumns(10);
		
		JLabel lblMSch_1_1 = new JLabel("Mã TL");
		lblMSch_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch_1_1.setBounds(10, 95, 66, 26);
		panel_3.add(lblMSch_1_1);
		
		txtMaTLDMS = new JTextField();
		txtMaTLDMS.setColumns(10);
		txtMaTLDMS.setBounds(89, 95, 111, 32);
		panel_3.add(txtMaTLDMS);
		
		JLabel lblMSch_1_1_1 = new JLabel("Tình trạng");
		lblMSch_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch_1_1_1.setBounds(10, 145, 75, 26);
		panel_3.add(lblMSch_1_1_1);
		
		txtTinhTrangDMS = new JTextField();
		txtTinhTrangDMS.setColumns(10);
		txtTinhTrangDMS.setBounds(89, 145, 111, 32);
		panel_3.add(txtTinhTrangDMS);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 236, 350, 121);
		panel_3.add(scrollPane_4);
		
		tblDanhMucSach = new JTable();
		tblDanhMucSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int idTableDMS = tblDanhMucSach.getSelectedRow();
				//chiTietSach = dsChiTietSach.get(idTable);
				
				danhMucSach = chiTietSach.getDanhMucSachs().get(idTableDMS);
				if(idTableDMS >=0){
					txtMaTLDMS.setText(danhMucSach.getMatl());
					txtTinhTrangDMS.setText(danhMucSach.getTinhTrang());
					
				}
				
			}
		});
		scrollPane_4.setViewportView(tblDanhMucSach);
		tblModelDanhMucSach.addColumn("Mã tài liệu");
		tblModelDanhMucSach.addColumn("Mã sách");
		tblModelDanhMucSach.addColumn("Tình trạng");
		tblDanhMucSach.setModel(tblModelDanhMucSach);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matl = txtMaTLDMS.getText();
				String tinhtrang = txtTinhTrangDMS.getText();
				
				danhMucSach = new DanhMucSach (matl, chiTietSach, tinhtrang);
				Object obj [] = {matl, chiTietSach, tinhtrang};
				tblModelDanhMucSach.addRow(obj);
				xlTaiLieu.insertDanhMucSach(danhMucSach);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 190, 66, 35);
		panel_3.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTableDMS = tblDanhMucSach.getSelectedRow();
				if (idTableDMS >= 0) {
				
					tblModelDanhMucSach.removeRow(idTableDMS);
					chiTietSach.getDanhMucSachs().remove(idTableDMS);
					
					//Xóa trong CSDL
					xlTaiLieu.deleteDanhMucSach(danhMucSach);
			}
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXa.setBounds(79, 190, 63, 35);
		panel_3.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matlx = txtMaTLDMS.getText();
				String tinhtrang = txtTinhTrangDMS.getText();
				
				danhMucSach.setMatl(matlx);
				danhMucSach.setTinhTrang(tinhtrang);
				tblModelDanhMucSach.setValueAt(matlx, idTable, 0);
				tblModelDanhMucSach.setValueAt(tinhtrang, idTable, 2);
				xlTaiLieu.updateDanhMucSach(danhMucSach);
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSa.setBounds(145, 190, 66, 35);
		panel_3.add(btnSa);
		
		
		loadDSTacGia();
		loadDSTaiLieuSach();
		loadDSMaSach_DMS();
	}
}
