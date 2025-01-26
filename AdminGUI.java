import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI();
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
	public AdminGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("관리자");
		setBounds(850, 300, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("계좌 생성");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount create = new CreateAccount();
				create.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 62, 120, 60);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("계좌 삭제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAccount delete = new DeleteAccount();
				delete.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 149, 120, 60);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("비밀번호 변경");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPassword edit = new EditPassword();
				edit.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(152, 149, 120, 60);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("뒤로");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(12, 10, 64, 28);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("계좌 조회");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInfo info = new CustomerInfo();
				info.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(152, 62, 120, 60);
		panel.add(btnNewButton_2_1);
	}
}
