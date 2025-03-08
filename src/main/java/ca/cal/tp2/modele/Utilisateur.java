package ca.cal.tp2.modele;

import lombok.Data;

@Data
public abstract class Utilisateur {
    private int userID;
    private String name;
    private String email;
    private String phoneNumber;

    public void login(){
        System.out.println("Login");
    }
}
