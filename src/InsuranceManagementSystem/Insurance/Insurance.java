package InsuranceManagementSystem.Insurance;

import java.util.Date;

public abstract class Insurance {
    String insuranceName;
    double insurancePrice;
    Date insuranceStartDate;
    Date InsuranceFinishDate;

    public Insurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceStartDate = insuranceStartDate;
        InsuranceFinishDate = insuranceFinishDate;
    }

    public abstract double calculate();
    public String getInsuranceName() {
        return insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public Date getInsuranceFinishDate() {
        return InsuranceFinishDate;
    }
}
