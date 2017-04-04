/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author gul
 */
public class NewHibernateUtil {

    public static final SessionFactory sessionFact;
  static {
  try {
  // Create the SessionFactory from hibernate.cfg.xml
  sessionFact = new Configuration().configure().buildSessionFactory();
  }
  catch(Throwable e) {
  System.out.println("SessionFactory creation failed." + e);
  throw new ExceptionInInitializerError(e);
  }
  }
  public static final ThreadLocal session = new ThreadLocal();
  
  public static Session currentSession() throws HibernateException {
  Session sess = (Session) session.get();
  // Open a new Session, if this thread has none yet
  if(sess == null){
  sess = sessionFact.openSession();
  // Store it in the ThreadLocal variable
  session.set(sess);
  }
  return sess;
  }
  public static void SessionClose() throws Exception {
  Session s = (Session) session.get();
  if (s != null)
  s.close();
  session.set(null); 
  }
}
