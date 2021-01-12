package snackBar;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Order{
   SaveSnack ss = new SaveSnack();
   
   //�ʵ�
   public static List<SaveSnack> sSave = new ArrayList<>(); //������ 
	// �ʵ�
	// ���� ����
   private String[] sFood = {"������������", "ī��� ����", "�÷��� �ֵ���", "���� ��¡�� ����", "ĥ��ġ�� ����"};
   private int[] lfPrice = {0, 5500, 4000, 5000, 3500};
   //���� ����
   private String[] sJuice = {"������������", "ź������", "�Ƹ޸�ī��", "���� ���̵�", "������ ���̽�Ƽ"};
   private int[] ljPrice = {0, 1500, 2000, 2500, 3500, 2500};
   //���� ����
   private String[] sGoods = {"�������� ����", "�����̴��� ���", "��� �����", "�ظ����� ������", "��Ű���콺 Ƽ����"};
   private int[] ldPrice = {0, 15000, 6500, 18000, 20000};

	private boolean addflag = false;
	private int total = 0;

	private Scanner scan = new Scanner(System.in);

	// Method
	 public int intro(){
	        int menu = 0;
	        System.out.println("   ***     Snack Bar      ***");
	        System.out.println();
	      System.out.println("     ��������������������������������������������������������������������������������");
	      System.out.println("     ��      [1. �ֹ��ϱ�]    [2. �ڷΰ���]      ��");
	      System.out.println("     ��������������������������������������������������������������������������������");
	        System.out.println();
	        System.out.print("   �޴��� �������ּ��� : ");
	        menu = scan.nextInt();
	        System.out.println();
	        System.out.println("============================================");
	        System.out.println();
	        return menu;
	    }

	public void snackbarList() {
		System.out.println("-----����Ʈ�ó׸� ������-----");
		// Ǫ��
		System.out.println("<����>");
		for (int idx = 1; idx < this.sFood.length; idx++) {

			System.out.print(idx + "." + this.sFood[idx] + " " + this.lfPrice[idx] + "��  ");
			System.out.println();
		}
		// ����
		System.out.println("<����>");
		for (int idx = 1; idx < this.sJuice.length; idx++) {
			System.out.print(idx + "." + this.sJuice[idx] + " " + this.ljPrice[idx] + "��  ");
			System.out.println();
		}

		// ����
		System.out.println("<��ǰ>");
		for (int idx = 1; idx < this.sGoods.length; idx++) {
			System.out.print(idx + "." + this.sGoods[idx] + " " + this.ldPrice[idx] + "��  ");
			System.out.println();
		}
		System.out.println("");
		System.out.println("�١ڷα��� �� �������ּ���ڡ�");
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
	           System.out.print(idx + "."+this.sFood[idx] + "  ------  " + this.lfPrice[idx] + "��  ");
	           }
	        }
	        
	        
	        System.out.println();
	        System.out.println();
	        System.out.print("	������ �������ּ��� : ");
	        num = scan.nextInt();
	        System.out.println();
	        
	        System.out.println();
	        System.out.println("*** "+ sFood[num] + "�� �ֹ��� �Ϸ�Ǿ����ϴ�.");
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
	            System.out.print(idx + "." + this.sJuice[idx] + "  ------  "  + this.ljPrice[idx] + "��  ");}
	        }
	        System.out.println();
	        System.out.println();
	        System.out.print("	���Ḧ �������ּ��� : ");
	        num = scan.nextInt();
	        System.out.println();
	        System.out.println("*** "+ sJuice[num] + "�� �ֹ��� �Ϸ�Ǿ����ϴ�.");
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
	            System.out.print(idx + "." + this.sGoods[idx] + "  ------  " + this.ldPrice[idx] + "��  ");
	           }
	        }
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.print("	��� �������ּ��� : ");
	        num = scan.nextInt();
	        scan.nextLine();
	        System.out.println();
	        System.out.println("*** "+ sGoods[num] + "�� �ֹ��� �Ϸ�Ǿ����ϴ�.");
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
	        System.out.println("	***  �Ѿ� : "+this.total + "���� ���Խ��ϴ�     ***");
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

			if (menu == 1) { // �ֹ��ϱ�
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

			} else if (menu == 2) { // ����ϰ� ������
//                order.price_display();
				brunning = false;
			}
		}
	}
}
