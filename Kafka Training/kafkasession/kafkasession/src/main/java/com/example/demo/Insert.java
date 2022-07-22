package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {
   public static void insert(String columns, String values) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
        		 .getConnection("jdbc:postgresql://localhost:5432/postgres",
                 "postgres", "root");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO public.newtable_1 ( " + columns + " ) "
            + "VALUES ( " + values + " );";
         System.out.println(sql);
         stmt.executeUpdate(sql);
        

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}