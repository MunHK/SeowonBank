import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositGUI extends JFrame {
	private JTextField moneytextField;
	LoginGUI login = new LoginGUI();
	Database db = new Database();
	public String baccount;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositGUI window = new DepositGUI(account);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DepositGUI(String account) {
		baccount=account;
		setTitle("입금");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(850, 400, 280, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 264, 111);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("취소하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserGUI admin = new UserGUI(baccount);
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 76, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("입금하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit();
			}
		});
		btnNewButton_1.setBounds(136, 76, 116, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("금액");
		lblNewLabel_1.setBounds(33, 43, 30, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("계좌로 입금할 금액을 숫자만 입력하시오");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel.setBounds(12, 18, 240, 15);
		panel.add(lblNewLabel);
		
		moneytextField = new JTextField();
		moneytextField.setBounds(92, 43, 160, 23);
		panel.add(moneytextField);
		moneytextField.setColumns(10);
	}
	public void Deposit() {
		String uaccount=baccount;
		String umoney = moneytextField.getText();
		//String upassword = passwordtextField.getText();

		if(umoney.equals("")) {
			JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "입금 실패", JOptionPane.ERROR_MESSAGE);
			System.out.println("입금 실패 > 금액 미입력");
		}
		
		else if(!umoney.equals("")) {
			if(db.DepositCheck(umoney,uaccount)) {
				System.out.println("입금 성공");
				JOptionPane.showMessageDialog(null, umoney+"원이 입금되었습니다.");
			} else {
				System.out.println("입금 실패");
				JOptionPane.showMessageDialog(null, "입금 실패");
			}
		}
	}
}
