import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Invoice.
 */
public class Invoice {
    private ArrayList<Item> itemsSold = new ArrayList<Item>();
    private Customer customer;
    private Store store;
    private String invoiceDate;

    /**
     * Instantiates a new Invoice.
     *
     * @param customer     the customer
     * @param currentStore the current store
     */
    public Invoice(Customer customer, Store currentStore) {
        this.customer = customer;
        this.store = currentStore;
        this.invoiceDate = this.setInvoiceDate();
    }

    /**
     * Sets invoice date.
     *
     * @return the invoice date
     */
    protected String setInvoiceDate()
    {
        LocalDateTime orderDateObj = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = orderDateObj.format(formatObj);
        return formattedDate;
    }

    /**
     * Gets invoice date.
     *
     * @return the invoice date
     */
    public String getInvoiceDate()
    {
        return this.invoiceDate;
    }

    /**
     * Add item.
     *
     * @param newItemsSold the new items sold
     * @throws Exception the exception
     */
    public void addItem(ArrayList<Item> newItemsSold) throws Exception
    {
        for(Item itemSold: newItemsSold)
        {
            if(itemSold instanceof Item)
            {
                int itemIndexInStore = this.store.getItems().indexOf(itemSold);

                if((this.store.getItems().contains(itemSold)) &&
                        (this.store.getItems().get(itemIndexInStore).getQuantity() > 0))
                {
                    this.itemsSold.add(itemSold);
                    int newQuantity = this.store.getItems().get(itemIndexInStore).getQuantity() - 1;
                    this.store.getItems().get(itemIndexInStore).setQuantity(newQuantity);
                }
                else{
                    throw new Exception("The item you are trying to buy is not in stock");
                }

            }
            else{
                throw new Exception("The items are not of class Item");
            }

        }
    }

    /**
     * Add item.
     *
     * @param newItemSold the new item sold
     * @throws Exception the exception
     */
    public void addItem(Item newItemSold) throws Exception
    {
        if(newItemSold instanceof Item)
        {
//            if(newItemSold.getQuantity() == 0){
//                throw new Exception("The item " + newItemSold.getModel()+ " has " +
//                        "a quantity of zero");
//            }
//            else{
//                this.itemsSold.add(newItemSold);
//            }
            int itemIndexInStore = this.store.getItems().indexOf(newItemSold);

            if((this.store.getItems().contains(newItemSold)) &&
                    (this.store.getItems().get(itemIndexInStore).getQuantity() > 0))
            {
                this.itemsSold.add(newItemSold);
                int newQuantity = this.store.getItems().get(itemIndexInStore).getQuantity() - 1;
                this.store.getItems().get(itemIndexInStore).setQuantity(newQuantity);
            }
            else{
                throw new Exception("The item you are trying to buy is not in stock");
            }
        }
        else{
            throw new Exception("The items are not of class Item");
        }


    }

    /**
     * Display invoice.
     */
    public void displayInvoice()
    {
        double totalInvoiceAmount = 0.0;
        LocalDateTime orderDateObj = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = orderDateObj.format(formatObj);
        System.out.println(Store.DASHES);
        System.out.printf("Store Name: %s%n", this.store.getName());
        System.out.println(Store.DASHES);
        System.out.printf("Name: %s, %s%nE-mail: %s%nPhone: %s%nPurchase Date: %s%n",
                this.customer.getFirstName(),
                this.customer.getLastName(),
                this.customer.getEmailAddress(),
                this.customer.getPhoneNumber(),
                formattedDate);
        System.out.println(Store.DASHES);
        System.out.println();

        for(Item item: this.itemsSold)
        {
            totalInvoiceAmount += item.getPrice();
            System.out.printf("%s %-79s %s%n",
                    item.getManufacturer(),
                    item.getModel(),
                    item.getPrice());
        }
        System.out.println();
        System.out.println(Store.DASHES);
        System.out.printf("%-85s %s%n","Total:", totalInvoiceAmount);
        System.out.println(Store.DASHES);
    }

    /**
     * Gets all items sold.
     *
     * @return the all items sold
     */
    public ArrayList<Item> getAllItemsSold()
    {
        return this.itemsSold;
    }

    /**
     * Gets store.
     *
     * @return the store
     */
    public Store getStore() {
        return store;
    }
}
