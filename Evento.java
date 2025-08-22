public class Evento {
    private String nombreEvento;
    private String tipoEvento; 
    private String encargado;
    private String fecha; 
    private String horaInicio;
    private String horaFin;

    public Evento(String nombreEvento, String tipoEvento, String encargado, String fecha, String horaInicio, String horaFin) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.encargado = encargado;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombreEvento() { return nombreEvento; }
    public String getTipoEvento() { return tipoEvento; }
    public String getEncargado() { return encargado; }
    public String getFecha() { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }

    @Override
    public String toString() {
        return nombreEvento + " (" + tipoEvento + ") - Encargado: " + encargado + " - Fecha: " + fecha;
    }
}
