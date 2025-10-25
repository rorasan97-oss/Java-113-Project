public class Purchase {
   private int PurchaseID;
   private Products[] productsList;
   private int numOFProducts;
   private Customer costumer;
    
   public Purchase(Customer costumer)
   {
	   this.costumer = new Customer (costumer.getCustomerID(),costumer.getCustomerName());
	   productsList = new Products[4];
	   numOFProducts =0;
	   PurchaseID++;
	  
   }
public boolean addProducts(Products p)
{
    if (numOFProducts < productsList.length) {
        if (p instanceof VideoGame)
            productsList[numOFProducts++] = new VideoGame((VideoGame) p);
        else if (p instanceof ElectronicItem)
            productsList[numOFProducts++] = new ElectronicItem((ElectronicItem) p);
           /*     else if (p instanceof Console)
            productsList[numOFProducts++] = new Console((Console) p); */

            

        return true;
    } 
    else {
    System.out.println("Your cart is full");
        return false;
    }
}

   public int searchProducts(String ProductName) 
   {
  	 for(int i=0;i<numOFProducts;i++)
  	 {
  		 if(productsList[i].getProductName().equals(ProductName))
  			 return i;
  	 }
  	 return -1;
   }
   public boolean removeProducts(String ProductName)
   {
  	 int indexOfTheProduct = searchProducts(ProductName);
  	 if(indexOfTheProduct !=-1)
  	 { 
  		for(int i= indexOfTheProduct;i<numOFProducts-1;i++)
  			productsList[ i]= productsList[ i+1];
  		   productsList[--numOFProducts]=null;
  			return true;
       }	 
  	 return false;
   }
   public double calculateTotalPrice()
   {
	   double TotalPrice =0;
	   for(int i =0;i<numOFProducts;i++)
		   TotalPrice += productsList[i].calculatePrice() ;
	   return TotalPrice;
   }
   public String toString()
   {
	   
	   String str = "The costumer ID:"+costumer.getCustomerID()+" The costumer Name:"+costumer.getCustomerName()
	   +"\n The Purchase ID:"+PurchaseID+"------------------------------------------------\nThe product name                                      The product price\n";
	   for(int i =0;i<numOFProducts;i++) 
		   str+=productsList[ i].getProductName()+"                                     "+productsList[ i].getPrice()+"\n";
	   str+="Number of prosucts:"+numOFProducts+"    The total price:"+calculateTotalPrice();
	   
	   
	return str;
	
   }
   public int getNumOfProducts() {
    return numOFProducts;
}

   
}
