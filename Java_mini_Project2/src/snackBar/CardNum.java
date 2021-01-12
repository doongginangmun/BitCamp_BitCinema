package snackBar;

import java.util.Scanner;

import Bit_Cinema.View;
import Member.User;
import Member.UserM;

public class CardNum {
	Scanner sc = new Scanner(System.in);
	String cardNum;
	View view = new View();
	User user = new User();
	public void View(){
		
		
		
		
		
//		Snack snack = new Snack();	
//		Drink drink = new Drink();	
		//System.out.println("	       총합" + (snack.snackPrice+drink.drinkPrice) + "원 입니다.");
		System.out.println();
		System.out.println("     ┌───────────────────────────────┐");
		System.out.println("     │    등록된 카드로 결제하시겠습니까?    │");
		System.out.println("     │         (1.Yes / 2.No)        │");
		System.out.println("     └───────────────────────────────┘");
		System.out.print("	카드 번호 : ");
		
		
		boolean flag = true;
		int selectNum = sc.nextInt();
		switch(selectNum) {
		case 1:
			System.out.println();
			System.out.println("	결제 완료되었습니다. 감사합니다.");	
			System.out.println("	처음 화면으로 돌아갑니다.");	
			System.out.println();
			break;
		case 2:
			System.out.println();
			System.out.println("	틀린 카드 번호입니다. 결제가  취소됐습니다.");
			System.out.println("	처음으로 돌아갑니다.");
			System.out.println();
			break;
		default:
			System.out.println("	잘못 입력하셨습니다.");
			System.out.println("	처음으로 돌아갑니다.");
			flag=false;
			break;	
		}
		
	
		}
	}

