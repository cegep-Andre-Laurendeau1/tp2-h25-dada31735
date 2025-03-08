package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Utilisateur {
    @Id
    @GeneratedValue
    private long userID;
    private String name;
    private String email;
    private String phoneNumber;

    public void login(){
        System.out.println("Login");
    }
}
