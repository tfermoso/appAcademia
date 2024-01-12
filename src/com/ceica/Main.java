package com.ceica;


import com.ceica.modelos.Academia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Academia academia;

        if(args.length>1){
            String nombre_academia=args[0];
            int numero_alumnos;
            try{
                numero_alumnos= Integer.parseInt(args[1]);
            }catch (NumberFormatException e){
                System.out.println("Número no válido");
                numero_alumnos=20;
            }

            academia=new Academia(nombre_academia,numero_alumnos);
        }else{
            academia=new Academia("CEICA",20);
        }
        for (int i = 0; i < 20; i++) {
            academia.altaAlumno("n"+i,"a"+i,"d"+i,"2-3-1989");
        }

        //Creo el objeto aplicación
        Scanner leer = new Scanner(System.in);
        String opcion,dni;
        String MENU = """
                0. Establecer nombre
                1. Alta alumno
                2. Buscar alumnos por DNI
                3. Borrar alumno por DNI
                4. Editar alumno por DNI
                9. Mostrar información de la academia
                10. Salir""";

        do {
            System.out.println(MENU);
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    // Código para limpiar la pantalla de la consola en Java
                    if(academia.matriculados()>=academia.plazas()){
                        System.out.println("Academia llena");
                    }else {
                        System.out.println("---------------------------------");
                        System.out.println("Alta de alumno");
                        if (nuevoAlumno(leer, academia)) {
                            System.out.println("No hay sitio en la academia");
                        } else {
                            System.out.println("Alumno matriculado");
                        }
                    }
                    break;

                case "2":
                    System.out.println("Buscar alumno por DNI");
                    System.out.println("Introduce el DNI del alumno");
                    dni=leer.nextLine();
                    System.out.println(academia.buscarPorDNI(dni));
                    break;
                case "3":
                    System.out.println("Borror alumno por DNI");
                    System.out.println("Introduce el DNI del alumno");
                    dni=leer.nextLine();
                    System.out.println(academia.borrarAlumnoPorDNI(dni));
                    break;
                case "4":
                    System.out.println("Editar datos Alumno");
                    System.out.println("Introduce el DNI del alumno");
                    dni=leer.nextLine();
                    if(academia.buscarAlumnoPorDNI(dni)){
                        editarAlumno(leer,academia,dni);
                    }else{
                        System.out.println("No hay ningún alumno con ese dni");
                    }
                    break;
                case "9":
                    System.out.println("Info de la Academia");
                    System.out.println(academia.toString());
                    break;
                case "10":
                    System.out.println("Gracias por utilicar la AcademiaAPP");
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!opcion.equals("10"));
        System.out.println("CHAO...");
    }

    private static void editarAlumno(Scanner leer, Academia academia, String dni) {
        String MENUEDITAR= """
                1. Editar Nombre
                2. Editar Apellidos
                3. Editar Fecha Nacimiento
                """;
        String opcionEditar,nuevoNombre,nuevoApellido,nuevaFecha;
        System.out.println(MENUEDITAR);
        opcionEditar=leer.nextLine();
        switch (opcionEditar){
            case "1":
                System.out.println("El alumno que vas a editar es: "+academia.buscarPorDNI(dni));
                System.out.println("Nuevo nombre");
                nuevoNombre=leer.nextLine();
                academia.editarNombreAlumnoPorDNI(dni,nuevoNombre);
                break;
            case "2":
                System.out.println("El alumno que vas a editar es: "+academia.buscarPorDNI(dni));
                System.out.println("Nuevo apellido");
                nuevoApellido=leer.nextLine();
                academia.editarApellidosAlumnoPorDNI(dni,nuevoApellido);
                break;
            case "3":
                System.out.println("El alumno que vas a editar es: "+academia.buscarPorDNI(dni));
                System.out.println("Fecha de nacimiento: dd-MM-yyyy");
                nuevaFecha=leer.nextLine();
                academia.editarFechaNacimientoAlumnoPorDNI(dni,nuevaFecha);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static boolean nuevoAlumno(Scanner leer, Academia academia) {
        String nombre,apellidos,dni;
        String fecha_nacimiento;
        System.out.println("Nombre: ");
        nombre=leer.nextLine();
        System.out.println("Apellidos: ");
        apellidos=leer.nextLine();
        System.out.println("Dni: ");
        dni=leer.nextLine();
        System.out.println("Fecha nacimiento dd-mm-yyyy");
        fecha_nacimiento=leer.nextLine();
        return academia.altaAlumno(nombre,apellidos,dni,fecha_nacimiento);

    }
}