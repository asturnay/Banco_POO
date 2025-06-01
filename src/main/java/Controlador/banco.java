package Controlador;

import Modelo.Cuenta;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class banco {
    private String Nit;
    private String Razon_Social;
    private LinkedList<Cuenta>Cuentas;   
    
    //metodos
    public banco(){
        this.Cuentas= new LinkedList<>();
    }
    public void setNit(String nit){
        this.Nit=nit;
    }
    public String getNit(){
        return this.Nit;
    }
    public void setRazonSocial(String rz){
        this.Razon_Social=rz;
       
    }
    public LinkedList<Cuenta>getCuentas(){
        return this.Cuentas;
    }
     //simular  metodos crud
    
    public void crearCuenta(Cuenta obj){
        //forichs recorre el for de pricipio a fin almacena en c y compara con Cuentas y asi lo hace hasta terminar el ciclo no almacena la pocision
        for (Cuenta c: this.Cuentas){ 
            if(c.getNumero().equals(obj.getNumero())){
                System.out.println("La cuenta ya Existe");
                return;
            }
        }
        this.Cuentas.add(obj);
        System.out.println("La cuenta ha sido Creada");
            
        }
        
        public Cuenta buscarCuenta(String num){
         Cuenta cta = null;
         for (Cuenta c: this.Cuentas){
             if (c.getNumero().equals(num)){
                 cta = c;
             }
        }
        return cta;
    }
    public boolean modificarCuenta(Cuenta cta){
        boolean modificado = false;
        for (int i = 0 ; i < this.Cuentas.size(); i++){
            if(this.Cuentas.get(i).getNumero().equals(cta.getNumero())){
                this.Cuentas.set(i, cta);
                modificado = true;
                break;
            }
        }
        return modificado;
    }
    public boolean eliminarCuenta(String num){
        String  rta = "";
        Scanner s = new Scanner(System.in);
        boolean eliminado = false;
        for(int m = 0; m < this.Cuentas.size();m++){
            if (this.Cuentas.get(m).getNumero().equals(num)){
                System.out.println("Esta seguro de eliminar la cuenta (S/N): ");
                rta = s.next();
                rta = rta.toLowerCase();
                if (rta.equals("s")){
                     this.Cuentas.remove(m);
                     eliminado = true;
                     break;
                }
               break;
            }
        }
        return eliminado;
    }
    
    public boolean transacciones(String num,double valor , String tran, String cla){
        Scanner x = new Scanner(System.in);
        Cuenta cta = null;
        boolean exito = false;
        for(int i = 0 ; i < this.Cuentas.size();i++){
            if(this.Cuentas.get(i).getNumero().equals(num)){
                cta = this.Cuentas.get(i);
                if(tran.equals("con")){
                    cta.consignar(valor);
                    this.Cuentas.set(i, cta);
                    exito = true;
                } if(tran.equals("sal")){
                    if(cla.equals(cta.getClave())){
                        System.out.println(cta.getSaldo());
                        exito = true;
                        System.out.println("Precione una tecla para continuar ");
                        x.nextLine();
                        x.close();
                    }else{
                        System.out.println("Clave incorrecta");
                         System.out.println("Precione una tecla para continuar ");
                        x.nextLine();
                        x.close();
                    }
                }else if(tran.equals("ret")){
                    if(cta.equals(cta.getClave())){
                        cta.retirar(valor, cla);
                        this.Cuentas.set(i, cta);
                        exito = true;
                    }else{
                        System.out.println("Clave incorrecta");
                         System.out.println("Precione una tecla para continuar ");
                        x.nextLine();
                        x.close();
                    }
                }else if(tran.equals("cam")){
                    String act = "", nue = ""; 
                    System.out.println("Ingrese su clave actual: ");
                    act = x.next();
                    System.out.println("Ingrese nueva clave");
                    nue = x.next();
                    cta.cambiarClave(act, nue);
                    this.Cuentas.set(i, cta);
                    System.out.println("Nueva clave: " + cta.getClave());
                    exito = true;
                }
                break;
            }
        }
        return exito;
    }
}