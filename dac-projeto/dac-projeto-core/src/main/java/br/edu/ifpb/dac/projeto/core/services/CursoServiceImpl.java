
package br.edu.ifpb.dac.projeto.core.services;

import br.edu.ifpb.dac.projeto.core.dao.interfaces.CursoDAO;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Aula;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Curso;
import br.edu.ifpb.dac.projeto.shared.domain.entidades.Turma;
import br.edu.ifpb.dac.projeto.shared.domain.interfaces.CursoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(CursoService.class)
public class CursoServiceImpl implements CursoService{
    
    @EJB
    private CursoDAO cursoDAO;

    @Override
    public void salvar(Curso curso) {
        cursoDAO.salvar(curso);
    }

    @Override
    public void atualizar(Curso curso) {
        cursoDAO.atualizar(curso);
    }

    @Override
    public void remover(int codigo) {
        Curso curso = cursoDAO.getCurso(codigo);
        cursoDAO.remover(curso);
        
    }

    @Override
    public Curso getCurso(int codigo) {
        return cursoDAO.getCurso(codigo);
    }

    @Override
    public List<Curso> listar() {
        return cursoDAO.listar();
    }

    @Override
    public List<Aula> listarAulas(Curso curso, int periodo) {
        return cursoDAO.listarAulas(curso, periodo);
    }
    
}
