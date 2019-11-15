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
public class Paquete extends Entregable {
  private String entrega;
  private boolean electrico;
  private boolean fragil;
  private double peso;

  public Paquete(String entrega, boolean electrico, boolean fragil, double peso) {
    this.entrega = entrega;
    this.electrico = electrico;
    this.fragil = fragil;
    this.peso = peso;
  }

  public String getEntrega() {
    return entrega;
  }

  public void setEntrega(String entrega) {
    this.entrega = entrega;
  }

  public boolean isElectrico() {
    return electrico;
  }

  public void setElectrico(boolean electrico) {
    this.electrico = electrico;
  }

  public boolean isFragil() {
    return fragil;
  }

  public void setFragil(boolean fragil) {
    this.fragil = fragil;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  @Override
  public String toString() {
    return "Paquete{" + "entrega=" + entrega + ", electrico=" + electrico + ", fragil=" + fragil + ", peso=" + peso + '}';
  }
   
  
}
