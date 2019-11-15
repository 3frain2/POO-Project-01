/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Casillero;
import Modelo.Cliente;
import Modelo.Entregable;
import Modelo.Revista;
import Modelo.TCliente;
import Modelo.TRevista;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author efrai
 */
public class Counter {
  private String nombre;
  private int cedulaJuridica;
  private String direccion;
  private int casilleros;
  private ArrayList<Casillero> registroCasilleros;
  private ArrayList<Cliente> registroClientes;

  private int cantNivel = 10;
  
  public Counter(String nombre, int cedulaJuridica, String direccion, int casilleros) {
    this.nombre = nombre;
    this.cedulaJuridica = cedulaJuridica;
    this.direccion = direccion;
    this.casilleros = casilleros;
    this.registroCasilleros = new ArrayList<>();
    this.registroClientes = new ArrayList<>();
    for(int i = 0; i < casilleros; i++) {
      Casillero casillero = new Casillero(i+1000);
      registroCasilleros.add(casillero);
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCedulaJuridica() {
    return cedulaJuridica;
  }

  public void setCedulaJuridica(int cedulaJuridica) {
    this.cedulaJuridica = cedulaJuridica;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public ArrayList<Cliente> getRegistroClientes() {
    return registroClientes;
  }

  public void setRegistroClientes(ArrayList<Cliente> registroClientes) {
    this.registroClientes = registroClientes;
  }

  public int getCasilleros() {
    return casilleros;
  }

  public void setCasilleros(int casilleros) {
    this.casilleros = casilleros;
  }

  public ArrayList<Casillero> getRegistroCasilleros() {
    return registroCasilleros;
  }

  public void setRegistroCasilleros(ArrayList<Casillero> registroCasilleros) {
    this.registroCasilleros = registroCasilleros;
  }
  
  @Override
  public String toString() {
    return "Counter{" + "nombre=" + nombre + ", cedulaJuridica=" + cedulaJuridica + ", direccion=" + direccion + ", registroClientes=" + registroClientes + '}';
  }
    
  public int cantidad(){
      return registroClientes.size();
  }
  
  public int agregarCliente (int identificador, String nombre, String correo, 
    int telefono, String direccion, String sexo, Date fechaNacimiento) {
    Cliente nueva = new Cliente(identificador, nombre, correo, telefono, direccion, sexo, fechaNacimiento);
    nueva.setTipo(TCliente.Normal);
    
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher mather = pattern.matcher(correo);
    int digitos = (int)(Math.log10(telefono)+1);
    boolean noEncontrado = true;
    int retorno = 0;
    
    if(digitos==8){
      if(mather.find() == true){
        for (int i = 0; i < registroClientes.size(); i++) {
          Cliente clienteLista = registroClientes.get(i);
          if (clienteLista.getIdentificador() == identificador) {
              noEncontrado = false;
          }
        }
      }
      else{
        System.out.println("Fallo de Correo");
        retorno = 2;
      }
    }
    else {
      System.out.println("Fallo de Telefono");
      retorno = 1;
    }
    if (noEncontrado == true) {
      if(revisarCasillero(nueva) == false) {
        System.out.println("Fallo de Casillero");
        retorno = 4;
      }
      else {
        retorno = nueva.getCasillero().getNumero();
        registroClientes.add(nueva);
      }
    }
    else {
     System.out.println("Fallo de Identificacion");
     retorno = 3;
    } 
    return retorno;
  }
  
  public boolean revisarCasillero(Cliente cliente) {
    for(int i = 0; i < registroCasilleros.size(); i++) {
      if(registroCasilleros.get(i).getEstado() == true) {
        registroCasilleros.get(i).setEstado(false);
        cliente.setCasillero(registroCasilleros.get(i));
        return true;
      }
    }
    return false;
  }
  
  public int modificarCliente(int identificador, String nombre, String correo, 
    int telefono, String direccion, String sexo) {
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher mather = pattern.matcher(correo);
    int digitos = (int)(Math.log10(telefono)+1);
    
    for(int i = 0; i < registroClientes.size(); i++) {
      if(registroClientes.get(i).getIdentificador() == identificador) {
          if(digitos == 8 || digitos == 0){
            if(mather.find() == true || correo.equals("")){
              if(!"".equals(nombre)) {
                registroClientes.get(i).setNombre(nombre);
              }
              if(!"".equals(direccion)) {
                registroClientes.get(i).setDireccion(direccion);
              }
              if(!"".equals(sexo)) {
                registroClientes.get(i).setSexo(sexo);
              }
              if(telefono == 0) {
                registroClientes.get(i).setTelefono(telefono);
              }
              if(!"".equals(correo)) {
                registroClientes.get(i).setCorreo(correo);
              }
            }
            else{
              System.out.println("Fallo de Correo");
              return 2;
            }
          }
          else {
            System.out.println("Fallo de Telefono");
            return 1;
          }
      }
      return 3;
    }
    return 0;
  }
  
  public Cliente consultaCliente(int identificador) { 
    Cliente vacia = new Cliente();
    for(int i = 0; i < registroClientes.size(); i++) {
      if(registroClientes.get(i).getIdentificador() == identificador) {
        System.out.println(registroClientes.get(i).toString());
        return registroClientes.get(i);
      }
    }
    return vacia;
  }
  
  public boolean eliminarCliente(int identificador) { 
    for(int i = 0; i < registroClientes.size(); i++) {
      if(registroClientes.get(i).getIdentificador() == identificador) {
        registroClientes.get(i).getCasillero().getRegistroEntregables().clear();
        registroClientes.get(i).getCasillero().setEstado(true);
        registroClientes.remove(i);
        return true;
      }
    }
    return false;
  }
  
  /*
  public Cliente mostrarClientes() { 
    for(int i = 0; i < registroClientes.size(); i++) {
      if(registroClientes.get(i).getIdentificador() == identificador) {
        return registroClientes.get(i);
      }
    }
  }
  */
  
  public void recepcionArticulos(String ... prop) {
    String ID;
    String idComprobar = prop[0];
    String tipo = prop[1];
    int idArticulo = Integer.parseInt(prop[2]);
    String descripcion = prop[3];
    String remitente = prop[4];
    String cuerpoCorreo = "Por parte de Vongola Service le avisamos que su paquete acaba de llegar a la nuestro departamento:"+"\n";

    for(int i = 0; i < registroClientes.size(); i++) {
      ID = String.valueOf(registroClientes.get(i).getIdentificador());
      if(ID.equals(idComprobar)) {
        String correo = registroClientes.get(i).getCorreo();
        if("revista".equals(tipo)) {
          registroClientes.get(i).getCasillero().agregarRevista(idArticulo, descripcion, remitente, prop[5], parseBoolean(prop[6]), prop[7]);
          verificarNivel(registroClientes.get(i), correo);
          cuerpoCorreo += 
                  "Identificacion: "+prop[0]+"\n"
                  +"Tipo de Entrega: "+prop[1]+"\n"
                  +"ID del paquete: "+prop[2]+"\n"
                  +"Descripcion: "+prop[3]+"\n"
                  +"Remitente: "+prop[4]+"\n"
                  +"Nombre: "+prop[5]+"\n"
                  +"¿Catalogo?: "+prop[6]+"\n"
                  +"Tema: "+prop[7];
          System.out.println("revista");
        }
        else if("paquete".equals(tipo)) {
          registroClientes.get(i).getCasillero().agregarPaquete(idArticulo, descripcion, remitente, prop[5], parseBoolean(prop[6]), parseBoolean(prop[7]), parseDouble(prop[8]));
          verificarNivel(registroClientes.get(i), correo);
          cuerpoCorreo += 
                  "Identificacion: "+prop[0]+"\n"
                  +"Tipo de Entrega: "+prop[1]+"\n"
                  +"ID del paquete: "+prop[2]+"\n"
                  +"Descripcion: "+prop[3]+"\n"
                  +"Remitente: "+prop[4]+"\n"
                  +"Entrega: "+prop[5]+"\n"
                  +"¿Electronico?: "+prop[6]+"\n"
                  +"¿Fragil?: "+prop[7]+"\n"
                  +"Peso: "+prop[8];
          System.out.println("paquete");
        }
        else if("sobre".equals(tipo)) {
          registroClientes.get(i).getCasillero().agregarSobre(idArticulo, descripcion, remitente, prop[5], prop[6], parseDouble(prop[7]));
          verificarNivel(registroClientes.get(i), correo);
          cuerpoCorreo += 
                  "Identificacion: "+prop[0]+"\n"
                  +"Tipo de Entrega: "+prop[1]+"\n"
                  +"ID del paquete: "+prop[2]+"\n"
                  +"Descripcion: "+prop[3]+"\n"
                  +"Remitente: "+prop[4]+"\n"
                  +"Tipo de Sobre: "+prop[5]+"\n"
                  +"Contenido: "+prop[6]+"\n"
                  +"Peso: "+prop[7];
          System.out.println("sobre");
        }
        registroClientes.get(i).getCasillero().enviarCorreo(correo, cuerpoCorreo);
      }
    }
  }
  
  public void verificarNivel(Cliente cliente, String correo) {
    String plataMsg = "Felicidades su cuenta ha subido a Plata.";
    String oroMsg = "Enhorabuena su cuenta ha subido a Oro, muchas gracias por apoyarnos.";
    cliente.setCantPaquetes(cliente.getCantPaquetes()+1);
    if(cliente.getCantPaquetes() == cantNivel) {
      cliente.setTipo(TCliente.Plata);
      cliente.getCasillero().enviarCorreo(correo, plataMsg);
    }
    if(cliente.getCantPaquetes() == cantNivel*2) {
      cliente.setTipo(TCliente.Oro);
      cliente.getCasillero().enviarCorreo(correo, oroMsg);
    }  
  }


}
