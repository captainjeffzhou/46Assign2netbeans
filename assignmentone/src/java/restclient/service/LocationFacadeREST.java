/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restclient.Location;





import javax.persistence.Query;

import javax.persistence.TypedQuery;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonArrayBuilder;



/**
 *
 * @author CPZHOUCHENG
 */
@Stateless
@Path("restclient.location")
public class LocationFacadeREST extends AbstractFacade<Location> {

    @PersistenceContext(unitName = "assignmentonePU")
    private EntityManager em;

    public LocationFacadeREST() {
        super(Location.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Location entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Location entity) {
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
    public Location find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Location> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
    
    
    
    
 //////////////////////////   
    @GET
    @Path("Location.findByLocationid/{locationid}")
        @Produces({"application/json"})
        public List<Location> findByLocationid(@PathParam("locationid") int locationid)
        {Query query = em.createNamedQuery("Location.findByLocationid");
                query.setParameter("locationid", locationid);
                return query.getResultList();
        }
    
    @GET
    @Path("Location.findByLongitude/{longitude}")
        @Produces({"application/json"})
        public List<Location> findByLongitude(@PathParam("longitude") double longitude)
        {Query query = em.createNamedQuery("Location.findByLongitude");
                query.setParameter("longitude", longitude);
                return query.getResultList();
        }
    
    @GET
    @Path("Location.findByLatitude/{latitude}")
        @Produces({"application/json"})
        public List<Location> findByLatitude(@PathParam("latitude") double latitude)
        {Query query = em.createNamedQuery("Location.findByLatitude");
                query.setParameter("latitude", latitude);
                return query.getResultList();
        }    
    
    @GET
    @Path("Location.findByLocationname/{locationname}")
        @Produces({"application/json"})
        public List<Location> findByLocationname(@PathParam("locationname") String locationname)
        {Query query = em.createNamedQuery("Location.findByLocationname");
                query.setParameter("locationname", locationname);
                return query.getResultList();
        }   
    
    @GET
    @Path("Location.findByDatetime/{datetime}")
        @Produces({"application/json"})
        public List<Location> findByDatetime(@PathParam("datetime") double datetime)
        {Query query = em.createNamedQuery("Location.findByDatetime");
                query.setParameter("datetime", datetime);
                return query.getResultList();
        }        
        
        
 
//////        
    // Task 2 - b - (3) ( implicit not sure if it works, code should be better in LocationFacade table)    
    @GET
    @Path("findByCourseANDlocationName/{course}/{locationname}")
    @Produces({"application/json"})
    public List<Location> findByCourseANDlocationName(@PathParam("course") String course, @PathParam("locationname") String locationname) 
    {
        TypedQuery<Location> q = em.createQuery("SELECT l FROM Location l WHERE l.sid.course = :course AND l.locationname = :locationname", Location.class); 
        q.setParameter("course", course); 
        q.setParameter("locationname", locationname);
        return q.getResultList();
    }
        
        
  //////test 3 a  
  
 //////test  not work   
   @GET
    @Path("findBySidWithDates/{sid}/{sdate}/{edate}")
    @Produces({"application/json"})
    public JsonObject findBySidWithDates(@PathParam("sid") int sid, @PathParam("sdate") double sdate, @PathParam("edate") double edate)
    {
        
        //Query q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Student s JOIN s.locationCollection l WHERE s.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Student.class);
      //List<Object[]> rows = q.list();
       //////// List<Object> object = new ArrayList<Object>();
      ///Query q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Location l WHERE l.sid.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Location.class);
        TypedQuery<Object[]> q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Location l WHERE l.sid.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Object[].class);
        q.setParameter("sid", sid);
        q.setParameter("sdate", sdate);
        q.setParameter("edate", edate);
        List<Object[]> Lists = q.getResultList();
        
        //JsonObject builder = Json.createObjectBuilder();
                //JsonObject jsonObject = Json.createObjectBuilder();
        
        JsonObject jsonObject = Json.createObjectBuilder().build();
        
       String jsonString;
       String Overall = "";        
        for (Object[] element : Lists) 
        {
            jsonObject = Json.createObjectBuilder().add("locationname", (String)element[0]).add("frequency", (Long)element[1]).build();
            jsonString = jsonObject.toString();
            Overall = Overall +"/ "+ jsonString;
        }
        
     JsonObject finaljsonObject = Json.createObjectBuilder()
        .add("Results",Overall)
             .build();
        return finaljsonObject;
}
  
      
      
    
    
    
    @GET
    @Path("findBySidWithTwoDates/{sid}/{sdate}/{edate}")
    @Produces({"application/json"})
    public JsonArray findBySidWithTwoDates(@PathParam("sid") int sid, @PathParam("sdate") double sdate, @PathParam("edate") double edate)
    {
        
        //Query q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Student s JOIN s.locationCollection l WHERE s.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Student.class);
      //List<Object[]> rows = q.list();
       //////// List<Object> object = new ArrayList<Object>();
      ///Query q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Location l WHERE l.sid.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Location.class);
        TypedQuery<Object[]> q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Location l WHERE l.sid.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Object[].class);
        q.setParameter("sid", sid);
        q.setParameter("sdate", sdate);
        q.setParameter("edate", edate);
        List<Object[]> Lists = q.getResultList();
        
        //JsonObject builder = Json.createObjectBuilder();
                //JsonObject jsonObject = Json.createObjectBuilder();
        
         JsonArrayBuilder builder = Json.createArrayBuilder();
        
        JsonObject jsonObject = Json.createObjectBuilder().build();
        
       String jsonString;
       String Overall = "";        
        for (Object[] element : Lists) 
        {
            jsonObject = Json.createObjectBuilder().add("locationname", (String)element[0]).add("frequency", (Long)element[1]).build();
            jsonString = jsonObject.toString();
            Overall = Overall +"/ "+ jsonString;
            builder.add(jsonObject);
        }
        
     JsonObject finaljsonObject = Json.createObjectBuilder()
        .add("Results",Overall)
             .build();
     
     JsonArray ja = builder.build();
        return ja;
}
 
    
    
    
    
    
    
    
    
    
    
 //////BBBBbbbbbbbbbbbbbbbbbbbb
//// assign2 
////////work
@GET
@Path("findLatiLongiwithMonashEmail/{email}")
@Produces({"application/json"})
public JsonObject findLatiLongiwithMonashEmail(@PathParam("email") String email) 
{
TypedQuery<Object[]> q = em.createQuery("SELECT max(l.locationid), MAX(l.datetime) FROM Location l WHERE l.sid.monashemail = :email", Object[].class);
q.setParameter("email", email);

List<Object[]> Lists = q.getResultList();
JsonObject jsonObjectq= Json.createObjectBuilder().build();
int maxDate = 0;

//////JsonObject jsonObjectqTest = Lists[0];

for (Object[] element : Lists) 
{
    /////JsonObject j0 = element[0];
    String ff = element[1].toString();
    jsonObjectq = Json.createObjectBuilder().add("maxLocationID",(int)element[0]).add("RecentMostTime",(int)element[1]).build();
    maxDate = (int)element[1];
}


///////____________________

JsonObject jsonObjectq2 = Json.createObjectBuilder().build();
TypedQuery<Object[]> q2 = em.createQuery("SELECT l.latitude, l.longitude FROM Location l WHERE l.datetime = :maxDate", Object[].class);
q2.setParameter("maxDate", maxDate);
List<Object[]> Lists2 = q2.getResultList();
for (Object[] element2 : Lists2) 
{
    /////JsonObject j0 = element[0];
    //String ff = (String)element[0];
    
    jsonObjectq2 = Json.createObjectBuilder().add("latitude",(double)element2[0]).add("longitude",(double)element2[1]).build();
    //maxDate = (int)element[1];
}
//JsonObject finalObjectTest = Json.createObjectBuilder().add("result",a).build(); 




//TypedQuery<Object[]> qq = em.createQuery("select l.latitude, l.longitude from Location l where l.datetime = :datetime", Object[].class);
//qq.setParameter("datetime", a);
//List<Object[]> Listsqq = qq.getResultList();
//JsonObject jsonObjectQQ = Json.createObjectBuilder().build();
//String jsonStringQQ; 
//String OverallQQ = "";
//for (Object[] element : Listsqq)
//{
 //   jsonObjectQQ = Json.createObjectBuilder().add("latitude", (double)element[0]).add("longitude", (double)element[1]).build();
//jsonStringQQ = jsonObjectQQ.toString();
//OverallQQ = OverallQQ + jsonStringQQ; }





//TypedQuery<Student> qqq = em.createQuery ("SELECT s FROM Student s WHERE s.monashemail = :monashemail", Student.class);
//q.setParameter("monashemail", monashemail); 
// List<Student> sList = qqq.getResultList();
// String sListString = sList.toString();
 
 
//String finalString = OverallQQ+ sListString; 

//JsonObject finalObject = Json.createObjectBuilder().add("result",finalString).build(); 

//return finalObject;
return jsonObjectq2;
}
   
    
    
    
    
    
    
    
    
    
        
        
    }        
        
        
    
    
    

