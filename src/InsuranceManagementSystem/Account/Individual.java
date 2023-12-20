package InsuranceManagementSystem.Account;

public class Individual extends Account{
    public static final double rate = 1.15;
    private final String accountType = "Individual";

    public Individual(User user) {
        super(user, rate);
    }

    public String getAccountType() {
        return accountType;
    }

}
