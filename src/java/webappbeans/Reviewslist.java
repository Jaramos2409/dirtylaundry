/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappbeans;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EVA Unit 02
 */
public class Reviewslist implements Serializable {
    
   private int ownerid;
   private int reviewercount;
   private int revieweecount;
   private List<Review> reviews;

    public Reviewslist() {
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getReviewercount() {
        return reviewercount;
    }

    public void setReviewercount(int reviewercount) {
        this.reviewercount = reviewercount;
    }

    public int getRevieweecount() {
        return revieweecount;
    }

    public void setRevieweecount(int revieweecount) {
        this.revieweecount = revieweecount;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
   
   
    
}
