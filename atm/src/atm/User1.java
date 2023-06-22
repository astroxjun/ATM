package atm;

import java.util.ArrayList;

public class User1 {
	
	private int userCode; 
	private String name;
	private String id;
	private String password;
	private int age;
	

	private ArrayList<Account> accs;
	
	public User1(int userCode, String name, String id, String password) {
		this.accs = new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
	}
	
	public User1(int userCode, String name, String id, String password, int age) {
		this.accs = new ArrayList<Account>();
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}
	
	
	public User1(int userCode, String name, String id, String password, int age, ArrayList<Account>accs){
		this.accs = new ArrayList<Account>();
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
		this.accs = accs;
	}
	
	public int getUserCode() {
		return this.userCode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Account> getAccs() {
		return (ArrayList<Account>) this.accs.clone();
	}

	public void setAccs(ArrayList<Account> accs) {
		this.accs = accs;
	}
	
//	Override
	
	public String toString() {
		String str = String.format("%s(%d) : %s%s\n", this.name, this.userCode, this.id, this.password);
		
		for(int x=0; x<this.accs.size(); x++) {
			str += "\n" + this.accs.get(x);
		}
		return str;
	}
	
	
	
	

}




