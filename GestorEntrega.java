//  @ Ejercicio 6
//  @ File Name : GestorEntrega.java
//  @ Date : 28/10/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//
import java.util.Scanner;
import java.util.Map;


public class GestorEntrega {
    

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        Funcionamiento funcionamiento=new Funcionamiento();
        int eleccion=menu();
        int eleccion2;
        Scanner teclado=new Scanner(System.in);
        float peso;
        float distancia;

        while (eleccion!=3) {
            if (eleccion == 1) {
                distancia=ingresarfloat(2);
                eleccion2=menu2(ingresarfloat(1), distancia);
                if (eleccion2==1) {
                    Transporte transporte=new Transporte("Camion", distancia, 20, 0.05);
                    System.out.println("El costo de la entrega es de: "+transporte.CostoTotal());
                    funcionamiento.agregarTransporte(transporte);
                    funcionamiento.guardarDatosCSV("transportes.csv");
                } else if (eleccion2==2) {
                    Transporte transporte=new Transporte("Motocicleta", distancia, 10, 0);
                    System.out.println("El costo de la entrega es de: "+transporte.CostoTotal());
                    funcionamiento.agregarTransporte(transporte);
                    funcionamiento.guardarDatosCSV("transportes.csv");
                } else if (eleccion2==3) {
                    Transporte transporte=new Transporte("Drone", distancia, 5, 0);
                    System.out.println("El costo de la entrega es de: "+transporte.CostoTotal());
                    funcionamiento.agregarTransporte(transporte);
                    funcionamiento.guardarDatosCSV("transportes.csv");
                } else
                System.out.println("Lo sentimos no podesmos realizar tu pedido");
                eleccion=menu();
            }else if (eleccion == 2) {
                funcionamiento.cargarDatosCSV("transportes.csv");
            
                // Calcula y muestra el total de ventas por tipo de transporte
                Map<String, Double> totalesPorTipo = funcionamiento.calcularTotalPorTipo();
                System.out.println("Total de ventas por tipo de transporte:");
                for (String tipo : totalesPorTipo.keySet()) {
                    System.out.println(tipo + ": " + totalesPorTipo.get(tipo));
                }
                eleccion = menu();
            }
        }
        System.out.println("Gracias por preferirnos, hasta la proxima.");

    }

    /**
     * 
     * @return int
     */
    public static int menu(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        while (verificador==false) {
            System.out.println("\nMenu\nSeleccione lo que deses realizar\n1. Crear pedido\n2. Crear reporte menusal\n3. Salir");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>3){
                    System.out.println("Ingrese una de las opciones del menu");
                }else
                verificador=true;
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioi;

    }

    /**
     * 
     * @param peso float
     * @param distancia flaot
     * @return int
     */
    public static int menu2(float peso, float distancia){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;

        if (peso>1000) {
            return 4;
        } else if (peso>50) {
            while (verificador==false) {
                System.out.println("\nMenu\nSeleccione el metodo de envio\n1. Camión");
                eleccionUsuarioS=teclado.nextLine();
    
                try { 
                    eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                    if(eleccionUsuarioi<1 ||eleccionUsuarioi>1){
                        System.out.println("Ingrese una de las opciones del menu");
                    }else
                    verificador=true;
                    
                } catch (Exception e) {
                    System.out.println("Ingrese un numero entero");
                } 
            }
            return eleccionUsuarioi;
        } else if (peso>5 ||distancia>10) {
            while (verificador==false) {
                System.out.println("\nMenu\nSeleccione el metodo de envio\n1. Camión \n2. Motocicleta");
                eleccionUsuarioS=teclado.nextLine();
    
                try { 
                    eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                    if(eleccionUsuarioi<1 ||eleccionUsuarioi>2){
                        System.out.println("Ingrese una de las opciones del menu");
                    }else
                    verificador=true;
                    
                } catch (Exception e) {
                    System.out.println("Ingrese un numero entero");
                } 
            }
            return eleccionUsuarioi;
        } else{
            while (verificador==false) {
                System.out.println("\nMenu\nSeleccione el metodo de envio\n1. Camión \n2. Motocicleta\n3. Drone");
                eleccionUsuarioS=teclado.nextLine();
    
                try { 
                    eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                    if(eleccionUsuarioi<1 ||eleccionUsuarioi>3){
                        System.out.println("Ingrese una de las opciones del menu");
                    }else
                    verificador=true;
                    
                } catch (Exception e) {
                    System.out.println("Ingrese un numero entero");
                } 
            }
            return eleccionUsuarioi;
        }

    }


    /**
     * 
     * @param accion int
     * @return float
     */
    public static float ingresarfloat(int accion){
        Scanner teclado=new Scanner(System.in);
        String Es;
        float Ei=0;
        boolean verificador=false;

        while (verificador==false) {
            if (accion==1) {
                System.out.println("Ingrese el peso del producto");   
            } else if (accion==2) {
                System.out.println("Ingrese la distancia de la entrega");   
            } 
            Es=teclado.nextLine();

            try { 
                Ei=Float.parseFloat(Es);
                verificador=true;
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero");
            } 
        }
        return Ei;
    }

}
