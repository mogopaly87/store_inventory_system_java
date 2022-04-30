import java.util.ArrayList;

/**
 * This class is used to create Customer objects
 * @author Chinonso Mogo 2059294
 * @version 2021-12-10
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    private Store store;

    /**
     * Constructor used to create Customer objects
     * @param firstName - string of customer first name
     * @param lastName - string of customer last name
     * @param emailAddress - string of customer email address
     * @param phoneNumber - string of customer phone number
     */
    public Customer(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns customer's first name
     * @return a string representation of the customer's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of this customer object
     * @param firstName - String representing the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns customer's last name
     * @return a string representation of the customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of this customer object
     * @param lastName - String representing the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns customer's email address
     * @return a string representation of the customer's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of this customer object
     * @param emailAddress - String representing the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Returns customer's phone number
     * @return a string representation of the customer's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of this customer object
     * @param phoneNumber - String representing the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * returns the Store object that this customer is associated with
     * @return a store object
     */
    public Store getStore() {
        return store;
    }

    /**
     * This method sets a store to a customer object.
     * Once a store is set to a customer object, this method..
     * adds the current customer object to the specific store
     * using the 'addCustomerToStore' method called on the store
     * instance.
     * @param store
     */
    public void setStore(Store store) {
        this.store = store;
        this.store.addCustomerToStore(this);
    }

    /**
     * Adds an invoice object to this customer's array list of invoices
     * @param invoices - one or more Invoice objects
     */
    public void addInvoice(Invoice... invoices)
    {
        for(Invoice currentInvoice: invoices)
        {
            this.invoices.add(currentInvoice);
        }
    }

    /**
     * This method prints to the console, the customer's information (first name, last name,
     * total sale, email address, name of store, and phone number).
     * It also prints the items contained in each invoice object associated with this customer.
     */
    public void displayProfile()
    {
        double totalSale = 0.00;
        System.out.println(Store.DASHES);

        for(Invoice invoice: this.invoices)
        {
            ArrayList<Item> arrayOfItems = invoice.getAllItemsSold();
            for(Item item: arrayOfItems)
            {
                totalSale += item.getPrice();
            }
        }

        System.out.printf("Name: %s, %-55sTotal Sales: %-20s%n", this.firstName, this.lastName, totalSale);
        System.out.printf("E-mail: %-65sStore: %s%n", this.emailAddress, this.store.getName());
        System.out.printf("Phone: %s%n", this.phoneNumber);
        System.out.println(Store.DASHES);

        for(int invNum=0; invNum < this.invoices.size(); ++invNum)
        {
            System.out.printf("Invoice %s%n", invNum + 1);
            System.out.printf("Purchase Date: %s%n", this.invoices.get(invNum).getInvoiceDate());
            System.out.println("Items Purchased");
            double totalOnInvoice = 0.0;

            ArrayList<Item> arrayOfItemsOnInvoice = this.invoices.get(invNum).getAllItemsSold();
            for(Item item: arrayOfItemsOnInvoice)
            {
                System.out.printf("%s %-80s%s%n",
                        item.getManufacturer(), item.getModel(), item.getPrice());
                totalOnInvoice += item.getPrice();
            }
            System.out.println(Store.DASHES);
            System.out.printf("%-85s %s%n","Total:", totalOnInvoice);
            System.out.println(Store.DASHES);
        }
    }
}
