package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import br.edu.ifpb.dac.projeto.shared.domain.enuns.TipoUsuario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.UsuarioService;
import br.edu.ifpb.dac.projeto.web.util.FacesUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioService usuarioService;
    @Inject
    private ProfessorService professorService;
    private Usuario usuario = new Usuario();

    public UsuarioBean() {
    }

    public String cadastrar() {
        try {
            if (this.usuario.getTipoUsuario().equals(TipoUsuario.PROFESSOR)) {
                Professor professor = professorService.professorPorEmail(usuario.getEmail());
                if (professor != null) {
                    this.usuario.setAcesso(false);
                    professor.setUsuario(usuario);
                    professorService.atualizar(professor);
                    FacesUtil.addMsgInfo("Professor cadastrado com sucesso!");
                } else {
                    FacesUtil.addMsgErro("Professor não encontrado!");
                }
            } else {
                this.usuario.setAcesso(false);
                this.usuarioService.salvar(usuario);
                this.usuario = new Usuario();
                FacesUtil.addMsgInfo("Usuario cadastrado com sucesso!");
            }

        } catch (Exception e) {
            FacesUtil.addMsgErro("Erro ao cadastrar usuário!");
        }
        this.usuario = new Usuario();
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
