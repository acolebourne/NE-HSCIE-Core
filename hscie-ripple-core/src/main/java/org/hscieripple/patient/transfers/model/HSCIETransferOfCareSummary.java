/*
 * Copyright 2015 Ripple OSI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hscieripple.patient.transfers.model;

import java.util.Date;

public class HSCIETransferOfCareSummary {

    private String sourceId;
    private String siteFrom;
    private String siteTo;
    private Date dateOfTransfer;
    private String HSP;
    private String careType;
    private String source;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSiteFrom() {
        return siteFrom;
    }

    public void setSiteFrom(String siteFrom) {
        this.siteFrom = siteFrom;
    }

    public String getSiteTo() {
        return siteTo;
    }

    public void setSiteTo(String siteTo) {
        this.siteTo = siteTo;
    }

    public Date getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(Date dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }
    
    
    public String getHSP() {
        return HSP;
    }

    public void setHSP(String HSP) {
        this.HSP = HSP;
    }
    
    
    public String getCareType() {
        return careType;
    }

    public void setCareType(String careType) {
        this.careType = careType;
    }
    
    

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
