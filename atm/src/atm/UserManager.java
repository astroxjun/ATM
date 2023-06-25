package atm;

import java.util.ArrayList;
import java.util.Arrays;

public class UserManager {
	static int log = -1;

	private ArrayList<User1> list = new ArrayList<User1>();

//  Desing Pattern (GOF) 설계 패턴 중
//	싱글 인스턴스를 만드는
//	Singleton Pattern 을 사용해보자

//	1)생성자를 숨긴다 private
	private UserManager() {
	}

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
		boolean check = true;

		for (int x = 0; x < this.list.size(); x++) {
			if (this.list.get(x).getId().equals(id) && this.list.get(x).getPassword().equals(password)) {
				this.list.remove(x);
				System.out.println("회원탈퇴가 완료 되었습니다.");
				check = true;
				break;
			} else {
				check = false;
			}
		}

		if (check == false) {
			System.out.println("ID 또는 비밀번호가 틀렸습니다.");
		}

	}

	public int logoutUser() {
		if (this.log != -1) {
			System.out.println("로그아웃이 완료 되었습니다.");
			this.log = -1;
			return this.log;
		} else {
			System.out.println("로그아웃 상태입니다.");
			return this.log;
		}
	}

	public int loginUser() {
		if (this.log != -1) {
			System.out.println("로그인 상태입니다.");
			return this.log;
		}

		System.out.print("ID : ");
		String id = Atm.scan.next();
		System.out.print("PASSWORD : ");
		String password = Atm.scan.next();

		if (check(id, password)) {
			System.out.println("로그인에 성공하였습니다.");
			System.out.println("log 번호 : " + log);
			return this.log;
		} else {
			System.out.println("ID 또는 비밀번호가 틀렸습니다.");
			return this.log;
		}

	}

	private boolean check(String id, String password) {
		boolean checkId = true;

		for (int x = 0; x < this.list.size(); x++) {
			if (this.list.get(x).getId().equals(id) && this.list.get(x).getPassword().equals(password)) {
				this.log = x;
				checkId = true;
				break;
			} else {
				checkId = false;
			}
		}

		return checkId;

	}

	public void joinUser() {
		while (true) {

			if (this.log != -1) {
				System.out.println("현재 로그인 상태입니다.");
				break;
			}

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
				System.out.println("회원가입이 완료 되었습니다.");
				System.out.println(this.list); // ���߿� ���� �κ�

			} else {
				System.out.println("중복되는 ID입니다.");
			}

			break;
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
