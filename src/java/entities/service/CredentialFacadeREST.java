/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Credential;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jennifer
 */
@Stateless
@Path("entities.credential")
public class CredentialFacadeREST extends AbstractFacade<Credential> {

    @PersistenceContext(unitName = "RestSmartERPU")
    private EntityManager em;

    public CredentialFacadeREST() {
        super(Credential.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credential entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Credential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Credential find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByUserName/{userName}")
    @Produces({"application/json"})
    public List<Credential> findByUserName(@PathParam("userName") String userName) {
        Query query = em.createNamedQuery("Credential.findByUserName");
        query.setParameter("userName", userName);
        List<Credential> initial = query.getResultList();
        if (!initial.isEmpty()){
            return initial;
        } else{
            return Collections.emptyList();
        }
    }
    
    @GET
    @Path("findByPwHash/{pwHash}")
    @Produces({"application/json"})
    public List<Credential> findByPwHash(@PathParam("pwHash") String pwHash) {
        Query query = em.createNamedQuery("Credential.findByPwHash");
        query.setParameter("pwHash", pwHash);
        return query.getResultList();
    }
    
    @GET
    @Path("findByRegDate/{regDate}")
    @Produces({"application/json"})
    public List<Credential> findByRegDate(@PathParam("regDate") String regDate) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(regDate);
        Query query = em.createNamedQuery("Credential.findByRegDate");
        query.setParameter("regDate", date);
        return query.getResultList();
    }
    
    @GET
    @Path("findByResid/{resid}")
    @Produces({"application/json"})
    public List<Credential> findByResid(@PathParam("resid") Integer resid) {
        Query query = em.createNamedQuery("Credential.findByResid");
        query.setParameter("resid", resid);
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
