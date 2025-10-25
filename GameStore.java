import java.util.Scanner;
public class GameStore{
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
System.out.println("_________ Welcome to our Games Shop _________");
System.out.println("Enter your name and your ID respectively: ");
String name = input.next();
String ID = input.next();
Customer customer = new Customer(ID , name);
Purchase purchase = new Purchase(customer);
int choice ; 
do{
System.out.println(" ================== Main Menu ===================");
         System.out.println("1 - add Product ");
         System.out.println("2 - remove product");
         System.out.println("3 - search product ");
         System.out.println("4 - Display invoice  ")  ;     
         System.out.println("5- Exit ");
         System.out.println("-------------------------------------------------");
         System.out.println("  choose an option...");
         choice = input.nextInt();
         while (choice != 1 && choice != 2 && choice != 3 && choice!= 4  && choice !=5){
          System.out.println(" Incorrect input , rewrite again");
          choice = input.nextInt();
}
         switch(choice) {
         case 1:
         System.out.println("What type of product do you want to add?");
         System.out.println("1 - Video Game");
         System.out.println("2 - Electronic Item");
         int type = input.nextInt();
         while (type != 1 && type != 2) {
         System.out.println(" Incorrect input , rewrite again");
         type = input.nextInt();
         }
              switch(type)
               {
                case 1 :
                 System.out.println("Game name --- price --- type");
                 System.out.println("Mario (M) ---  50$  --- digital (D) or physical (P)");
                 System.out.println("Sonic (S) ---  30$  --- digital (D) or physical (P)");
                 System.out.println("Enter name ");
                 char namegame = input.next().charAt(0);
                 while (namegame != 'm' && namegame != 'M'&&namegame != 'S' && namegame != 's') {
                     System.out.println(" Incorrect input , rewrite again");
                     namegame = input.next().charAt(0);
                     }
                 System.out.println("Enter type ");
                 char typeofgame = input.next().charAt(0);
                 while (typeofgame != 'D' && typeofgame != 'd'&&typeofgame != 'P' && typeofgame != 'p') {
                     System.out.println(" Incorrect input , rewrite again");
                     typeofgame = input.next().charAt(0);
                     }
                 
                 if(namegame==('M') || namegame==('m')){
                 
                     VideoGame v1 = new VideoGame(typeofgame ,"Mario", 50 );
                     if(purchase.addProducts(v1))
                      System.out.println("added successfully");
                     else
                     System.out.println("we cannot add it");
                 }
                 else
                    if(namegame==('S') || namegame==('s'))
                     {
                     VideoGame v2 = new VideoGame(typeofgame ,"Sonic", 30 );
                     if(purchase.addProducts(v2))
                      System.out.println("added successfully");
                     else
                     System.out.println("we cannot add it");
                     }
                     break;
                     
                     case 2 :
                      System.out.println(" item name     ---  price --- year of release");
                      System.out.println("Console (1)    ---  1000$ --- 2013 (3) or 2020 (0)");
                      System.out.println("Controller (2) ---  500$  --- 2014 (4) or 2025 (5) ");
                      System.out.println("Enter the number of the name and the number of the year respectively ");
                      int ename = input.nextInt();
                      int year = input.nextInt();
                      if(ename== 1 ){
                         System.out.println("choose storage:");
                          System.out.println("(1) 256 GB or (2) 512 GB");
                          int storage = input.nextInt();
                          System.out.println("(Y) with CD Port or (N) without CD Port");
                          char cd = input.next().charAt(0);
                          if(storage == 1)
                        	  storage =256;
                          else 
                        	  if(storage == 2)
                        		  storage =512;
             
                          Console e1 = new Console(storage , cd , year ,"Console", 1000 );
                          if(purchase.addProducts(e1))
                          System.out.println("added successfully");
                          else
                          System.out.println("we cannot add it");
                      }
                 else
                      if(ename == 2){
                    	  
                        	  if(year == 4)
                            	  year =2014;
                        	  else
                        		  if(year == 5)
                                	  year =2025;
                     ElectronicItem e2 = new  ElectronicItem(year ,"Controller", 500 );
                     if(purchase.addProducts(e2))
                      System.out.println("added successfully");
                     else
                     System.out.println("we cannot add it"); }
                     break;

                
                    }
                    break;
           case 2 :
                      System.out.println("What type of product do you want to remove?");
                      System.out.println("1 - Mario or 2 - Sonic or 3 - Controller 4 - Console");
                      int kind = input.nextInt();
                      while (kind != 1 && kind != 2 && kind != 3&& kind != 4) {
                      System.out.println(" Incorrect input , rewrite again");
                      kind = input.nextInt();}
                      if(kind == 1){
                      if(purchase.removeProducts("Mario"))
                      System.out.println("Removed Successfully");
                      }
                      else if(kind == 2) {
                      if(purchase.removeProducts("Sonic"))
                      System.out.println("Removed Successfully"); }
                      else if(kind == 3) {
                      if(purchase.removeProducts("Controller"))
                      System.out.println("Removed Successfully"); }
                      else if(kind == 4) {
                      if(purchase.removeProducts("Console"))
                      System.out.println("Removed Successfully"); }
                      else
                      System.out.println("the item is not found"); 
                      break;
                      
                       case 3 :
                       System.out.println("What type of product do you want to search?");
                      System.out.println("1 - Mario or 2 - Sonic or 3 - Controller 4 - Console");
                      int search = input.nextInt();
                      while (search != 1 && search != 2 && search != 3&& search != 4) {
                      System.out.println(" Incorrect input , rewrite again");
                      search = input.nextInt();}
                      if(search == 1){
                            if(purchase.searchProducts("Mario") != -1)
                             System.out.println( "Item found");
                      } else 
                     	 if(search == 2) {
                             if(purchase.searchProducts("Sonic") != -1)
                             System.out.println("Item found"); 
                             else
                                 System.out.println("Not found");
                             } else
                           	  if(search == 3) {
                                  if(purchase.searchProducts("Controller") != -1)
                                     System.out.println("Item found");
                                  else
                                      System.out.println("Not found");
                                  }else 
                                	  if(search == 4) {
                                          if(purchase.searchProducts("Console") != -1)
                                          System.out.println("Item found"); 
                                          else
                                              System.out.println("Not found");
                                          }
                      
                        
                   
                      
                     
                      break; 
                      
                      case 4: 
                      System.out.println("\n========== PURCHASE RECEIPT ==========");
                      System.out.println("--------------------------------------");
                      System.out.println(purchase.toString());
                      System.out.println("======================================");
                      System.out.println("We will be happy to see you again!\nhave a nice day^-^");
    break;
    
    
                      case 5:
                    	  System.out.println("We will be happy to see you again!\nhave a nice day^-^");
                    	  break;
                      



              
         }
                     
                      


}while(choice !=5);






}
}