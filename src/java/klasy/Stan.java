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
public class Stan {
    public Karta karta;
    public int na_stanie;
    public float cena;
    public float wartosc_razem;
    public Stan(Karta karta,int na_stanie, float cena)
    {
        this.karta=karta;
        this.na_stanie=na_stanie;
        this.cena=cena;
        this.wartosc_razem=cena*na_stanie;
    }
    
}
