import java.util.ArrayList;

/**
 * This class is used to create 'store' objects
 * @author Chinonso Mogo 2059294
 * @version 2021-12-10
 */
public class Store {
    private String name;
    private ArrayList<Customer> customersInThisStore = new ArrayList<Customer>();
    private ArrayList<Item> items = new ArrayList<Item>();
    public static final String DASHES =
            "----------------------------------------"
                    + "----------------------------------------"
                    + "-------------";

    /**
     * Used to create store objects
     * @param name of the store
     */
    public Store(String name)
    {
        this.name = name;
    }

    /**
     * Returns the name of store object
     * @return a string representing the name of an object
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a customer object to the store object's array list of customer objects
     * @param newCustomer - a customer object
     */
    public void addCustomerToStore(Customer newCustomer)
    {
        this.customersInThisStore.add(newCustomer);
    }

    /**
     * Displays a list of all items in a store object's inventory
     */
    public void displayInventory()
    {
        System.out.println(DASHES);
        System.out.printf("Store Name:  %s%n", this.name);
        System.out.println(DASHES);
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                "Manufacturer", "Model", "Type", "Qty", "Price");

        System.out.println(DASHES);

        for (Item item: this.items)
        {
            System.out.printf(
                    "%-20s%-20s%-20s%-20s%-20s%n",
                    item.getManufacturer(),
                    item.getModel(),
                    item.getType(),
                    item.getQuantity(),
                    item.getPrice()
            );
            System.out.printf("%12s: %-12s%n", "Location", item.getType().getLocation());
        }
    }


    /**
     * Displays a list all items in a store object's inventory where the quantity of the
     * item is greater than 0.
     */
    public void displayAvailableInventory()
    {
        System.out.println(DASHES);
        System.out.printf("Store Name:  %s%n", this.name);
        System.out.println(DASHES);
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                "Manufacturer", "Model", "Type", "Qty", "Price");

        System.out.println(DASHES);

        for (Item item: this.items)
        {
            if(item.getQuantity() > 0)
            {
                System.out.printf(
                        "%-20s%-20s%-20s%-20s%-20s%n",
                        item.getManufacturer(),
                        item.getModel(),
                        item.getType(),
                        item.getQuantity(),
                        item.getPrice()
                );
                System.out.printf("%12s: %-12s%n", "Location", item.getType().getLocation());
            }

        }
    }

    /**
     * Adds item objects to a store object's array list of Item objects
     * @param args - receives one or more Item object(s) as parameter.
     */
    public void addItemToStore(Item... args)
    {
        for(Item item: args)
        {
            this.items.add(item);
        }

    }

    /**
     * Returns an array list of all Item objects in this store.
     * @return an array list.
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }
}
