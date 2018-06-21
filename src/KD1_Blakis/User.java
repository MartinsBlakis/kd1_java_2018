/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KD1_Blakis;

/**
 *
 * @author Lietotajs
 */
public class User {
    String username;
    String password;
    
    public User(){
        username = "n/a";
        password = "n/a";
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
