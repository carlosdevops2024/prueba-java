import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definición de la clase Libro
class Libro {
    // Atributos de la clase Libro
    String titulo;
    String autor;
    int anioPublicacion;
    double precio;
    boolean prestadoPersonalizado;

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, int anioPublicacion, double precio, boolean prestadoPersonalizado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
        this.prestadoPersonalizado = prestadoPersonalizado;
    }

    // Método para obtener una representación en forma de cadena del libro
    @Override
    public String toString() {
        return "Título: " + titulo +
               ", Autor: " + autor +
               ", Año: " + anioPublicacion +
               ", Precio: $" + precio+
               ", prestadoPersonalizado: $"+ prestadoPersonalizado;
    }
}

// Clase principal del programa
public class Main {
    // Método principal del programa
    public static void main(String[] args) {
        // Inicialización de la lista de libros y del objeto Scanner
        List<Libro> listaLibros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Bucle principal del programa
        while (true) {
            // Mostrar el menú de opciones al usuario
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Buscar libros por título");
            System.out.println("3. Mostrar todos los libros disponibles");
            System.out.println("4. Salir");
            System.out.print("Ingresa tu opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            // Switch para manejar las opciones del usuario
            switch (opcion) {
                case 1: // Opción para agregar un nuevo libro
                    System.out.println("\nAgregar un nuevo libro:");
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("¿Está prestado? (true/false): ");
                    boolean prestadoPersonalizado = scanner.nextBoolean();
                    // Crear un nuevo objeto Libro y agregarlo a la lista de libros
                    listaLibros.add(new Libro(titulo, autor, anio, precio, prestadoPersonalizado));
                    System.out.println("Libro agregado con éxito.");
                    break;
                case 2: // Opción para buscar libros por título
                    System.out.println("\nBuscar libros por título:");
                    System.out.print("Ingresa el título: ");
                    String tituloBuscar = scanner.nextLine();
                    boolean encontrado = false;
                    // Recorrer la lista de libros y mostrar los que coincidan con el título buscado
                    for (Libro libro : listaLibros) {
                        if (libro.titulo.equalsIgnoreCase(tituloBuscar)) {
                            System.out.println(libro);
                            encontrado = true;
                        }
                    }
                    // Mostrar un mensaje si no se encontraron libros con el título buscado
                    if (!encontrado) {
                        System.out.println("No se encontraron libros con ese título.");
                    }
                    break;
                case 3: // Opción para mostrar todos los libros disponibles
                    System.out.println("\nTodos los libros disponibles:");
                    boolean hayLibrosDisponibles = false;
                    // Recorrer la lista de libros y mostrar los que no están prestados
                    for (Libro libro : listaLibros) {
                        if (libro.prestadoPersonalizado == false) { // Verificar si el libro no está prestado
                            System.out.println(libro);
                            hayLibrosDisponibles = true;
                        }
                    }
                    // Mostrar un mensaje si no se encontraron libros disponibles
                    if (!hayLibrosDisponibles) {
                        System.out.println("No hay libros disponibles");
                    }
                    break;
                case 4: // Opción para salir del programa
                    System.out.println("¡Hasta luego!");
                    System.exit(0); // Terminar la ejecución del programa
                default: // Opción para manejar una entrada inválida
                    System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
            }
        }
    }
}
