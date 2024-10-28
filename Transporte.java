//  @ Ejercicio 6
//  @ File Name : Transporte.java
//  @ Date : 28/10/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

public class Transporte implements Entrega {
    

    //Atributos
    private String tipo;
    private float distancia;
    private float tarifa;
    private double descuento;

    /**
     * 
     * @param tipo String
     * @param distancia float
     * @param tarifa float
     * @param descuento double
     */
    public Transporte(String tipo, float distancia, float tarifa, double descuento){
        this.tipo=tipo;
        this.distancia=distancia;
        this.tarifa=tarifa;
        this.descuento=descuento;
    }

    /**
     * @return double
     */
    @Override
    public double CostoTotal(){
        double descuentoT=0;
        double precio = distancia*tarifa;
        if (distancia>100) {
            descuentoT=precio*descuento;
        }
        return precio-descuentoT;
    }

    /**
     * 
     * @return double
     */
    public double getDescuento() {
        return descuento;
    }
    /**
     * 
     * @return float
     */
    public float getDistancia() {
        return distancia;
    }
    /**
     * 
     * @return float
     */
    public float getTarifa() {
        return tarifa;
    }
    /**
     * 
     * @return Stirng
     */
    public String getTipo() {
        return tipo;
    }
}
