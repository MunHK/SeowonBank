import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

public class CustomerInfo extends JFrame{

	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo window = new CustomerInfo();
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
	public CustomerInfo() {
		setTitle("정보 조회");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(850, 400, 503, 278);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 487, 239);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		String[] header = {"번호","이름", "주민번호", "계좌(전화)번호", "주소", "잔액"};
		String contents[][]= {{"1","김씨","20041111","01056785678","충청북도 청주","1000"},
				{"2","문형규","20001113","01075761795","경기도 안산","51000"},
				{"3","박씨","20040102","01087654321","충청북도 청주","1000"},
				{"4","이씨","19871010","01012345678","충청북도 청주","49950"},
				{"5","우성민","20000714","01037713894","경기도 시흥","1000"},
				{"6","황성진","20000923","01033123739","충청북도 청주","1000"},
				{"7","안민","20001021","01089845491","충청북도 청주","1000"},
				{"8","한승현","20000508","01052313206","경기도 평택","1000"},
				{"9","안덕근","20191021","01189845491","강원도 원주","1000"},
				{"10","고객1","19871210","01011112222","경기도 수원","1000"},
				{"11","고객2","20000111","01033334444","서울시 강남","1000"},
				{"12","고객3","19981023","01055556666","경기도 오산","1000"}};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 462, 176);
		panel.add(scrollPane);
		
		table = new JTable(contents,header);
		scrollPane.setViewportView(table);

	}
}
