/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import java.awt.Image;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author kuba2108
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Mtgsklep_serwer {
        @WebMethod Magazyn zwroc_magazyn();
        @WebMethod Potw_zamowienia zloz_zamowienie(ArrayList<Stan> zamowienie,Konto konto);
        @WebMethod Konto zaloguj(String login,String haslo) throws  Exception;
    //update image to server
    
}
