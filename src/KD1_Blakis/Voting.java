/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KD1_Blakis;

import static KD1_Blakis.ActionsWithDB.stmt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author Lietotajs
 */
public class Voting {
     public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Candidate> allCandidates = new ArrayList<>();
        generateCandidates();
        Voting vote = new Voting();
        vote.generateCandidates();       // Creates file with candidates with generateCandidates function
        
        ArrayList<User> allUsers = new ArrayList<>();
        User user1 = new User("admin", "admin");
        User user2 = new User("lietotajs", "parole");
        User user3 = new User("test", "test");
        User user4 = new User("test2", "test");
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        
        String username;
        String password;
         try (Scanner reader = new Scanner(System.in)) {
             System.out.println("Enter username: ");
             username = reader.next();
             System.out.println("Enter password: ");
             password = reader.next();
         }
        
         for (User allUser : allUsers) {
             if( (allUser.getUsername().equals(username)) && (allUser.getPassword().equals(password)) ){
                 try {
                    System.out.println("You have successfuly logged in! Hello, "+username+ "!");
                    BufferedReader br = new BufferedReader( new FileReader( "CandidateList.txt" ) );
                    while (br.readLine() != null) {
                        String txtName = br.readLine();
                        String [] tokens = txtName.split("\n");
                        String name = tokens[0];
                        int txtAge = Integer.valueOf(tokens[1]);
                        Candidate candidate = new Candidate(txtName, txtAge, "");
                        allCandidates.add(candidate);
                        
                        
                        /*
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("text.txt"));
                        int txtAge2 = ois.readInt();
                        String txtName2 = (String) ois.readObject();
                        String txtCom2 = (String) ois.readObject();
                        int txtVote2 = ois.readInt();
                        Candidate candidate2 = new Candidate(txtName2, txtAge2, "");
                        allCandidates.add(candidate2);
                        */
                    }
                    br.close();
                    System.out.println(allCandidates);
                     
                 } catch (Exception e) {
                     
                 }
             }else {
                 System.out.println("Incorrect username/password");
             }
         }
    }

    public static void generateCandidates() {
        Random rand = new Random();
        int  age = rand.nextInt(70) + 18;
        Candidate canOne = new Candidate("Varis Jurnieks", age, "");
        age = rand.nextInt(70) + 18;
        Candidate canTwo = new Candidate("Ainars Mielavs", age, "");
        age = rand.nextInt(70) + 18;
        Candidate canThree = new Candidate("Kristaps Kulbergs", age, "");
        
        ArrayList<Candidate> allCandidates = new ArrayList<Candidate>();
        allCandidates.add(canOne);
        allCandidates.add(canTwo);
        allCandidates.add(canThree);
        
        try (PrintWriter writer = new PrintWriter("CandidateList.txt", "UTF-8")) {
            for (Candidate allCandidate : allCandidates) {
                writer.println(allCandidate.getName());
                writer.println(allCandidate.getAge());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
        
        /*
        try {
            FileOutputStream fos = new FileOutputStream("text.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);   
            oos.writeObject(allCandidates); // write MenuArray to ObjectOutputStream
            oos.close(); 
        } catch(Exception ex) {
            ex.printStackTrace();
        }*/
        
        
        
    }
}