import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateAccount extends JFrame {

	Database db = new Database();
	LoginGUI login = null;
	CreateAccount create=null;
	private JTextField nametextField;
	private JTextField birthtextField;
	private JTextField phonetextField;
	private JTextField addresstextField;
	private JPasswordField passwordField;
	public String umonth;
	public String uday;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String[] month= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		String[] day= { "01","02","03","04","05","06","07","08","09","10",
						"11","12","13","14","15","16","17","18","19","20",
						"21","22","23","24","25","26","27","28","29","30","31"};
		setTitle("계좌 생성하기");
		setBounds(850, 300, 300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 311);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고객정보 입력");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(87, 10, 162, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성명");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 50, 57, 15); 
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("생년월일");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(12, 85, 57, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("주소");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(12, 155, 57, 15);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("본인의 전화번호가 계좌번호로 등록됩니다.");
		lblNewLabel_1_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(12, 233, 260, 23);
		panel.add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("계좌 개설하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNewButton.setBounds(127, 268, 122, 33);
		panel.add(btnNewButton);
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(80, 47, 192, 21);
		panel.add(nametextField);
		
		birthtextField = new JTextField();
		birthtextField.setColumns(10);
		birthtextField.setBounds(80, 82, 72, 21);
		panel.add(birthtextField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("전화번호");
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(12, 120, 57, 15);
		panel.add(lblNewLabel_1_2_1);
		
		phonetextField = new JTextField();
		phonetextField.setColumns(10);
		phonetextField.setBounds(80, 117, 192, 21);
		panel.add(phonetextField);
		
		addresstextField = new JTextField();
		addresstextField.setColumns(10);
		addresstextField.setBounds(80, 152, 192, 21);
		panel.add(addresstextField);
		
		JComboBox comboBox = new JComboBox(month);
		comboBox.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox.setBounds(164, 81, 45, 23);
		panel.add(comboBox);
		//umonth = comboBox.getSelectedItem().toString();
		
		JComboBox comboBox_1 = new JComboBox(day);
		comboBox_1.setFont(new Font("굴림", Font.PLAIN, 12));
		comboBox_1.setBounds(227, 81, 45, 23);
		panel.add(comboBox_1);
		//uday = comboBox_1.getSelectedItem().toString();
		
		JLabel lblNewLabel_1_2_2 = new JLabel("비밀번호");
		lblNewLabel_1_2_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(12, 186, 57, 15);
		panel.add(lblNewLabel_1_2_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 183, 192, 21);
		panel.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("뒤로");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGUI admin = new AdminGUI();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNewButton_1.setBounds(34, 268, 64, 33);
		panel.add(btnNewButton_1);
	}
	
	public void Create() {
		String uname = nametextField.getText();
		String ubirth = birthtextField.getText();
		String uphone = phonetextField.getText();
		String uaddress = addresstextField.getText();
		String upass = "";
		for(int i=0;i<passwordField.getPassword().length;i++) {
			upass = upass + passwordField.getPassword()[i];
		}
		if(uname.equals("") || ubirth.equals("") ||uphone.equals("") ||uaddress.equals("") || upass.equals("")) {
			JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
			System.out.println("회원가입 실패 > 회원정보 미입력");
		}
		
		else if(!uname.equals("") && !ubirth.equals("") &&!uphone.equals("") &&!uaddress.equals("") && !upass.equals("")) {
			if(db.CreateCheck(uname,ubirth,uphone,uaddress, upass)) {
				System.out.println("회원가입 성공");
				JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다");
				//dispose();
			} else {
				System.out.println("회원가입 실패");
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");
				passwordField.setText("");
			}
		}

		
	}
}
