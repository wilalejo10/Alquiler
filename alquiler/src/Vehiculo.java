
    public class Vehiculo
    {
        private String placa;
        private String tipo; // Puede ser "carga" o "pasajeros"
        private double valorPorDia;
        private String estado; // Puede ser "ocupado" o "disponible"
        private int capacidad;

        public Vehiculo(String placa, String tipo, double valorPorDia, String estado, int capacidad)
        {
            this.placa = placa;
            this.tipo = tipo;
            this.valorPorDia = valorPorDia;
            this.estado = estado;
            this.capacidad = capacidad;
        }

        public String getPlaca()
        {
            return placa;
        }

        public void setPlaca(String placa)
        {
            this.placa = placa;
        }

        public String getTipo()
        {
            return tipo;
        }

        public void setTipo(String tipo)
        {
            this.tipo = tipo;
        }

        public double getValorPorDia()
        {
            return valorPorDia;
        }

        public void setValorPorDia(double valorPorDia)
        {
            this.valorPorDia = valorPorDia;
        }

        public String getEstado()
        {
            return estado;
        }

        public void setEstado(String estado)
        {
            this.estado = estado;
        }

        public int getCapacidad()
        {
            return capacidad;
        }

        public void setCapacidad(int capacidad)
        {
            this.capacidad = capacidad;
        }
        public String toString()
        {
            return "Vehiculo{" +
                    "placa='" + placa + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", valorPorDia=" + valorPorDia +
                    ", estado='" + estado + '\'' +
                    ", capacidad=" + capacidad +
                    '}';
        }
    }