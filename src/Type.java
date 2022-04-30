/**
 * The enum Type.
 */
public enum Type {
    /**
     * The Phn.
     */
    PHN("PHN","Storage Shelf 1-2"),
    /**
     * The Acc.
     */
    ACC("ACC","Storage Shelf 3-4");

    private final String name;
    private final String location;

    Type(String name, String location)
    {
        this.name = name;
        this.location = location;

    }


    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
