package modelo;

import modelo.filtros.Filtro;
import modelo.filtros.FiltroCompletada;
import modelo.filtros.FiltroPrioridad;
import modelo.serializacion.Serializacion;
import modelo.tareas.Tarea;


import java.util.LinkedList;

public class Modelo implements InterfaceModelo{
    private LinkedList<Tarea> tareas;
    private Filtro filtro;

    //CONSTRUCTOR
    public Modelo(){
        this.tareas = new LinkedList<>();
    }

    //GETTERS
    public LinkedList<Tarea> getTareas() {
        return this.tareas;
    }

    //MODIFIERS
    public boolean NuevaTarea(Tarea tarea){
        return tareas.add(tarea);
    }
    public boolean BorrarTarea(Tarea tarea){
        return tareas.remove(tarea);
    }
    public void Completar(Tarea tarea, boolean b){
        tarea.setCompletado(b);
    }

    //FILTERS
    public LinkedList<Tarea> filtrarPrioridadAlta(LinkedList<Tarea> tareas){
        this.filtro = new FiltroPrioridad(Tarea.Prioridad.ALTA);
        return filtro.Filtrar(tareas);
    }
    public LinkedList<Tarea> filtrarPrioridadMedia(LinkedList<Tarea> tareas){
        this.filtro = new FiltroPrioridad(Tarea.Prioridad.MEDIA);
        return filtro.Filtrar(tareas);
    }
    public LinkedList<Tarea> filtrarPrioridadBaja(LinkedList<Tarea> tareas){
        this.filtro = new FiltroPrioridad(Tarea.Prioridad.BAJA);
        return filtro.Filtrar(tareas);
    }
    public LinkedList<Tarea> filtrarCompletados(LinkedList<Tarea> tareas){
        this.filtro = new FiltroCompletada(true);
        return filtro.Filtrar(tareas);
    }
    public LinkedList<Tarea> filtraNoCompletados(LinkedList<Tarea> tareas){
        this.filtro = new FiltroCompletada(false);
        return filtro.Filtrar(tareas);
    }



}
