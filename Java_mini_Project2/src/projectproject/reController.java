package projectproject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Member.User;

public class reController implements Serializable {
	public ArrayList<reservationSave> re;
	
	 List<String> movieList = new ArrayList<>();
	 List<String> timeList = new ArrayList<>();
	public reController() {}
	
	
	public reController(ArrayList<reservationSave> list) {
		this.re = list;
	}
	public void insert(reservationSave list) {
		re.add(list);
	}
	public int getSize() throws IOException {
		return re.size();
	}
	void movieChange() {
		movieList.add("�ݵ�");
		movieList.add("�㽩");
		movieList.add("�˶��");
		movieList.add("�ĸ��� �ξ�");
	}

	void timeChange() {
		timeList.add("10:00");
		timeList.add("13:30");
		timeList.add("17:00");
		timeList.add("21:30");
	}
}
