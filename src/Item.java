/**
 * The type Item.
 */
public class Item {
    private String manufacturer;
    private String model;
    private double price;
    private int quantity;
    private Type type;
    private Store store;

    /**
     * Instantiates a new Item.
     *
     * @param manufacturer the manufacturer
     * @param model        the model
     * @param price        the price
     * @param quantity     the quantity
     * @param type         the type
     * @param store        the store
     */
    public Item(String manufacturer, String model,
                double price, int quantity, Type type,
                Store store)
    {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.store = store;
    }

    /**
     * Gets manufacturer.
     *
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets manufacturer.
     *
     * @param manufacturer the manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets store.
     *
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * Sets store.
     *
     * @param store the store
     */
    public void setStore(Store store) {
        this.store = store;
    }
}
