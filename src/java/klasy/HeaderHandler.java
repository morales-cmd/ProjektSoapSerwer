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
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingType;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.soap.SOAPFaultException;
@MTOM
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class HeaderHandler implements SOAPHandler<SOAPMessageContext>{

   @Override
   public boolean handleMessage(SOAPMessageContext context) {

    System.out.println("Server : handleMessage()......");
        
    Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    //for response message only, true for outbound messages, false for inbound
    if(!isRequest){
            
    try{
        SOAPMessage soapMsg = context.getMessage();
        SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
            SOAPHeader soapHeader = soapEnv.getHeader();
                
            //if no header, add one
        if (soapHeader == null){
                soapHeader = soapEnv.addHeader();
                //throw exception
                generateSOAPErrMessage(soapMsg, "No SOAP header.");
         }
        else{
        //System.out.print(soapHeader);
        System.out.print(soapEnv.getHeader());
        }
        
             //Get client mac address from SOAP header
         
                
           //tracking
           soapMsg.writeTo(System.out);

        }catch(SOAPException e){
            System.err.println(e);
        }catch(IOException e){
            System.err.println(e);
        }
            
        }
//    else{
//        try{
//        SOAPMessage soapMsg = context.getMessage();
//            SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
//            SOAPHeader soapHeader = soapEnv.getHeader();
//                
//            //if no header, add one
//            if (soapHeader == null){
//            	soapHeader = soapEnv.addHeader();
//            }
//
//            //get mac address
//            Dane_sklepu dk= new Dane_sklepu();
//            //add a soap header, name as "mac address"
//            QName qname = new QName("http://25.76.141.122:8080/ProjektSoapSerwer/", "Dane_firmy");
//            SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
//
//            //soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
//            soapHeaderElement.addTextNode(dk.nazwa+"\n"+dk.NIP+"\n"+dk.adres+"\n"+dk.kod_pocztowy+" "+dk.miasto+"\n"+dk.wlasciciel);
//            soapMsg.saveChanges();
//            //tracking
//           //soapMsg.writeTo(System.out);
//
//                 
//       }catch(SOAPException e){
//        System.err.println(e);
//       }
////        catch(IOException e){
////        System.err.println(e);
////       }
//        
//    }

      //continue other handler chain
      return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        
        System.out.println("Server : handleFault()......");
        
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close()......");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return null;
    }
    
     private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
       try {
          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
          SOAPFault soapFault = soapBody.addFault();
          soapFault.setFaultString(reason);
          throw new SOAPFaultException(soapFault); 
       }
       catch(SOAPException e) { }
    }

}
