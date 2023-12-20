package InsuranceManagementSystem.Insurance;

import java.time.LocalDate;

public class TravelInsurance extends Insurance{
    public TravelInsurance(String insuranceName, double insurancePrice, LocalDate insuranceStartDate, LocalDate insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return insurancePrice * 1.1;
    }
}
