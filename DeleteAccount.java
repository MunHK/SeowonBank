import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteAccount extends JFrame {

	private JTextField nametextField;
	private JTextField AccounttextField;
	Database db = new Database();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount window = new DeleteAccount();
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
	public DeleteAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("계좌 삭제");
		setBounds(850, 400, 280, 175);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 135);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("삭제 할 성명과 계좌번호 입력");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 10, 202, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("이름");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(12, 38, 24, 15);
		panel.add(lblNewLabel_1_2);
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(80, 35, 172, 21);
		panel.add(nametextField);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("계좌번호");
		lblNewLabel_1_2_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(12, 73, 48, 15);
		panel.add(lblNewLabel_1_2_2);
		
		JButton btnNewButton = new JButton("뒤로");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGUI admin = new AdminGUI();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 101, 66, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("계좌 삭제하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		btnNewButton_1.setBounds(122, 101, 130, 27);
		panel.add(btnNewButton_1);
		
		AccounttextField = new JTextField();
		AccounttextField.setColumns(10);
		AccounttextField.setBounds(80, 70, 172, 21);
		panel.add(AccounttextField);
	}
	
	public void Delete() {
		String uname = nametextField.getText();
		String uaccount = AccounttextField.getText();

		if(uname.equals("") || uaccount.equals("")) {
			JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "계좌삭제 실패", JOptionPane.ERROR_MESSAGE);
			System.out.println("회원가입 실패 > 회원정보 미입력");
		}
		
		else if(!uname.equals("") && !uaccount.equals("")) {
			if(db.DeleteCheck(uname,uaccount)) {
				System.out.println("계좌삭제 성공");
				JOptionPane.showMessageDialog(null, uname+"님의 계좌가 삭제되었습니다.");
				
			} else {
				System.out.println("계좌삭제 실패");
				JOptionPane.showMessageDialog(null, "계좌삭제 실패");
			}
		}

	}
}
