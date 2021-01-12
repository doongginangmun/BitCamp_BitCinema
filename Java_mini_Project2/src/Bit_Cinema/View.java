package Bit_Cinema;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import Member.FileSave;
import Member.User;
import Member.UserM;
import movieInfo.MovieInfoTest;
import projectproject.reController;
import projectproject.reservation;
import projectproject.reservationSave;
import snackBar.SaveSnack;
import snackBar.SnackBar;

public class View implements Serializable {
	static Scanner sc = new Scanner(System.in);
	static SnackBar sn = new SnackBar();
	static SaveSnack ss = new SaveSnack();
	List<String> movieList = new ArrayList<>();
	 List<String> timeList = new ArrayList<>();
	reservationSave rv = new reservationSave();
	reController re = new reController();
	
	Calendar cal = new GregorianCalendar();

	int[][] seats = new int[5][5];
	String password;
	String id;

	User use = new User();

	public void mainView(UserM ct,reController re) throws IOException {
		while (true) {
			homeprintMenu();
			String sel = getSelectMenu();
			switch (sel) {
			case "1":
				UInsert(ct);
				break;
			case "2":
				if (login(ct))
					memberprintMenu(ct);
				break;
			case "3":
				MovieInfoTest.movieinFo();
				break;
			case "4":
				sn.snackbarList();
				break;
			case "5":
				programExit();
				break;
			default:
				System.out.println("�߸� �ԷµǾ����ϴ�.");
				break;
			}
		}
	}

	static void programExit() {
		System.out.println("����Ǿ����ϴ�.");
		System.exit(0);
	}

	public String getSelectMenu() {
		String sel = sc.next();
		return sel;
	}

	public void memberSelect(UserM ct,reController re) throws IOException {
		String sel = getSelectMenu();
		switch (sel) {
		case "1":
			ticketing(re,ct);
			memberprintMenu(ct);
		case "2":
			// ticketCancel();
			break;
		case "3":
			SnackBar.mainOrder();
			break;
		case "4":
			myInfo(ct);
			break;
		case "5":
			uRemove(ct);
			break;
		case "6":
			logout(ct);
			break;
		case "7":
			programExit();
			break;
		default:
			System.out.println("�߸� �ԷµǾ����ϴ�.");
			return;
		}
	}

	public void memberprintMenu(UserM ct) throws IOException {
		 if(prompt(ct) == true) {
			   System.out.println(">> [" + use.getName() + "]�� ȯ���մϴ�.");
			    System.out.println(">> ���Ͻô� ���� ��ȣ�� �������ּ���!");
		        System.out.println();
				System.out.println("     ��������������������������������������������������������������������������������");
				System.out.println("     ��        =====<Member Menu>=====       ��");
				System.out.println("     ��                                      ��");        
				System.out.println("     ��             [1. ���Ź�ư ]	            ��");  
				System.out.println("     ��             [2. ������� ]	            ��");
				System.out.println("     ��             [3. �������� ]	            ��");
				System.out.println("     ��             [4. MY ����  ]	            ��");
				System.out.println("     ��             [5. ȸ��Ż�� ]	            ��");
				System.out.println("     ��             [6. �α׾ƿ� ]	            ��");
				System.out.println("     ��            [7. ���α׷� ���� ]           ��");
				System.out.println("     ��                                      ��");
				System.out.println("     ��������������������������������������������������������������������������������");
			  System.out.print(">> ");
			  memberSelect(ct,re);
		  }
	}

	public void logout(UserM ct) throws IOException {
		System.out.println("�α׾ƿ� ����!");
		mainView(ct,re);
	}

	public void homeprintMenu() {
		System.out.println();
	    System.out.println("	      >>�ȳ��ϼ���, ��Ʈ�ó׸��Դϴ�.	 ");
	    System.out.println("	    >>���Ͻô� ���� ��ȣ�� �������ּ���!	");
        System.out.println();
		System.out.println("     ��������������������������������������������������������������������������������");
		System.out.println("     ��        =====<Home Menu>=====         ��");
		System.out.println("     ��                                      ��");        
		System.out.println("     ��             [1. ȸ������]              ��");
		System.out.println("     ��             [2. �� �� �� ]              ��");
		System.out.println("     ��             [3. �󿵿�ȭ]              ��");
		System.out.println("     ��             [4. �� �� �� ]              ��");
		System.out.println("     ��             [5. �����ϱ�]              ��");
		System.out.println("     ��                                      ��");
		System.out.println("     ��������������������������������������������������������������������������������");
		System.out.print(">> ");
	}

	public String idchk(UserM ct) throws IOException {
		String check = "";
		boolean ds = true;
		while (ds) {
			check = sc.next();
			if (ct.getSize() == 0) {
				return check;
			} else {
				for (int i = 0; i < ct.getSize(); i++) {
					if (ct.getLocate(i).getid().equals(check)) {
						System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.");
						System.out.println("�ٸ����̵� �Է����ּ���");
						break;
					}
					if (i == ct.getSize() - 1) {
						ds = false;
					}
				}
			}
		}
		return check;
	}

	public boolean login(UserM ct) throws IOException {
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		String password = sc.next();
		for (int i = 0; i < ct.getSize(); i++) {
			if (ct.getLocate(i).getid().equals(id) && ct.getLocate(i).getpassword().equals(password)) {
				System.out.println("�α��� ����!!");
				this.id = id;
				this.password = password;
				return true;
			}
		}
		System.out.println("�α��� ���� ");
		return false;
	}

	public void uRemove(UserM ct) throws IOException {
		FileSave save = new FileSave();
		System.out.println("Ż���� ȸ�� ������ ���̵� �Է��ϼ���");
		String id = sc.next();
		for (int i = 0; i < ct.getSize(); i++) {
			if (ct.getLocate(i).getid().equals(id)) {
				System.out.println("���� �����Ͻðڽ��ϱ�?(y/n)");
				String ans = sc.next();
				if (ans.toLowerCase().trim().equals("y")) {
					ct.remove(ct.getLocate(i));
					System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
					save.cListWriter(ct);
					return;
				} else {
					System.out.println("ȸ�� ������ �������� �ʽ��ϴ�.");
				}
			}
		}
	}

	public void UInsert(UserM ct) throws IOException {
		FileSave save = new FileSave();
		System.out.println("<< ȸ������ >>");
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�ڵ�����ȣ : ");
		String phone = sc.next();
		System.out.print("�ֹι�ȣ: ");
		String joomin = sc.next();
		System.out.print("���̵� : ");
		String id = idchk(ct);
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		System.out.print("ī���̸� : ");
		String cardName = sc.next();
		System.out.print("ī���ȣ : ");
		String cardN = sc.next();
		User i = new User();
		i.msetAll(name, phone, joomin, id, password, cardName, cardN);// �̷��� �ϸ� view���� control�� ��ġ�� �ʰ� �ٷ� �𵨷� ��.
		ct.insert(i); // list�� �Է¹��� ���� ��ü�� ����
		save.cListWriter(ct);
		System.out.println("��ȸ�������̿Ϸ� �Ǿ����ϴ�.��");
	}

	public void ticketing(reController re,UserM ct) throws IOException {
		while (true) {
			if (prompt(ct) == true) {
			   tickView(re,ct);
				return;
			}
		}
	}

	public boolean prompt(UserM ct) throws IOException {
		for (int i = 0; i < ct.getSize(); i++)
			if (ct.getLocate(i).getid().equals(this.id))
				use = ct.getLocate(i);
		return true;
	}

	public void myInfo(UserM ct) throws IOException {
		while (true) {
			if (prompt(ct) == true) {
				System.out.println("=====<�� ����>=====");
				System.out.println("[" + use.getName() + "]���� �����Դϴ�.");
				System.out.println("ID: " + use.getid());
				System.out.println("Password: " + use.getpassword());
				System.out.println("�̸�: " + use.getName());
				System.out.println("����ȣ: " + use.getphone());
				System.out.println("ī���̸�: " + use.getcardName());
				System.out.println("���� ����: ");
				// System.out.println("���� ����: " + use.getTicketList());
				System.out.println("=================");
			}
			memberprintMenu(ct);
		}
	}

	
	
	
	
	
	
	public void tickView(reController re,UserM ct) throws IOException {
		while(true) {
			select();
			movieSelect(re);
			timeSelect();
			seats(re);
			return;
		}
	}

	public void select() throws IOException {
		System.out.println("���ϴ� ��¥�� �����ϼ���.");
		System.out.println("-----------------------------");
		System.out.println("1." + rv.day());
		System.out.println("2." + rv.tomorrow());
		System.out.println("-----------------------------");
		int input = sc.nextInt();
		if (input == 1) {
			rv.dateSave(rv.day());
			System.out.println("1." + rv.day());
		} else if (input == 2) {
			rv.dateSave(rv.tomorrow());
			System.out.println("2." + rv.tomorrow());
		}
	}

	public void movieSelect(reController re) throws IOException {
		movieChange();
		while (true) {
			System.out.println("-----------------------------");
			for (int i = 0; i <movieList.size(); i++)
				System.out.println((i + 1) + ". " + movieList.get(i));
			System.out.println("-----------------------------");
			System.out.println("���ϴ� ��ȭ�� �����ϼ���.");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				rv.movieSave(movieList.get(0));
				return;
			case 2:
				rv.movieSave(movieList.get(1));
				return;
			case 3:
				rv.movieSave(movieList.get(2));
				return;
			case 4:
				rv.movieSave(movieList.get(3));
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	public void timeSelect() throws IOException {
		timeChange();
		while (true) {
			System.out.println("-----------------------------");
			for (int i = 0; i < timeList.size(); i++)
				System.out.println((i + 1) + ". " + timeList.get(i));
			System.out.println("-----------------------------");
			System.out.println("���ϴ� ȸ���� �����ϼ���.");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				rv.timeSave(timeList.get(0));
				return;
			case 2:
				rv.movieSave(timeList.get(1));
				return;
			case 3:
				rv.movieSave(timeList.get(2));
				return;
			case 4:
				rv.movieSave(timeList.get(3));
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	public void seats(reController re) throws IOException {
		while(true) {
			System.out.println("-----------��ũ��------------");
			System.out.println();
			for (int a = 0; a < seats.length; a++) {
				System.out.print(" [" + (a + 1) + "] ");
			}
			for (int a = 0; a < seats.length; a++) {
				System.out.println();
				for (int b = 0; b < seats[a].length; b++) {
					if (seats[a][b] != 1) {
						System.out.print("  O  ");
					} else {
						System.out.print("  X  ");
					}
				}
				System.out.println(" [" + (a + 1) + "] ");
			}
			System.out.print(" ");
			System.out.println("--------------------------");
			System.out.println("o ���� ���� �¼� ");
			System.out.println("x ���� �Ұ��� �¼�");
			System.out.println("--------------------------");
			System.out.println("���ϴ� �¼��� ���� �Է��Ͻÿ�");
			int i = sc.nextInt();
			rv.seatASave(Integer.toString(i));
			i = i - 1;
			if (i < 0 || i > 5) {
				Wrong();
				continue;
			}
			System.out.println("���ϴ� �¼��� ���� �Է��Ͻÿ�");
			int j = sc.nextInt();
			rv.seatBSave(Integer.toString(j));
			j = j - 1;
			if (j < 0 || j > 5) {
				Wrong();
				continue;
			}
			if (seats[i][j] != 1) {
				System.out.printf("[%d]��[%d]�� �¼��� �����ϼ̽��ϴ�.", i + 1, j + 1);
				System.out.println("��ϵ� ī��� �����Ͻðڽ��ϱ�? y/n");
				String yes = sc.next();
				yes = yes.toUpperCase();
				if (yes.equals("Y")) {
					seats[i][j] = 1;
					System.out.println("���� �Ϸ�");
					// ���ȭ������ �����ؾ���
					ticket(re);
					return;
				} else if (yes.equals("n")) {
				} else {
					Wrong();
				}
			} else if (seats[i][j] == 1) {
				System.out.println("�̹� ����� �¼��Դϴ�.");
			} else {
				Wrong();
			}
		}
	}
	
	public void ticket(reController a) throws IOException {
		FileSave save = new FileSave();
		System.out.println("------------���ű�------------");
		System.out.println("���Ź�ȣ: " + rv.noOut());
		System.out.println("��¥: " + rv.dateOut());
		System.out.println("��ȭ: " + rv.movieOut());
		System.out.println("�ð�: " + rv.timeOut());
		System.out.println("�¼�: " + rv.seatAOut() + "�� " + rv.seatBOut() + "��");
		System.out.println("-----------------------------");
		System.out.println("          �߰� ���� ����                    ");
		System.out.println("Snack: " + ss.FoodOut());
		System.out.println("Juice: " + ss.JuiceOut());
		System.out.println("Goods: " + ss.GoodsOut());
		System.out.println("����� �������� ���� ��Ź�帳�ϴ�.");
		System.out.println("��ſ� �����ǽñ�");
		System.out.println("-----------------------------");
		reservationSave q = new reservationSave();
		System.out.println("Q:"+q);
		q.rsetAll(rv.noOut(),rv.dateOut(),rv.movieOut(),rv.timeOut(),rv.seatAOut(),rv.seatBOut());
		//a.insert(q);
		//save.rListWriter(a);
		

		// save.cListWriter(ct);

		System.out.println("-----------------------------");
	}

	void Wrong() {
		System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.MONTH) + 1 + "��" + date.get(Calendar.DATE) + "��";
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

