package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {

    private String userName;
    private String userPassword;
    private Integer userBalance;

    CasinoAccount(String userName, String userPassword, Integer userBalance) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Integer userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "Account Name is: " + userName;
    }
}
