/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author efrai
 */
public class Cambio {
  private int indicador = 0; //317: Compra, 318: Venta
  private String tcFechaInicio;
  private String tcFechaFinal;
  private final String tcNombre = "Efrain";
  private final String tnSubNiveles = "N";
  private final String HOST = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
  private String url;
  private final String VALUE_TAG = "NUM_VALOR";
  
  public Cambio(){
    setFecha();
  }
  
  public double getCompra(){
    setCompra();
    
    double valor = Double.parseDouble(getValue());
    return valor;
  }
  
  public double getVenta(){
    setVenta();
    
    double valor = Double.parseDouble(getValue());
    return valor;
  }
  
  private String getValue(){
    try {
      setUrl(); //Set del Url con los Parámetros
      
      //Obtiene y Parsea el XML
      String data = getHTML(url);
      XmlParser xml = new XmlParser(data);
      
      //Retorna el valor del tag
      return xml.getValue(VALUE_TAG);
    } catch (Exception e) {
      System.out.println("Error al obtener el valor del BCCR.");
      return "0";
    }
  }
  
  private void setUrl(){
    String params = "tcIndicador="+indicador+"&tcFechaInicio="+tcFechaInicio+"&tcFechaFinal="+tcFechaFinal+"&tcNombre="+tcNombre+"&tnSubNiveles="+tnSubNiveles;
    this.url = HOST+"?"+params;
  }
  
  private void setFecha(){
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    this.tcFechaInicio = sdf.format(date);
    this.tcFechaFinal = tcFechaInicio;
  }
  
  private void setCompra(){
    this.indicador = 317;
  }
  
  private void setVenta(){
    this.indicador = 318;
  }
  
  protected static String getHTML(String urlToRead) throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
       result.append(line);
    }
    rd.close();
    return result.toString();
  }
  
  
}
