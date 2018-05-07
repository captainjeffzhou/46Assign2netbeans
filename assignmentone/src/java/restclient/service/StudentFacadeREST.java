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
import restclient.Student;

//
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
@Path("restclient.student")
public class StudentFacadeREST extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "assignmentonePU")
    private EntityManager em;

    public StudentFacadeREST() {
        super(Student.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Student entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Student entity) {
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
    public Student find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////////////////////////////////////////
    
    //////////////////////////////////////////
    
    //////////////////////////////////////////
    
    @GET
    @Path("findByFirstname/{firstname}")
        @Produces({"application/json"})
        public List<Student> findByFirstname(@PathParam("firstname") String firstname)
        {Query query = em.createNamedQuery("Student.findByFirstname");
                query.setParameter("firstname", firstname);
                return query.getResultList();
        }
        
    @GET
    @Path("findByLastname/{lastname}")
        @Produces({"application/json"})
        public List<Student> findByLastname(@PathParam("lastname") String lastname)
        {Query query = em.createNamedQuery("Student.findByLastname");
                query.setParameter("lastname", lastname);
                return query.getResultList();
        }    
    
    @GET
    @Path("findByDateofbirth/{dateofbirth}")
        @Produces({"application/json"})
        public List<Student> findByDateofbirth(@PathParam("dateofbirth") int dateofbirth)
        {Query query = em.createNamedQuery("Student.findByDateofbirth");
                query.setParameter("dateofbirth", dateofbirth);
                return query.getResultList();
        }
    @GET   
    @Path("findByGender/{gender}")
        @Produces({"application/json"})
        public List<Student> findByGender(@PathParam("gender") String gender)
        {Query query = em.createNamedQuery("Student.findByGender");
                query.setParameter("gender", gender);
                return query.getResultList();
        }        
        
    @GET
    @Path("findByCourse/{course}")
        @Produces({"application/json"})
        public List<Student> findByCourse(@PathParam("course") String course)
        {Query query = em.createNamedQuery("Student.findByCourse");
                query.setParameter("course", course);
                return query.getResultList();
        }        
        
    @GET
    @Path("findByStudymode/{studymode}")
        @Produces({"application/json"})
        public List<Student> findByStudymode(@PathParam("studymode") String studymode)
        {Query query = em.createNamedQuery("Student.findByStudymode");
                query.setParameter("studymode", studymode);
                return query.getResultList();
        }
    @GET           
    @Path("findByAddress/{address}")
        @Produces({"application/json"})
        public List<Student> findByAddress(@PathParam("address") String address)
        {Query query = em.createNamedQuery("Student.findByAddress");
                query.setParameter("address", address);
                return query.getResultList();
        }
        
    @GET
    @Path("findBySuburb/{suburb}")
        @Produces({"application/json"})
        public List<Student> findBySuburb(@PathParam("suburb") String suburb)
        {Query query = em.createNamedQuery("Student.findBySuburb");
                query.setParameter("suburb", suburb);
                return query.getResultList();
        }   
    
    @GET
    @Path("findByNationality/{nationality}")
        @Produces({"application/json"})
        public List<Student> findByNationality(@PathParam("nationality") String nationality)
        {Query query = em.createNamedQuery("Student.findByNationality");
                query.setParameter("nationality", nationality);
                return query.getResultList();
        }   
    
    @GET
    @Path("findByNativelanguage/{nativelanguage}")
        @Produces({"application/json"})
        public List<Student> findByNativelanguage(@PathParam("nativelanguage") String nativelanguage)
        {Query query = em.createNamedQuery("Student.findByNativelanguage");
                query.setParameter("nativelanguage", nativelanguage);
                return query.getResultList();
        } 
        
        
    @GET
    @Path("findByFavouritesport/{favouritesport}")
        @Produces({"application/json"})
        public List<Student> findByFavouritesport(@PathParam("favouritesport") String favouritesport)
        {Query query = em.createNamedQuery("Student.findByFavouritesport");
                query.setParameter("favouritesport", favouritesport);
                return query.getResultList();
        }

    @GET
    @Path("findByFavouritemovie/{favouritemovie}")
        @Produces({"application/json"})
        public List<Student> findByFavouritemovie(@PathParam("favouritemovie") String favouritemovie)
        {Query query = em.createNamedQuery("Student.findByFavouritemovie");
                query.setParameter("favouritemovie", favouritemovie);
                return query.getResultList();
        }

    @GET
    @Path("findByFavouriteunit/{favouriteunit}")
        @Produces({"application/json"})
        public List<Student> findByFavouriteunit(@PathParam("favouriteunit") String favouriteunit)
        {Query query = em.createNamedQuery("Student.findByFavouriteunit");
                query.setParameter("favouriteunit", favouriteunit);
                return query.getResultList();
        }
        
    @GET
    @Path("findByCurrentjob/{currentjob}")
        @Produces({"application/json"})
        public List<Student> findByCurrentjob(@PathParam("currentjob") String currentjob)
        {Query query = em.createNamedQuery("Student.findByCurrentjob");
                query.setParameter("currentjob", currentjob);
                return query.getResultList();
        }        
        
    @GET
    @Path("findByMonashemail/{monashemail}")
        @Produces({"application/json"})
        public List<Student> findByMonashemail(@PathParam("monashemail") String monashemail)
        {Query query = em.createNamedQuery("Student.findByMonashemail");
                query.setParameter("monashemail", monashemail);
                return query.getResultList();
        }        
        
    @GET
    @Path("findByPassword/{password}")
        @Produces({"application/json"})
        public List<Student> findByPassword(@PathParam("password") String password)
        {Query query = em.createNamedQuery("Student.findByPassword");
                query.setParameter("password", password);
                return query.getResultList();
        }        
 
    @GET
    @Path("findBySubscriptiondate/{subscriptiondate}")
        @Produces({"application/json"})
        public List<Student> findBySubscriptiondate(@PathParam("subscriptiondate") int subscriptiondate)
        {Query query = em.createNamedQuery("Student.findBySfindBySubscriptiondate");
                query.setParameter("subscriptiondate", subscriptiondate);
                return query.getResultList();
        }      
        
        
        
 // Task 2 - b - (2) ( it works)
   @GET
    @Path("findByCourseANDgender/{course}/{gender}")
    @Produces({"application/json"})
    public List<Student> findByCourseANDgender(@PathParam("course") String course, @PathParam("gender") String gender)
    {
        TypedQuery<Student> q = em.createQuery ("SELECT s FROM Student s WHERE s.course = :course AND s.gender = :gender", Student.class);
        q.setParameter("course", course);
        q.setParameter("gender", gender);
     return q.getResultList();
    }  
  
    
    ///// Task 2 - b - (4) join
    @GET
    @Path("findByCourseANDfriendid/{course}/{friendid}")
    @Produces({"application/json"})
    public List<Student> findByCourseANDfriendid(@PathParam("course") String course, @PathParam("friendid") int friendid)
    {
        
        Query query = em.createNamedQuery("Student.findByCourseANDfriendid");
                query.setParameter("course", course);
                query.setParameter("friendid", friendid);
                return query.getResultList();

    }
        
        
    /////// Task 3 (a)
   // @GET
    //@Path("findBysidANDlcocationdate")
  //  @Path("findBysidANDlocationdate/{sid}")
  //  @Produces({"application/json"})
    //////{startdate}/{endingdate}
  //          //, @PathParam("startdate") double startdate, @PathParam("endingdate") double endingdate
   // { Query query = em.createNamedQuery("Student.findBysidANDlocationdate");
    //            query.setParameter("sid", sid);
                //query.setParameter("startdate", startdate);
                //query.setParameter("endingdate", endingdate);
   //             return query.getResultList();
   // }

      
 
    //@GET
    //@Path("findBysidANDlcocationdate")
    //@Path("findBysidANDfriendid/{sid}/{friendid}")
    //@Produces({"application/json"})
    //////{startdate}/{endingdate}
   // public List<Student> findBysidANDfriendid(@PathParam("sid") int sid, @PathParam("friendid") int friendid)
            //, @PathParam("startdate") double startdate, @PathParam("endingdate") double endingdate
   // { Query query = em.createNamedQuery("Student.findBysidANDfriendid");
             //   query.setParameter("sid", sid);
             //   query.setParameter("friendid", friendid);
                //query.setParameter("startdate", startdate);
                //query.setParameter("endingdate", endingdate);
             //   return query.getResultList();
   // }    
    
    
    ////// test   NOT WORK
    //@GET
   // @Path("findBysidANDlcidddddd")
   // @Produces({"application/json"})
   // public List<Student> findBysidANDlcidddddd()
   // {
    //    TypedQuery<Student> q = em.createQuery ("SELECT count(s) as c FROM Student s", Student.class);
        //q.setParameter("sid", sid);
       // q.setParameter("gender", gender);
   //  return q.getResultList();
   // }   

    
    //////test    WORKS
   @GET
    @Path("findByCourseANDunit/{course}/{favouriteunit}")
    @Produces({"application/json"})
    public List<Student> findByCourseANDunit(@PathParam("course") String course, @PathParam("favouriteunit") String favouriteunit)
    {
        TypedQuery<Student> q = em.createQuery ("SELECT s FROM Student s WHERE s.course = :course AND s.favouriteunit = :favouriteunit", Student.class);
        q.setParameter("course", course);
        q.setParameter("favouriteunit", favouriteunit);
     return q.getResultList();
    }  
  

    //////test  not work   
   @GET
    @Path("findBySidWithDate/{sid}/{sdate}/{edate}")
    @Produces({"application/json"})
    public List<Student> findBySidWithDate(@PathParam("sid") int sid, @PathParam("sdate") double sdate, @PathParam("edate") double edate)
    {
        
        //Query q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Student s JOIN s.locationCollection l WHERE s.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate group by l.locationname", Student.class);
      //List<Object[]> rows = q.list();
      
        TypedQuery<Student> q = em.createQuery("SELECT l.locationname, count(l.locationname) FROM Student s JOIN s.locationCollection l WHERE s.sid = :sid AND l.datetime >= :sdate AND l.datetime <= :edate", Student.class);
        q.setParameter("sid", sid);
        q.setParameter("sdate", sdate);
        q.setParameter("edate", edate);
        
        
     return q.getResultList();
    } 
    
  
    
    
    
    
    
 ////// Task 3 e   

    //////work  
   @GET
    @Path("findallFavouriteunits")
    @Produces({"application/json"})
    public JsonObject findBySidWithDates()
    {
 
        TypedQuery<Object[]> q = em.createQuery("SELECT s.favouriteunit, count(s.favouriteunit) FROM Student s group by s.favouriteunit", Object[].class);
       
        List<Object[]> Lists = q.getResultList();
        
        //JsonObject builder = Json.createObjectBuilder();
                //JsonObject jsonObject = Json.createObjectBuilder();
        
        JsonObject jsonObject = Json.createObjectBuilder().build();
      
       String jsonString;
       String Overall = "";
        for (Object[] element : Lists) 
        {
           
          //jsonObject.
            jsonObject = Json.createObjectBuilder().add("favouriteunit", (String)element[0]).add("frequency", (Integer)element[1]).build();
            
           jsonString = jsonObject.toString();
           
           Overall = Overall +"/ "+ jsonString;
            //jsonObject = jsonObjectInside;
        }
        //Json.createObjectBuilder().build().toString();
     //return q.getResultList();
     //JsonObject j = builder.build();
     JsonObject finaljsonObject = Json.createObjectBuilder()
        .add("Results",Overall)
             .build();
        return finaljsonObject;
}


  // Task 3 c matching three attributes
  
    @GET
    @Path("findStdWithSameCourseGenderJob/{sid}")
    @Produces({"application/json"})
    public JsonObject findStdWithSameCourseGenderJob(@PathParam("sid") int sid, @PathParam("course") String course, @PathParam("currentjob") String currentjob, @PathParam("gender") String gender)
    {
 
        TypedQuery<Object[]> q = em.createQuery("SELECT s.course, s.currentjob, s.gender FROM Student s WHERE s.sid = :sid", Object[].class); 
        q.setParameter("sid", sid);
        List<Object[]> Lists = q.getResultList();
        JsonObject jsonObjectq = Json.createObjectBuilder().build();
        
       String a = "";
       String b = "";
       String c = "";
       //String Overall = "";
       String[] threeValues = new String[3];
        for (Object[] element : Lists) 
        {
            a =  (String)element[0];
            b =  (String)element[1];
            c =  (String)element[2];
            
            /////jsonObjectq = Json.createObjectBuilder().add("course",(String)element[0]).add("currentjob",(String)element[1]).add("gender",(String)element[2]).build();
          //jsonObject.
            //jsonObject = Json.createObjectBuilder().add("favouriteunit", (String)element[0]).add("frequency", (Long)element[1]).build();
            
           ///courseq = jsonObjectq.get("course").toString();
           ///currentjobq = jsonObjectq.get("currentjob").toString();
          /// genderq = jsonObjectq.get("gender").toString();
           
        }
               
        // jsonObjectq = Json.createObjectBuilder().add("course",(String)element[0]).add("sport",(String)element[1]).add("course",(String)element[2]).build();
        
       TypedQuery<Object[]> p = em.createQuery("select s.firstname, s.lastname from Student s where s.course = :course AND s.gender = :gender AND s.currentjob = :currentjob", Object[].class); 
       p.setParameter("course", a);
       p.setParameter("currentjob", b);
       p.setParameter("gender", c);
       
        List<Object[]> Listsp = p.getResultList();
        //JsonObject builder = Json.createObjectBuilder();
                //JsonObject jsonObject = Json.createObjectBuilder();
        
        JsonObject jsonObjectp = Json.createObjectBuilder().build();
      
       String jsonString;
       String Overall = "";
        for (Object[] element : Listsp) 
        {
           
          //jsonObject.
            jsonObjectp = Json.createObjectBuilder().add("firstname", (String)element[0]).add("lastname", (String)element[1]).build();
            
           jsonString = jsonObjectp.toString();
           
           Overall = Overall +" "+ jsonString + "/ ";
            //jsonObject = jsonObjectInside;
        }
        //Json.createObjectBuilder().build().toString();
     //return q.getResultList();
     //JsonObject j = builder.build();
     JsonObject finaljsonObject = Json.createObjectBuilder()
        .add("Results",Overall)
             .build();
        return finaljsonObject;
}
   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
// Task 3 d matching any attributes
  
    @GET
    @Path("findWithAnyAttributes/{sid}/{attributesSplitByComma}")
    @Produces({"application/json"})
    public JsonObject findWithAnyAttributes(@PathParam("sid") int sid, 
            @PathParam("course") String course, 
            @PathParam("currentjob") String currentjob, 
            @PathParam("gender") String gender,
            @PathParam("address") String address, 
            @PathParam("dateofbirth") String dateofbirth,
            @PathParam("studymode") String studymode,
            @PathParam("suburb") String suburb,
            @PathParam("nationality") String nationality,
            @PathParam("nativelanguage") String nativelaguage,
            @PathParam("favouritesport") String favouritesport,
            @PathParam("favouritemovie") String favouritemovie,
            @PathParam("favouriteunit") String favouriteunit,
            @PathParam("password") String password,
            @PathParam("monashemail") String monashemail,
            @PathParam("subscriptiondate") int subscriptiondate,
            @PathParam("firstname") String firstname,
            @PathParam("lastname") String lastname,
            @PathParam("attributesSplitByComma") String attributesSplitByComma

            )
    {
 
        
        String[] attributes = attributesSplitByComma.split(",");
        String qStringA = "";

        for (String attribute : attributes)
        {

            String combination = "s." + attribute; // s.sid
            qStringA = qStringA + combination + ", "; // s.sid, 
                    }
        String qStringb = qStringA.substring(0, qStringA.length() - 2);
        String QueryA = "select " + qStringb + " FROM Student s WHERE s.sid = :sid";
        
        TypedQuery<Object[]> q = em.createQuery(QueryA, Object[].class); 
        q.setParameter("sid", sid);
        List<Object[]> Lists = q.getResultList();
        JsonObject jsonObjectq = Json.createObjectBuilder().build();
        
       String a = "";///////////
       String b = "";
       String c = "";
       ;
             
       
        String pStringA = "";
       for (String attribute : attributes)
        {
            String levelA = "s." + attribute; //s.sid
            String levelB = levelA + " = :"+ attribute; //s.sid = :sid
            pStringA = pStringA + levelB + " AND "; //s.sid = :sid AND
                    }
        
       String pQueryA = pStringA.substring(0, pStringA.length() - 4); // move last AND
       String pQueryB = "select s.firstname, s.lastname from Student s where " + pQueryA;
       
       TypedQuery<Object[]> p = em.createQuery(pQueryB, Object[].class);
       
        ///for (Object[] element : Lists)///////////// 
        ///{
         ///   a =  (String)element[0];
         ///   b =  (String)element[1];
         ///   c =  (String)element[2];
   
       /// }
       
       ///p.setParameter("course", a);
       ///p.setParameter("currentjob", b);
      /// p.setParameter("gender", c);
       
       
       
       //////=======  Draft 
       int howLongLists = Lists.size();
       int howLong = attributes.length;
       //for (Object[] element : Lists)
       for (Object[] element : Lists)
       {
           for (int j = 0; j < howLong; j++)
           {
            p.setParameter(attributes[j], (String)element[j]); // ("sid", sid)
           }
       }
       //////=======
       
       
       
        List<Object[]> Listsp = p.getResultList();
        //JsonObject builder = Json.createObjectBuilder();
                //JsonObject jsonObject = Json.createObjectBuilder();
        
        JsonObject jsonObjectp = Json.createObjectBuilder().build();
      
       String jsonString;
       String Overall = "";
        for (Object[] element : Listsp) 
        {
           
          //jsonObject.
            jsonObjectp = Json.createObjectBuilder().add("firstname", (String)element[0]).add("lastname", (String)element[1]).build();
            
           jsonString = jsonObjectp.toString();
           
           Overall = Overall +""+ jsonString;
            //jsonObject = jsonObjectInside;
        }
        //Json.createObjectBuilder().build().toString();
     //return q.getResultList();
     //JsonObject j = builder.build();
     JsonObject finaljsonObject = Json.createObjectBuilder()
        .add("Results",Overall)
             .build();
        return finaljsonObject;
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//// assign2    
 @GET
@Path("findStdAndLatiLongiWithEmail/{monashemail}")
@Produces({"application/json"})
public JsonObject findStdAndLatiLongtiWithemail(@PathParam("monashemail") String monashemail,@PathParam("datetime") String datetime) 
{
TypedQuery<Object[]> q = em.createQuery("SELECT l.locationname FROM Location l WHERE l.sid.monashemail = :monashemail", Object[].class);
q.setParameter("monashemail", monashemail);
List<Object[]> Lists = q.getResultList();
JsonObject jsonObjectq;
   /////JsonObject jsonObjectqTest= Json.createObjectBuilder().add("",1).build();
String a = "";
String b ="";
int c =0;
String stringq = "";
String overallq = "";

//////JsonObject jsonObjectqTest = Lists[0];

for (Object[] element : Lists) 
{
    /////JsonObject j0 = element[0];
    a= (String)element[0];
    jsonObjectq = Json.createObjectBuilder().add("maxdate",(String)element[0]).build();
    //a = element[0].toString();
    //stringq=jsonObjectq.toString();
    overallq= stringq;
}

JsonObject finalObjectTest = Json.createObjectBuilder().add("result",a).build(); 




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
return finalObjectTest;
}    
    
    
    
    
    
/////


//Assign2 
//









 















 @GET
    @Path("findAnyAttributes/{sid}/{attributesSplitByComma}")
    @Produces({"application/json"})
    public List<Student> findAnyAttributes(@PathParam("sid") int sid, 
            @PathParam("course") String course, 
            @PathParam("currentjob") String currentjob, 
            @PathParam("gender") String gender,
            @PathParam("address") String address, 
            @PathParam("dateofbirth") String dateofbirth,
            @PathParam("studymode") String studymode,
            @PathParam("suburb") String suburb,
            @PathParam("nationality") String nationality,
            @PathParam("nativelanguage") String nativelaguage,
            @PathParam("favouritesport") String favouritesport,
            @PathParam("favouritemovie") String favouritemovie,
            @PathParam("favouriteunit") String favouriteunit,
            @PathParam("password") String password,
            @PathParam("monashemail") String monashemail,
            @PathParam("subscriptiondate") int subscriptiondate,
            @PathParam("firstname") String firstname,
            @PathParam("lastname") String lastname,
            @PathParam("attributesSplitByComma") String attributesSplitByComma

            )
    {
 
        
        String[] attributes = attributesSplitByComma.split(",");
        String qStringA = "";

        for (String attribute : attributes)
        {

            String combination = "s." + attribute; // s.sid
            qStringA = qStringA + combination + ", "; // s.sid, 
                    }
        String qStringb = qStringA.substring(0, qStringA.length() - 2);
        String QueryA = "select " + qStringb + " FROM Student s WHERE s.sid = :sid";
        
        TypedQuery<Object[]> q = em.createQuery(QueryA, Object[].class); 
        q.setParameter("sid", sid);
        List<Object[]> Lists = q.getResultList();
        JsonObject jsonObjectq = Json.createObjectBuilder().build();
        
       String a = "";///////////
       String b = "";
       String c = "";
       ;
             
       
        String pStringA = "";
       for (String attribute : attributes)
        {
            String levelA = "s." + attribute; //s.sid
            String levelB = levelA + " = :"+ attribute; //s.sid = :sid
            pStringA = pStringA + levelB + " AND "; //s.sid = :sid AND
                    }
        
       String pQueryA = pStringA.substring(0, pStringA.length() - 4); // move last AND
       String pQueryB = "select s from Student s where " + pQueryA;
       
       TypedQuery<Student> p = em.createQuery(pQueryB, Student.class);
       
        ///for (Object[] element : Lists)///////////// 
        ///{
         ///   a =  (String)element[0];
         ///   b =  (String)element[1];
         ///   c =  (String)element[2];
   
       /// }
       
       ///p.setParameter("course", a);
       ///p.setParameter("currentjob", b);
      /// p.setParameter("gender", c);
       
       
       
       //////=======  Draft 
       int howLongLists = Lists.size();
       int howLong = attributes.length;
       //for (Object[] element : Lists)
       for (Object[] element : Lists)
       {
           for (int j = 0; j < howLong; j++)
           {
            p.setParameter(attributes[j], (String)element[j]); // ("sid", sid)
           }
       }
       //////=======
       
       
       
        
        return p.getResultList();
}


        //// assign2 
////////Work !
@GET
@Path("findfriendsByfeiendid/{sid}")
@Produces({"application/json"})
public List<Student> findfriendsByfeiendid(@PathParam("sid") int sid) 
{
TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s JOIN s.friendshipCollection f WHERE f.sid.sid = :sid", Student.class);
q.setParameter("sid", sid);  
return q.getResultList();
}


        //// assign2 
////////
@GET
@Path("findfriendsBysid2/{sid}")
@Produces({"application/json"})
public String findfriendsBysid2(@PathParam("sid") int sid) 
{
    
    JsonObject jsonObject = Json.createObjectBuilder().build();
    String jsonString ="";
    
    
TypedQuery<Object[]> q = em.createQuery("SELECT s.firstname, s.lastname, s.gender, s.course, s.favouritesport,s.favouriteunit, s.nationality,s.nativelanguage,s.studymode,s.suburb,s.currentjob,s.monashemail,s.favouritemovie FROM Student s JOIN s.friendshipCollection f WHERE f.sid.sid = :sid", Object[].class);
q.setParameter("sid", sid);
List<Object[]> Lists = q.getResultList();

String Overall ="";
for (Object[] element : Lists) {
  
jsonObject = Json.createObjectBuilder().add("firstname", (String)element[0]).add("lastname", (String)element[1]).add("gender", (String)element[2]).add("course", (String)element[3]).add("favouritesport", (String)element[4]).add("favouriteunit", (String)element[5]).add("nationality", (String)element[6]).add("nativelanguage", (String)element[7]).add("studymode", (String)element[8]).add("suburb", (String)element[9]).add("currentjob", (String)element[10]).add("monashemail", (String)element[11]).add("favouritemovie", (String)element[12]).build();
jsonString = jsonObject.toString();
Overall = Overall +"/ "+ jsonString; }
JsonObject finaljsonObject = Json.createObjectBuilder() .add("",Overall)
.build();
return jsonString;





}












        //// assign2 
////////
@GET
@Path("findfriendsByselfsid2/{sid}")
@Produces({"application/json"})
public String findfriendsByselfsid(@PathParam("sid") int sid) 
{
    
    JsonObject jsonObject = Json.createObjectBuilder().build();
    String jsonString ="";
    
    
TypedQuery<Object[]> q = em.createQuery("SELECT s FROM Student s JOIN s.friendshipCollection f WHERE f.sid = :sid", Object[].class);
q.setParameter("sid", sid);
List<Object[]> Lists = q.getResultList();

String Overall ="";
for (Object[] element : Lists) {
  
jsonObject = Json.createObjectBuilder().add("firstname", (String)element[0]).add("lastname", (String)element[1]).add("gender", (String)element[2]).add("course", (String)element[3]).add("favouritesport", (String)element[4]).add("favouriteunit", (String)element[5]).add("nationality", (String)element[6]).add("nativelanguage", (String)element[7]).add("studymode", (String)element[8]).add("suburb", (String)element[9]).add("currentjob", (String)element[10]).add("monashemail", (String)element[11]).add("favouritemovie", (String)element[12]).build();
jsonString = jsonObject.toString();
Overall = Overall +"/ "+ jsonString; }
JsonObject finaljsonObject = Json.createObjectBuilder() .add("",Overall)
.build();
return jsonString;





}














 //////work  
   @GET
    @Path("findallFavouriteunitss")
    @Produces({"application/json"})
    public JsonArray findallFavouriteunitss()
    {
 
        TypedQuery<Object[]> q = em.createQuery("SELECT s.favouriteunit, count(s.favouriteunit) FROM Student s group by s.favouriteunit", Object[].class);
       
        List<Object[]> Lists = q.getResultList();
        
        //JsonObject builder = Json.createObjectBuilder();
                //JsonObject jsonObject = Json.createObjectBuilder();
        
        JsonObject jsonObject = Json.createObjectBuilder().build();
      
       String jsonString;
       String Overall = "";
       JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Object[] element : Lists) 
        {
           
          //jsonObject.
            jsonObject = Json.createObjectBuilder().add("favouriteunit", (String)element[0]).add("frequency", (Long)element[1]).build();
            
           jsonString = jsonObject.toString();
           
           Overall = Overall +"/ "+ jsonString;
           builder.add(jsonObject);
            //jsonObject = jsonObjectInside;
        }
        //Json.createObjectBuilder().build().toString();
     //return q.getResultList();
     //JsonObject j = builder.build();
     JsonObject finaljsonObject = Json.createObjectBuilder()
        .add("Results",Overall)
             .build();
     
     JsonArray jsonarray = builder.build();
        return jsonarray;
}













    
}
