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
public class Potw_zamowienia {
    public float kwota;
    public float kwota_netto;
    public Dane_sklepu dane_sklepu;
    public Boolean czy_zatwierdzono;
    public String message;
    public ArrayList<Stan> koszyk;
    public Potw_zamowienia(Boolean czy_zatwierdzono,String message)
    {
        this.czy_zatwierdzono=czy_zatwierdzono;
        this.message=message;
    }
    
    
    
}
