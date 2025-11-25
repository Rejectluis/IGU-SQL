
package com.mycompany.pruebaconmaeven.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    
    private String dni;
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private String email;
    private String telefono;
    @Column(insertable = false)// @Column(insertable = false) -> indica que la base de datos asigne su valor
    private int estado;
    
    private List<Prestamo> prestamoList;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String ape_paterno, String ape_materno, String email, String telefono, List<Prestamo> prestamoList) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.email = email;
        this.telefono = telefono;
        this.prestamoList = prestamoList;
    }
    
    //Getters setters
    public int getId_usuario() {return id_usuario;}
    public String getDni() {return dni;}
    public String getNombre() {return nombre;}
    public String getApe_paterno() {return ape_paterno;}
    public String getApe_materno() {return ape_materno;}
    public String getEmail() {return email;}
    public String getTelefono() {return telefono;}
    public int getEstado() {return estado;}
    public List<Prestamo> getPrestamoList() {return prestamoList;}
    
    //setters
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario;}
    public void setDni(String dni) {this.dni = dni;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApe_paterno(String ape_paterno) {this.ape_paterno = ape_paterno;}
    public void setApe_materno(String ape_materno) {this.ape_materno = ape_materno;}
    public void setEmail(String email) {this.email = email;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setEstado(int estado) {this.estado = estado;}
    public void setPrestamoList(List<Prestamo> prestamoList) {this.prestamoList = prestamoList;}
    
    
    @Override
    public String toString(){
        
        return String.format(
             "id_usuario:%d %n dni:%s %n nombre:%s %n ape_paterno:%s %n ape_materno:%s %n email:%s %n telefono:%s %n estado:%d%n Prestamos:%d",
             getId_usuario(),
             getDni(),
             getNombre(),
             getApe_paterno(),
             getApe_materno(),
             getEmail(),
             getTelefono(),
             getEstado(),
             getPrestamoList().size()
        );
    }
    
}
