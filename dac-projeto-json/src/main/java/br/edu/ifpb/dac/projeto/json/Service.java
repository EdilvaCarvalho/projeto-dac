package br.edu.ifpb.dac.projeto.json;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Disciplina;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Horario;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Laboratorio;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Sala;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Semestre;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Edilva
 */
public class Service {

    private JSONParser parser;
    private Dao dao;

    public Service() {
        dao = new Dao();
        parser = new JSONParser();
    }

    private JSONObject lerArquivo(String path) throws FileNotFoundException,
            IOException, ParseException {
        return (JSONObject) parser.parse(new FileReader(path));
    }

    public void salvarHorarios() {
        CriaHorario horario = new CriaHorario();
        List<Horario> horarios = horario.getHorarios();

        horarios.forEach((horario1) -> {
            dao.salvarHorario(horario1);
        });
    }

    public void salvarSalas() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/salas.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Sala sala = new Sala();
            JSONObject obj = (JSONObject) object;
            sala.setCodigo(Integer.parseInt((String) obj.get("codigo")));
            sala.setDescricao((String) obj.get("descricao"));
            sala.setAbreviacao((String) obj.get("abreviacao"));
            dao.salvarSala(sala);
        });
    }

    public void salvarLaboratorios() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/laboratorios.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Laboratorio laboratorio = new Laboratorio();
            JSONObject obj = (JSONObject) object;
            laboratorio.setCodigo(Integer.parseInt((String) obj.get("codigo")));
            laboratorio.setDescricao((String) obj.get("descricao"));
            laboratorio.setAbreviacao((String) obj.get("abreviacao"));
            dao.salvarLaboratorio(laboratorio);
        });
    }

    public void salvarProfessores() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/professores.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Professor professor = new Professor();
            JSONObject obj = (JSONObject) object;
            professor.setCodigo(Integer.parseInt((String) obj.get("codigo")));
            professor.setNome((String) obj.get("nome"));
            professor.setUnidade((String) obj.get("unidade"));
            professor.setVinculo((String) obj.get("vinculo"));
            professor.setRegime((String) obj.get("regime"));
            professor.setEmail((String) obj.get("email"));
            dao.salvarProfessor(professor);
        });
    }

    public void salvarCursos() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/cursos.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Curso curso = new Curso();
            JSONObject obj = (JSONObject) object;
            curso.setCodigo(Integer.parseInt((String) obj.get("codigo")));
            curso.setUnidade((String) obj.get("unidade"));
            curso.setDescricao((String) obj.get("descricao"));
            curso.setAbreviacao((String) obj.get("abreviacao"));
            curso.setPeriodos(Integer.parseInt((String) obj.get("periodos")));
            dao.salvarCurso(curso);
        });
    }

    public void salvarDisciplinas() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/disciplinas.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Disciplina disciplina = new Disciplina();
            JSONObject obj = (JSONObject) object;
            disciplina.setCodigo(Integer.parseInt((String) obj.get("codigo")));
            disciplina.setDescricao((String) obj.get("descricao"));
            disciplina.setAbreviacao((String) obj.get("abreviacao"));
            disciplina.setPeriodo(Integer.parseInt((String) obj.get("periodo")));
            disciplina.setCarga_horaria(Integer.parseInt((String) obj.get("carga_horaria")));
            disciplina.setAulas_semana(Integer.parseInt((String) obj.get("aulas_semana")));
            Curso curso = dao.getCurso(Integer.parseInt((String) obj.get("curso")));
            disciplina.setCurso(curso);
            dao.salvarDisciplina(disciplina);
        });
    }

    public void salvarTurmas() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/turmas.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Turma turma = new Turma();
            JSONObject obj = (JSONObject) object;
            turma.setCodigo(Integer.parseInt((String) obj.get("codigo")));
            turma.setIdentificacao((String) obj.get("identificacao"));
            turma.setDisciplina((String) obj.get("disciplina"));
            Curso curso = dao.getCurso(Integer.parseInt((String) obj.get("curso")));
            turma.setCurso(curso);
            Professor professor = dao.getProfessor(Integer.parseInt((String) obj.get("professor")));
            turma.setProfessor(professor);
            dao.salvarTurma(turma);
        });
    }

    public void salvarSemestre(Semestre semestre) {
        dao.salvarSemestre(semestre);
    }

    public void salvarAulas() throws IOException, FileNotFoundException, ParseException {
        JSONObject parseFile = lerArquivo("json/aulas.json");
        JSONArray array = (JSONArray) parseFile.get("data");

        array.forEach((object) -> {
            Aula aula = new Aula();
            JSONObject obj = (JSONObject) object;
            aula.setDia_abrev(Integer.parseInt((String) obj.get("dia_abrev")));
            aula.setDia_desc((String) obj.get("dia_desc"));
            Curso curso = dao.getCurso(Integer.parseInt((String) obj.get("cur_cod")));
            aula.setCurso(curso);
            Disciplina disciplina = dao.getDisciplina(Integer.parseInt((String) obj.get("disc_cod")));
            aula.setDisciplina(disciplina);
            Horario horario = dao.getHorario(Integer.parseInt((String) obj.get("hor_cod")));
            aula.setHorario(horario);
            String cod_lab = (String) obj.get("laboratorio");
            if (cod_lab != null) {
                Laboratorio laboratorio = dao.getLaboratorio(Integer.parseInt(cod_lab));
                aula.setLaboratorio(laboratorio);
            }
            Professor professor = dao.getProfessor(Integer.parseInt((String) obj.get("prof_cod")));
            aula.setProfessor(professor);
            String cod_sala = (String) obj.get("sala");
            if (cod_sala != null) {
                Sala sala = dao.getSala(Integer.parseInt(cod_sala));
                aula.setSala(sala);
            }
            Turma turma = dao.getTurma(Integer.parseInt((String) obj.get("tur_cod")));
            aula.setTurma(turma);
            Semestre semestre = dao.getSemestre(Integer.parseInt((String) obj.get("sem_cod")));
            aula.setSemestre(semestre);
            dao.salvarAula(aula);
        });
    }

    public void finalizar() {
        dao.finalizaConexao();
    }

}
