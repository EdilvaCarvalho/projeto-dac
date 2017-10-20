package br.edu.ifpb.dac.projeto.web.beans;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Professor;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import br.edu.ifpb.dac.projeto.shared.domain.enuns.TipoUsuario;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.ProfessorService;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.UsuarioService;
import br.edu.ifpb.dac.projeto.web.util.FacesUtil;
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
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioService usuarioService;
    @Inject
    private ProfessorService professorService;
    private List<Usuario> usuariosLiberados = new ArrayList<>();
    private List<Usuario> usuariosNaoLiberados = new ArrayList<>();
    private Usuario usuario = new Usuario();
    private String email;
    private String senha;

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

    public String autenticar() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);

        Usuario user = this.usuarioService.autenticar(email, senha);

        if (user != null) {
            if (user.isAcesso()) {
                session.setAttribute("user", user);

                switch (user.getTipoUsuario()) {
                    case ADMINISTRADOR:
                        return "admin/home.xhtml?faces-redirect=true";
                    case PROFESSOR:
                        return "professor/home.xhtml?faces-redirect=true";
                    default:
                        return "publico/home.xhtml?faces-redirect=true";
                }
            } else {
                FacesUtil.addMsgErro("Acesso não liberado!");
                return null;
            }
        }
        FacesUtil.addMsgErro("Email ou senha incorretos!");
        return null;
    }

    public String sair() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.setAttribute("user", null);
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String liberarAcesso(Usuario usuario){
        usuario.setAcesso(true);
        this.usuarioService.atualizar(usuario);
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ProfessorService getProfessorService() {
        return professorService;
    }

    public void setProfessorService(ProfessorService professorService) {
        this.professorService = professorService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getUsuariosLiberados() {
        usuariosLiberados = usuarioService.listarAcessoLiberado();
        return usuariosLiberados;
    }

    public List<Usuario> getUsuariosNaoLiberados() {
        usuariosNaoLiberados = usuarioService.listarAcessoPendente();
        return usuariosNaoLiberados;
    }

}
