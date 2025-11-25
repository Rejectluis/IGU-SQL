
package com.mycompany.pruebaconmaeven.logica;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Ejemplar")
public class Ejemplar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ejemplar;
    
    @ManyToOne
    @JoinColumn(name = "Libro_id_libro")
    private Libro libro;
    @Column(insertable = false)
    private int estado;

    public Ejemplar() {
    }

    public Ejemplar(Libro libro) {
        this.libro = libro;
    }

    
    //  Getters
    public int getId_ejemplar() {return id_ejemplar;}
    public Libro getLibro() {return libro;}
    public int getEstado() {return estado;}
    
    //  Setters
    public void setId_ejemplar(int id_ejemplar) {this.id_ejemplar = id_ejemplar;}
    public void setLibro(Libro Libro) {this.libro = Libro;} 
    public void setEstado(int estado) {this.estado = estado;}
    private static final Logger LOG = Logger.getLogger(Ejemplar.class.getName());
    
    @Override
    public String toString(){
        return String.format("id_ejemplar: %d %n Libro_id_libro:%d %n estado:%d %n", 
            getId_ejemplar(),
            getLibro().getId_libro(),
            getEstado()
        
        );
    }
    
}
