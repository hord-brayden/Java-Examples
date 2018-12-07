/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package hibernate11;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import hibernate11.jdbctime;
import java.util.*;
//my netbeans doesn't like when I don't have this SPECIFIC import here, idk why

/**
 *
 * @author Seagull
 */
public class CreateActor {
    
    public static void main(String[] args) {
        
        SessionFactory fact = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(jdbctime.class).buildSessionFactory();
        Session sess = fact.getCurrentSession();
        
    try {
        //Create you as an insert into the Hibernate
        System.out.println("Making you a movie star");
        jdbctime newActor = new jdbctime("Troy", "Tuckett");
        //Open SessionFactory
        sess.beginTransaction();
        sess.save(newActor);
        sess.getTransaction().commit();
        System.out.println("Actor Added!");
        
        //Then we'll delete you as a
        sess.delete(newActor);
        sess.getTransaction().commit();
        System.out.println("Actor Deleted!");
    }
    catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
    }  
    finally{
        //Then close the SessionFactory
        fact.close();
    }

    
   }
}
