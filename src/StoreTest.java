import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * The type Store test.
 */
public class StoreTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Type phone = Type.PHN;
        Type casing = Type.ACC;

//        TEST 1
        Store myFirstStore = new Store("St. John's");
        Store mySecondStore = new Store("Gander");


//        TEST 2
        Item apple1 = new Item("Apple","iPhone 5",1500.00,
                    10, phone, myFirstStore);
        Item apple2 = new Item("Apple","iPhone 4 64GB",
                    29,10, phone, myFirstStore);
        Item apple3 = new Item("Apple","iPhone 6",1500.00,
                10, phone, myFirstStore);
        Item apple4 = new Item("Apple","iPhone 7 64GB",
                29,16, phone, myFirstStore);
        Item apple5 = new Item("Apple","iPhone 8",1500.00,
                10, phone, myFirstStore);
        Item apple6 = new Item("Apple","iPhone 9 64GB",
                29,17, phone, myFirstStore);
        Item apple7 = new Item("Apple","iPhone 10",1500.00,
                10, phone, myFirstStore);
        Item apple8 = new Item("Apple","iPhone 11 64GB",
                29,15, phone, myFirstStore);
        Item apple9 = new Item("Apple","iPhone 12",1500.00,
                10, phone, myFirstStore);
        Item apple10 = new Item("Apple","iPhone 13 64GB",
                29,14, phone, myFirstStore);
        Item apple11 = new Item("Apple","iPhone 14 64GB",
                29,0, phone, myFirstStore);

        Item huwawei1 = new Item("Apple","Model 5G",
                540.20,17, phone, mySecondStore);
        Item huwawei2 = new Item("Apple","Model1 5G",
                540.20,10, phone, mySecondStore);
        Item huwawei3 = new Item("Apple","Model2 5G",
                540.20,19, phone, mySecondStore);
        Item huwawei4 = new Item("Apple","Model3 5G",
                540.20,21, phone, mySecondStore);
        Item huwawei5 = new Item("Apple","Model4 5G",
                540.20,13, phone, mySecondStore);
        Item huwawei6 = new Item("Apple","Model5 5G",
                540.20,16, phone, mySecondStore);
        Item huwawei7 = new Item("Apple","Model6 5G",
                540.20,18, phone, mySecondStore);
        Item huwawei8 = new Item("Apple","Model7 5G",
                540.20,32, phone, mySecondStore);
        Item huwawei9 = new Item("Apple","Model8 5G",
                540.20,12, phone, mySecondStore);
        Item huwawei10 = new Item("Apple","Model9 5G",
                540.20,15, phone, mySecondStore);

        myFirstStore.addItemToStore(apple1,apple2, apple3, apple4, apple5,
                apple6, apple7, apple8, apple9, apple10, apple11);

        mySecondStore.addItemToStore(huwawei1, huwawei2, huwawei3, huwawei4,
                huwawei5, huwawei6, huwawei7, huwawei8, huwawei9, huwawei10);

//        TEST 3
        myFirstStore.displayAvailableInventory();
        mySecondStore.displayInventory();


//        TEST 4
        Customer c1 = new Customer("Chinonso", "Mogo",
                "mogononso@gmail.com", "(709)769-8522");
        Customer c2 = new Customer("Jane", "Doe", "janedoe@gmail.com", "(709)777-2233");

        c1.setStore(myFirstStore);
        c2.setStore(myFirstStore);

        Customer c3 = new Customer("John", "Doe",
                "johndoe@gmail.com", "(709)222-2222");
        Customer c4 = new Customer("Mary", "Doe", "marydoe@gmail.com", "(709)333-4444");
        c3.setStore(mySecondStore);
        c4.setStore(mySecondStore);


//        TEST 5
        Invoice inv1 = new Invoice(c1, myFirstStore);
        Invoice inv2 = new Invoice(c1, myFirstStore);
        ArrayList<Item> allItemsFromStore =myFirstStore.getItems();

        try{
            inv1.addItem(StoreTest.fiveRandomItems(allItemsFromStore));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //        TEST 6
        System.out.println("Displaying invoice before checking quantity>>>>>");
        inv1.displayInvoice();
        System.out.println("\nChecking to confirm quantity reduced quantity>>>>>>");
        myFirstStore.displayInventory();

//        TEST 7
        try{
            inv2.addItem(apple1);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        c1.addInvoice(inv1, inv2);



//        TEST 8
        c1.displayProfile();

//        TEST 9 & TEST 10
        myFirstStore.displayAvailableInventory();

//        TEST 11
        Invoice inv3 = new Invoice(c2, myFirstStore);
        ArrayList<Item> allStoreItems = inv3.getStore().getItems();

        for(Item item: allStoreItems)
        {
            try{
            inv3.addItem(item);
        }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Displaying final invoice>>> \n");
        inv3.displayInvoice();


    }

    /**
     * Five random items array list.
     *
     * @param listOfItems the list of items
     * @return the array list
     */
    public static ArrayList<Item> fiveRandomItems(ArrayList<Item> listOfItems)
    {   SecureRandom rand = new SecureRandom();
        ArrayList<Item> randomFive = new ArrayList<Item>();
        for(int i=0; i < 5; i++)
        {
            int randNum = rand.nextInt(listOfItems.size());
            randomFive.add(listOfItems.get(randNum));
        }
        return randomFive;
    }
}
