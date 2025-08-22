import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Salon[] salones = {
            new Salon(1, "Pequeño", 20, 50),
            new Salon(2, "Mediano", 50, 100),
            new Salon(3, "Grande", 100, 200),
            new Salon(4, "Grande", 150, 250)
        };

        ControladorReservas controlador = new ControladorReservas(salones);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ:");
            System.out.println("1. Registrar evento");
            System.out.println("2. Consultar reservas");
            System.out.println("3. Consultar lista de espera");
            System.out.println("4. Cancelar reserva");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch(opcion) {
                case 1:
                    System.out.print("Nombre del evento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo de evento (General/VIP): ");
                    String tipo = sc.nextLine();
                    System.out.print("Encargado: ");
                    String encargado = sc.nextLine();
                    System.out.print("Fecha (AAAA-MM-DD): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora inicio (HH:MM): ");
                    String inicio = sc.nextLine();
                    System.out.print("Hora fin (HH:MM): ");
                    String fin = sc.nextLine();

                    Evento evento = new Evento(nombre, tipo, encargado, fecha, inicio, fin);

                    System.out.println("\nTipos de salones disponibles:");
                    System.out.println("1. Pequeño");
                    System.out.println("2. Mediano");
                    System.out.println("3. Grande (Solo VIP)");

                    String tipoSalonSolicitado = "";
                    int opcionSalon;
                    do {
                        System.out.print("Seleccione el tipo de salón: ");
                        opcionSalon = sc.nextInt(); sc.nextLine();
                        switch (opcionSalon) {
                            case 1: tipoSalonSolicitado = "Pequeño"; break;
                            case 2: tipoSalonSolicitado = "Mediano"; break;
                            case 3: tipoSalonSolicitado = "Grande"; break;
                            default: System.out.println("Opción inválida.");
                        }
                    } while (opcionSalon < 1 || opcionSalon > 3);

                    if (opcionSalon == 3 && !tipo.equalsIgnoreCase("VIP")) {
                        System.out.println("ERROR: Solo eventos VIP pueden reservar salones grandes.");
                        break;
                    }

                    if (controlador.registrarSolicitud(evento, tipoSalonSolicitado)) {
                        System.out.println("¡Reserva confirmada!");
                    } else {
                        System.out.println("No hay salones disponibles de ese tipo, evento agregado a lista de espera.");
                    }
                    break;


                case 2:
                    
                    System.out.println("RESERVAS");
                    controlador.consultarReservas();
                    break;

                case 3:
                    
                    System.out.println("LISTA DE ESPERA");
                    controlador.consultarListaEspera();
                    break;

                case 4:
                    
                    System.out.println("RESERVAS DISPONIBLES PARA CANCELAR:");
                    controlador.consultarReservas();
                    System.out.print("Ingrese el ID de la reserva a cancelar: ");
                    int idCancel = sc.nextInt(); sc.nextLine();
                    if (controlador.cancelarReservaPorID(idCancel)) {
                    System.out.println("Reserva cancelada.");
                    } else {
                        System.out.println("ID no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while(opcion != 0);

        sc.close();
    }
}
