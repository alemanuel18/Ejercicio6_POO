//  @ Ejercicio 6
//  @ File Name : Funcionamiento.java
//  @ Date : 28/10/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcionamiento {

    //Atributos
    private List<Transporte> transportes;


    // Método para agregar un transporte a la lista
    /**
     * 
     * @param transporte Transporte
     */
    public void agregarTransporte(Transporte transporte) {
        transportes.add(transporte);
    }

    // Método para guardar los datos en un archivo CSV
    /**
     * 
     * @param archivo String
     */
    public void guardarDatosCSV(String archivo) {
        boolean archivoExiste = new java.io.File(archivo).exists();
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            // Si el archivo no existe, escribe la cabecera
            if (!archivoExiste) {
                writer.write("Tipo,Distancia,Tarifa,Descuento,CostoTotal\n");
            }
    
            // Escribe cada transporte en una nueva línea
            for (Transporte t : transportes) {
                writer.write(t.getTipo() + "," + t.getDistancia() + "," + t.getTarifa() + "," +
                             t.getDescuento() + "," + t.CostoTotal() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
        transportes.clear();
    }
    
    

    // Método para cargar datos desde un archivo CSV
    /**
     * 
     * @param archivo String
     */
    public void cargarDatosCSV(String archivo) {
        transportes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            reader.readLine(); // Lee la cabecera y la descarta
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String tipo = datos[0];
                float distancia = Float.parseFloat(datos[1]);
                float tarifa = Float.parseFloat(datos[2]);
                double descuento = Double.parseDouble(datos[3]);
                Transporte transporte = new Transporte(tipo, distancia, tarifa, descuento);
                transportes.add(transporte);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
    

    // Método para calcular el total de ventas por tipo de transporte
    /**
     * 
     * @return Map<String, Double>
     */
    public Map<String, Double> calcularTotalPorTipo() {
        Map<String, Double> totalesPorTipo = new HashMap<>();
        for (Transporte t : transportes) {
            String tipo = t.getTipo();
            double costo = t.CostoTotal();
    
            // Sumar el costo al tipo correspondiente en el mapa
            totalesPorTipo.put(tipo, totalesPorTipo.getOrDefault(tipo, 0.0) + costo);
        }
        return totalesPorTipo;
    }
}
