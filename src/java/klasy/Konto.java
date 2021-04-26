/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

/**
 *
 * @author kuba2108
 */
public class Konto {
    public String login;
    public String haslo;
    public float stan_konta;
    public String miasto;
    public String kod_pocztowy;
    public String adres;
    public String email;
    public String numer_telefonu;
    public Konto (String login,String haslo, float stan_konta, String miasto, String kod_pocztowy,String adres,String email,String numer_telefonu){
        this.login=login;
        this.haslo=haslo;
        this.stan_konta=stan_konta;
        this.miasto=miasto;
        this.kod_pocztowy=kod_pocztowy;
        this.adres=adres;
        this.email=email;
        this.numer_telefonu=numer_telefonu;
             
}
    
}
