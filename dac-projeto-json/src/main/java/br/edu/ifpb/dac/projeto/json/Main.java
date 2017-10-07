package br.edu.ifpb.dac.projeto.json;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Edilva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Service service = new Service();

        try {
            service.salvarHorarios();
            service.salvarSalas();
            service.salvarLaboratorios();
            service.salvarProfessores();
            service.salvarCursos();
            service.salvarDisciplinas();
            service.salvarTurmas();
            Semestre semestre = new Semestre(13, 2017, 1, 1);
            service.salvarSemestre(semestre);
            service.salvarAulas();
            service.finalizar();
        } catch (ParseException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        service.finalizar();
    }

}
