package InsuranceManagementSystem.Account;

public class Enterprise extends Account{
    public static final double rate = 1.50;
    public final String accountType = "Enterprise";

    public Enterprise(User user) {
        super(user, rate);
    }

    public String getAccountType() {
        return accountType;
    }
}
