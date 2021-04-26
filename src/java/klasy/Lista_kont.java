/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kuba2108
 */
public class Lista_kont {
    public ArrayList<Konto> lista_kont;
    public Lista_kont() throws FileNotFoundException{
        lista_kont=new ArrayList<Konto>();
        File plik = new File("C:\\Users\\kuba2\\Desktop\\RSI\\ProjektSoapSerwer\\src\\java\\baza_magazynu\\uzytkownicy.txt");
        Scanner odczyt = new Scanner( plik );
        while (odczyt.hasNext()){
            String login=odczyt.nextLine();
            System.out.println(login);
            String haslo=odczyt.nextLine();
            System.out.println(haslo);
            String stan_konta=odczyt.nextLine();
            System.out.println(stan_konta);
            String miasto=odczyt.nextLine();
            System.out.println(miasto);
            String kod_pocztowy=odczyt.nextLine();
            System.out.println(kod_pocztowy);
            String adres=odczyt.nextLine();
            System.out.println(adres);
            String email=odczyt.nextLine();
            System.out.println(email);
            String numer_telefonu=odczyt.nextLine();
            System.out.println(numer_telefonu);
            Konto konto=new Konto(login, haslo, Float.parseFloat(stan_konta),  miasto, kod_pocztowy,adres, email, numer_telefonu);
            lista_kont.add(konto);
            System.out.println("www");
    }
    }
       

    void aktualizuj_stan_konta(float f, String login, String haslo) throws Exception {
        Konto pom= zaloguj(login,haslo);
        pom.stan_konta=pom.stan_konta-f;//To change body of generated methods, choose Tools | Templates.
        
    }

    Konto zaloguj(String login, String haslo) throws Exception {
        for (int i=0;i<lista_kont.size();i++)
        {
            if(login.equals(lista_kont.get(i).login)&& haslo.equals(lista_kont.get(i).haslo))
                return lista_kont.get(i);
        }
        throw new Exception("niepoprawny login i/lub hasło");
    }
    
    
}
