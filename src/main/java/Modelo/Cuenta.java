package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class Cuenta {
    // Atributos Cuenta 
    private String numero;
    private String tipo;
    private Persona titular;
    private LocalDate FechaApertura;
    private double saldo;
    private String cleve;
    private String claveDinamica;
    
    public Cuenta (){
    }
    
    public Cuenta (String num,String tip,Persona tit,LocalDate fec,
            double sal,String cla,String din){
        this.numero = num;
        this.tipo = tip;
        this.titular = tit;
        this.FechaApertura = fec;
        this.saldo = sal;
        this.cleve = cla;
        this.claveDinamica = din;
    }
    //Metodos modificadores set  
    public void setNumero(String num){
        this.numero = num;
    }
    public void setTipo(String tip){
        this.tipo = tip;
    }
    public void setTitular(Persona tit){
        this.titular = tit;
    }
    public void setFechaApertura(LocalDate fec){
        this.FechaApertura = fec;
    }
    public void setSaldo(double sal){
        this.saldo = sal;
    }
    public void setClave(String cla){
        this.cleve = cla;
    }
    public void setclaveDinamica(String dim){
        this.claveDinamica = dim;
    }
   ///Metodos accesesores get 
    
     public String getNumero(){
        return this.numero;
    }
    public String getTipo(){
        return this.tipo;
    }
    public Persona getTitular(){
        return this.titular;
    }
    public LocalDate getFechaApertura(){
        return this.FechaApertura;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getClave(){
        return this.cleve;
    }
    public String getclaveDinamica(){
        return this.claveDinamica;
    }
    //Metodo Consignar 
    
    public void consignar(double monto){
        this.saldo += monto;
    }
    public void retirar(double monto,String cla){
        if (this.cleve.equals(cla)){
            if (this.saldo > monto){
           this.saldo -= monto; 
        }else{
            System.out.println("Saldo Insuficiente...");
        }   
    }else {
            System.out.println("Credenciales no validas");
        } 
    }    
    public void cambiarClave(String ant,String nue){
        // isEmpty es preguntar si es vacio y si quiero que no sea vacia se antepone !
        if (ant.equals(this.cleve) && nue!=this.cleve && !nue.isEmpty()){ 
            this.cleve = nue;
        }
    }   
}
