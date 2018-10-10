/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Credential;
import entities.Resident;
import entities.Usage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
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
@Path("entities.resident")
public class ResidentFacadeREST extends AbstractFacade<Resident> {

    @PersistenceContext(unitName = "RestSmartERPU")
    private EntityManager em;

    public ResidentFacadeREST() {
        super(Resident.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Resident entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Resident entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Resident find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Resident> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Resident> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("countREST")
    @Produces({"application/json"})
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByFName/{fName}")
    @Produces({"application/json"})
    public List<Resident> findByFName(@PathParam("fName") String fName) {
        Query query = em.createNamedQuery("Resident.findByFName");
        query.setParameter("fName", fName);
        return query.getResultList();
    }
    
    @GET
    @Path("findByLName/{lName}")
    @Produces({"application/json"})
    public List<Resident> findByLName(@PathParam("lName") String lName) {
        Query query = em.createNamedQuery("Resident.findByLName");
        query.setParameter("lName", lName);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<Resident> findByDob(@PathParam("dob") String dob) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dob);
        Query query = em.createNamedQuery("Resident.findByDob");
        query.setParameter("dob", date);
        return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Resident> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Resident.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<Resident> findByPostcode(@PathParam("postcode") String postcode) {
        Query query = em.createNamedQuery("Resident.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }
    
    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<Resident> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("Resident.findByEmail");
        query.setParameter("email", email);
        List<Resident> initial = query.getResultList();
        if (!initial.isEmpty()){
            return initial;
        } else{
            return Collections.emptyList();
        }
    }
    
    @GET
    @Path("findByMobile/{mobile}")
    @Produces({"application/json"})
    public List<Resident> findByMobile(@PathParam("mobile") String mobile) {
        Query query = em.createNamedQuery("Resident.findByMobile");
        query.setParameter("mobile", mobile);
        return query.getResultList();
    }
    
    @GET
    @Path("findByNoOfResident/{noOfResident}")
    @Produces({"application/json"})
    public List<Resident> findByNoOfResident(@PathParam("noOfResident") Integer noOfResident) {
        Query query = em.createNamedQuery("Resident.findByNoOfResident");
        query.setParameter("noOfResident", noOfResident);
        return query.getResultList();
    }
    
    @GET
    @Path("findByProvider/{provider}")
    @Produces({"application/json"})
    public List<Resident> findByProvider(@PathParam("provider") String provider) {
        Query query = em.createNamedQuery("Resident.findByProvider");
        query.setParameter("provider", provider);
        return query.getResultList();
    }
    
    @GET
    @Path("findAllCredential/{id}")
    @Produces({"application/json"})
    public Collection<Credential> findAllCredential(@PathParam("id") Integer resid) {
        Query query = em.createQuery("Select r from Resident r WHERE r.resid = :resid",Resident.class);
        query.setParameter("resid", resid);
        Resident singleResult = (Resident) query.getSingleResult();
        return singleResult.getCredentialCollection();
    }
    
    @GET
    @Path("findAllUsage/{id}")
    @Produces({"application/json"})
    public Collection<Usage> findAllUsage(@PathParam("id") Integer resid) {
        Query query = em.createQuery("Select r from Resident r WHERE r.resid = :resid",Resident.class);
        query.setParameter("resid", resid);
        Resident singleResult = (Resident) query.getSingleResult();
        return singleResult.getUsageCollection();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
