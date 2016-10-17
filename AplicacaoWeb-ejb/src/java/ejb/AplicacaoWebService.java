/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leon
 */
@Stateless
@LocalBean
public class AplicacaoWebService {

    @PersistenceContext(unitName = "AplicacaoWeb-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void merge(Object object){
        em.merge(object);
    }
    
    public Funcionarios buscaFuncionario(Integer id){
        Funcionarios f = (Funcionarios)em.createQuery("SELECT f FROM Funcionarios f where f.id =:id")
                .setParameter("id", id).getSingleResult();
        return f;
    }
    
    public Pacientes buscaPaciente(Integer id){
        Pacientes f = (Pacientes)em.createQuery("SELECT p FROM Pacientes p where p.id =:id")
                .setParameter("id", id).getSingleResult();
        return f;
    }
    
    public Consultas buscaConsulta(Integer id){
        Consultas consultas = (Consultas)em.createQuery("SELECT c FROM Consultas c where c.id =:id")
                .setParameter("id", id).getSingleResult();
        return consultas;
    }
    
    public ArrayList<Consultas> buscaConsultasMarcadas(Integer id){
        ArrayList<Consultas> consultas = (ArrayList<Consultas>)em.createQuery("SELECT c FROM Consultas c where c.codpac =:codpac")
                .setParameter("codpac", id).getResultList();
        return consultas;
    }
    
    public ArrayList<Consultas> pesquisaConsultas(Consultas c){
         ArrayList<Consultas> consultas = (ArrayList<Consultas>)em.createQuery("SELECT c FROM Consultas c order by hora")
                .getResultList();
        return consultas;
    }
    
    
}
