package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;

/**
 *
 * @author Bruno Tarditi
 */
public class MenuControlador implements ActionListener {

    private MenuVista menu_vista;

    public MenuControlador() {
    }

    public MenuControlador(MenuVista menu_vista) {

        this.menu_vista = menu_vista;
        menu_vista.setLocationRelativeTo(null);
        menu_vista.setTitle("Menú universitario");
        menu_vista.setVisible(true);
        botones_en_escucha();

    }

    public void botones_en_escucha() {

        this.menu_vista.getBtnAlumno().addActionListener(this);
        this.menu_vista.getBtnCarrera().addActionListener(this);
        this.menu_vista.getBtnCursado().addActionListener(this);
        this.menu_vista.getBtnInscripcion().addActionListener(this);
        this.menu_vista.getBtnMateria().addActionListener(this);
        this.menu_vista.getBtnProfesor().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource().equals(this.menu_vista.getBtnCarrera())) {
            CarreraVista carrera_vista = new CarreraVista();
            CarreraModelo carrera_modelo = new CarreraModelo();
            CarreraControlador carrera_controlador = new CarreraControlador(carrera_modelo, carrera_vista);
            this.menu_vista.dispose();

        }

        if (evento.getSource().equals(this.menu_vista.getBtnInscripcion())) {
            InscripcionVista inscripcion_vista = new InscripcionVista();
            InscripcionModelo inscripcion_modelo = new InscripcionModelo();
            InscripcionControlador inscripcion_controlador = new InscripcionControlador(inscripcion_modelo, inscripcion_vista);
            this.menu_vista.dispose();

        }
        if (evento.getSource().equals(this.menu_vista.getBtnProfesor())) {
            ProfesorVista profesor_vista = new ProfesorVista();
            ProfesorModelo profesor_modelo = new ProfesorModelo();
            ProfesorControlador profesor_controlador = new ProfesorControlador(profesor_modelo, profesor_vista);
            this.menu_vista.dispose();

        }

        if (evento.getSource().equals(this.menu_vista.getBtnAlumno())) {
            AlumnoVista alumno_vista = new AlumnoVista();
            AlumnoModelo alumno_modelo = new AlumnoModelo();
            AlumnoControlador alumno_controlador = new AlumnoControlador(alumno_modelo, alumno_vista);

            this.menu_vista.dispose();

        }

        if (evento.getSource().equals(this.menu_vista.getBtnCursado())) {
            CursadoVista cursado_vista = new CursadoVista();
            CursadoModelo cursado_modelo = new CursadoModelo();
            CursadoControlador cursado_controlador = new CursadoControlador(cursado_modelo, cursado_vista);
            this.menu_vista.dispose();
        }

        if (evento.getSource().equals(this.menu_vista.getBtnMateria())) {
            MateriaVista materia_vista = new MateriaVista();
            MateriaModelo materia_modelo = new MateriaModelo();
            MateriaControlador materia_controlador = new MateriaControlador(materia_modelo, materia_vista);
            this.menu_vista.dispose();
        }

    }

}
