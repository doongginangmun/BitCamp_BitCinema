package movieInfo;

import java.util.Scanner;

public class MovieInfoTest {

	static Scanner sc = new Scanner(System.in);
	static boolean flag = true;
	static MovieInfo movieInfo = new MovieInfo();

	public static void main(String[] args) {
		movieinFo();
	}

	public static void movieinFo() {
		while(flag) {
		System.out.println("<<�� ���� ��ȭ ����>>");
		System.out.println();
		System.out.println("				������ ��ȭ�Դϴ�.");
		System.out.println();
		System.out.println("     ������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("     ��    1. �ݵ�  | 2. �˶��  | 3. �ĸ��� �ξ�  |  4. �㽩 -������ �ٲ� ��ź����       ��");
		System.out.println("     ������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println();
		System.out.println("			����Ȯ���� ���ϴ� ��ȭ ��ȣ�� �Է����ּ���.");
		System.out.println();
		System.out.println("				  0. �������� ����");
		movieSelect();
		}
	}

	public static void movieSelect() {
		int selectNum = sc.nextInt();
		switch (selectNum) {
		case 1:
			movieInfo.MovieInfo1();
			movieinFo();
			break;
		case 2:
			movieInfo.MovieInfo2();
			movieinFo();
			break;
		case 3:
			movieInfo.MovieInfo3();
			movieinFo();
			break;
		case 4:
			movieInfo.MovieInfo4();
			movieinFo();
			break;
		case 0:
			flag = false;
			break;
		}
	}
}
