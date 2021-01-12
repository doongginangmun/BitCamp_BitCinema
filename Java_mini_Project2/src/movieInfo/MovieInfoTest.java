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
		System.out.println("<<상영 중인 영화 정보>>");
		System.out.println();
		System.out.println("				상영중인 영화입니다.");
		System.out.println();
		System.out.println("     ┌────────────────────────────────────────────────────────────────┐");
		System.out.println("     │    1. 반도  | 2. 알라딘  | 3. 파리의 인어  |  4. 밤쉘 -세상을 바꾼 폭탄선언       │");
		System.out.println("     └────────────────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.println("			정보확인을 원하는 영화 번호를 입력해주세요.");
		System.out.println();
		System.out.println("				  0. 메인으로 가기");
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
