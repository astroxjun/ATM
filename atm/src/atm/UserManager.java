package atm;

import java.util.ArrayList;
import java.util.Arrays;

public class UserManager {
	private ArrayList<User1> list = new ArrayList<User1>();

//  Desing Pattern (GOF) 설계 패턴 중
//	싱글 인스턴스를 만드는
//	Singleton Pattern 을 사용해보자

//	1)생성자를 숨긴다 private
	private UserManager() {}

//	2)클래스 내부에서 단일 인스턴스를 생성해준다.
	private static UserManager instance = new UserManager();

//	3) 외부에서 단일 인스턴스를 참조할 수 있도록 > getter를 제공한다.
	public static UserManager getInstance() {
		return instance;
	}
	
	public void leaveUser() {
		System.out.print("ID : ");
		String id = Atm.scan.next();
		System.out.print("PASSWORD : ");
		String password = Atm.scan.next();
		
		
		
		
		
		
	}

	public void joinUser() {

		int userCode = generateRandomCode();
		System.out.print("ID : ");
		String id = Atm.scan.next();
		System.out.print("PASSWORD : ");
		String password = Atm.scan.next();
		System.out.print("NAME : ");
		String name = Atm.scan.next();

		if (!duplId(id)) {
			User1 user = new User1(userCode, name, id, password);
			this.list.add(user);
			System.out.println("회원가입 완료");
			System.out.println(this.list);

		} else {
			System.out.println("중복되는 아이디입니다.");
		}
	}

	private boolean duplId(String id) {
		boolean dupl = false;
		for (User1 user : this.list) {
			if (user.getId().equals(id)) {
				dupl = true;
			}
		}
		return dupl;
	}

	public ArrayList<User1> getList() {
		return (ArrayList<User1>) this.list.clone();
	}

	private int generateRandomCode() {
		int code = 0;

		while (true) {
			code = (int) (Math.random() * 9000) + 1000;

			boolean dupl = false;
			for (User1 user : this.list) {
				if (user.getUserCode() == code) {
					dupl = true;
				}
			}
			if (!dupl) {
				break;
			}

		}
		return code;
	}

}
