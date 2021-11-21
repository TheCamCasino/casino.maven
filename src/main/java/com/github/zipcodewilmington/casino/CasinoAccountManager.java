package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private Map<String, CasinoAccount> arcadeAccount = new HashMap<>();

    public CasinoAccountManager() {
        arcadeAccount.put("Bob", new CasinoAccount("Bob", "Billy", 500));
    }

//    /**
//     * @param userName     name of account to be returned
//     * @param userPassword password of account to be returned
//     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
//     */
    public CasinoAccount getAccount(String userName) {
        return arcadeAccount.get(userName);
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param userName     name of account to be created
     * @param userPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String userName, String userPassword) {
        CasinoAccount casinoAccount = new CasinoAccount(userName, userPassword, 500);

        return casinoAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        arcadeAccount.put(casinoAccount.getUserName(), casinoAccount);
    }
}
