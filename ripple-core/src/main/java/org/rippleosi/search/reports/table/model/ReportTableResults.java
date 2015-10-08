package org.rippleosi.search.reports.table.model;

import java.util.List;

import org.rippleosi.search.common.model.SearchTablePatientDetails;

public class ReportTableResults {

    private String totalPatients;
    private List<SearchTablePatientDetails> patientDetails;

    public String getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(String totalPatients) {
        this.totalPatients = totalPatients;
    }

    public List<SearchTablePatientDetails> getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(List<SearchTablePatientDetails> patientDetails) {
        this.patientDetails = patientDetails;
    }
}