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
    
    private int sourceid;
    private int target_id;
    private int review_count;
    private int reviewer_count;
    private int reviewee_count;
    private int disagree_count;
    private int agree_count;

    public int getSourceid() {
        return sourceid;
    }

    public void setSourceid(int sourceid) {
        this.sourceid = sourceid;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public int getReviewer_count() {
        return reviewer_count;
    }

    public void setReviewer_count(int reviewer_count) {
        this.reviewer_count = reviewer_count;
    }

    public int getReviewee_count() {
        return reviewee_count;
    }

    public void setReviewee_count(int reviewee_count) {
        this.reviewee_count = reviewee_count;
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

    
}
