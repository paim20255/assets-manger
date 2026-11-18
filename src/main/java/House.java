import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, int originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }
     @Override
    public BigDecimal getValue() {
         BigDecimal perSquareFoot = switch (condition){
             case 1 -> new BigDecimal("180.00");
             case 2 -> new BigDecimal("130.00");
             case 3 -> new BigDecimal("90.0");
             case 4 -> new BigDecimal("80.00");
             default ->  BigDecimal.ZERO;

         };
         return perSquareFoot.multiply(BigDecimal.valueOf(this.squareFoot));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
