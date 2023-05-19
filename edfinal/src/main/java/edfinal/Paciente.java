package edfinal;

import java.time.LocalDate;

class Paciente {
    private final String nombre;
    private final LocalDate fechaAtencion;
    private final String profesional;

    public Paciente(String nombre, LocalDate fechaAtencion, String profesional) {
        this.nombre = nombre;
        this.fechaAtencion = fechaAtencion;
        this.profesional = profesional;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public String getProfesional() {
        return profesional;
    }
}
