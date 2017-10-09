
package br.edu.ifpb.dac.projeto.core.dao.interfaces;

import br.edu.ifpb.dac.projeto.shared.domain.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface UsuarioDAO {
    
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void remover(Usuario usuario);
    Usuario getUsuario(int id);
    Usuario autenticar(String email, String senha);
    List<Usuario> listarTodos();
    List<Usuario> listarAcessoLiberado();
    List<Usuario> listarAcessoPendente();
}
