package Bit_Cinema;

import java.io.*;
import java.util.*;

import Member.FileSave;
import Member.User;
import Member.UserM;
import projectproject.reController;
import projectproject.reservation;
import projectproject.reservationSave;


public class MovieMain {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		View view = new View(); // 보여지기위한 클래스 호출 MVC패턴중 V에해당
		FileSave save = new FileSave();// 파일을 저장할수 있는 클래스
		ArrayList<User> clist = new ArrayList<User>();
		ArrayList<reservationSave> rlist = new ArrayList<reservationSave>();
		UserM ct = save.cListReader();// 이미 파일이 있을경우 파일을 불러와서 실행
		if (ct == null) {
			ct = new UserM(clist);
			save.cListWriter(ct);
		}
	
	reController re = save.rListReader();// 이미 파일이 있을경우 파일을 불러와서 실행
		if (re == null) {
			re = new reController(rlist);
			save.rListWriter(re);
		}
		
		view.mainView(ct,re);// 메인 루프 실행

	}

}
