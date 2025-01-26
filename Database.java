import java.sql.*;

public class Database {
	Connection con;
	Statement st;
	String url = "jdbc:mysql://localhost:3306/seowon";
	String user = "root";
	String passwd = "1234";
	
	Database(){  //db 연동 여부
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,passwd);
			st=con.createStatement();
			System.out.println("MySQL 서버 연동 성공");
		}catch(Exception e) {
			System.out.println("MySQL 서버 연동 실패 > "+e.toString());
		}
	}
	
	boolean LoginCheck(String _i,String _p) {
		boolean flag = false;
		
		String id=_i;
		String pwd=_p;
		
		try {
			String checkingStr = "select account_passwd from account where account_number='"+id+"'";
			ResultSet result = st.executeQuery(checkingStr);
			
			int count=0;
			while(result.next()) {
				if(pwd.equals(result.getString("account_passwd"))) {
					flag = true;
					System.out.println("로그인 성공");
				}
				
				else {
					flag = false;
					System.out.println("로그인 실패");
				}
				count++;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 실패 > "+e.toString());
		}
		return flag;
	}
	
	boolean CreateCheck(String _n,String _s,String _p,String _a,String _pw) {
		boolean flag = false;
		
		String name=_n;
		String SSN=_s;
		String phone=_p;
		String address=_a;
		String passwd = _pw;
		
		try {
			String insertStr1 = "insert into customer values('" + name + "','"+ SSN +"','"+ phone +"','"+ address +"','"+ 1000 +"')";
			String insertStr2 = "insert into account values('" + phone + "','"+ passwd +"')";
			st.executeUpdate(insertStr2);
			st.executeUpdate(insertStr1);
			
			flag = true;
			System.out.println("계좌개설 성공");
		}catch(Exception e) {
			flag = false;
			System.out.println("계좌개설 실패 > "+e.toString());
		}
		return flag;
	}
	
	boolean DeleteCheck(String _n,String _a) {
		boolean flag = false;
		
		String name=_n;
		String account = _a;
		try {
			String deleteStr1 = "delete from customer where name=('" + name + "') and phone_number=('" + account + "')";
			String deleteStr2 = "delete from account where account_number=('" + account + "')";
			st.executeUpdate(deleteStr1);
			st.executeUpdate(deleteStr2);
			
			flag = true;
			System.out.println("계좌 삭제 성공");
		}catch(Exception e) {
			flag = false;
			System.out.println("계좌삭제 실패 > "+e.toString());
		}
		return flag;
	}
	
	boolean EditCheck(String _a,String _p,String _np) {
		boolean flag = false;
		
		String account=_a;
		String password = _p;
		String newpassword=_np;
		try {
			String editStr = "update account set account_passwd=('"+newpassword+"') "
					+ "where account_number = ('" + account + "') and account_passwd = ('" + password + "')";
			st.executeUpdate(editStr);
			
			flag = true;
			System.out.println("비밀번호 변경 성공");
		}catch(Exception e) {
			flag = false;
			System.out.println("비밀번호 변경 실패 > "+e.toString());
		}
		return flag;
	}
	
	boolean DepositCheck(String _m,String _a) {
		boolean flag = false;
		
		String money = _m;
		String account=_a;
		String umoney = null;
		try {
			String bringStr = "select money from customer where phone_number='"+account+"'";
			ResultSet result = st.executeQuery(bringStr);
			while(result.next()) {
				umoney=result.getString("money");
			}
			int plus = Integer.parseInt(money)+Integer.parseInt(umoney);
			String editStr = "update customer set money=('"+(plus)+"') " + "where phone_number = ('" + account + "')";
			st.executeUpdate(editStr);
			
			flag = true;
			System.out.println("입금 성공");
		}catch(Exception e) {
			flag = false;
			System.out.println("입금 실패 > "+e.toString());
		}
		return flag;
	}
	
	boolean WithdrawCheck(String _m,String _a) {
		boolean flag = false;
		
		String money = _m;
		String account=_a;
		String umoney = null;
		try {
			String bringStr = "select money from customer where phone_number='"+account+"'";
			ResultSet result = st.executeQuery(bringStr);
			while(result.next()) {
				umoney=result.getString("money");
			}
			int minus = Integer.parseInt(umoney)-Integer.parseInt(money);
			String editStr = "update customer set money=('"+(minus)+"') " + "where phone_number = ('" + account + "')";
			st.executeUpdate(editStr);
			
			flag = true;
			System.out.println("출금 성공");
		}catch(Exception e) {
			flag = false;
			System.out.println("출금 실패 > "+e.toString());
		}
		return flag;
	}
	boolean TransferCheck(String _a,String _m,String _b) {
		boolean flag = false;
		
		String mymoney=null;
		String opmoney = null;
		String sendmoney = _m;
		String sendaccount=_a;
		String myaccount=_b;
		
		try {
			String bringStr = "select money from customer where phone_number='"+myaccount+"'";
			ResultSet result = st.executeQuery(bringStr);
			while(result.next()) {
				mymoney=result.getString("money");
			}
			String opbringStr = "select money from customer where phone_number='"+sendaccount+"'";
			ResultSet opresult = st.executeQuery(opbringStr);
			while(opresult.next()) {
				opmoney=opresult.getString("money");
			}
			
			int me = Integer.parseInt(mymoney)-Integer.parseInt(sendmoney);
			int opponent = Integer.parseInt(opmoney)+Integer.parseInt(sendmoney);
			String myeditStr = "update customer set money=('"+(me)+"') " + "where phone_number = ('" + myaccount + "')";
			st.executeUpdate(myeditStr);
			
			
			String opeditStr = "update customer set money=('"+opponent+"') " + "where phone_number = ('" + sendaccount + "')";
			st.executeUpdate(opeditStr);
			
			flag = true;
			System.out.println("계좌이체 성공");
		}catch(Exception e) {
			flag = false;
			System.out.println("계좌이체 실패 > "+e.toString());
		}
		return flag;
	}
	
	String BringMoney(String _a) {
		
		String account=_a;
		String umoney = null;
		try {
			String bringStr = "select money from customer where phone_number='"+account+"'";
			ResultSet result = st.executeQuery(bringStr);
			while(result.next()) {
				umoney=result.getString("money");
			}
			System.out.println("리턴 성공");
		}catch(Exception e) {
			System.out.println("리턴 실패 > "+e.toString());
		}
		return umoney;
	}
}
