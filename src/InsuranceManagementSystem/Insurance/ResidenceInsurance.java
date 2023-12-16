package InsuranceManagementSystem.Insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 0;
    }
}
