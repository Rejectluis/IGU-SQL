
package com.mycompany.pruebaconmaeven.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Prestamo")
public class Prestamo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prestamo;
    
    @ManyToOne
    @JoinColumn(name = "Usuario_id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "Ejemplar_id_ejemplar")
    private Ejemplar ejemplar;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion_esperada;
    private LocalDate fecha_devolucion_real;
    @Column(insertable = false)
    private int estado;

    public Prestamo() {
    }

    public Prestamo(Usuario usuario, Ejemplar ejemplar) {
        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.fecha_prestamo = LocalDate.now();
        this.fecha_devolucion_esperada = LocalDate.now().plusDays(14);
        this.fecha_devolucion_real = null;
    }
    
    
    //Getter
    public int getId_prestamo() {return id_prestamo;}
    public LocalDate getFecha_prestamo() {return fecha_prestamo;}
    public LocalDate getFecha_devolucion_esperada() {return fecha_devolucion_esperada;}
    public LocalDate getFecha_devolucion_real() {return fecha_devolucion_real;}
    public int getEstado() {return estado;}
    public Usuario getUsuario() {return usuario;}
    public Ejemplar getEjemplar() {return ejemplar;}
 
    
    //Setters
    public void setId_prestamo(int id_prestamo) {this.id_prestamo = id_prestamo;}
    public void setFecha_prestamo(LocalDate fecha_prestamo) {this.fecha_prestamo = fecha_prestamo;}
    public void setFecha_devolucion_esperada(LocalDate fecha_devolucion_esperada) {this.fecha_devolucion_esperada = fecha_devolucion_esperada;}
    public void setFecha_devolucion_real(LocalDate fecha_devolucion_real) {this.fecha_devolucion_real = fecha_devolucion_real;}
    public void setEstado(int estado) {this.estado = estado;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
    public void setEjemplar(Ejemplar ejemplar) {this.ejemplar = ejemplar;}

    
    @Override
    public String toString(){
        return String.format("id_prestamo:%d %nfecha_prestamo:%s %nfecha_devolucion_esperada:%s %n fecha_devolucion_real:%s %n Usuario_id_usuario:%d %nEjemplar_id_ejemplar:%d %n",
            getId_prestamo(),
            getFecha_prestamo(),
            getFecha_devolucion_esperada(),
            getFecha_devolucion_real(),
            getUsuario().getId_usuario(),
            getEjemplar().getId_ejemplar()
        );
    }
    
    
    
    
}
