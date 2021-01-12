package projectproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import Member.User;
import snackBar.SaveSnack;

public class reservation {

	static Scanner sc = new Scanner(System.in);
	static SaveSnack ss = new SaveSnack();
	 List<String> movieList = new ArrayList<>();
	 List<String> timeList = new ArrayList<>();
	public List<User> rSave = new ArrayList<>();
	Calendar cal = new GregorianCalendar();
	User use = new User();
	int[][] seats = new int[5][5];

	public void tickView() throws IOException {
		while(true) {
			select();
			movieSelect();
			timeSelect();
			seats();
			return;
		}
	}

	public void select() throws IOException {
		System.out.println("원하는 날짜를 선택하세요.");
		System.out.println("-----------------------------");
		System.out.println("1." + use.day());
		System.out.println("2." + use.tomorrow());
		System.out.println("-----------------------------");
		int input = sc.nextInt();
		if (input == 1) {
			use.dateSave(use.day());
			System.out.println("1." + use.day());
		} else if (input == 2) {
			use.dateSave(use.tomorrow());
			System.out.println("2." + use.tomorrow());
		}
	}

	public void movieSelect() throws IOException {
		movieChange();
		while (true) {
			System.out.println("-----------------------------");
			for (int i = 0; i < movieList.size(); i++)
				System.out.println((i + 1) + ". " + movieList.get(i));
			System.out.println("-----------------------------");
			System.out.println("원하는 영화를 선택하세요.");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				use.movieSave(movieList.get(0));
				return;
			case 2:
				use.movieSave(movieList.get(1));
				return;
			case 3:
				use.movieSave(movieList.get(2));
				return;
			case 4:
				use.movieSave(movieList.get(3));
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
				use.timeSave(timeList.get(0));
				return;
			case 2:
				use.movieSave(timeList.get(1));
				return;
			case 3:
				use.movieSave(timeList.get(2));
				return;
			case 4:
				use.movieSave(timeList.get(3));
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	public void seats() throws IOException {
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
			use.seatASave(Integer.toString(i));
			i = i - 1;
			if (i < 0 || i > 5) {
				Wrong();
				continue;
			}
			System.out.println("원하는 좌석의 열을 입력하시오");
			int j = sc.nextInt();
			use.seatBSave(Integer.toString(j));
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
					tickView();
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
	
	public void ticket(reController a) {
		System.out.println("------------예매권------------");
		System.out.println("예매번호: " + use.noOut());
		System.out.println("날짜: " + use.dateOut());
		System.out.println("영화: " + use.movieOut());
		System.out.println("시간: " + use.timeOut());
		System.out.println("좌석: " + use.seatAOut() + "행 " + use.seatBOut() + "열");
		System.out.println("-----------------------------");
		System.out.println("          추가 구매 내역                    ");
		System.out.println("Snack: " + ss.FoodOut());
		System.out.println("Juice: " + ss.JuiceOut());
		System.out.println("Goods: " + ss.GoodsOut());
		System.out.println("입장시 직원에게 제시 부탁드립니다.");
		System.out.println("즐거운 관람되시길");
		System.out.println("-----------------------------");
		User q = new User();
		q.rsetAll(use.noOut(), use.dateOut(), use.movieOut(), use.timeOut(), use.seatAOut(), use.seatBOut());
		
		rSave.add(q);

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