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
public class Cliente {
  private int identificador;
  private String nombre;
  private String correo;
  private int telefono;
  private String direccion;
  private String sexo;
  private Date fechaNacimiento;
  private Casillero casillero;
  private TCliente tipo;
  private int cantPaquetes;
  
  public Cliente(int identificador, String nombre, String correo, 
    int telefono, String direccion, String sexo, Date fechaNacimiento) {
    this.identificador = identificador;
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.direccion = direccion;
    this.sexo = sexo;
    this.direccion = direccion;
  }
  
  public Cliente() { 
    this.identificador = -1;
  }
  
  public int getIdentificador() {
    return identificador;
  }

  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Casillero getCasillero() {
    return casillero;
  }

  public void setCasillero(Casillero casillero) {
    this.casillero = casillero;
  }

  public TCliente getTipo() {
    return tipo;
  }

  public void setTipo(TCliente tipo) {
    this.tipo = tipo;
  }

  public int getCantPaquetes() {
    return cantPaquetes;
  }

  public void setCantPaquetes(int cantPaquetes) {
    this.cantPaquetes = cantPaquetes;
  }

  @Override
  public String toString() {
    return "Cliente{" + "identificador=" + identificador + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", casillero=" + casillero + ", tipo=" + tipo + ", cantPaquetes=" + cantPaquetes + '}';
  }

  
  
  
}
