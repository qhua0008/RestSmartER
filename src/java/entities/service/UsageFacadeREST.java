/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Usage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
@Path("entities.usage")
public class UsageFacadeREST extends AbstractFacade<Usage> {

    @PersistenceContext(unitName = "RestSmartERPU")
    private EntityManager em;

    public UsageFacadeREST() {
        super(Usage.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usage entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usage entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usage find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usage> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usage> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("countREST")
    @Produces({"application/json"})
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Usage> findByDate(@PathParam("date") String date) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        Query query = em.createNamedQuery("Usage.findByDate");
        query.setParameter("date", d);
        return query.getResultList();
    }
    
    @GET
    @Path("findByHr/{hr}")
    @Produces({"application/json"})
    public List<Usage> findByHr(@PathParam("hr") Integer hr) throws Exception {
        Query query = em.createNamedQuery("Usage.findByHr");
        query.setParameter("hr", hr);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFridgeUsage/{fridgeUsage}")
    @Produces({"application/json"})
    public List<Usage> findByFridgeUsage(@PathParam("fridgeUsage") Double fridgeUsage) throws Exception {
        Query query = em.createNamedQuery("Usage.findByFridgeUsage");
        query.setParameter("fridgeUsage", fridgeUsage);
        return query.getResultList();
    }
    
    @GET
    @Path("findByAirconUsage/{airconUsage}")
    @Produces({"application/json"})
    public List<Usage> findByAirconUsage(@PathParam("airconUsage") Double airconUsage) throws Exception {
        Query query = em.createNamedQuery("Usage.findByAirconUsage");
        query.setParameter("airconUsage", airconUsage);
        return query.getResultList();
    }
    
    @GET
    @Path("findByWashmUsage/{washmUsage}")
    @Produces({"application/json"})
    public List<Usage> findByWashmUsage(@PathParam("washmUsage") Double washmUsage) throws Exception {
        Query query = em.createNamedQuery("Usage.findByWashmUsage");
        query.setParameter("washmUsage", washmUsage);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTemperature/{temperature}")
    @Produces({"application/json"})
    public List<Usage> findByTemperature(@PathParam("temperature") Double temperature) throws Exception {
        Query query = em.createNamedQuery("Usage.findByTemperature");
        query.setParameter("temperature", temperature);
        return query.getResultList();
    }
    
    @GET
    @Path("findByResid/{resid}")
    @Produces({"application/json"})
    public List<Usage> findByResid(@PathParam("resid") Integer resid) throws Exception {
        Query query = em.createNamedQuery("Usage.findByResid");
        query.setParameter("resid", resid);
        List<Usage> initial = query.getResultList();
        if (!initial.isEmpty()){
            return initial;
        } else{
            return Collections.emptyList();
        }
    }
    
    @GET
    @Path("findByHourAndDate/{hour}/{date}")
    @Produces({"application/json"})
    public List<Usage> findByHourAndDate(@PathParam("hour") Integer hour, @PathParam("date") String date) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Usage> q = em.createQuery("SELECT u FROM Usage u WHERE u.hr = :hour AND u.date = :date", Usage.class);
        q.setParameter("hour", hour);
        q.setParameter("date", d);
        return q.getResultList();
    }
    
     @GET
    @Path("findByProviderAndDate/{provider}/{date}")
    @Produces({"application/json"})
    public List<Usage> findByProviderAndDate(@PathParam("provider") String provider, @PathParam("date") String date) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Usage> query = em.createQuery("SELECT u FROM Usage u WHERE u.resid.provider = :provider And u.date =:date", Usage.class);
        query.setParameter("provider", provider);
        query.setParameter("date", d);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFNameAndHr/{fName}/{hr}")
    @Produces({"application/json"})
    public List<Usage> findByFNameAndHr(@PathParam("fName") String fName, @PathParam("hr") Integer hr) throws Exception {
        Query query = em.createNamedQuery("Usage.findByFNameAndHr");
        query.setParameter("fName", fName);
        query.setParameter("hr", hr);
        return query.getResultList();
    }
    
    @GET
    @Path("applianceHourUsage/{resid}/{appliance}/{date}/{hour}")
    @Produces({"application/json"})
    public Object applianceHourUsage(@PathParam("resid") Integer resid, @PathParam("appliance") String appliance, @PathParam("date") String date, @PathParam("hour") Integer hr) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Usage> q = em.createQuery("SELECT u from Usage u Where u.resid.resid = :resid AND u.date = :date AND u.hr = :hr", Usage.class);
        q.setParameter("resid", resid);
        q.setParameter("date",d);
        q.setParameter("hr", hr);
        List<Usage> initial = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        switch (appliance.trim().toLowerCase()){
            case "fridge":
                arrayBuilder.add(initial.get(0).getFridgeUsage());
                break;
            case "air conditioner":
                arrayBuilder.add(initial.get(0).getAirconUsage());
                break;
            case "washing machine":
                arrayBuilder.add(initial.get(0).getWashmUsage());
                break;
            default:
                break;
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    
    @GET
    @Path("sumHourUsage/{resid}/{date}/{hour}")
    @Produces({"application/json"})
    public Object sumHourUsage(@PathParam("resid") Integer resid, @PathParam("date") String date, @PathParam("hour") Integer hr) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Double> q = em.createQuery("SELECT u.airconUsage+u.fridgeUsage+u.washmUsage as sumHourUsage from Usage u Where u.resid.resid = :resid AND u.date = :date AND u.hr = :hr", Double.class);
        q.setParameter("resid", resid);
        q.setParameter("date",d);
        q.setParameter("hr", hr);
        List<Double> initial = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            Double sum = initial.get(0);
           JsonObject jObject = Json.createObjectBuilder().add("sumHourUsage",sum).build();
           arrayBuilder.add(jObject);

        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    
    @GET
    @Path("allSumHourUsage/{date}/{hour}")
    @Produces({"application/json"})
    public Object allSumHourUsage(@PathParam("date") String date, @PathParam("hour") Integer hr) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid, u.resid.address, u.resid.postcode, u.fridgeUsage+u.airconUsage+u.washmUsage as sumHourUsage From Usage u where u.date = :date and u.hr = :hr",Object[].class);
        q.setParameter("date",d);
        q.setParameter("hr", hr);
        List<Object[]> initial = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] o : initial) {
            JsonObject residentObject = Json.createObjectBuilder().add("resid", (Integer)o[0])
                    .add("address", (String)o[1])
                    .add("postcode",(String)o[2])
                    .add("sumHourUsage", (Double)o[3])
                    .build();
            arrayBuilder.add(residentObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;  
    }
    
    @GET
    @Path("highestUsage/{resid}")
    @Produces({"application/json"})
    public Object highestUsage(@PathParam("resid") Integer resid) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        TypedQuery<Object[]> q = em.createQuery("SELECT u.date, u.hr, u.fridgeUsage+u.airconUsage+u.washmUsage as sumHourUsage From Usage u where sumHourUsage = (select max(u.fridgeUsage+u.airconUsage+u.washmUsage) from Usage u where u.resid.resid = :resid) and u.resid.resid = :resid",Object[].class);
        q.setParameter("resid", resid);
        List<Object[]> initial = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        if (!initial.isEmpty()){
            for (Object[] o : initial) {
                String date = df.format(o[0]);
            JsonObject residentObject = Json.createObjectBuilder()
                    .add("highestDate", date)
                    .add("hour", (Integer)o[1])
                    .add("highestHourlyUsage",(Double)o[2])
                    .build();     
                    arrayBuilder.add(residentObject);                         
            }
            JsonArray jArray = arrayBuilder.build(); 
            return jArray;
        } else {
            JsonArray jArray = arrayBuilder.build(); 
            return jArray;
        }
    }
    
    @GET
    @Path("dailyApplianceUsage/{resid}/{date}")
    @Produces({"application/json"})
    public Object dailyApplianceUsage(@PathParam("resid") Integer resid, @PathParam("date") String date) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Usage> q = em.createQuery("SELECT u From Usage u where u.resid.resid = :resid and u.date = :date",Usage.class);
        q.setParameter("resid", resid);
        q.setParameter("date",d);
        List<Usage> initial = q.getResultList();        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        if (!initial.isEmpty()){
        Double sumFridge = 0.0;
        Double sumAircon = 0.0;
        Double sumWashm = 0.0;
        for(Usage u: initial) {
            sumFridge = sumFridge + u.getFridgeUsage();
            sumAircon = sumAircon + u.getAirconUsage();
            sumWashm = sumWashm + u.getWashmUsage(); 
        }
        JsonObject usageObject = Json.createObjectBuilder().add("resid", resid).add("fridgeUsage", sumFridge).add("airConditionerUsage",sumAircon).add("washingMachineUsage",sumWashm).build();
        arrayBuilder.add(usageObject);
        JsonArray jArray = arrayBuilder.build(); 
        return jArray;
        } else {
            JsonArray jArray = arrayBuilder.build(); 
            return jArray;
        }
    }
    
    @GET
    @Path("hourlyDailyUsage/{resid}/{date}/{view}")
    @Produces({"application/json"})
    public Object hourlyDailyUsage(@PathParam("resid") Integer resid, @PathParam("date") String date, @PathParam("view") String view) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = df.parse(date);
        TypedQuery<Usage> q = em.createQuery("SELECT u From Usage u where u.resid.resid = :resid and u.date = :date",Usage.class);
        q.setParameter("resid", resid);
        q.setParameter("date",d);
        List<Usage> initial = q.getResultList();
        if (!initial.isEmpty()){
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            switch (view.trim().toLowerCase()) {
                case "hourly":
                    for (Usage u: initial){
                        Double sum = u.getAirconUsage() + u.getFridgeUsage() + u.getWashmUsage();
                        JsonObject usageObject = Json.createObjectBuilder().add("resid", resid).add("usage", sum).add("temperature", u.getTemperature()).add("date",date).add("time", u.getHr()).build();
                        arrayBuilder.add(usageObject);
                    }
                    JsonArray jArray1 = arrayBuilder.build();
                    return jArray1;                     
                case "daily":
                    Double sum = 0.0;
                    Double sumT = 0.0;
                    for (Usage u: initial){
                        sum = sum + u.getAirconUsage() + u.getFridgeUsage() + u.getWashmUsage();
                        sumT = sumT + u.getTemperature();
                    }
                    Double avgT = sumT/(initial.size());
                    JsonObject usageObject = Json.createObjectBuilder().add("resid", resid).add("usage", sum).add("temperature", avgT).build();
                    arrayBuilder.add(usageObject);
                    JsonArray jArray = arrayBuilder.build();
                    return jArray;                     
                default:
                    JsonArray jArray2 = arrayBuilder.build();
                    return jArray2;
            }
        } else {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            JsonArray jArray = arrayBuilder.build(); 
            return jArray;
        }
    }
     
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
