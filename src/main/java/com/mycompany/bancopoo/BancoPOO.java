package com.mycompany.bancopoo;

import Modelo.Cuenta;
import Modelo.Persona;
import java.util.Scanner;
import Controlador.banco;
import java.time.LocalDate;

/**
 *
 * @author Daniel
 */
public class BancoPOO {
    // variables locales 
     static Scanner sc = new Scanner(System.in);
     static banco Banco = null;
     static Cuenta Cuenta = null;
     static Persona per = null;
    public static void main(String[] args) {
       //Menu
       menu();
    }
    public static void menu(){
        String op ="";
        System.out.println("### Banco ###");
        System.out.println("1. Abrir Cuenta");
        System.out.println("2. Crear Cuenta");
        System.out.println("3. Consultar Cuenta");
        System.out.println("4. Modificar Cuenta");
        System.out.println("5. Eliminar  Cuenta");
        System.out.println("6. Realizar Transacciones");
        System.out.println("7. Salir");
        System.out.println("Seleccione una opcion valida (1 - 7 ) ");
        op = sc.next();
        switch (op){
            case "1":
                abrirBanco();
                break;
            case "2":
                crearCuentaV();
                break;
            case "3":
                crearCuentaV();
                break;
            case "4":
                modificarCuentaV();
                break;
            case "5":
                eliminarCuentaV();
                break;
            case "6":
                realizarTransaccion();
                break;
            case "7":
                salir();
                break;
            default: 
                System.out.println("Ingrese una opcion valida del (1 - 7)");
                reiniciar();
                break;
                
        }
    }
    public static void salir(){
        System.out.println("Gracias por usar nuestro banco");
    }
    public static void reiniciar(){
      System.out.println("presione enter para volver al menu");
        sc.next();
        sc.next();
        menu();
    } 
    public static void abrirBanco() {
        if(Banco == null){
        Banco = new banco();
        System.out.println("Ingrese el nit del Banco ");
        Banco.setNit(sc.next());
        System.out.println("Ingrese Razon social del banco");
        Banco.setRazonSocial(sc.next());
        reiniciar();    
        }else{
            System.out.println("El banco ya esta abierto");
            reiniciar();
        }
    }
    public static void crearCuentaV(){
        per = new Persona();
        Cuenta = new Cuenta();
        System.out.println("Ingrese documuento: ");
        per.setDocmento(sc.next());
        System.out.println("Ingrese nombre: ");
        per.setNombres(sc.next());
        System.out.println("Ingrese apellidos: ");
        per.setApellidos(sc.next());
        System.out.println("Ingrese genero: ");
        per.setGenero(sc.next());
        System.out.println("Ingrese direccion: ");
        per.setDireccion(sc.next());
        System.out.println("Ingrese celular: ");
        per.setCelular(sc.next());
        System.out.println("Ingrese correo: ");
        per.setCorreo(sc.next());
        System.out.println("Ingrese fecha de nacimiento: ");
        //per.setFechaNacimiento(sc.);
        System.out.println("Ingrese tipo de cuenta : ");
        per.setTipo(sc.next());
        
        Scanner sc1 = new Scanner (System.in);
        
        Cuenta = new Cuenta ();
        System.out.println("Ingrese numero de cuenta");
        Cuenta.setNumero(sc.next());
        System.out.println("Ingrese tipo de cuenta");
        Cuenta.setTipo(sc.next());
        System.out.println("Ingrese saldo actual");
        Cuenta.setSaldo(sc1.nextDouble());
        System.out.println("Ingrese clave");
        Cuenta.setClave(sc.next());
        Cuenta.setclaveDinamica("5555");
        per.setFechaNacimiento(LocalDate.now());
        System.out.println("ingrese fecha de nacimiento : ");
        Cuenta.setTitular(per);
        
        Banco.crearCuenta(Cuenta);
        reiniciar();
       
    }
    public static void buscarCuentaV(){
        String num ="";
        System.out.println("Ingrese el numero de cuenta: ");
        num = sc.nextLine();
        Cuenta temp  = Banco.buscarCuenta(num);
        if(temp == null){
            System.out.println("Cuenta no encontrada");
        }else{
            System.out.println("numero: " + temp.getNumero() + "Saldo: " + temp.getSaldo() + "tipo: " + temp.getTipo() +
                    "Clave: " + temp.getClave() + "Dinamica: " + temp.getclaveDinamica() + "titular: " + temp.getTitular() +
                    "Celular: " + temp.getTitular().getCelular()
            );
        }
        reiniciar();
        System.out.println("buscar cuenta ");
        reiniciar();
    }
       private static void modificarCuentaV() {
           String n = "";
           Scanner saldo = new Scanner(System.in);
           System.out.println("Ingrese el numero de la cuenta a modificar: ");
           n = sc.next();
           Cuenta cta =  Banco.buscarCuenta(n);
           if(cta != null){
               System.out.println("Ingrese el nuevo saldo: ");
               cta.setSaldo(saldo.nextDouble());
               System.out.println("Ingrese el nueva clave: ");
               cta.setClave(sc.next());
               System.out.println("Ingrese el nueva clavedinamica: ");
               cta.setclaveDinamica(sc.next());
               System.out.println("Ingrese el nueva celular: ");
               Persona p= cta.getTitular();
               p.setCelular(sc.next());
               cta.setTitular(p);
               
               Banco.modificarCuenta(cta);
               boolean modi  = Banco.modificarCuenta(cta);
               if(modi){
                   System.out.println("la cuenta se ha modificado");
               }else{
                   System.out.println("Error al aplicar la modificacion");
               }
               
           }else {
               System.out.println("La cuenta Existe");
           }
        
    }

    private static void eliminarCuentaV() {
        String num = "";
        System.out.println("Ingrese el numero de la cuenta que se va a eliminar: ");
        num = sc.next();
        boolean r = Banco.eliminarCuenta(num);
        if(r){
            System.out.println("La cuenta se a eliminado");
        }else{
            System.out.println("No fue posible terminar la transaccion");
        }
        reiniciar();
    }

    private static void realizarTransaccion() {
        int opc=1;
        Scanner tran = new Scanner(System.in);
        System.out.println("Indique la transaccion que desaea realizar: ");
        System.out.println("1. Consignar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Cambiar Clave ");
        System.out.println("5. volver al menu principal");
        System.out.println("ingrese un valor validode 1 - 5");
        opc = tran.nextInt();
        
         switch (opc){
            case 1:
                consignar();
                break;
            case 2:
                retirar();
                break;
            case 3:
                consultarSaldo();
                break;
            case 4:
                cambiarClave();
                break;
            case 5:
                reiniciar();
                break;
         default: 
                System.out.println("Ingrese una opcion valida del (1 - 5)");
                reiniciar();
                break;
    }   
}
    private static void consignar() {
        Scanner con = new Scanner(System.in);
        String num = "";
        double valor  = 0;
        System.out.println("### Formulario consignacion ###");
        System.out.println("Ingrese el numero de la cuenta: ");
        num = con.next();
        System.out.println("Ingrese el valor a consignar: ");
        valor = con.nextDouble();  
        Banco.transacciones(num , valor ,"con","");
        reiniciar();
    }

    private static void retirar() {
        Scanner con = new Scanner(System.in);
        String num = "", cla = "";
        double valor  = 0;
        System.out.println("### Formulario Retiro ###");
        System.out.println("Ingrese el numero de la cuenta: ");
        num = con.next();
        System.out.println("Ingrese clave: ");
        cla=con.next();
        System.out.println("Ingrese el valor a consignar: ");
        valor = con.nextDouble();
        Banco.transacciones(num , valor ,"ret","");
        reiniciar();
    }

    private static void consultarSaldo() {
        Scanner con = new Scanner(System.in);
        String num = "", cla = "";
        System.out.println("### Formulario Consultar Saldo ###");
        System.out.println("Ingrese el numero de la cuenta: ");
        num = con.next();
        System.out.println("Ingrese clave: ");
        cla=con.next();
        Banco.transacciones(num , 0 ,"sal",cla);
        reiniciar();
    }
    
    private static void cambiarClave() {
        Scanner con = new Scanner(System.in);
        String num = "";
        System.out.println("### Formulario Cambiar clave ###");
        System.out.println("Ingrese el numero de la cuenta: ");
        num = con.next();
        Banco.transacciones(num , 0 ,"cam","");
    }
}
        
      
