/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author efrai
 */
public class Sobre extends Entregable { 
  private String tipo;
  private String contenido;
  private double peso;

  public Sobre(String tipo, String contenido, double peso) {
    this.tipo = tipo;
    this.contenido = contenido;
    this.peso = peso;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  @Override
  public String toString() {
    return "Sobre{" + "tipo=" + tipo + ", contenido=" + contenido + ", peso=" + peso + '}';
  }
  
  
}
