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

		View view = new View(); // ������������ Ŭ���� ȣ�� MVC������ V���ش�
		FileSave save = new FileSave();// ������ �����Ҽ� �ִ� Ŭ����
		ArrayList<User> clist = new ArrayList<User>();
		ArrayList<reservationSave> rlist = new ArrayList<reservationSave>();
		UserM ct = save.cListReader();// �̹� ������ ������� ������ �ҷ��ͼ� ����
		if (ct == null) {
			ct = new UserM(clist);
			save.cListWriter(ct);
		}
	
	reController re = save.rListReader();// �̹� ������ ������� ������ �ҷ��ͼ� ����
		if (re == null) {
			re = new reController(rlist);
			save.rListWriter(re);
		}
		
		view.mainView(ct,re);// ���� ���� ����

	}

}
