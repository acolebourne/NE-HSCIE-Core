package org.rippleosi.patient.careplans.model;

import java.io.Serializable;
import java.util.Date;

/**
 */
public class CPRDecision implements Serializable {

    private String cprDecision;
    private Date dateOfDecision;
    private String comment;

    public String getCprDecision() {
        return cprDecision;
    }

    public void setCprDecision(String cprDecision) {
        this.cprDecision = cprDecision;
    }

    public Date getDateOfDecision() {
        return dateOfDecision;
    }

    public void setDateOfDecision(Date dateOfDecision) {
        this.dateOfDecision = dateOfDecision;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
