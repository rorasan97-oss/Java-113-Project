import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.awt.geom.RoundRectangle2D;


public class GameStore extends JFrame implements ActionListener {
	
	private JLabel textLabel;
	private JLabel textLabel2;
	private JLabel textLabel3;
	private JLabel textLabel4;
	private JTextField inputNAME;
	private JTextField inputID;
	private JLabel textLabelName;
	private JLabel textLabelID;
	private JButton start;
	private JPanel loginPanel;
	private JPanel mainMenuPanel;
	private JButton Exit;
	private JButton LoadPreviousReceipt;
	private JButton SaveReceiptToFile ;
	private JButton DisplayInvoice;
	private JButton SearchProduct;
	private JButton removeproduct;
	private JButton addProduct;
    private String IDGUI;
    private String nameGUI;
    private Customer customer1;
    private  Purchase purchase1;
	
	
	
	



    public static void main(String[] args) {
    	GameStore frame = new GameStore ();
    		frame.setVisible(true);
    	
        Scanner input = new Scanner(System.in);

        System.out.println("_________ Welcome to our Games Shop _________");
        System.out.println("Enter your name and your ID respectively: ");
        String name = input.next();
        String ID = input.next();

        Customer customer = new Customer(ID, name);
        Purchase purchase = new Purchase(customer);

        int choice = 0;

        do {
            System.out.println(" ================== Main Menu ===================");
            System.out.println("1 - add Product ");
            System.out.println("2 - remove product");
            System.out.println("3 - search product ");
            System.out.println("4 - Display invoice  "); 
            System.out.println("5- Save receipt to file  "); 
            System.out.println("6- Load previous receipt  "); 
            System.out.println("7- Exit ");
            System.out.println("-------------------------------------------------");
            System.out.println("Choose an option:");

            boolean valid = false;
            while (!valid) {
                try {
                    choice = input.nextInt();
                    validateMenuChoice(choice);
                    valid = true;
                } catch (InvalidProductException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please enter a correct menu option:");
                }
            }

            switch (choice) {

                case 1:
                    System.out.println("What type of product do you want to add?");
                    System.out.println("1 - Video Game");
                    System.out.println("2 - Electronic Item");
                    int type = input.nextInt();

                    while (type != 1 && type != 2) {
                        System.out.println("Incorrect input, rewrite again");
                        type = input.nextInt();
                    }

                    switch (type) {

                        case 1:
                            System.out.println("Game name --- price --- type");
                            System.out.println("Mario (M) --- 50$ --- digital (D) or physical (P)");
                            System.out.println("Sonic (S) --- 30$ --- digital (D) or physical (P)");

                            char namegame = ' ';
                            boolean validName = false;

                            while (!validName) {
                                try {
                                    System.out.println("Enter name (M or S):");
                                    namegame = input.next().charAt(0);

                                    if (namegame != 'M' && namegame != 'm' &&
                                        namegame != 'S' && namegame != 's') {

                                        throw new InvalidProductNameException("Invalid game name! Please enter M or S.");
                                    }

                                    validName = true;

                                } catch (InvalidProductNameException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            System.out.println("Enter type (D or P):");
                            char typeofgame = input.next().charAt(0);

                            while (typeofgame != 'D' && typeofgame != 'd' &&
                                   typeofgame != 'P' && typeofgame != 'p') {

                                System.out.println("Incorrect input, please enter D or P:");
                                typeofgame = input.next().charAt(0);
                            }

                            if (namegame == 'M' || namegame == 'm') {
                                VideoGame v1 = new VideoGame(typeofgame, "Mario", 50);
                                if (purchase.addProducts(v1))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");

                            } else {
                                VideoGame v2 = new VideoGame(typeofgame, "Sonic", 30);
                                if (purchase.addProducts(v2))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");
                            }
                            break;

                        case 2:
                            System.out.println("item name --- price --- year of release");
                            System.out.println("Console (1) --- 1000$ --- 2013 (3) or 2020 (0)");
                            System.out.println("Controller (2) --- 500$ --- 2014 (4) or 2025 (5)");
                            System.out.println("Enter the number of the name and year:");

                            int ename = input.nextInt();
                            int year = input.nextInt();

                            if (ename == 1) {
                                System.out.println("Choose storage:");
                                System.out.println("(1) 256 GB or (2) 512 GB");
                                int storage = input.nextInt();

                                System.out.println("(Y) with CD Port or (N) without CD Port");
                                char cd = input.next().charAt(0);

                                if (storage == 1) storage = 256;
                                else storage = 512;
                                if(year == 3)
                              	  year =2013;
                          	  else
                          		  if(year == 0)
                                  	  year =2020;
                                Console e1 = new Console(storage, cd, year, "Console", 1000);
                                if (purchase.addProducts(e1))
                                    System.out.println("Added successfully");
                                else
                                    System.out.println("We cannot add it");

                            } if(ename == 2){
                          	  
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

                case 2:
                    System.out.println("What type of product do you want to remove?");
                    System.out.println("1 - Mario  2 - Sonic  3 - Controller  4 - Console");

                    int kind = input.nextInt();
                    while (kind < 1 || kind > 4) {
                        System.out.println("Incorrect input, rewrite again");
                        kind = input.nextInt();
                    }

                    String toRemove =
                        (kind == 1) ? "Mario" :
                        (kind == 2) ? "Sonic" :
                        (kind == 3) ? "Controller" :
                                      "Console";

                    if (purchase.removeProducts(toRemove))
                        System.out.println("Removed Successfully");
                    else
                        System.out.println("Item not found");
                    break;

                case 3:
                    System.out.println("What type of product do you want to search?");
                    System.out.println("1 - Mario  2 - Sonic  3 - Controller  4 - Console");

                    int search = input.nextInt();
                    while (search < 1 || search > 4) {
                        System.out.println("Incorrect input, rewrite again");
                        search = input.nextInt();
                    }

                    String searchName =
                        (search == 1) ? "Mario" :
                        (search == 2) ? "Sonic" :
                        (search == 3) ? "Controller" :
                                        "Console";

                    if (purchase.searchProducts(searchName) != -1)
                        System.out.println("Item found");
                    else
                        System.out.println("Not found");
                    break;

                case 4:
                    System.out.println("\n========== PURCHASE RECEIPT ==========");
                    System.out.println(purchase);
                    System.out.println("======================================");
                    break;

                case 5:
                    try {
                        purchase.saveToFile();
                        System.out.println("Receipt saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Error saving receipt: " + e.getMessage());
                    }
                    break;

                case 6:
                    Purchase loaded = purchase.loadFromFile();
                    if (loaded != null) {
                        System.out.println("=== Loaded Previous Receipt ===");
                        System.out.println(loaded);
                    }
                    break;

                case 7:
                    System.out.println("We will be happy to see you again!");
                    break;
            }

        } while (choice != 7);
    }

    public  static void validateMenuChoice(int choice) throws InvalidProductException {
        if (choice < 1 || choice > 7)
            throw new InvalidProductException("Menu choice must be between 1 and 7.");
    }
    public GameStore()
    {

    	setSize(500,400);
    	setResizable(false);
    	setTitle("Game store");
    	setLocation(150,250);
    	 getContentPane().setLayout(new GridBagLayout());    	
    	 getContentPane().setBackground(Color.decode("#F8F2DE"));
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 loginPanel();
    	
    }
    public void loginPanel()
    {
    	loginPanel	= new JPanel(new  GridBagLayout());
    	loginPanel.setBackground(Color.decode("#F8F2DE"));
    	GridBagConstraints layoutEdit = new  GridBagConstraints();
    	layoutEdit.fill =GridBagConstraints.HORIZONTAL;
    	//=========================================//
    	textLabel = new  JLabel("Welcome to our Games Shop ",JLabel.CENTER);
    	textLabel.setFont(new Font("Serif",Font.BOLD,18));
    	textLabel.setForeground(Color.decode("#1D1616"));
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=0;
    	layoutEdit.gridwidth =2;
    	layoutEdit.insets = new Insets(0,0,30,0);
    	loginPanel.add(textLabel,layoutEdit);
    	//=========================================//
    	textLabelName = new JLabel("Your Name");
    	textLabelName.setFont(new Font("Serif",Font.BOLD,15));
    	textLabelName.setForeground(Color.decode("#B82132"));		
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=1;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,0,5,10);
    	loginPanel.add(textLabelName,layoutEdit);
    	inputNAME = new JTextField();
    	layoutEdit.gridx =1;
    	layoutEdit.gridy=1;
    	layoutEdit.insets = new Insets(0,0,5,0);
    	loginPanel.add(inputNAME,layoutEdit);
    	inputNAME .addActionListener(this);
    	textLabelID = new JLabel("Your ID");
    	textLabelID.setFont(new Font("Serif",Font.BOLD,15));
    	textLabelID.setForeground(Color.decode("#B82132"));		
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=2;
    	layoutEdit.insets = new Insets(0,0,5,10);
    	loginPanel.add(textLabelID,layoutEdit);
    	inputID = new JTextField();
    	layoutEdit.gridx =1;
    	layoutEdit.gridy=2;
    	layoutEdit.insets = new Insets(0,0,20,0);
    	loginPanel.add(inputID ,layoutEdit);
    	inputID.addActionListener(this);
    	//=========================================//
    	textLabel2 = new  JLabel("After you fill the to fildes press Start Button",JLabel.CENTER);
    	textLabel2.setFont(new Font("Serif",Font.PLAIN,12));
    	textLabel2.setForeground(Color.decode("#D34E4E"));
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=3;
    	layoutEdit.gridwidth =2;
    	layoutEdit.insets = new Insets(0,0,25,0);
    	loginPanel.add(textLabel2,layoutEdit);
    	//=========================================//
    	start = new JButton("Start");
    	start.setFont(new Font("Serif",Font.BOLD,15));
    	start.setForeground(Color.WHITE);
    	start.setBackground(Color.decode("#B82132"));
    	start.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=4;
    	layoutEdit.gridwidth =2;
    	layoutEdit.insets = new Insets(5,0,0,0);
    	loginPanel.add(start,layoutEdit);
    	start.addActionListener(this);
    	getContentPane().add(loginPanel);

    }
    public void actionPerformed(ActionEvent event)
    {
         
    	if(event.getSource() instanceof JButton)
      { 
    		JButton  active = (JButton) event.getSource();
    		  nameGUI =inputNAME.getText().trim() ;
              IDGUI= inputID.getText().trim() ;
             if(nameGUI.isEmpty() || IDGUI.isEmpty())
             {
            	 JOptionPane.showMessageDialog(this,"Please fill all fields");
             return;
             }
             customer1= new Customer(IDGUI, nameGUI);
             purchase1 = new Purchase(customer1);
             JOptionPane.showMessageDialog(this,"Customer with :\n name : "+nameGUI+"  ,ID: "+IDGUI+" \ncreated successfully ");
             showMainMenuPanel();
         
             
      }

    }
    public void mainMenuPanel()
    {
    	mainMenuPanel	= new JPanel(new  GridBagLayout());
    	mainMenuPanel.setBackground(Color.decode("#F8F2DE"));
    	GridBagConstraints layoutEdit = new  GridBagConstraints();
    	layoutEdit.fill =GridBagConstraints.HORIZONTAL;
    	//=========================================//
    	textLabel3 = new  JLabel("Main Menu  ",JLabel.CENTER);
    	textLabel3 .setFont(new Font("Serif",Font.BOLD,40));
    	textLabel3 .setForeground(Color.decode("#B82132"));
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=0;
    	layoutEdit.gridwidth =3;
    	layoutEdit.insets = new Insets(0,40,10,0);
    	mainMenuPanel.add(textLabel3 ,layoutEdit);    	
    	//=========================================//
    	textLabel4 = new  JLabel("Customer name : "+nameGUI+"  ,ID: "+IDGUI,JLabel.CENTER);
    	textLabel4 .setFont(new Font("Serif",Font.BOLD,12));
    	textLabel4 .setForeground(Color.decode("#D34E4E"));
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=1;
    	layoutEdit.gridwidth =3;
    	layoutEdit.insets = new Insets(0,0,10,0);
    	mainMenuPanel.add(textLabel4 ,layoutEdit);
    	//=========================================//
    	addProduct= new JButton("add Product");
    	addProduct.setFont(new Font("Serif",Font.BOLD,15));
    	addProduct.setForeground(Color.WHITE);
    	addProduct.setBackground(Color.decode("#D34E4E"));
    	addProduct.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=2;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(addProduct,layoutEdit);
    	addProduct.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	removeproduct= new JButton("remove product");
    	removeproduct.setFont(new Font("Serif",Font.BOLD,15));
    	removeproduct.setForeground(Color.WHITE);
    	removeproduct.setBackground(Color.decode("#D34E4E"));
    	removeproduct.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=3;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(removeproduct,layoutEdit);
    	removeproduct.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	SearchProduct= new JButton("Search product");
    	SearchProduct.setFont(new Font("Serif",Font.BOLD,15));
    	SearchProduct.setForeground(Color.WHITE);
    	SearchProduct.setBackground(Color.decode("#D34E4E"));
    	SearchProduct.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=4;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(SearchProduct,layoutEdit);
    	SearchProduct.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	DisplayInvoice= new JButton("Display invoice");
    	DisplayInvoice.setFont(new Font("Serif",Font.BOLD,15));
    	DisplayInvoice.setForeground(Color.WHITE);
    	DisplayInvoice.setBackground(Color.decode("#D34E4E"));
    	DisplayInvoice.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=5;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(DisplayInvoice,layoutEdit);
   	    DisplayInvoice.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	SaveReceiptToFile = new JButton("Save receipt to file ");
    	SaveReceiptToFile.setFont(new Font("Serif",Font.BOLD,15));
    	SaveReceiptToFile.setForeground(Color.WHITE);
    	SaveReceiptToFile.setBackground(Color.decode("#D34E4E"));
    	SaveReceiptToFile.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=6;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(SaveReceiptToFile,layoutEdit);
    	SaveReceiptToFile.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	LoadPreviousReceipt= new JButton("Load previous receipt");
    	LoadPreviousReceipt.setFont(new Font("Serif",Font.BOLD,15));
    	LoadPreviousReceipt.setForeground(Color.WHITE);
    	LoadPreviousReceipt.setBackground(Color.decode("#D34E4E"));
    	LoadPreviousReceipt.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=7;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(LoadPreviousReceipt,layoutEdit);
    	LoadPreviousReceipt.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	Exit= new JButton("Exit");
    	Exit.setFont(new Font("Serif",Font.BOLD,15));
    	Exit.setForeground(Color.WHITE);
    	Exit.setBackground(Color.decode("#D34E4E"));
    	Exit.setFocusPainted(false);
    	layoutEdit.gridx =0;
    	layoutEdit.gridy=8;
    	layoutEdit.gridwidth =1;
    	layoutEdit.insets = new Insets(0,50,5,5);
    	mainMenuPanel.add(Exit,layoutEdit);
    	Exit.addActionListener(this:: actionPerformedMenu);
    	//=========================================//
    	getContentPane().add(mainMenuPanel);
    	
    }
    public void showMainMenuPanel()
    {
    	getContentPane().removeAll();
    	mainMenuPanel();
    	revalidate();
    	repaint();
    }
    public void actionPerformedMenu(ActionEvent event)
    {
    	String  clicked = ((JButton) event.getSource()).getText();
    	 

    	switch(clicked)
    	{
    	case "add Product":
                JRadioButton VideoGame = new JRadioButton("Video Game");
                JRadioButton ElectronicItem= new JRadioButton("Electronic Item");
                ButtonGroup items =  new  ButtonGroup();
                items.add(VideoGame);
                items.add(ElectronicItem);
                VideoGame.setSelected(true);
                JPanel itemsPanel = new JPanel(new GridLayout(0,1));
                itemsPanel.add(new JLabel("What type of product do you want to add?"));
                itemsPanel.add(VideoGame);
                itemsPanel.add(ElectronicItem);
                int show = JOptionPane.showConfirmDialog(this,itemsPanel,"add",JOptionPane.OK_CANCEL_OPTION);
                if(show==JOptionPane.OK_OPTION)
                {
                	if(VideoGame.isSelected())
                	{
                		JRadioButton Mario = new JRadioButton("Mario (50$)");
                		JRadioButton Sonic = new JRadioButton("Sonic(50$)");
                        ButtonGroup items1 =  new  ButtonGroup();
                        items1.add(Mario);
                        items1.add(Sonic);
                        Mario.setSelected(true);
                        JPanel itemsPanel1 = new JPanel(new GridLayout(0,1));
                        itemsPanel1.add(new JLabel("What game would you like to add?"));
                        itemsPanel1.add(Sonic);
                        itemsPanel1.add(Mario);
                        int show1 = JOptionPane.showConfirmDialog(this,itemsPanel1,"games",JOptionPane.OK_CANCEL_OPTION);
                        if(show1==JOptionPane.OK_OPTION)
                        {
                        	if(Mario.isSelected())
                        	{
                             JRadioButton physical = new JRadioButton("physical");
                    		JRadioButton digital = new JRadioButton("digital");
                            ButtonGroup items2 =  new  ButtonGroup();
                            items2.add(digital);
                            items2.add(physical);
                            digital.setSelected(true);
                            JPanel itemsPanel2 = new JPanel(new GridLayout(0,1));
                            itemsPanel2.add(new JLabel("What game would you like to add?"));
                            itemsPanel2.add(physical);
                            itemsPanel2.add(digital);
                            int show2 = JOptionPane.showConfirmDialog(this,itemsPanel2,"games",JOptionPane.OK_CANCEL_OPTION);
                            if(show2==JOptionPane.OK_OPTION)
                            {
                            	if(physical.isSelected())
                            	{
                            		VideoGame v1 = new VideoGame('P', "Mario", 50);
                                    if (purchase1.addProducts(v1))
                                    	JOptionPane.showMessageDialog(this,"Added successfully");

                                    else
                                     	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                            	}
                            	else
                            		if(digital.isSelected())
                                	{
                                		VideoGame v2 = new VideoGame('D', "Mario", 50);
                                        if (purchase1.addProducts(v2))
                                        	JOptionPane.showMessageDialog(this,"Added successfully");

                                        else
                                         	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                	}
                            }
                        	}
                        	if(Sonic.isSelected())
                        	{
                             JRadioButton physical = new JRadioButton("physical");
                    		JRadioButton digital = new JRadioButton("digital");
                            ButtonGroup items2 =  new  ButtonGroup();
                            items2.add(digital);
                            items2.add(physical);
                            digital.setSelected(true);
                            JPanel itemsPanel2 = new JPanel(new GridLayout(0,1));
                            itemsPanel2.add(new JLabel("What game would you like to add?"));
                            itemsPanel2.add(physical);
                            itemsPanel2.add(digital);
                            int show2 = JOptionPane.showConfirmDialog(this,itemsPanel2,"games",JOptionPane.OK_CANCEL_OPTION);
                            if(show2==JOptionPane.OK_OPTION)
                            {
                            	if(physical.isSelected())
                            	{
                            		VideoGame v3 = new VideoGame('P', "Sonic", 50);
                                    if (purchase1.addProducts(v3))
                                    	JOptionPane.showMessageDialog(this,"Added successfully");

                                    else
                                     	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                            	}
                            	else
                            		if(digital.isSelected())
                                	{
                                		VideoGame v4 = new VideoGame('D', "Sonic", 50);
                                        if (purchase1.addProducts(v4))
                                        	JOptionPane.showMessageDialog(this,"Added successfully");

                                        else
                                         	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                	}
                            }
                        	}
                        	
                        }

                	}
                	else
                		if(ElectronicItem.isSelected())
                		{
                			JRadioButton Controller = new JRadioButton("Controller (500$)");
                    		JRadioButton Console = new JRadioButton("Console(100$)");
                            ButtonGroup items1 =  new  ButtonGroup();
                            items1.add(Console);
                            items1.add(Controller);
                            Console.setSelected(true);
                            JPanel itemsPanel1 = new JPanel(new GridLayout(0,1));
                            itemsPanel1.add(new JLabel("What ElectronicItem would you like to add?"));
                            itemsPanel1.add(Console);
                            itemsPanel1.add(Controller);
                            int show1 = JOptionPane.showConfirmDialog(this,itemsPanel1,"games",JOptionPane.OK_CANCEL_OPTION);
                            if(show1==JOptionPane.OK_OPTION)
                            {
                            	if(Controller.isSelected())
                            	{
                                 JRadioButton YEAR1 = new JRadioButton("2014");
                        		JRadioButton YEAR2 = new JRadioButton("2025");
                                ButtonGroup items2 =  new  ButtonGroup();
                                items2.add(YEAR1);
                                items2.add(YEAR2);
                                YEAR1.setSelected(true);
                                JPanel itemsPanel2 = new JPanel(new GridLayout(0,1));
                                itemsPanel2.add(new JLabel("What is your preferred device release year?"));
                                itemsPanel2.add(YEAR1);
                                itemsPanel2.add(YEAR2);
                                int show2 = JOptionPane.showConfirmDialog(this,itemsPanel2,"games",JOptionPane.OK_CANCEL_OPTION);
                                if(show2==JOptionPane.OK_OPTION)
                                {
                                	if(YEAR1.isSelected())
                                	{
                                        ElectronicItem e3 = new  ElectronicItem(2014 ,"Controller", 500 );
                                        if (purchase1.addProducts(e3))
                                        	JOptionPane.showMessageDialog(this,"Added successfully");

                                        else
                                         	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");

                                	}
                                	else
                                		if(YEAR2.isSelected())
                                    	{
                                            ElectronicItem e4 = new  ElectronicItem(2025,"Controller", 500 );
                                            if (purchase1.addProducts(e4))
                                            	JOptionPane.showMessageDialog(this,"Added successfully");

                                            else
                                             	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                    	}
                                }
                            	}
                            	if(Console.isSelected())
                            	{
                                    JRadioButton YEAR1 = new JRadioButton("2013");
                            		JRadioButton YEAR2 = new JRadioButton("2020");
                                    ButtonGroup items2 =  new  ButtonGroup();
                                    items2.add(YEAR1);
                                    items2.add(YEAR2);
                                    YEAR1.setSelected(true);
                                    JPanel itemsPanel2 = new JPanel(new GridLayout(0,1));
                                    itemsPanel2.add(new JLabel("What is your preferred device release year?"));
                                    itemsPanel2.add(YEAR1);
                                    itemsPanel2.add(YEAR2);
                                    int show2 = JOptionPane.showConfirmDialog(this,itemsPanel2,"games",JOptionPane.OK_CANCEL_OPTION);
                                    if(show2==JOptionPane.OK_OPTION)
                                    {
                                    	if(YEAR1.isSelected())
                                    	{
                                    	  JRadioButton  storage1 = new JRadioButton("512 GB");
                                  		JRadioButton storage2 = new JRadioButton("256 GB");
                                          ButtonGroup items3 =  new  ButtonGroup();
                                          items3.add(storage1);
                                          items3.add(storage2);
                                          storage1.setSelected(true);
                                          JPanel itemsPanel3= new JPanel(new GridLayout(0,1));
                                          itemsPanel3.add(new JLabel("What storage is best for you?"));
                                          itemsPanel3.add(storage1);
                                          itemsPanel3.add(storage2);
                                          int show3 = JOptionPane.showConfirmDialog(this,itemsPanel3,"games",JOptionPane.OK_CANCEL_OPTION);
                                          if(show3==JOptionPane.OK_OPTION)
                                          {
                                        	  if(storage1.isSelected())
                                        	  {
                                          	  JRadioButton  cd = new JRadioButton("with CD Port");
                                        		JRadioButton nocd = new JRadioButton("without CD Port");
                                                ButtonGroup items4=  new  ButtonGroup();
                                                items4.add(cd);
                                                items4.add(nocd);
                                                cd.setSelected(true);
                                                JPanel itemsPanel4= new JPanel(new GridLayout(0,1));
                                                itemsPanel4.add(new JLabel("without CD Port OR with CD Port"));
                                                itemsPanel4.add(cd);
                                                itemsPanel4.add(nocd);
                                                int show4 = JOptionPane.showConfirmDialog(this,itemsPanel4,"games",JOptionPane.OK_CANCEL_OPTION);
                                                if(show4==JOptionPane.OK_OPTION)
                                                {
                                                	if(cd.isSelected())
                                                	{
                                                        Console e1 = new Console(512, 'Y', 2013, "Console", 1000);
                                                         if (purchase1.addProducts(e1))
                                                         	JOptionPane.showMessageDialog(this,"Added successfully");

                                                         else
                                                          	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                                	}
                                                	
                                                }
                                        	  }  
                                          }
                                    	}
                                    	else
                                    		if(YEAR2.isSelected())
                                        	{
                                        	  JRadioButton  storage1 = new JRadioButton("512 GB");
                                      		JRadioButton storage2 = new JRadioButton("256 GB");
                                              ButtonGroup items3 =  new  ButtonGroup();
                                              items3.add(storage1);
                                              items3.add(storage2);
                                              storage1.setSelected(true);
                                              JPanel itemsPanel3= new JPanel(new GridLayout(0,1));
                                              itemsPanel3.add(new JLabel("What storage is best for you?"));
                                              itemsPanel3.add(storage1);
                                              itemsPanel3.add(storage2);
                                              int show3 = JOptionPane.showConfirmDialog(this,itemsPanel3,"games",JOptionPane.OK_CANCEL_OPTION);
                                              if(show3==JOptionPane.OK_OPTION)
                                              {
                                            	  if(storage1.isSelected())
                                            	  {
                                              	  JRadioButton  cd = new JRadioButton("with CD Port");
                                            		JRadioButton nocd = new JRadioButton("without CD Port");
                                                    ButtonGroup items4=  new  ButtonGroup();
                                                    items4.add(cd);
                                                    items4.add(nocd);
                                                    cd.setSelected(true);
                                                    JPanel itemsPanel4= new JPanel(new GridLayout(0,1));
                                                    itemsPanel4.add(new JLabel("without CD Port OR with CD Port"));
                                                    itemsPanel4.add(cd);
                                                    itemsPanel4.add(nocd);
                                                    int show4 = JOptionPane.showConfirmDialog(this,itemsPanel4,"games",JOptionPane.OK_CANCEL_OPTION);
                                                    if(show4==JOptionPane.OK_OPTION)
                                                    {
                                                    	if(cd.isSelected())
                                                    	{
                                                            Console e2 = new Console(512, 'Y', 2020, "Console", 1000);
                                                             if (purchase1.addProducts(e2))
                                                             	JOptionPane.showMessageDialog(this,"Added successfully");

                                                             else
                                                              	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                                    	}
                                                    	else
                                                    		if(nocd.isSelected())
                                                        	{
                                                                Console e3 = new Console(512, 'N', 2020, "Console", 1000);
                                                                 if (purchase1.addProducts(e3))
                                                                 	JOptionPane.showMessageDialog(this,"Added successfully");

                                                                 else
                                                                  	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                                        	}
                                                    		
                                                    	
                                                    }
                                            	  }  
                                            	  else
                                            		  if(storage2.isSelected())
                                                	  {
                                                  	  JRadioButton  cd = new JRadioButton("with CD Port");
                                                		JRadioButton nocd = new JRadioButton("without CD Port");
                                                        ButtonGroup items4=  new  ButtonGroup();
                                                        items4.add(cd);
                                                        items4.add(nocd);
                                                        cd.setSelected(true);
                                                        JPanel itemsPanel4= new JPanel(new GridLayout(0,1));
                                                        itemsPanel4.add(new JLabel("without CD Port OR with CD Port"));
                                                        itemsPanel4.add(cd);
                                                        itemsPanel4.add(nocd);
                                                        int show4 = JOptionPane.showConfirmDialog(this,itemsPanel4,"games",JOptionPane.OK_CANCEL_OPTION);
                                                        if(show4==JOptionPane.OK_OPTION)
                                                        {
                                                        	if(cd.isSelected())
                                                        	{
                                                                Console e2 = new Console(256, 'Y', 2020, "Console", 1000);
                                                                 if (purchase1.addProducts(e2))
                                                                 	JOptionPane.showMessageDialog(this,"Added successfully");

                                                                 else
                                                                  	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                                        	}
                                                        	else
                                                        		if(nocd.isSelected())
                                                            	{
                                                                    Console e3 = new Console(256, 'N', 2020, "Console", 1000);
                                                                     if (purchase1.addProducts(e3))
                                                                     	JOptionPane.showMessageDialog(this,"Added successfully");

                                                                     else
                                                                     	JOptionPane.showMessageDialog(this,"We cannot add the item , Your cart is full");
                                                            	}
                                                        		
                                                        	
                                                        }
                                                	  }  
                                              }
                                        	}
                                    }
                            	}
                            	
                            }

                			
                			
                		}
                	
                }
                break;

              
    	case "remove product":
         	JOptionPane.showMessageDialog(this,"Feature coming soon in the GUI! ");
            break;

    		
    	case "Search product":
    		 JRadioButton Mario1 = new JRadioButton("Mario");
             JRadioButton Sonic1= new JRadioButton("Sonic");
             JRadioButton Controller1 = new JRadioButton("Controller");
             JRadioButton Console1= new JRadioButton("Console");
             ButtonGroup items9 =  new  ButtonGroup();
             items9.add(Mario1);
             items9.add(Sonic1);
             items9.add(Controller1);
             items9.add(Console1);
             Console1.setSelected(true);
             JPanel itemsPanel9= new JPanel(new GridLayout(0,1));
             itemsPanel9.add(new JLabel("What type of product do you want to search?"));
             itemsPanel9.add(Console1);
             itemsPanel9.add(Controller1);
             itemsPanel9.add(Sonic1);
             itemsPanel9.add(Mario1);
             int show9 = JOptionPane.showConfirmDialog(this,itemsPanel9,"add",JOptionPane.OK_CANCEL_OPTION);
             if(show9==JOptionPane.OK_OPTION)
             {
            	 if(Mario1.isSelected())
            	 {
            		 if (purchase1.searchProducts("Mario") != -1)
                      	JOptionPane.showMessageDialog(this,"Item found");
                     else
                       	JOptionPane.showMessageDialog(this,"Item not found");
            	 }
            	 else
            		 if(Sonic1.isSelected())
            	 {
            		 if (purchase1.searchProducts("Sonic") != -1)
                      	JOptionPane.showMessageDialog(this,"Item found");
                     else
                       	JOptionPane.showMessageDialog(this,"Item not found");
            	 }
            		 else
                		 if(Controller1.isSelected())
                	 {
                		 if (purchase1.searchProducts("Controller") != -1)
                          	JOptionPane.showMessageDialog(this,"Item found");
                         else
                           	JOptionPane.showMessageDialog(this,"Item not found");
                	 }
                		 else
                    		 if(Console1.isSelected())
                    	 {
                    		 if (purchase1.searchProducts("Console") != -1)
                              	JOptionPane.showMessageDialog(this,"Item found");
                             else
                               	JOptionPane.showMessageDialog(this,"Item not found");
                    	 }

             }

          
            break;

    		
    	case "Display invoice":
         	JOptionPane.showMessageDialog(this,"Feature coming soon in the GUI! ");
            break;

    	case "Save receipt to file ":
         	JOptionPane.showMessageDialog(this,"Feature coming soon in the GUI! ");
            break;

    	case "Load previous receipt":
         	JOptionPane.showMessageDialog(this,"Feature coming soon in the GUI! ");
            break;

    	case "Exit":
         	JOptionPane.showMessageDialog(this,"We will be happy to see you again!^-^ ");
            System.exit(0);

            break;

    		
           
    		
    	
    	
    	}
    		
    	
    	
    }
   
   

	
}
