public class ControladorReservas {
    private Salon[] salones;
    private Reserva[] reservas;
    private Evento[] listaEspera;
    private int contadorReservas;
    private int contadorListaEspera;
    private int siguienteID; 

    public ControladorReservas(Salon[] salones) {
        this.salones = salones;
        this.reservas = new Reserva[50];
        this.listaEspera = new Evento[50];
        this.contadorReservas = 0;
        this.contadorListaEspera = 0;
        this.siguienteID = 1;
    }

    public boolean registrarSolicitud(Evento evento) {
        Salon salonDisponible = buscarSalonDisponible(evento);

        if (salonDisponible != null && contadorReservas < reservas.length) {
            reservas[contadorReservas++] = new Reserva(siguienteID++, evento, salonDisponible);
            salonDisponible.setDisponible(false);
            return true;
        } else {
            if (contadorListaEspera < listaEspera.length) {
                listaEspera[contadorListaEspera++] = evento;
            }
            return false;
        }
    }

    private Salon buscarSalonDisponible(Evento evento) {
        for (Salon s : salones) {
            if (s.isDisponible()) {
                if (s.getTipo().equalsIgnoreCase("Grande") && evento.getTipoEvento().equalsIgnoreCase("VIP")) {
                    return s;
                } else if (!s.getTipo().equalsIgnoreCase("Grande")) {
                    return s;
                }
            }
        }
        return null;
    }

    public void consultarReservas() {
        for (int i = 0; i < contadorReservas; i++) {
            System.out.println(reservas[i]);
        }
    }

    public void consultarListaEspera() {
        for (int i = 0; i < contadorListaEspera; i++) {
            System.out.println(listaEspera[i]);
        }
    }

    public boolean cancelarReservaPorID(int id) {
        for (int i = 0; i < contadorReservas; i++) {
            if (reservas[i].getId() == id) {
                reservas[i].getSalon().setDisponible(true);
                reservas[i] = reservas[--contadorReservas];
                reservas[contadorReservas] = null;
                return true;
            }
        }
        return false;
    }

public boolean registrarSolicitud(Evento evento, String tipoSalonSolicitado) {
    Salon salonDisponible = buscarSalonDisponible(evento, tipoSalonSolicitado);

    if (salonDisponible != null && contadorReservas < reservas.length) {
        reservas[contadorReservas++] = new Reserva(siguienteID++, evento, salonDisponible);
        salonDisponible.setDisponible(false);
        return true;
    } else {
        if (contadorListaEspera < listaEspera.length) {
            listaEspera[contadorListaEspera++] = evento;
        }
        return false;
    }
}

private Salon buscarSalonDisponible(Evento evento, String tipoSolicitado) {
    for (Salon s : salones) {
        if (s.isDisponible() && s.getTipo().equalsIgnoreCase(tipoSolicitado)) {
            // Si el salón es grande, solo aceptar eventos VIP
            if (s.getTipo().equalsIgnoreCase("Grande") && !evento.getTipoEvento().equalsIgnoreCase("VIP")) {
                return null; // No permitido
            }
            return s;
        }
    }
    return null;
}
}