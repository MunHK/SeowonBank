import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WithdrawGUI extends JFrame{

	private JTextField moneytextField;
	public String baccount;
	public String bmoney;
	Database db = new Database();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawGUI window = new WithdrawGUI();
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
	public WithdrawGUI(String account) {
		baccount = account;
		bmoney = db.BringMoney(baccount);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("출금");
		setBounds(850, 400, 280, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 264, 130);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("취소하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserGUI admin = new UserGUI(baccount);
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 95, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("출금하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw();
			}
		});
		btnNewButton_1.setBounds(136, 95, 116, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("출금액");
		lblNewLabel_1.setBounds(27, 62, 36, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("계좌에서 출금할 금액을 숫자만 입력하시오");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel.setBounds(8, 10, 252, 15);
		panel.add(lblNewLabel);
		
		moneytextField = new JTextField();
		moneytextField.setColumns(10);
		moneytextField.setBounds(92, 62, 160, 23);
		panel.add(moneytextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("잔액");
		lblNewLabel_1_1.setBounds(33, 35, 30, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("₩"+bmoney);
		lblNewLabel_1_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(92, 35, 160, 23);
		panel.add(lblNewLabel_1_1_1);
		
	}
	
	public void Withdraw() {
		String uaccount=baccount;
		String umoney = moneytextField.getText();
		//String upassword = passwordtextField.getText();

		if(umoney.equals("")) {
			JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "출금 실패", JOptionPane.ERROR_MESSAGE);
			System.out.println("출금 실패 > 금액 미입력");
		}
		
		else if(!umoney.equals("")) {
			
			if(Integer.parseInt(bmoney)<Integer.parseInt(umoney)) {
				System.out.println("출금 실패");
				JOptionPane.showMessageDialog(null, "잔액 부족");
			}
			
			else if(!(Integer.parseInt(bmoney)<Integer.parseInt(umoney)) && db.WithdrawCheck(umoney,uaccount)) {
				System.out.println("출금 성공");
				JOptionPane.showMessageDialog(null, umoney+"원이 출금되었습니다.");
			} else {
				System.out.println("출금 실패");
				JOptionPane.showMessageDialog(null, "출금 실패");
			}
		}
	}
}
