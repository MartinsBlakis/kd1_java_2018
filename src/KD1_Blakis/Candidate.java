/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KD1_Blakis;

import java.util.UUID;
import javasem04.activity.Person;

/**
 *
 * @author Lietotajs
 */
public class Candidate extends Person{
    UUID no;
    int votes;
    
    public Candidate(String name, int age, String comment){
        super(name, age, comment);
        no = UUID.randomUUID();
        votes = 0;
    }
    
    public void setVotes(int votes){
        if (this.votes != votes) {
            this.votes = votes;
        }
    }
    
    public int getVotes(){
        return votes;
    }
    
    public UUID getID(){
        return no;
    }

    @Override
    public int getMyID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}