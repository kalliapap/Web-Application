/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kalli
 */
public class User {
    private String email;
    private String psw;
    private String role;
    public boolean exists;
    
    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
            
    public boolean userExists(){
        return exists;
    }
    
    public void setExists(boolean exists){
        this.exists = exists;
    }
}
