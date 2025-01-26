import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPassword extends JFrame {

	private JTextField accounttextField;
	private JTextField passwordtextField;
	private JTextField newpasswordtextField;
	Database db = new Database();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPassword window = new EditPassword();
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
	public EditPassword() {
		setTitle("비밀번호 변경");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(850, 300, 280, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 180);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("계좌번호");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(12, 48, 57, 15);
		panel.add(lblNewLabel_1_2_1);
		
		accounttextField = new JTextField();
		accounttextField.setColumns(10);
		accounttextField.setBounds(112, 45, 140, 21);
		panel.add(accounttextField);
		
		JLabel lblNewLabel_1_2 = new JLabel("기존 비밀번호");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(12, 83, 76, 15);
		panel.add(lblNewLabel_1_2);
		
		passwordtextField = new JTextField();
		passwordtextField.setColumns(10);
		passwordtextField.setBounds(112, 80, 140, 21);
		panel.add(passwordtextField);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("새로운 비밀번호");
		lblNewLabel_1_2_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(12, 118, 89, 15);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel = new JLabel("비밀번호 변경하기");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(75, 11, 117, 24);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("뒤로");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGUI admin = new AdminGUI();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 149, 66, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("비밀번호 변경");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit();
			}
		});
		btnNewButton_1.setBounds(122, 149, 130, 25);
		panel.add(btnNewButton_1);
		
		newpasswordtextField = new JTextField();
		newpasswordtextField.setColumns(10);
		newpasswordtextField.setBounds(112, 115, 140, 21);
		panel.add(newpasswordtextField);
	}

	public void Edit() {
		String uaccount = accounttextField.getText();
		String upassword = passwordtextField.getText();
		String unewpassword = newpasswordtextField.getText();

		if(uaccount.equals("") || upassword.equals("")|| unewpassword.equals("")) {
			JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "비밀번호 변경 실패", JOptionPane.ERROR_MESSAGE);
			System.out.println("회원가입 실패 > 회원정보 미입력");
		}
		
		else if(!uaccount.equals("") && !upassword.equals("")&& !unewpassword.equals("")) {
			if(db.EditCheck(uaccount,upassword,unewpassword)) {
				System.out.println("비밀번호 변경 성공");
				JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
			} else {
				System.out.println("비밀번호 변경 실패");
				JOptionPane.showMessageDialog(null, "비밀번호 변경 실패");
			}
		}

	}
}
