package InsuranceManagementSystem.Account;

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

    public User(String name, String surname, String email, String password, String job, int age, ArrayList<IAddress> addresses, Date lastLoginDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addresses = addresses;
        this.lastLoginDate = lastLoginDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<IAddress> getAddresses() {
        return addresses;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }
}
