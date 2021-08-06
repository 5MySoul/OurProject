package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControlAuthentication;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FLogin extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUserName;
	private JPasswordField pPWord;
	private JButton btnSignIn;
	private JCheckBox chckbxRememberMe;
	
	ControlAuthentication ctrlAuthen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FLogin frame = new FLogin();
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
	public FLogin() {
		setBackground(SystemColor.textHighlight);
		setFont(new Font("Arial Black", Font.BOLD, 13));
		setForeground(UIManager.getColor("CheckBox.light"));
		setResizable(false);
		setTitle("Welcome to our Login System!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(10, 11, 339, 188);
			panel.setLayout(null);
			panel.add(getLblUsername());
			panel.add(getLblPassword());
			panel.add(getTxtUserName());
			panel.add(getPPWord());
			panel.add(getBtnSignIn());
			panel.add(getChckbxRememberMe());
		}
		return panel;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setBounds(10, 38, 79, 14);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(10, 77, 79, 14);
		}
		return lblPassword;
	}
	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setBounds(99, 32, 215, 26);
			txtUserName.setColumns(10);
		}
		return txtUserName;
	}
	private JPasswordField getPPWord() {
		if (pPWord == null) {
			pPWord = new JPasswordField();
			pPWord.setEchoChar('*');
			pPWord.setBounds(99, 71, 215, 26);
		}
		return pPWord;
	}
	private JButton getBtnSignIn() {
		if (btnSignIn == null) {
			btnSignIn = new JButton("Sign In");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String u = txtUserName.getText();
					String pw = pPWord.getText();
					if (u.isEmpty()){
						JOptionPane.showMessageDialog(null, "Please enter your usename and try again!");
						return;
					}
					if (pw.isEmpty()){
						JOptionPane.showMessageDialog(null, "Please enter your password and try again!");
						return;
					}
					boolean kq = ctrlAuthen.checkAccount(u, pw);
					if (kq == true){
						JOptionPane.showMessageDialog(null, "Login successfully!");
						FLogin login = new FLogin();
						login.dispose();
						FMain mFrame = new FMain();
					}
				}
			});
			btnSignIn.setBounds(121, 142, 89, 23);
		}
		return btnSignIn;
	}
	private JCheckBox getChckbxRememberMe() {
		if (chckbxRememberMe == null) {
			chckbxRememberMe = new JCheckBox("Remember me");
			chckbxRememberMe.setToolTipText("Remember your id for your next login section");
			chckbxRememberMe.setSelected(true);
			chckbxRememberMe.setBounds(99, 104, 129, 23);
		}
		return chckbxRememberMe;
	}
}
