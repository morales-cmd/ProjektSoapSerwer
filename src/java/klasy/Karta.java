/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author kuba2108
 */
public class Karta {
public String nazwa;
public String opis;
public Image ilustracja;
public Karta(String nazwa,String opis,String nazwa_il)
{
    this.nazwa= nazwa;
    this.opis=opis;
    try {
            
            File image = new File("C:\\Users\\kuba2\\Desktop\\RSI\\ProjektSoapSerwer\\src\\java\\klasy\\ilustracje\\"+ nazwa_il);
            ilustracja= ImageIO.read(image);
            
        } catch (IOException e) {
            
            e.printStackTrace(); 
            
        }
}

    
}
