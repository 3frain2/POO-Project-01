/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Control.Counter;
import Modelo.Cambio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author efrai
 */
public class NewMain {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    //Crea el servicio del API
    //Cambio TipoCambio = new Cambio();
    //Obtiene el valor del precio de compra USD
    //System.out.println(TipoCambio.getCompra());
    //Obtiene el valor del precio de venta USD
    //System.out.println(TipoCambio.getVenta());

    Date date = new Date();
    DateFormat hourFormat = new SimpleDateFormat("HH:mm a");
    System.out.println("Hora: "+hourFormat.format(date));
    
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("Fecha: "+dateFormat.format(date));
    Date inicio = new Date(2019-1900, 11-1, 05);
    Counter counter = new Counter("Express", 200000, "Puntarenas" , 80);
    
    counter.agregarCliente(999, "efrain", "efrainvegam27@gmail.com", 83806240, "a", "M", inicio);
    
    counter.recepcionArticulos("999","revista","123", "true", "gogogo", "DIO", "revista 0", "false", "Cocina");
    //counter.recepcionArticulos("999","sobre","1546356", "descripcion", "remitente", "Tipo", "Contenido", "78.0");

    //counter.recepcionArticulos("9992","revista","123", "true", "gogogo", "DIO", "revista 0", "false", "Cocina");

    //counter.consultaCliente(999);
    /*
    counter.eliminarCliente(999);
    counter.agregarCliente(9992, "randy2", "efrainvegamkr@hotmail.com", 
    84362457, "z", "M", inicio);
    //counter.consultaCliente(9992);
    
    counter.recepcionArticulos("9992","sobre","123", "true", "gogogo", "DIO", "1", "true", "78.0");
    
    counter.consultaCliente(9992);
    */
  }
}
