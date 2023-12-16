package InsuranceManagementSystem.Account;

import InsuranceManagementSystem.Insurance.Insurance;

import java.util.ArrayList;

public abstract class Account {
    private AuthenticationStatus status;
    private User user;
    private ArrayList<Insurance> insurances;
    final void showUserInfo() {

    }
}
