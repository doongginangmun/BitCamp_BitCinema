package Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projectproject.reservationSave;

public class User extends reservationSave implements Serializable {

	String name, phone, joomin, id, password, cardName, cardN;

	

	public User() {
		name = "";
		phone = "";
		joomin = "";
		id = "";
		password = "";
		cardName = "";
		cardN = "";
	}

public User(String name, String phone, String joomin, String id, String password, String cardName, String cardN) {
		this.name = name;
		this.phone = phone;
		this.joomin = joomin;
		this.id = id;
		this.password = password;
		this.cardName = cardName;
		this.cardN = cardN;
	}

public void msetAll(String name, String phone, String joomin, String id, String password, String cardName,
			String cardN) {
		this.name = name;
		this.phone = phone;
		this.joomin = joomin;
		this.id = id;
		this.password = password;
		this.cardName = cardName;
		this.cardN = cardN;
	}

	public void rsetAll(int no, String date, String movie, String time, String seatA, String seatB) {
		this.no = no;
		this.date = date;
		this.movie = movie;
		this.time = time;
		this.seatA = seatA;
		this.seatB = seatB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getphone() {
		return phone;
	}

	public void setjphone(String phone) {
		this.phone = phone;
	}

	public String getjoomin() {
		return joomin;
	}

	public void setjoomin(String joomin) {
		this.joomin = joomin;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getpassword() {
		return password;
	}

	public void setpassowrd(String password) {
		this.password = password;
	}

	public String getcardName() {
		return cardName;
	}

	public void setcardName(String cardName) {
		this.cardName = cardName;
	}

	public String getcardN() {
		return cardN;
	}

	public void setcardN(String cardN) {
		this.cardN = cardN;
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
/*
	public boolean equals(Object o) {
		if (o instanceof User) {
			User a = (User) o;
			if (this.name.equals(a.name))
				return true;
		}
		return false;
	}
*/
}
