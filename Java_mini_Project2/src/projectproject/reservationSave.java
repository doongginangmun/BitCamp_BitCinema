package projectproject;

import java.util.ArrayList;
import java.util.Calendar;

public class reservationSave {
	
	Calendar cal = Calendar.getInstance();
	static int cnt = 0;
	protected int no;
	protected String movie;
	protected String time;
	protected String seatA; // 1���� ���� //���� ����� �� int�� ��ȯ�ؼ� -1 ��Ű��
	protected String seatB; // 1���� ���� //���� ����� �� int�� ��ȯ�ؼ� -1 ��Ű��
	protected String date;
	protected String nextDate;
	
	public reservationSave() {

	}

	public static String toString(Calendar cal) {
		return cal.get(Calendar.MONTH) + 1 + "��" + cal.get(Calendar.DATE) + "��";
	}

	public String day() {
		String str = toString(cal);
		return str;
	}

	public String tomorrow() {
		cal.add(Calendar.DATE, 1);
		return toString(cal);
	}

	public reservationSave(String date, String movie, String time, String seatA, String seatB) {
		cnt++;
		this.no = cnt;
		this.date = toString(cal);
		this.movie = movie;
		this.time = time;
		this.seatA = seatA;
		this.seatB = seatB;

	}
	public void rsetAll(int no, String date, String movie, String time, String seatA, String seatB) {
		this.no = no;
		this.date = date;
		this.movie = movie;
		this.time = time;
		this.seatA = seatA;
		this.seatB = seatB;
	}

	public void noSave(int no) {
		this.no = no;
	}

	public void dateSave(String date) {
		this.date = date;

	}

	public void movieSave(String movie) {
		this.movie = movie;
	}

	public void timeSave(String time) {
		this.time = time;
	}

	public void seatASave(String seatA) {
		this.seatA = seatA;
	}

	public void seatBSave(String seatB) {
		this.seatB = seatB;
	}

	public int noOut() {
		return no;
	}

	public String timeOut() {
		return time;
	}

	public String movieOut() {
		return movie;
	}

	public String dateOut() {
		return date;
	}

	public String seatAOut() {
		return seatA;
	}

	public String seatBOut() {
		return seatB;
	}
}
