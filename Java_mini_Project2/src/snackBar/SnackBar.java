package snackBar;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Order{
   SaveSnack ss = new SaveSnack();
   
   //필드
   public static List<SaveSnack> sSave = new ArrayList<>(); //스낵바 
	// 필드
	// 스낵 음식
   private String[] sFood = {"선택하지않음", "카라멜 팝콘", "플레인 핫도그", "버터 오징어 구이", "칠리치즈 나쵸"};
   private int[] lfPrice = {0, 5500, 4000, 5000, 3500};
   //스낵 음료
   private String[] sJuice = {"선택하지않음", "탄산음료", "아메리카노", "레몬 에이드", "복숭아 아이스티"};
   private int[] ljPrice = {0, 1500, 2000, 2500, 3500, 2500};
   //스낵 굿즈
   private String[] sGoods = {"선택하지 않음", "스파이더맨 담요", "쥬디 당근펜", "해리포터 지팡이", "미키마우스 티셔츠"};
   private int[] ldPrice = {0, 15000, 6500, 18000, 20000};

	private boolean addflag = false;
	private int total = 0;

	private Scanner scan = new Scanner(System.in);

	// Method
	 public int intro(){
	        int menu = 0;
	        System.out.println("   ***     Snack Bar      ***");
	        System.out.println();
	      System.out.println("     ┌──────────────────────────────────────┐");
	      System.out.println("     │      [1. 주문하기]    [2. 뒤로가기]      │");
	      System.out.println("     └──────────────────────────────────────┘");
	        System.out.println();
	        System.out.print("   메뉴를 선택해주세요 : ");
	        menu = scan.nextInt();
	        System.out.println();
	        System.out.println("============================================");
	        System.out.println();
	        return menu;
	    }

	public void snackbarList() {
		System.out.println("-----♡비트시네마 매점♡-----");
		// 푸드
		System.out.println("<간식>");
		for (int idx = 1; idx < this.sFood.length; idx++) {

			System.out.print(idx + "." + this.sFood[idx] + " " + this.lfPrice[idx] + "원  ");
			System.out.println();
		}
		// 음료
		System.out.println("<음료>");
		for (int idx = 1; idx < this.sJuice.length; idx++) {
			System.out.print(idx + "." + this.sJuice[idx] + " " + this.ljPrice[idx] + "원  ");
			System.out.println();
		}

		// 굿즈
		System.out.println("<상품>");
		for (int idx = 1; idx < this.sGoods.length; idx++) {
			System.out.print(idx + "." + this.sGoods[idx] + " " + this.ldPrice[idx] + "원  ");
			System.out.println();
		}
		System.out.println("");
		System.out.println("☆★로그인 후 구매해주세요★☆");
		System.out.println("");
	}

	 public int order_food(){
	        int num = 0;
	        System.out.println("*** Snack Menu");
	        for(int idx = 0; idx < this.sFood.length; idx++){
	           System.out.println();
	           if(idx == 0) {
	              System.out.print(idx + "."+this.sFood[idx]);
	           }else {
	           System.out.print(idx + "."+this.sFood[idx] + "  ------  " + this.lfPrice[idx] + "원  ");
	           }
	        }
	        
	        
	        System.out.println();
	        System.out.println();
	        System.out.print("	음식을 선택해주세요 : ");
	        num = scan.nextInt();
	        System.out.println();
	        
	        System.out.println();
	        System.out.println("*** "+ sFood[num] + "의 주문이 완료되었습니다.");
	        System.out.println();
	        this.total += this.lfPrice[num];
	        ss.FoodSave(sFood[num]);
	        return num;
	        //ss.FoodSave = Integer.toString(num);
	       
	        
	    }
	    public int order_juice(){
	    	System.out.println("============================================");
	        int num = 0;
	        System.out.println();
	        System.out.println("*** Drink Menu");
	        System.out.println();
	        for(int idx = 0; idx < this.sJuice.length; idx++){
	           if(idx == 0) {
	              System.out.print(idx + "."+this.sJuice[idx]);
	           }else {   
	           System.out.println();
	            System.out.print(idx + "." + this.sJuice[idx] + "  ------  "  + this.ljPrice[idx] + "원  ");}
	        }
	        System.out.println();
	        System.out.println();
	        System.out.print("	음료를 선택해주세요 : ");
	        num = scan.nextInt();
	        System.out.println();
	        System.out.println("*** "+ sJuice[num] + "의 주문이 완료되었습니다.");
	        System.out.println();
	        System.out.println("============================================");
	        System.out.println();
	        this.total += this.ljPrice[num];
	        ss.JuiceSave(sJuice[num]);
	        return num;
	        
	    }
	    
	    public int order_goods(){
	        int num = 0;
	        System.out.println();
	        System.out.println("*** Goods Menu");
	        System.out.println();
	        for(int idx = 0; idx < this.sGoods.length; idx++){
	           if(idx == 0) {
	              System.out.print(idx + "."+this.sGoods[idx]);
	           }else {
	              System.out.println();
	            System.out.print(idx + "." + this.sGoods[idx] + "  ------  " + this.ldPrice[idx] + "원  ");
	           }
	        }
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.print("	굿즈를 선택해주세요 : ");
	        num = scan.nextInt();
	        scan.nextLine();
	        System.out.println();
	        System.out.println("*** "+ sGoods[num] + "의 주문이 완료되었습니다.");
	        System.out.println();
	        System.out.println("============================================");
	        System.out.println();
	        this.total += this.ldPrice[num];
	        ss.GoodsSave(sGoods[num]);
	        sSave.add(ss);    //
	        return num;
	        
	    }
	 
	    public int add_food(){
	        addflag = true;
	        
	        return this.order_food();
	    }
	    
	    public int add_juice(){
	        addflag = true;
	        
	        return this.order_juice();
	    }
	    
	    public int add_goods(){
	        addflag = true;
	        
	        return this.order_goods();
	    }
	 
	    public void price_display(){
	        System.out.println("	***  총액 : "+this.total + "원이 나왔습니다     ***");
	      //  scan.close();
	    }

}

public class SnackBar extends Order {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		mainOrder();

	}

	public static void mainOrder() {
		Order order = new Order();
		CardNum cardNum = new CardNum();
		boolean brunning = true;
		int menu = 1;
		int lnumfood = 0;
		int lnumjuice = 0;
		int lnumdessert = 0;
		boolean addflag = false;
		boolean orderflag = false;
		while (brunning) {
			menu = order.intro();

			if (menu == 1) { // 주문하기
				if (addflag == false) {
					if (orderflag == false) {
						lnumfood = order.order_food();
						lnumjuice = order.order_juice();
						lnumdessert = order.order_goods();
					}
				}
				orderflag = true;
				order.price_display();
				cardNum.View();

			} else if (menu == 2) { // 계산하고 나가기
//                order.price_display();
				brunning = false;
			}
		}
	}
}
