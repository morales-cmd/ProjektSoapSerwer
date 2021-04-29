/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

/**
 *
 * @author kuba2108
 */
@MTOM

@WebService()
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)

public class Mtgsklep_serwerImpl implements Mtgsklep_serwer{
    public Magazyn magazyn;
    public Lista_kont uzytkownicy;
    public Dane_sklepu dane_sklepu;
    
    public Mtgsklep_serwerImpl() throws FileNotFoundException{
    this.magazyn=new Magazyn();
    this.uzytkownicy=new Lista_kont();
    
    }
            
    @Override
    public Magazyn zwroc_magazyn()
    {
        return this.magazyn;
    }
    @Override
    public Potw_zamowienia zloz_zamowienie( String login,String haslo) throws Exception
    {
        Konto konto=zaloguj(login,haslo);
        try {
            magazyn.weryfikuj_zamowienie(konto.koszyk, konto);
        } catch (Exception ex) {
           return new Potw_zamowienia(false,ex.getMessage());
           
        }
          
        try {
             Potw_zamowienia potw=finalizuj_zamowienie(konto.koszyk,konto);
             konto.oproznij_koszyk();
             return potw;
        } catch (Exception ex) {
            return new Potw_zamowienia(false,ex.getMessage());
        }
        
    }
    public Potw_zamowienia finalizuj_zamowienie(ArrayList<Stan> zamowienie, Konto konto) throws Exception{
        float kwota= magazyn.aktualizuj_magazyn(zamowienie);
        uzytkownicy.aktualizuj_stan_konta(kwota*(-1),konto.login,konto.haslo);
        Potw_zamowienia potw=new Potw_zamowienia(true,"zamowienie potwierdzone");
        potw.dane_sklepu=this.dane_sklepu;
        potw.kwota=kwota;
        potw.kwota_netto=(float) (kwota/1.23);
        potw.podatek=potw.kwota-potw.kwota_netto;
        return potw;
        
    }

    @Override
    public Konto zaloguj(String login, String haslo) throws Exception {
        try {
            return uzytkownicy.zaloguj(login,haslo);//To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            throw new Exception ("niepoprawny login i/lub hasło");
        }
    }

    @Override
    public Konto dodaj_do_koszyka(String login, String haslo, String nazwa_karty, int liczba) throws Exception{
        Konto k= zaloguj(login,haslo);
        Stan stan=magazyn.zwroc_stan(nazwa_karty);
        
        k.dodaj_do_koszyka(stan.karta,stan.cena,liczba);
        return k;
        
    }

    public Konto usun_z_koszyka(String login, String haslo, String nazwa_karty) throws Exception {
        Konto k= zaloguj(login,haslo);
        Stan stan=magazyn.zwroc_stan(nazwa_karty);
        
        k.usun_z_koszyka(stan.karta);
        return k; //To change body of generated methods, choose Tools | Templates.
    }
    
}
