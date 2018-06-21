/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KD1_Blakis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lietotajs
 */
public class ActionsWithDB {
    static ArrayList<Candidate> allCandidates = new ArrayList<Candidate>();
    static Connection c = null;  
    static Statement stmt = null;
    public static void main(String[] args){
        ArrayList<Candidate> candidates = null;
        makeConnection();
        //createAndInsertDB(candidates);
        candidates = selectAllCandidatesSQL();
        closeDB();
    }
    
    public static void makeConnection() { 
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:IIHF16.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
    }
    
    public static void closeDB() { 
      try {
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database closed");
    }
    
    public static void createAndInsertDB(ArrayList<Candidate> candidates){
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE CANDIDATE " +
                        "(CandidateID     INTEGER PRIMARY KEY   AUTOINCREMENT," +
                        " NAME            TEXT    NOT NULL, " + 
                        " AGE             INT     NOT NULL, " + 
                        " COMMENT         VARCHAR(50)," +
                        " VOTES           INT )"; 

            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    
    public static ArrayList<Candidate> selectAllCandidatesSQL(){
        //ArrayList<Candidate> allCandidates = new ArrayList<Candidate>();
        try{
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM CANDIDATE;" );
            
            while ( rs.next() ) {
               String name = rs.getString("NAME"); 
               int age = rs.getInt("AGE");
               String comment = rs.getString("COMMENT");
               int votes = rs.getInt("VOTES");
       
               Candidate candidate1 = new Candidate(name, age, comment);
               candidate1.setVotes(votes);
               
               allCandidates.add(candidate1);
            }
            
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return allCandidates;
    }
    
    public static void printAllCandidates(){
        for (int i = 0; i < allCandidates.size(); i++) { //Checks for user selected numbers.
            System.out.println(allCandidates.get(i));
        }
    }
}
