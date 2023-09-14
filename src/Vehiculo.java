 public class Vehiculo
 {
        private String placa;
        private String tipo;
        private String estado;
        private double capacidad;
        private double costoPorDia;

        public Vehiculo(String placa, String tipo,String estado, double capacidad, double costoPorDia)
        {
            this.placa = placa;
            this.tipo = tipo;
            this.estado = estado;
            this.capacidad = capacidad;
            this.costoPorDia = costoPorDia;
        }

        public Vehiculo(String tipoVehiculo, double capacidad, double costoPorDia) { }
        public String getPlaca()
        {
            return placa;
        }
        public String getTipo()
        {
            return tipo;
        }
        public String getEstado()
        {
            return estado;
        }
        public double getCapacidad()
        {
            return capacidad;
        }
        public double getCostoPorDia()
        {
            return costoPorDia;
        }
 }