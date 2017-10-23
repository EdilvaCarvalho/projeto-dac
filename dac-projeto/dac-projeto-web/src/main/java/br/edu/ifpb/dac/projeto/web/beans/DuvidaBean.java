package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Duvida;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.DuvidaService;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class DuvidaBean implements Serializable {

    @Inject
    private DuvidaService duvidaService;
    @Inject
    private ProfessorService professorService;
    private List<Duvida> duvidas = new ArrayList<>();
    private Professor professorEncontrado = new Professor();
    private String resposta;
    private String pergunta;

    public DuvidaBean() {
    }

    public String cadastrar() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario usuario = (Usuario) session.getAttribute("user");
        Duvida duvida = new Duvida();
        duvida.setUsuario(usuario);
        duvida.setProfessor(professorEncontrado);
        duvida.setPergunta(pergunta);
        this.duvidaService.salvar(duvida);
        pergunta = "";
        return null;
    }

    public String responder(Duvida duvida) {
        duvida.setResposta(resposta);
        this.duvidaService.atualizar(duvida);
        resposta = "";
        return null;
    }

    public String pegaProfessor(Professor professor) {
        this.professorEncontrado = this.professorService.getProfessor(professor.getCodigo());
        return "duvidas.xhtml";
    }

    public List<Duvida> getDuvidas() {
        this.duvidas = duvidaService.duvidasProfessor(professorEncontrado);
        return duvidas;
    }

    public void setDuvidas(List<Duvida> duvidas) {
        this.duvidas = duvidas;
    }

    public Professor getProfessorEncontrado() {
        return professorEncontrado;
    }

    public void setProfessorEncontrado(Professor professorEncontrado) {
        this.professorEncontrado = professorEncontrado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

}
