import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Password extends JFrame{

	private JPanel panel;
	private JTextField fourtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password window = new Password();
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
	public Password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("비밀번호 입력");
		setBounds(100, 100, 250, 270);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 234, 231);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		fourtextField = new JTextField();
		fourtextField.setFont(new Font("굴림", Font.PLAIN, 14));
		fourtextField.setColumns(10);
		fourtextField.setBounds(68, 10, 99, 30);
		panel.add(fourtextField);
		
		fourtextField.setText("");
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(12, 50, 64, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBounds(85, 50, 64, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2.setBounds(158, 50, 64, 35);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_3.setBounds(12, 95, 64, 35);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_4.setBounds(85, 95, 64, 35);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_5.setBounds(158, 95, 64, 35);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("1");
		btnNewButton_6.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_6.setBounds(12, 140, 64, 35);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("2");
		btnNewButton_7.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_7.setBounds(85, 140, 64, 35);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("3");
		btnNewButton_8.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_8.setBounds(158, 140, 64, 35);
		panel.add(btnNewButton_8);
		
		JButton btnC = new JButton("초기화");
		btnC.setFont(new Font("굴림", Font.PLAIN, 10));
		btnC.setBounds(12, 185, 64, 35);
		panel.add(btnC);
		
		JButton btnNewButton_10 = new JButton("0");
		btnNewButton_10.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_10.setBounds(85, 185, 64, 35);
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("확인");
		btnNewButton_11.setBounds(158, 185, 64, 35);
		panel.add(btnNewButton_11);
	}
}
