 public class Vehiculo
 {
         private String tipo;
         private double capacidad;
         private double costoPorDia;

         public Vehiculo(String tipo, double capacidad, double costoPorDia) {
             this.tipo = tipo;
             this.capacidad = capacidad;
             this.costoPorDia = costoPorDia;
         }

         public String getTipo() {
             return tipo;
         }

         public double getCapacidad() {
             return capacidad;
         }

         public double getCostoPorDia() {
             return costoPorDia;
         }
     }
