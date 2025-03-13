//Lista simple

import java.util.ArrayList;
import java.util.Scanner;

class Pelicula {
    String titulo; // Título de la película
    double calificacion; // Calificación de la película

    // Constructor que inicializa el título y la calificación de la película
    Pelicula(String titulo, double calificacion) {
        this.titulo = titulo;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return titulo + " (" + calificacion + "/10)";
    }
}

public class ListaDePeliculas {
    public static void main(String[] args) {
        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>(); // Crear una lista de películas
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Bucle que permite al usuario interactuar con el menú de opciones
        while (continuar) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar película");
            System.out.println("2. Eliminar película");
            System.out.println("3. Calificar película");
            System.out.println("4. Mostrar lista de películas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt(); // Leer la opción seleccionada por el usuario
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar una nueva película a la lista
                    System.out.print("Ingresa el título de la película: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingresa la calificación de la película (0-10): ");
                    double calificacion = scanner.nextDouble();
                    listaDePeliculas.add(new Pelicula(titulo, calificacion));
                    break;
                case 2:
                    // Eliminar una película de la lista
                    System.out.print("Ingresa el número de la película a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    if (indiceEliminar >= 0 && indiceEliminar < listaDePeliculas.size()) {
                        listaDePeliculas.remove(indiceEliminar);
                    } else {
                        System.out.println("Número no válido.");
                    }
                    break;
                case 3:
                    // Calificar una película existente
                    System.out.print("Ingresa el número de la película a calificar: ");
                    int indiceCalificar = scanner.nextInt();
                    if (indiceCalificar >= 0 && indiceCalificar < listaDePeliculas.size()) {
                        System.out.print("Ingresa la nueva calificación de la película (0-10): ");
                        double nuevaCalificacion = scanner.nextDouble();
                        listaDePeliculas.get(indiceCalificar).calificacion = nuevaCalificacion;
                    } else {
                        System.out.println("Indice no válido.");
                    }
                    break;
                case 4:
                    // Mostrar la lista de películas
                    System.out.println("Lista de películas:");
                    for (int i = 0; i < listaDePeliculas.size(); i++) {
                        System.out.println(i + ". " + listaDePeliculas.get(i));
                    }
                    break;
                case 5:
                    // Salir del programa
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        }

        scanner.close(); // Cerrar el objeto Scanner
    }
}
