package atm;

import java.util.ArrayList;
import java.util.Arrays;

public class UserManager {
	int log = -1;

	private ArrayList<User1> list = new ArrayList<User1>();

//  Desing Pattern (GOF) ���� ���� ��
//	�̱� �ν��Ͻ��� �����
//	Singleton Pattern �� ����غ���

//	1)�����ڸ� ����� private
	private UserManager() {
	}

//	2)Ŭ���� ���ο��� ���� �ν��Ͻ��� �������ش�.
	private static UserManager instance = new UserManager();

//	3) �ܺο��� ���� �ν��Ͻ��� ������ �� �ֵ��� > getter�� �����Ѵ�.
	public static UserManager getInstance() {
		return instance;
	}

	public void leaveUser() {

		System.out.print("ID : ");
		String id = Atm.scan.next();
		System.out.print("PASSWORD : ");
		String password = Atm.scan.next();

		for (int x = 0; x < this.list.size(); x++) {
			if (this.list.get(x).getId().equals(id) && this.list.get(x).getPassword().equals(password)) {
				this.list.remove(x);
				System.out.println(this.list);
			} else {
				System.out.println("ID Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}

	}

	public int logoutUser() {
		if (this.log != -1) {
			System.out.println("�α׾ƿ� �Ϸ� �Ǿ����ϴ�.");
			this.log = -1;
			return this.log;
		} else {
			System.out.println("�α׾ƿ� �����Դϴ�.");
			return this.log;
		}
	}

	public int loginUser() {
		if (this.log != -1) {
			System.out.println("�α��� �����Դϴ�.");
			return this.log;
		}

		System.out.print("ID : ");
		String id = Atm.scan.next();
		System.out.print("PASSWORD : ");
		String password = Atm.scan.next();

		if (check(id, password)) {
			System.out.println("�α��ο� �����߽��ϴ�.");
			System.out.println("log ��ȣ : " + log);
			return this.log;
		} else {
			System.out.println("ID Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return this.log;
		}

	}

	private boolean check(String id, String password) {
		boolean checkId = true;

		for (int x = 0; x < this.list.size(); x++) {
			if (this.list.get(x).getId().equals(id) && this.list.get(x).getPassword().equals(password)) {
//				this.list.get(x).contains(id) // ��ȯ���� index ������ -1�� ��ȯ 
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
				System.out.println("���� �α��� �����Դϴ�.");
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
				System.out.println("ȸ������ �Ϸ�");
				System.out.println(this.list);

			} else {
				System.out.println("�ߺ��Ǵ� ���̵��Դϴ�.");
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
