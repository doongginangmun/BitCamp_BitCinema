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
		//System.out.println("	       ����" + (snack.snackPrice+drink.drinkPrice) + "�� �Դϴ�.");
		System.out.println();
		System.out.println("     ������������������������������������������������������������������");
		System.out.println("     ��    ��ϵ� ī��� �����Ͻðڽ��ϱ�?    ��");
		System.out.println("     ��         (1.Yes / 2.No)        ��");
		System.out.println("     ������������������������������������������������������������������");
		System.out.print("	ī�� ��ȣ : ");
		
		
		boolean flag = true;
		int selectNum = sc.nextInt();
		switch(selectNum) {
		case 1:
			System.out.println();
			System.out.println("	���� �Ϸ�Ǿ����ϴ�. �����մϴ�.");	
			System.out.println("	ó�� ȭ������ ���ư��ϴ�.");	
			System.out.println();
			break;
		case 2:
			System.out.println();
			System.out.println("	Ʋ�� ī�� ��ȣ�Դϴ�. ������  ��ҵƽ��ϴ�.");
			System.out.println("	ó������ ���ư��ϴ�.");
			System.out.println();
			break;
		default:
			System.out.println("	�߸� �Է��ϼ̽��ϴ�.");
			System.out.println("	ó������ ���ư��ϴ�.");
			flag=false;
			break;	
		}
		
	
		}
	}

