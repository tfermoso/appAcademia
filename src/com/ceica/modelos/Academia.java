package com.ceica.modelos;

import java.util.Arrays;
/**
 * Clase para gestionar una academia,
 * Tiene un nombre y un listado de alumnos
@Author: Tomás Fermoso
 **/
public class Academia {

    /**
     *
     */
    private String nombre;
    private Alumno[] alumnos;


    /**
     * @param nombre Nombre de la academia
     * @param numero_alumnos Número de alumnos que tendra el array de alumnos
     */
    public Academia(String nombre, int numero_alumnos) {
        this.nombre = nombre;
        this.alumnos = new Alumno[numero_alumnos];
    }

    public Academia() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlumnos(int num) {
        this.alumnos = new Alumno[num];
    }

    @Override
    public String toString() {
        return "Academia{" +
                "nombre='" + nombre + '\'' +
                ", alumnos=" + Arrays.toString(alumnos) +
                '}';
    }

    /**
     * @param nombre Nombre del alumno
     * @param apellidos Apellidos del alumno
     * @param dni DNI del alumno
     * @param fechaNacimiento Fecha de nacimiento del alumno
     * @return True si puede añadir al alumno y False si la academia esta llena
     */
    public boolean altaAlumno(String nombre, String apellidos, String dni, String fechaNacimiento) {
        int year,mes,dia;
        dia= Integer.parseInt(fechaNacimiento.split("-")[0]);
        mes= Integer.parseInt(fechaNacimiento.split("-")[1]);
        year=Integer.parseInt(fechaNacimiento.split("-")[2]);
        Alumno alumno = new Alumno(nombre, apellidos, dni,year,mes,dia);
        boolean lleno=true;
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]==null){
                alumnos[i]=alumno;
                lleno=false;
                break;
            }
        }
        return lleno;
    }
    public int matriculados(){
        int contador=0;
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]!=null){
                contador++;
            }
        }
        return contador;
    }
    public int plazas(){
        return alumnos.length;
    }

    public String buscarPorDNI(String dni) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null)
                if (dni.equals(alumnos[i].getDni())) {
                    return alumnos[i].getNombre() + " " + alumnos[i].getApellidos();
                }
        }
        return "No existe ningún alumno con ese DNI";
    }

    public String borrarAlumnoPorDNI(String dni){
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]!=null) {
                if(dni.equals(alumnos[i].getDni())){
                    String nombre=alumnos[i].getNombre();
                    alumnos[i]=null;
                    return "El alumno "+nombre+" ha sido eliminado";
                }

            }
        }
        return "No hay ningún alumno con ese dni";
    }
    public String buscarPorDNI2(String dni){
        String comprobacion=null;
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i].getDni().equals(dni)){
                comprobacion=alumnos[i].getNombre()+" "+alumnos[i].getApellidos();
                break;
            }else{
                comprobacion="Alumno no encontrado";
            }
        }
        return comprobacion;
    }

    public boolean buscarAlumnoPorDNI(String dni) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null)
                if (dni.equals(alumnos[i].getDni())) {
                    return true;
                }
        }
        return false;
    }

    public void editarNombreAlumnoPorDNI(String dni, String nuevoNombre) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null)
                if (dni.equals(alumnos[i].getDni())) {
                   alumnos[i].setNombre(nuevoNombre);
                }
        }
    }

    public void editarApellidosAlumnoPorDNI(String dni, String nuevoApellido) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null)
                if (dni.equals(alumnos[i].getDni())) {
                    alumnos[i].setApellidos(nuevoApellido);
                }
        }
    }

    public void editarFechaNacimientoAlumnoPorDNI(String dni, String nuevaFecha) {
        int year,mes,dia;
        dia= Integer.parseInt(nuevaFecha.split("-")[0]);
        mes= Integer.parseInt(nuevaFecha.split("-")[1]);
        year=Integer.parseInt(nuevaFecha.split("-")[2]);
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null)
                if (dni.equals(alumnos[i].getDni())) {
                    alumnos[i].setFecha_nacimiento(year,mes,dia);
                }
        }
    }
}
