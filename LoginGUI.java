import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {
	Database db = new Database();
	AdminGUI admin;
	public JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("서원은행");
		setBounds(850, 400, 280, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 111);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		btnNewButton.setBounds(12, 76, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("비밀번호 찾기");
		btnNewButton_1.setBounds(136, 76, 116, 25);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(92, 10, 160, 23);
		panel.add(textField);
		
		JLabel lblNewLabel = new JLabel("계좌번호");
		lblNewLabel.setBounds(12, 10, 57, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(12, 43, 57, 23);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 43, 160, 23);
		panel.add(passwordField);
	}
	
	public void Login() {
		String uid = textField.getText();
		
		String upass = "";
		for(int i=0; i<passwordField.getPassword().length; i++) {
			upass = upass + passwordField.getPassword()[i];
		}
		
		if(uid.equals("")||upass.equals("")) {
			JOptionPane.showMessageDialog(null,"아이디와 비밀번호 모두 입력해주세요","로그인 실패",JOptionPane.ERROR_MESSAGE);
			System.out.println("로그인 실패 > 로그인 정보 미입력");
		}
		else if(uid.equals("admin1234")&&upass.equals("1234")) {
			System.out.println("관리자 로그인 성공");
			JOptionPane.showMessageDialog(null, "관리자 로그인 성공");
			AdminGUI admin = new AdminGUI();
			admin.setVisible(true);
			dispose();
		}
		else if(uid!=null&&upass!=null) {
			if(db.LoginCheck(uid,upass)) {
				System.out.println("로그인 성공");
				JOptionPane.showMessageDialog(null, "로그인 성공");
				UserGUI admin = new UserGUI(uid);
				admin.setVisible(true);
				dispose();
			}else {
				System.out.println("로그인 실패 > 로그인 정보 불일치");
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		}
	}
}
