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
		System.out.println("���ϴ� ��¥�� �����ϼ���.");
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
			System.out.println("���ϴ� ��ȭ�� �����ϼ���.");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	public void seats() throws IOException {
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
			use.seatASave(Integer.toString(i));
			i = i - 1;
			if (i < 0 || i > 5) {
				Wrong();
				continue;
			}
			System.out.println("���ϴ� �¼��� ���� �Է��Ͻÿ�");
			int j = sc.nextInt();
			use.seatBSave(Integer.toString(j));
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
					tickView();
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
	
	public void ticket(reController a) {
		System.out.println("------------���ű�------------");
		System.out.println("���Ź�ȣ: " + use.noOut());
		System.out.println("��¥: " + use.dateOut());
		System.out.println("��ȭ: " + use.movieOut());
		System.out.println("�ð�: " + use.timeOut());
		System.out.println("�¼�: " + use.seatAOut() + "�� " + use.seatBOut() + "��");
		System.out.println("-----------------------------");
		System.out.println("          �߰� ���� ����                    ");
		System.out.println("Snack: " + ss.FoodOut());
		System.out.println("Juice: " + ss.JuiceOut());
		System.out.println("Goods: " + ss.GoodsOut());
		System.out.println("����� �������� ���� ��Ź�帳�ϴ�.");
		System.out.println("��ſ� �����ǽñ�");
		System.out.println("-----------------------------");
		User q = new User();
		q.rsetAll(use.noOut(), use.dateOut(), use.movieOut(), use.timeOut(), use.seatAOut(), use.seatBOut());
		
		rSave.add(q);

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