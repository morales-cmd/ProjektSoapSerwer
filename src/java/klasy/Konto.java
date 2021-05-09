/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import java.util.ArrayList;

/**
 *
 * @author kuba2108
 */
public class Konto {
    public String login;
    public String haslo;
    public String imie;
    public String nazwisko;
    public float stan_konta;
    public String miasto;
    public String kod_pocztowy;
    public String adres;
    public String email;
    public String numer_telefonu;
    public ArrayList<Stan> koszyk;
    public Konto (String login,String haslo, float stan_konta, String miasto, String kod_pocztowy,String adres,String email,String numer_telefonu,String imie,String nazwisko){
        this.login=login;
        this.haslo=haslo;
        this.stan_konta=stan_konta;
        this.miasto=miasto;
        this.kod_pocztowy=kod_pocztowy;
        this.adres=adres;
        this.email=email;
        this.numer_telefonu=numer_telefonu;
        this.koszyk= new ArrayList<Stan>();
        this.imie=imie;
        this.nazwisko=nazwisko;
}
    public Stan zwroc_stan(String name) throws Exception
    {
        for (int i=0;i<koszyk.size();i++)
        {
            if(name.equals(koszyk.get(i).karta.nazwa))
                return koszyk.get(i);
        }
        throw new Exception("brak elementu");
    }
    public void pop_stan(String name) 
        {
            for (int i=0;i<koszyk.size();i++)
            {
                if(name.equals(koszyk.get(i).karta.nazwa))
                    koszyk.remove(i);
            }
        }

    void dodaj_do_koszyka(Karta karta,float cena, int liczba) {
        try {Stan pom=this.zwroc_stan(karta.nazwa);
            pom.na_stanie=liczba;
            pom.wartosc_razem=liczba*pom.cena;
                }
        catch(Exception ex){
            Stan stan=new Stan(karta,liczba,cena);
            koszyk.add(stan);
        }//To change body of generated methods, choose Tools | Templates.
    }

    void usun_z_koszyka(Karta karta) {
         this.pop_stan(karta.nazwa);
            
                
        } //To change body of generated methods, choose Tools | Templates.

    void oproznij_koszyk() {
        while(koszyk.size()>0)
            koszyk.remove(0);//To change body of generated methods, choose Tools | Templates.
    }
    
}
