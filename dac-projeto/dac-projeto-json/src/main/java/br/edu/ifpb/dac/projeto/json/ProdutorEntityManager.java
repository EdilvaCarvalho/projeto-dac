package br.edu.ifpb.dac.projeto.json;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilva
 */
public class ProdutorEntityManager {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dac-projeto-PU");

    public static EntityManager criaEntityManager() {
        return factory.createEntityManager();
    }
    
    public static void finaliza(EntityManager manager) {
        if(manager != null && manager.isOpen()){
            manager.close();
        }
   }
}
