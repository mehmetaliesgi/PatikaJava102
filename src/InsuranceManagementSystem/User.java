package InsuranceManagementSystem;

import InsuranceManagementSystem.Address.IAddress;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<IAddress> addresses;
    private Date lastLoginDate;
}
