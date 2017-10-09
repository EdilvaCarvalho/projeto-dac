
package br.edu.ifpb.dac.projeto.json;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class CriaHorario {
    
    private List<Horario> horarios;

    public CriaHorario() {
        this.horarios = new ArrayList<>();
    }
    
    public void criar(){
        horarios.add(new Horario(1, "M1", LocalTime.of(7, 0, 0), LocalTime.of(7, 45, 0)));
        horarios.add(new Horario(2, "M2", LocalTime.of(7, 45, 0), LocalTime.of(8, 30, 0)));
        horarios.add(new Horario(3, "M3", LocalTime.of(8, 30, 0), LocalTime.of(9, 15, 0)));
        horarios.add(new Horario(4, "M4", LocalTime.of(9, 30, 0), LocalTime.of(10, 15, 0)));
        horarios.add(new Horario(5, "M5", LocalTime.of(10, 15, 0), LocalTime.of(11, 0, 0)));
        horarios.add(new Horario(6, "M6", LocalTime.of(11, 0, 0), LocalTime.of(11, 45, 0)));
        
        horarios.add(new Horario(7, "T1", LocalTime.of(13, 0, 0), LocalTime.of(13, 45, 0)));
        horarios.add(new Horario(8, "T2", LocalTime.of(13, 45, 0), LocalTime.of(14, 30, 0)));
        horarios.add(new Horario(9, "T3", LocalTime.of(14, 30, 0), LocalTime.of(15, 15, 0)));
        horarios.add(new Horario(10, "T4", LocalTime.of(15, 30, 0), LocalTime.of(16, 15, 0)));
        horarios.add(new Horario(11, "T5", LocalTime.of(16, 15, 0), LocalTime.of(17, 0, 0)));
        horarios.add(new Horario(12, "T6", LocalTime.of(17, 0, 0), LocalTime.of(17, 45, 0)));
        
        horarios.add(new Horario(13, "N1", LocalTime.of(18, 45, 0), LocalTime.of(19, 40, 0)));
        horarios.add(new Horario(14, "N2", LocalTime.of(19, 40, 0), LocalTime.of(20, 35, 0)));
        horarios.add(new Horario(15, "N3", LocalTime.of(20, 45, 0), LocalTime.of(21, 40, 0)));
        horarios.add(new Horario(16, "N4", LocalTime.of(21, 40, 0), LocalTime.of(22, 35, 0)));
    }

    public List<Horario> getHorarios() {
        criar();
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    
    
        
}
