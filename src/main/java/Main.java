import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Vehicle car = new Vehicle("208zx", "2026-10-05", 120, "Nissan 280ZX", 1983, 200_000);
        assets.add(car);

        House house = new House("Studio", "2021-01-01", 500_000, "200 Ozone Park", 3, 500, 0);
        assets.add(house);


        BigDecimal netWorth = BigDecimal.ZERO;
        BigDecimal vehicleTotal = BigDecimal.ZERO;

        for (Asset a : assets) {
            netWorth = netWorth.add(a.getValue());

            if (a instanceof Vehicle) {
                vehicleTotal = vehicleTotal.add(a.getValue());
            }
        }

        System.out.println("Total value: " + netWorth);
        System.out.println("Vehicle subtotal: " + vehicleTotal);


    }

}
