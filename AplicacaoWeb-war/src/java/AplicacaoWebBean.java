/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.AplicacaoWebService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Leon
 */
@Named(value = "aplicacaoWebBean")
@RequestScoped
public class AplicacaoWebBean {

    @EJB
    private AplicacaoWebService aplicacaoWebService;

    /**
     * Creates a new instance of AplicacaoWebBean
     */
    public AplicacaoWebBean() {
    }
    
}
