/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author efrai
 */
public class Entregable {
  protected int id;
  protected boolean estado;
  protected String descripcion;
  protected Date fechaLlegada;
  protected Date fechaRecogido;

  /**
   *
   */
  protected String remitente;

  public Entregable() {
    this.estado = true;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getRemitente() {
    return remitente;
  }

  public void setRemitente(String remitente) {
    this.remitente = remitente;
  }

  @Override
  public String toString() {
    return "Entregable{" + "id=" + id + ", estado=" + estado + ", descripcion=" + descripcion + ", remitente=" + remitente + '}';
  }
  
  
}
