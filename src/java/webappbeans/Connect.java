/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappbeans;

import java.io.Serializable;

/**
 *
 * @author nk5946
 */
public class Connect implements Serializable {
    
    private int id;
    private int requestorid;
    private int requestedid;
    private int requestaccepted;

    public Connect() {
    }

    public Connect(int id, int requestorid, int requestedid, int requestaccepted) {
        this.id = id;
        this.requestorid = requestorid;
        this.requestedid = requestedid;
        this.requestaccepted = requestaccepted;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequestorid() {
        return requestorid;
    }

    public void setRequestorid(int requestorid) {
        this.requestorid = requestorid;
    }

    public int getRequestedid() {
        return requestedid;
    }

    public void setRequestedid(int requestedid) {
        this.requestedid = requestedid;
    }

    public int getRequestaccepted() {
        return requestaccepted;
    }

    public void setRequestaccepted(int requestaccepted) {
        this.requestaccepted = requestaccepted;
    }
    
    
}
