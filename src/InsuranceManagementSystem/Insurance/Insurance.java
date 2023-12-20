package InsuranceManagementSystem.Insurance;

import java.time.LocalDate;

public abstract class Insurance {
    String insuranceName;
    double insurancePrice;
    LocalDate insuranceStartDate;
    LocalDate InsuranceFinishDate;

    public Insurance(String insuranceName, double insurancePrice, LocalDate insuranceStartDate, LocalDate insuranceFinishDate) {
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

    public LocalDate getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public LocalDate getInsuranceFinishDate() {
        return InsuranceFinishDate;
    }
}
