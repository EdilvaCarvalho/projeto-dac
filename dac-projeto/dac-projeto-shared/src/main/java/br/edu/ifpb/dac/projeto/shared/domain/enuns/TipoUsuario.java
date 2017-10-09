
package br.edu.ifpb.dac.projeto.shared.domain.enuns;

/**
 *
 * @author Edilva
 */
public enum TipoUsuario {
    
    ADMINISTRADOR("Administrador"), PROFESSOR("Professor"), PUBLICO("Público");
    
    private final String descricao;
    
    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
