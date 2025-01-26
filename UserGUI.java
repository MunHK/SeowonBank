import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGUI extends JFrame {
	Database db = new Database();
	public String baccount;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI window = new UserGUI();
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
	public UserGUI(String account) {
		baccount=account;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("사용자");
		setBounds(850, 300, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("뒤로");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(15, 10, 64, 28);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("예금 입금");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositGUI deposit = new DepositGUI(baccount);
				deposit.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(15, 75, 100, 50);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("예금 출금");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawGUI withdraw = new WithdrawGUI(baccount);
				withdraw.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(15, 150, 100, 50);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("계좌이체");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferGUI transfer = new TransferGUI(baccount);
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(170, 75, 100, 50);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("잔액 조회");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckMoney();
			}
		});
		btnNewButton_2_1.setBounds(170, 150, 100, 50);
		panel.add(btnNewButton_2_1);
	}
	public void CheckMoney() {
		String bmoney=db.BringMoney(baccount);
		JOptionPane.showMessageDialog(null, "현재 잔액 : "+bmoney+"원");
	}
}
