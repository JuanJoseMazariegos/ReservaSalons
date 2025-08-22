public class Salon {
    private int numeroSalon;
    private String tipo;
    private int capacidad;
    private double costoHora;
    private boolean disponible;

    public Salon(int numeroSalon, String tipo, int capacidad, double costoHora) {
        this.numeroSalon = numeroSalon;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.disponible = true;
    }

    public int getNumeroSalon() { return numeroSalon; }
    public String getTipo() { return tipo; }
    public int getCapacidad() { return capacidad; }
    public double getCostoHora() { return costoHora; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Salón " + numeroSalon + " (" + tipo + "), Capacidad: " + capacidad + ", Costo/hora: " + costoHora;
    }
}
