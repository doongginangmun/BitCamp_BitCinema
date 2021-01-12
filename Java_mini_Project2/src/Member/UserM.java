package Member;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class UserM implements Serializable {

	public ArrayList<User> ct;
	public ArrayList<User> rSave;
	
	public UserM(ArrayList<User> list) {
		this.ct = list;
	}
	
	public void insert(User a) throws IOException {
		ct.add(a);
	}
	
	
	public void remove(User a) throws IOException {
		ct.remove(a);
	}

	public int getSize() throws IOException {
		return ct.size();
	}

	public User getLocate(int num) throws IOException { // 객체에 있는 index번호를 찾는 메소드
		return ct.get(num);
	}

	public static void swapInstence(int index1, int index2, ArrayList<User> ct) {
		ArrayList<User> ct1 = ct;
		User temp = ct.get(index1);
		User temp2 = ct.get(index2);
		ct1.add(index1, temp2);
		ct1.remove(index1 + 1);
		ct1.add(index2, temp);
		ct1.remove(index2 + 1);
		ct = ct1;
	}
}
