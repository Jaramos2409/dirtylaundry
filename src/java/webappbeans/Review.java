/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappbeans;

/**
 *
 * @author Hien Nguyen
 */
import java.io.Serializable;
public class Review implements Serializable {
    
    private int id;
    private int reviewer_id;
    private String reviewer_name;
    private int reviewee_id;
    private String reviewtext; 
    private int disagree_count;
    private int agree_count;
    

    public Review() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(int reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public int getReviewee_id() {
        return reviewee_id;
    }

    public void setReviewee_id(int reviewee_id) {
        this.reviewee_id = reviewee_id;
    }

    public String getReviewtext() {
        return reviewtext;
    }

    public void setReviewtext(String reviewtext) {
        this.reviewtext = reviewtext;
    }
    
    
    public int getDisagree_count() {
        return disagree_count;
    }

    public void setDisagree_count(int disagree_count) {
        this.disagree_count = disagree_count;
    }

    public int getAgree_count() {
        return agree_count;
    }

    public void setAgree_count(int agree_count) {
        this.agree_count = agree_count;
    }

    public String getReviewer_name() {
        return reviewer_name;
    }

    public void setReviewer_name(String reviewer_name) {
        this.reviewer_name = reviewer_name;
        }
}
