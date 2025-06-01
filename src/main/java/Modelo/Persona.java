package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class Persona {
    // Atributos 
    private String documento;
    private String nombres;
    private String apellidos;
    private String genero;
    private String direccion;
    private String celular;
    private String correo;
    private LocalDate FechaNacimiento;
    private String tipo;
    // Metodos 
    
    public Persona(){
        
    }
    // Costructor Full 
    
    public Persona(String doc, String nom, String ape, String gen,String dir ,String cel, String cor, LocalDate fech,String tip ){
        this.documento = doc;
        this.nombres = nom;
        this.apellidos = ape;
        this.genero = gen;
        this.direccion = dir;
        this.celular = cel;
        this.correo = cor;
        this.FechaNacimiento = fech;
        this.tipo = tip;
        
    }
    //Metodos modificadores set  
    public void setDocmento(String doc){
        this.documento = doc;
    }
    public void setNombres(String nom){
        this.nombres = nom;
    }
    public void setApellidos(String ape){
        this.apellidos = ape;
    }
    public void setGenero(String gen){
        this.genero = gen;
    }
    public void setDireccion(String dir){
        this.direccion = dir;
    }
    public void setCelular(String cel){
        this.celular = cel;
    }
    public void setCorreo(String cor){
        this.correo = cor;
    }
    public void setFechaNacimiento(LocalDate fech){
        this.FechaNacimiento = fech;
    }
    public void setTipo(String tip){
        this.tipo= tip;
    }
    
    //Metodos accesesores get 
    
  
    
    
    public String getNombres(){
        return this.nombres;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public String getGenero(){
        return this.genero;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public String getCelular(){
        return this.celular;
    }
    public String getCorreo(){
        return this.correo;
    }
    public LocalDate getFechaNacimiento(){
        return this.FechaNacimiento;
    }
    public String getTipo(){
        return this.tipo;
    }
}