package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.XuLyTaiLieu;
import models.ChiTietBao_TapChi;
import models.KyXuatBan;
import models.TaiLieu;
import models.ThongTinBao_TapChi;
import models.ThongTinSach;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FHienThiTT extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaBao;
	private JTextField txtNamPHBao;
	private JTextField txtKyXBBao;
	DefaultListModel <ThongTinBao_TapChi> lstModelThongTinBao_TapChi = new DefaultListModel<>();
	DefaultTableModel tblModelSach = new DefaultTableModel();
	ArrayList<ThongTinBao_TapChi> dsTaiLieu = new ArrayList<>();
	ArrayList<ThongTinSach> dsTaiLieuSach = new ArrayList<>();
	
	XuLyTaiLieu xlTaiLieu = new XuLyTaiLieu();
	ThongTinBao_TapChi taiLieuBao;
	ThongTinSach sach;
	ChiTietBao_TapChi chiTietBao;
	ArrayList<ChiTietBao_TapChi> dschiTietBao = new ArrayList<>();
	private JTable tblSach;
	private JTextField txTenSach;
	private JTextField txtMaSach;
	private JTextField txtTinhTrang;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtKhoGiay;
	private JTextField txtGia;
	private JTextField txtCD;
	private JTextField txtSoLuong;
	private JTextField txtSearchBao;
	private JTextField txtSearchSach;
	
	public void loadDSTaiLieuBao(){
		dsTaiLieu = xlTaiLieu.findTaiLieuBao();
		for(ThongTinBao_TapChi ls:dsTaiLieu){
			lstModelThongTinBao_TapChi.addElement(ls);
	
		}
}
	public void loadDSTaiLieuSach(){
	dsTaiLieuSach = xlTaiLieu.findTaiLieuSach();
	for(ThongTinSach ls:dsTaiLieuSach){
		
		Object obj [] = {ls.getMatl(), ls.getMasach(), ls.getTentl()};
		tblModelSach.addRow(obj);
		//lstModelThongTinBao_TapChi.addElement(ls);
	}
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FHienThiTT frame = new FHienThiTT();
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
	public FHienThiTT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u00E1o-T\u1EA1p ch\u00ED", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 21, 241, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 43, 199, 216);
		panel.add(scrollPane);
		
		JList listBaoTapChi = new JList();
		listBaoTapChi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = listBaoTapChi.getSelectedIndex();
				ArrayList<ThongTinBao_TapChi> dsBao = xlTaiLieu.searchBao(txtSearchBao.getText());
				if(index >=0){
					taiLieuBao = dsBao.get(index);
					txtMaBao.setText(taiLieuBao.getMatl());
					txtNamPHBao.setText(Integer.toString(taiLieuBao.getNamph()));
					txtKyXBBao.setText(Integer.toString(taiLieuBao.getKyxb()));
					
				}
			}
		});
		scrollPane.setViewportView(listBaoTapChi);
		listBaoTapChi.setModel(lstModelThongTinBao_TapChi);
		
		txtSearchBao = new JTextField();
		txtSearchBao.setBounds(21, 290, 109, 32);
		panel.add(txtSearchBao);
		txtSearchBao.setColumns(10);
		
		JButton btnSearchBao = new JButton("Tìm");
		btnSearchBao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ThongTinBao_TapChi> dsBao = xlTaiLieu.searchBao(txtSearchBao.getText());
				if(dsBao.size() == 0){
					JOptionPane.showMessageDialog(null, "Không tìm thấy báo/tạp chí bạn cần");
				}
				else{
					lstModelThongTinBao_TapChi.setSize(0);
					for(ThongTinBao_TapChi ls:dsBao){
						lstModelThongTinBao_TapChi.addElement(ls);
				
					}
				}
			}
		});
		btnSearchBao.setBounds(138, 289, 79, 35);
		panel.add(btnSearchBao);
		
		JLabel lblMBotpCh = new JLabel("M\u00E3 b\u00E1o/t\u1EA1p ch\u00ED");
		lblMBotpCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMBotpCh.setBounds(23, 423, 107, 26);
		contentPane.add(lblMBotpCh);
		
		txtMaBao = new JTextField();
		txtMaBao.setEditable(false);
		txtMaBao.setBounds(133, 418, 129, 32);
		contentPane.add(txtMaBao);
		txtMaBao.setColumns(10);
		
		JLabel lblNmPhtHnh = new JLabel("N\u0103m ph\u00E1t h\u00E0nh");
		lblNmPhtHnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmPhtHnh.setBounds(23, 463, 107, 26);
		contentPane.add(lblNmPhtHnh);
		
		txtNamPHBao = new JTextField();
		txtNamPHBao.setEditable(false);
		txtNamPHBao.setColumns(10);
		txtNamPHBao.setBounds(133, 458, 129, 32);
		contentPane.add(txtNamPHBao);
		
		JLabel lblKXutBn = new JLabel("K\u1EF3 xu\u1EA5t b\u1EA3n");
		lblKXutBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKXutBn.setBounds(23, 503, 107, 26);
		contentPane.add(lblKXutBn);
		
		txtKyXBBao = new JTextField();
		txtKyXBBao.setEditable(false);
		txtKyXBBao.setColumns(10);
		txtKyXBBao.setBounds(133, 498, 129, 32);
		contentPane.add(txtKyXBBao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(283, 32, 377, 354);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 37, 335, 203);
		panel_1.add(scrollPane_1);
		
		tblSach = new JTable();
		
		scrollPane_1.setViewportView(tblSach);
		tblModelSach.addColumn("Mã tài liệu");
		tblModelSach.addColumn("Mã sách");
		tblModelSach.addColumn("Tên sách");
		tblSach.setModel(tblModelSach);
		
		txtSearchSach = new JTextField();
		txtSearchSach.setColumns(10);
		txtSearchSach.setBounds(31, 272, 212, 32);
		panel_1.add(txtSearchSach);
		
		JButton btnSearchSach = new JButton("Tìm");
		btnSearchSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ThongTinSach> dsSachTK = xlTaiLieu.search(txtSearchSach.getText());
				
				if(dsSachTK.size() == 0){
					JOptionPane.showMessageDialog(null, "Không tìm thấy sách bạn cần");
				}
				else{
					tblModelSach.setRowCount(0);
					for(ThongTinSach d:dsSachTK){
						Object obj [] = {d.getMatl(), d.getMasach(), d.getTentl()};
						tblModelSach.addRow(obj);
					}
				}
				
				
			}
		});
		btnSearchSach.setBounds(249, 271, 107, 35);
		panel_1.add(btnSearchSach);
		
		tblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<ThongTinSach> dsSachTK = xlTaiLieu.search(txtSearchSach.getText());
				int idTable = tblSach.getSelectedRow();
				if(idTable>=0){
					sach = dsSachTK.get(idTable);
					txtMaSach.setText(sach.getMatl());
					txTenSach.setText(sach.getTentl());
					txtTinhTrang.setText(sach.getTinhtrang());
					txtTacGia.setText(sach.getTentg());
					txtNamXB.setText(Integer.toString(sach.getNamxb()));
					txtNhaXB.setText(sach.getNhaxb());
					txtSoTrang.setText(Integer.toString(sach.getSotrang()));
					txtKhoGiay.setText(sach.getKhogiay());
					txtGia.setText(Integer.toString(sach.getGia()));
					txtCD.setText(sach.getCd());
					txtSoLuong.setText(Integer.toString(sach.getSoluong()));
					
			
				}
			}
		});
		
		JLabel lblMSch = new JLabel("Mã sách");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch.setBounds(283, 418, 65, 26);
		contentPane.add(lblMSch);
		
		JLabel lblTnSch = new JLabel("Tên sách");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSch.setBounds(283, 447, 65, 26);
		contentPane.add(lblTnSch);
		
		JLabel lblTnhTrng = new JLabel("Tình trạng");
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnhTrng.setBounds(283, 476, 79, 26);
		contentPane.add(lblTnhTrng);
		
		JLabel lblTcGi = new JLabel("Tác giả");
		lblTcGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcGi.setBounds(283, 511, 79, 26);
		contentPane.add(lblTcGi);
		
		JLabel lblNmXb = new JLabel("Năm XB");
		lblNmXb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmXb.setBounds(283, 542, 79, 26);
		contentPane.add(lblNmXb);
		
		JLabel lblNhXb = new JLabel("Nhà XB");
		lblNhXb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhXb.setBounds(487, 418, 65, 26);
		contentPane.add(lblNhXb);
		
		JLabel lblSTrang = new JLabel("Số trang");
		lblSTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSTrang.setBounds(487, 447, 65, 26);
		contentPane.add(lblSTrang);
		
		JLabel lblKhGiy = new JLabel("Khổ giấy");
		lblKhGiy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhGiy.setBounds(487, 476, 79, 26);
		contentPane.add(lblKhGiy);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGi.setBounds(487, 511, 79, 26);
		contentPane.add(lblGi);
		
		JLabel lblCd = new JLabel("CD");
		lblCd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCd.setBounds(487, 542, 32, 26);
		contentPane.add(lblCd);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSLng.setBounds(568, 542, 65, 26);
		contentPane.add(lblSLng);
		
		txTenSach = new JTextField();
		txTenSach.setEditable(false);
		txTenSach.setColumns(10);
		txTenSach.setBounds(369, 449, 97, 24);
		contentPane.add(txTenSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setEditable(false);
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(369, 418, 97, 24);
		contentPane.add(txtMaSach);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setEditable(false);
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(369, 478, 97, 24);
		contentPane.add(txtTinhTrang);
		
		txtTacGia = new JTextField();
		txtTacGia.setEditable(false);
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(369, 511, 97, 24);
		contentPane.add(txtTacGia);
		
		txtNamXB = new JTextField();
		txtNamXB.setEditable(false);
		txtNamXB.setColumns(10);
		txtNamXB.setBounds(369, 541, 97, 24);
		contentPane.add(txtNamXB);
		
		txtNhaXB = new JTextField();
		txtNhaXB.setEditable(false);
		txtNhaXB.setColumns(10);
		txtNhaXB.setBounds(546, 418, 97, 24);
		contentPane.add(txtNhaXB);
		
		txtSoTrang = new JTextField();
		txtSoTrang.setEditable(false);
		txtSoTrang.setColumns(10);
		txtSoTrang.setBounds(548, 449, 97, 24);
		contentPane.add(txtSoTrang);
		
		txtKhoGiay = new JTextField();
		txtKhoGiay.setEditable(false);
		txtKhoGiay.setColumns(10);
		txtKhoGiay.setBounds(548, 478, 97, 24);
		contentPane.add(txtKhoGiay);
		
		txtGia = new JTextField();
		txtGia.setEditable(false);
		txtGia.setColumns(10);
		txtGia.setBounds(548, 510, 97, 24);
		contentPane.add(txtGia);
		
		txtCD = new JTextField();
		txtCD.setEditable(false);
		txtCD.setColumns(10);
		txtCD.setBounds(513, 541, 45, 24);
		contentPane.add(txtCD);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(634, 541, 32, 24);
		contentPane.add(txtSoLuong);
		
		loadDSTaiLieuBao();
		loadDSTaiLieuSach();
	}
}
