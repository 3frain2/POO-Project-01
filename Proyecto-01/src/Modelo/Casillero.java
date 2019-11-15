/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author efrai
 */
public class Casillero {
  private int numero;
  private boolean estado = true;
  private ArrayList<Entregable> registroEntregables;

  public Casillero(int numero) {
    this.numero = numero;
    registroEntregables = new ArrayList<>();
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }
  
  public ArrayList<Entregable> getRegistroEntregables() {
    return registroEntregables;
  }

  public void setRegistroEntregables(ArrayList<Entregable> registroEntregables) {
    this.registroEntregables = registroEntregables;
  }

  @Override
  public String toString() {
    return "Casillero{" + "numero=" + numero + ", estado=" + estado + ", registroEntregables=" + registroEntregables + '}';
  }
  
  public void enviarCorreo(String hotmail, String cuerpo) {
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "465");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.socketFactory.port", "465");
    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("efrainvegam27@gmail.com", "efrain27");
      }
    });
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(hotmail));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(hotmail)
        );
        message.setSubject("Vongola Service");
        message.setText(cuerpo);

        Transport.send(message);

        System.out.println("Fin.");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
  
  public void agregarRevista(int id, String descripcion, String remitente,
          String nombre, boolean catalogo, String tema) {
          Revista revista = new Revista(nombre, catalogo, tema);
          
          revista.setId(id);
          revista.setDescripcion(descripcion);
          revista.setRemitente(remitente);
          registroEntregables.add(revista);
  }
  
  public void agregarPaquete(int id, String descripcion, String remitente,
          String entrega, boolean electronico, boolean fragil, double peso) {
          Paquete paquete = new Paquete(entrega, electronico, fragil, peso);
          
          paquete.setId(id);
          paquete.setDescripcion(descripcion);
          paquete.setRemitente(remitente);
          registroEntregables.add(paquete);
  }
  
  public void agregarSobre(int id, String descripcion, String remitente,
          String tipo, String contenido, double peso) {
          Sobre sobre = new Sobre(tipo, contenido, peso);
          
          sobre.setId(id);
          sobre.setDescripcion(descripcion);
          sobre.setRemitente(remitente);
          registroEntregables.add(sobre);
  }

}
