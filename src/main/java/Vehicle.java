import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle  extends Asset{
        private String makeModel;
        private int year;
        private int odometer;

    public Vehicle(String description, String dateAcquired, int originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);

        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal rate = BigDecimal.valueOf(0);
        BigDecimal value;
        int currentYear = LocalDate.now().getYear();
        int carAge = currentYear - this.year;

        if (carAge < 4) {
            rate = new BigDecimal("0.03");
        } else if (carAge < 7) {
            rate = new BigDecimal("0.06");
        } else if (carAge < 10) {
            rate = new BigDecimal("0.08");
        }
        if (carAge > 10) {
            value = BigDecimal.valueOf(1000);
        }
        else {
            BigDecimal deduction = rate.multiply(BigDecimal.valueOf(carAge)).multiply(this.getOriginalCost());
            value = getOriginalCost().subtract(deduction);
        }
        if (this.odometer > 100_000) {
            if( !this.makeModel.contains("Honda") && !this.makeModel.contains("Toyota")) {
                value = value.multiply(new BigDecimal("0.75"));
            }
        }

        return value;

    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
