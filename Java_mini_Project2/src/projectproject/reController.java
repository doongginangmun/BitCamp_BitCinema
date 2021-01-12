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
		movieList.add("반도");
		movieList.add("밤쉘");
		movieList.add("알라딘");
		movieList.add("파리의 인어");
	}

	void timeChange() {
		timeList.add("10:00");
		timeList.add("13:30");
		timeList.add("17:00");
		timeList.add("21:30");
	}
}
