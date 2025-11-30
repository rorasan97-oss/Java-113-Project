
package gamestore;

import java.io.*;

public class Purchase implements Serializable { 
    
    private ProductNode headProduct;      
    private int numOFProducts;
    private int maxProducts = 4;          
    
    private Customer costumer;
    
    public Purchase(Customer costumer) {
        this.costumer = new Customer(costumer.getCustomerID(), costumer.getCustomerName());
        headProduct = null;
        numOFProducts = 0;
    }
    
    public int countProducts() {
        if (headProduct == null)
            return 0;
        
        int count = 0;
        ProductNode current = headProduct;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean addProducts(Products p) {
        if (countProducts() < maxProducts) {

            Products newProduct = null;
            
            if (p instanceof VideoGame)
                newProduct = new VideoGame((VideoGame) p);
            else if (p instanceof Console)
                newProduct = new Console((Console) p);
            else if (p instanceof ElectronicItem)
                newProduct = new ElectronicItem((ElectronicItem) p);

            ProductNode n = new ProductNode(newProduct);
            
            n.setNext(headProduct);
            headProduct = n;
            
            numOFProducts++;
            return true;
        } 
        else {
            System.out.println("Your cart is full");
            return false;
        }
    }

    public int searchProducts(String ProductName) {
        
        int index = 0;
        ProductNode current = headProduct;
        
        while (current != null) {
            if (current.getData().getProductName().equals(ProductName))
                return index;
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public boolean removeProducts(String ProductName) {

        if (headProduct == null)
            return false;

        if (headProduct.getData().getProductName().equals(ProductName)) {
            headProduct = headProduct.getNext();
            numOFProducts--;
            return true;
        }

        ProductNode prev = headProduct;
        ProductNode current = headProduct.getNext();

        while (current != null) {
            if (current.getData().getProductName().equals(ProductName)) {
                prev.setNext(current.getNext());
                numOFProducts--;
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        return false;
    }

    public double calculateTotalPrice() {
        double TotalPrice = 0;
        
        ProductNode current = headProduct;
        while (current != null) {
            TotalPrice += current.getData().calculatePrice();
            current = current.getNext();
        }
        return TotalPrice;
    }

    public String toString() {
        String str = "Customer Name: :" + costumer.getCustomerName() + 
                     "\n Customer ID:" + costumer.getCustomerID()
                   + "\n======================================\nThe product name       The product price\n";

        ProductNode current = headProduct;
        while (current != null) {
            str += current.getData().toString() + "\n";
            current = current.getNext();
        }
        
        str += "Number of products:" + numOFProducts +
               "    The total price after discounts:" + calculateTotalPrice();
        
        return str;
    }


    public void saveToFile() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("receipt.ser"));
        out.writeObject(this);   
        out.close();
    } 

    public Purchase loadFromFile() {
        try {
         
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("receipt.ser"));

            Purchase loadedPurchase = (Purchase) in.readObject();
            in.close();

            File txt = new File("receipt_readable.txt");
            FileOutputStream fos = new FileOutputStream(txt);
            PrintWriter pr = new PrintWriter(fos);

            pr.println("======== LOADED RECEIPT ========");
            pr.println("Customer Name: " + loadedPurchase.costumer.getCustomerName());
            pr.println("Customer ID: " + loadedPurchase.costumer.getCustomerID());
            pr.println("--------------------------------");

            ProductNode current = loadedPurchase.headProduct;
            while (current != null) {
                if (current.getData() != null) {
                    pr.println(current.getData());
                }
                current = current.getNext();
            }

            pr.println("--------------------------------");
            pr.println("Total Products: " + loadedPurchase.numOFProducts);
            pr.println("Total Price: " + loadedPurchase.calculateTotalPrice());
            pr.println("================================");

            pr.close();

            System.out.println("A readable receipt was created: receipt_readable.txt");

            return loadedPurchase;

        } catch (FileNotFoundException e) {
            System.out.println("No previous receipt saved.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class mismatch.");
        }

        return null;
    }
}


