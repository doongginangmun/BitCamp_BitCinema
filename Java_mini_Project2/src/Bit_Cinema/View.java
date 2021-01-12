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
				System.out.println("잘못 입력되었습니다.");
				break;
			}
		}
	}

	static void programExit() {
		System.out.println("종료되었습니다.");
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
			System.out.println("잘못 입력되었습니다.");
			return;
		}
	}

	public void memberprintMenu(UserM ct) throws IOException {
		 if(prompt(ct) == true) {
			   System.out.println(">> [" + use.getName() + "]님 환영합니다.");
			    System.out.println(">> 원하시는 서비스 번호를 선택해주세요!");
		        System.out.println();
				System.out.println("     ┌──────────────────────────────────────┐");
				System.out.println("     │        =====<Member Menu>=====       │");
				System.out.println("     │                                      │");        
				System.out.println("     │             [1. 예매버튼 ]	            │");  
				System.out.println("     │             [2. 예매취소 ]	            │");
				System.out.println("     │             [3. 매점구매 ]	            │");
				System.out.println("     │             [4. MY 정보  ]	            │");
				System.out.println("     │             [5. 회원탈퇴 ]	            │");
				System.out.println("     │             [6. 로그아웃 ]	            │");
				System.out.println("     │            [7. 프로그램 종료 ]           │");
				System.out.println("     │                                      │");
				System.out.println("     └──────────────────────────────────────┘");
			  System.out.print(">> ");
			  memberSelect(ct,re);
		  }
	}

	public void logout(UserM ct) throws IOException {
		System.out.println("로그아웃 성공!");
		mainView(ct,re);
	}

	public void homeprintMenu() {
		System.out.println();
	    System.out.println("	      >>안녕하세요, 비트시네마입니다.	 ");
	    System.out.println("	    >>원하시는 서비스 번호를 선택해주세요!	");
        System.out.println();
		System.out.println("     ┌──────────────────────────────────────┐");
		System.out.println("     │        =====<Home Menu>=====         │");
		System.out.println("     │                                      │");        
		System.out.println("     │             [1. 회원가입]              │");
		System.out.println("     │             [2. 로 그 인 ]              │");
		System.out.println("     │             [3. 상영영화]              │");
		System.out.println("     │             [4. 스 낵 바 ]              │");
		System.out.println("     │             [5. 종료하기]              │");
		System.out.println("     │                                      │");
		System.out.println("     └──────────────────────────────────────┘");
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
						System.out.println("이미 존재하는 아이디 입니다.");
						System.out.println("다른아이디를 입력해주세요");
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
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요.");
		String password = sc.next();
		for (int i = 0; i < ct.getSize(); i++) {
			if (ct.getLocate(i).getid().equals(id) && ct.getLocate(i).getpassword().equals(password)) {
				System.out.println("로그인 성공!!");
				this.id = id;
				this.password = password;
				return true;
			}
		}
		System.out.println("로그인 실패 ");
		return false;
	}

	public void uRemove(UserM ct) throws IOException {
		FileSave save = new FileSave();
		System.out.println("탈퇴할 회원 정보의 아이디를 입력하세요");
		String id = sc.next();
		for (int i = 0; i < ct.getSize(); i++) {
			if (ct.getLocate(i).getid().equals(id)) {
				System.out.println("정말 삭제하시겠습니까?(y/n)");
				String ans = sc.next();
				if (ans.toLowerCase().trim().equals("y")) {
					ct.remove(ct.getLocate(i));
					System.out.println("탈퇴가 완료되었습니다.");
					save.cListWriter(ct);
					return;
				} else {
					System.out.println("회원 정보가 존재하지 않습니다.");
				}
			}
		}
	}

	public void UInsert(UserM ct) throws IOException {
		FileSave save = new FileSave();
		System.out.println("<< 회원가입 >>");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("핸드폰번호 : ");
		String phone = sc.next();
		System.out.print("주민번호: ");
		String joomin = sc.next();
		System.out.print("아이디 : ");
		String id = idchk(ct);
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("카드이름 : ");
		String cardName = sc.next();
		System.out.print("카드번호 : ");
		String cardN = sc.next();
		User i = new User();
		i.msetAll(name, phone, joomin, id, password, cardName, cardN);// 이렇게 하면 view에서 control로 거치지 않고 바로 모델로 감.
		ct.insert(i); // list에 입력받은 값을 객체를 저장
		save.cListWriter(ct);
		System.out.println("ㅡ회원가입이완료 되었습니다.ㅡ");
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
				System.out.println("=====<내 정보>=====");
				System.out.println("[" + use.getName() + "]님의 정보입니다.");
				System.out.println("ID: " + use.getid());
				System.out.println("Password: " + use.getpassword());
				System.out.println("이름: " + use.getName());
				System.out.println("폰번호: " + use.getphone());
				System.out.println("카드이름: " + use.getcardName());
				System.out.println("예매 내역: ");
				// System.out.println("예매 내역: " + use.getTicketList());
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
		System.out.println("원하는 날짜를 선택하세요.");
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
			System.out.println("원하는 영화를 선택하세요.");
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
				System.out.println("잘못 입력하셨습니다.");
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
			System.out.println("원하는 회차를 선택하세요.");
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
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	public void seats(reController re) throws IOException {
		while(true) {
			System.out.println("-----------스크린------------");
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
			System.out.println("o 예매 가능 좌석 ");
			System.out.println("x 예매 불가능 좌석");
			System.out.println("--------------------------");
			System.out.println("원하는 좌석의 행을 입력하시오");
			int i = sc.nextInt();
			rv.seatASave(Integer.toString(i));
			i = i - 1;
			if (i < 0 || i > 5) {
				Wrong();
				continue;
			}
			System.out.println("원하는 좌석의 열을 입력하시오");
			int j = sc.nextInt();
			rv.seatBSave(Integer.toString(j));
			j = j - 1;
			if (j < 0 || j > 5) {
				Wrong();
				continue;
			}
			if (seats[i][j] != 1) {
				System.out.printf("[%d]행[%d]열 좌석을 선택하셨습니다.", i + 1, j + 1);
				System.out.println("등록된 카드로 예매하시겠습니까? y/n");
				String yes = sc.next();
				yes = yes.toUpperCase();
				if (yes.equals("Y")) {
					seats[i][j] = 1;
					System.out.println("예매 완료");
					// 멤버화면으로 가게해야함
					ticket(re);
					return;
				} else if (yes.equals("n")) {
				} else {
					Wrong();
				}
			} else if (seats[i][j] == 1) {
				System.out.println("이미 예약된 좌석입니다.");
			} else {
				Wrong();
			}
		}
	}
	
	public void ticket(reController a) throws IOException {
		FileSave save = new FileSave();
		System.out.println("------------예매권------------");
		System.out.println("예매번호: " + rv.noOut());
		System.out.println("날짜: " + rv.dateOut());
		System.out.println("영화: " + rv.movieOut());
		System.out.println("시간: " + rv.timeOut());
		System.out.println("좌석: " + rv.seatAOut() + "행 " + rv.seatBOut() + "열");
		System.out.println("-----------------------------");
		System.out.println("          추가 구매 내역                    ");
		System.out.println("Snack: " + ss.FoodOut());
		System.out.println("Juice: " + ss.JuiceOut());
		System.out.println("Goods: " + ss.GoodsOut());
		System.out.println("입장시 직원에게 제시 부탁드립니다.");
		System.out.println("즐거운 관람되시길");
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
		System.out.println("잘못 입력하셨습니다.");
	}

	public static String toString(Calendar date) {
		return date.get(Calendar.MONTH) + 1 + "월" + date.get(Calendar.DATE) + "일";
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

