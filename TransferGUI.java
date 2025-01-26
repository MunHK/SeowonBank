import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TransferGUI extends JFrame{

	private JTextField moneytextField;
	private JTextField acctextField_1;
	Database db= new Database();
	public String baccount;
	public String bmoney;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferGUI window = new TransferGUI();
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
	public TransferGUI(String account) {
		baccount=account;
		bmoney = db.BringMoney(baccount);
		setTitle("계좌이체");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(850, 400, 280, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 264, 140);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("취소하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserGUI admin = new UserGUI(baccount);
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 105, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("입금하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transfer();
			}
		});
		btnNewButton_1.setBounds(136, 105, 116, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("입금액");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 72, 48, 23);
		panel.add(lblNewLabel_1);
		
		moneytextField = new JTextField();
		moneytextField.setColumns(10);
		moneytextField.setBounds(92, 72, 160, 23);
		panel.add(moneytextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("입금할 계좌");
		lblNewLabel_1_1.setBounds(12, 43, 75, 23);
		panel.add(lblNewLabel_1_1);
		
		acctextField_1 = new JTextField();
		acctextField_1.setColumns(10);
		acctextField_1.setBounds(92, 43, 160, 23);
		panel.add(acctextField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("잔액");
		lblNewLabel_1_1_1.setBounds(33, 15, 30, 23);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("₩"+bmoney);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(92, 15, 160, 23);
		panel.add(lblNewLabel_1_1_1_1);
	}
	public void Transfer() {
		String uaccount = acctextField_1.getText();
		String umoney = moneytextField.getText();

		if(umoney.equals("") || uaccount.equals("")) {
			JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "계좌이체 실패", JOptionPane.ERROR_MESSAGE);
			System.out.println("계좌이체 실패 > 금액 미입력");
		}
		
		else if(!umoney.equals("") && !uaccount.equals("")) {
			if(Integer.parseInt(bmoney)<Integer.parseInt(umoney)) {
				System.out.println("출금 실패");
				JOptionPane.showMessageDialog(null, "잔액 부족");
			}
			else if(db.TransferCheck(uaccount,umoney,baccount)&&!(Integer.parseInt(bmoney)<Integer.parseInt(umoney))) {
				System.out.println("계좌이체 성공");
				JOptionPane.showMessageDialog(null, umoney+"원이 입금되었습니다.");
				UserGUI admin = new UserGUI(baccount);
				admin.setVisible(true);
				dispose();
			} else {
				System.out.println("계좌이체 실패");
				JOptionPane.showMessageDialog(null, "입금 실패");
			}
		}
	}
}
