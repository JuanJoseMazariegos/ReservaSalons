public class Reserva {
    private int id;
    private Evento evento;
    private Salon salon;

    public Reserva(int id, Evento evento, Salon salon) {
        this.id = id;
        this.evento = evento;
        this.salon = salon;
    }

    public int getId() { return id; }
    public Evento getEvento() { return evento; }
    public Salon getSalon() { return salon; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + evento.getNombreEvento() + " en " + salon.toString();
    }
}
