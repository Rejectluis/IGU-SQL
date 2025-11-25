
package com.mycompany.pruebaconmaeven.logica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_libro;
    
    private int codigo_libro;
    private String titulo;
    private String autor;
    private int anno_publicacion;
    private int nro_paginas;
    @Column(insertable = false)// @Column(insertable = false) -> indica que la base de datos asigne su valor default
    private int estado;
    
    @OneToMany(mappedBy = "libro")
    private LinkedList<Ejemplar> ejemplaresList;
   

    public Libro() {
    }

    public Libro(int codigo_libro, String titulo, String autor, int anno_publicacion, int nro_paginas,LinkedList<Ejemplar> ejemplareslist) {
        this.codigo_libro = codigo_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.anno_publicacion = anno_publicacion;
        this.nro_paginas = nro_paginas;
        this.ejemplaresList = ejemplareslist;
    }
    
    //Getters
    public int getId_libro() {return id_libro;}
    public int getCodigo_libro() {return codigo_libro;}
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    public int getAnno_publicacion() {return anno_publicacion;}
    public int getNro_paginas() {return nro_paginas;}
    public int getEstado() {return estado;}
    public LinkedList<Ejemplar> getEjemplareslist() {return ejemplaresList;}
    
    //Setters
    public void setId_libro(int id_libro) {this.id_libro = id_libro;}
    public void setCodigo_libro(int codigo_libro) {this.codigo_libro = codigo_libro;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setAnno_publicacion(int anno_publicacion) {this.anno_publicacion = anno_publicacion;}
    public void setNro_paginas(int nro_paginas) {this.nro_paginas = nro_paginas;}
    public void setEstado(int estado) {this.estado = estado;}
    public void setEjemplareslist(LinkedList<Ejemplar> ejemplareslist) {this.ejemplaresList = ejemplareslist;}
    
    
    @Override
    public String toString(){
        return String.format(
            "id_libro:%d %n codigo_libro:%d %n titulo:%s %n autor:%s %n anno_publicacion:%d %n nro_paginas:%d %n estado:%d ",
            getId_libro(),
            getCodigo_libro(),
            getTitulo(),
            getAutor(),
            getAnno_publicacion(),
            getNro_paginas(),
            getEstado()
        );
    }
    
}
