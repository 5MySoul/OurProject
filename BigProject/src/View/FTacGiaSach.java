package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.XuLyTacGia;
import models.ChiTietSach;
import models.TacGia;

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

public class FTacGiaSach extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTG;
	private JTextField txtTenTG;
	private JTextField txtNamSinh;
	private JTable tblTacgia;
	DefaultTableModel tblModelTacGia = new DefaultTableModel();
	XuLyTacGia xlTacGia = new XuLyTacGia ();
	ArrayList<TacGia> dsTacGia = new ArrayList<>();
	TacGia tacGia;
	
	public void loadDSTacGia(){
		dsTacGia = xlTacGia.findAll();
		for(TacGia tg:dsTacGia){
			Object obj[] = {tg.getMaTacGia(), tg.getTenTacGia(), tg.getNamsinh()};
			tblModelTacGia.addRow(obj);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FTacGiaSach frame = new FTacGiaSach();
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
	public FTacGiaSach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMTcGi = new JLabel("M\u00E3 t\u00E1c gi\u1EA3");
		lblMTcGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTcGi.setBounds(21, 21, 80, 26);
		contentPane.add(lblMTcGi);
		
		JLabel lblTnTcGi = new JLabel("T\u00EAn t\u00E1c gi\u1EA3");
		lblTnTcGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnTcGi.setBounds(21, 57, 80, 26);
		contentPane.add(lblTnTcGi);
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmSinh.setBounds(21, 96, 80, 26);
		contentPane.add(lblNmSinh);
		
		txtMaTG = new JTextField();
		txtMaTG.setBounds(110, 16, 167, 32);
		contentPane.add(txtMaTG);
		txtMaTG.setColumns(10);
		
		txtTenTG = new JTextField();
		txtTenTG.setColumns(10);
		txtTenTG.setBounds(110, 52, 167, 32);
		contentPane.add(txtTenTG);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(110, 91, 167, 32);
		contentPane.add(txtNamSinh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 160, 372, 166);
		contentPane.add(scrollPane);
		
		tblTacgia = new JTable();
		tblTacgia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int idTable = tblTacgia.getSelectedRow();
				if(idTable>=0){
					tacGia = dsTacGia.get(idTable);
					txtMaTG.setText(tacGia.getMaTacGia());
					txtTenTG.setText(tacGia.getTenTacGia());
					txtNamSinh.setText(Integer.toString(tacGia.getNamsinh()));
				}
			}
		});
		scrollPane.setViewportView(tblTacgia);
		tblModelTacGia.addColumn("Mã tác giả");
		tblModelTacGia.addColumn("Tên tác giả");
		tblModelTacGia.addColumn("Năm sinh");
		tblTacgia.setModel(tblModelTacGia);
		
		JButton btnThemTG = new JButton("Th\u00EAm");
		btnThemTG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matg = txtMaTG.getText();
				String tentg = txtTenTG.getText();
				int namsinh = Integer.parseInt(txtNamSinh.getText());
				tacGia = new TacGia (matg, tentg, namsinh);
				Object obj [] = {matg, tentg, namsinh};
				tblModelTacGia.addRow(obj);
				xlTacGia.insertTacGia(tacGia);
				
			}
		});
		btnThemTG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemTG.setBounds(303, 15, 102, 35);
		contentPane.add(btnThemTG);
		
		JButton btnSuaTG = new JButton("S\u1EEDa");
		btnSuaTG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTable = tblTacgia.getSelectedRow();
				String tentg = txtTenTG.getText();
				int namsinh = Integer.parseInt(txtNamSinh.getText());
				
				tacGia.setTenTacGia(tentg);
				tacGia.setNamsinh(namsinh);
				tblModelTacGia.setValueAt(tentg, idTable, 1);
				tblModelTacGia.setValueAt(namsinh, idTable, 2);
				xlTacGia.updateTacGia(tacGia);
				
			}
		});
		btnSuaTG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuaTG.setBounds(303, 61, 102, 35);
		contentPane.add(btnSuaTG);
		
		JButton btnXoaTG = new JButton("X\u00F3a");
		btnXoaTG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTable = tblTacgia.getSelectedRow();
				if (idTable >= 0) {
					tblModelTacGia.removeRow(idTable);
					xlTacGia.deleteTacGia(tacGia);
					
			}
			}
		});
		btnXoaTG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaTG.setBounds(303, 104, 102, 35);
		contentPane.add(btnXoaTG);
		loadDSTacGia();
	}
}
