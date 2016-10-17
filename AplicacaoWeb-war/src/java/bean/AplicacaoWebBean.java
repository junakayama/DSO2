package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.AplicacaoWebService;
import ejb.Consultas;
import ejb.Pacientes;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
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

    private ArrayList<Consultas> consultasLista;

    private ArrayList<Consultas> listaConsultasDisponiveis;

    private Consultas pesquisaConsulta;

    private String tipoUsuario;
    private String login="";
    private String senha="";

    public AplicacaoWebBean() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        //RECEBE A LISTA DE CONSULTAS DAQUELE PACIENTE
//        consultasLista = aplicacaoWebService.buscaConsultasMarcadas(Integer.SIZE);
    }

    public String validaUsuario(){
  
        return "funcPage";
    }
    
    public void cancelaConsulta(Integer codc, Integer codp) {
        Pacientes p = aplicacaoWebService.buscaPaciente(codp);
        Consultas c = aplicacaoWebService.buscaConsulta(codc);
        p.getConsultasCollection().remove(c);
        c.setCodpac(null);
        aplicacaoWebService.merge(c);
        aplicacaoWebService.merge(p);
    }

    public void marcaConsulta(Integer codc, Integer codp) {
        Pacientes p = aplicacaoWebService.buscaPaciente(codp);
        Consultas c = aplicacaoWebService.buscaConsulta(codc);
        p.getConsultasCollection().add(c);
        c.setCodpac(p);
        aplicacaoWebService.merge(c);
        aplicacaoWebService.merge(p);
    }

    public void consultasDisponiveis() {
        listaConsultasDisponiveis = aplicacaoWebService.pesquisaConsultas(pesquisaConsulta);
    }

    public ArrayList<Consultas> getListaConsultasDisponiveis() {
        return listaConsultasDisponiveis;
    }

    public void setListaConsultasDisponiveis(ArrayList<Consultas> listaConsultasDisponiveis) {
        this.listaConsultasDisponiveis = listaConsultasDisponiveis;
    }

    public Consultas getPesquisaConsulta() {
        return pesquisaConsulta;
    }

    public void setPesquisaConsulta(Consultas pesquisaConsulta) {
        this.pesquisaConsulta = pesquisaConsulta;
    }

    public AplicacaoWebService getAplicacaoWebService() {
        return aplicacaoWebService;
    }

    public void setAplicacaoWebService(AplicacaoWebService aplicacaoWebService) {
        this.aplicacaoWebService = aplicacaoWebService;
    }

    public ArrayList<Consultas> getConsultasLista() {
        return consultasLista;
    }

    public void setConsultasLista(ArrayList<Consultas> consultasLista) {
        this.consultasLista = consultasLista;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
