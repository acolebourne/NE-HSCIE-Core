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

package org.hscieripple.patient.medications.search;

import java.util.List;

import org.rippleosi.common.exception.ConfigurationException;
import org.rippleosi.common.types.RepoSourceTypes; 
import org.rippleosi.common.types.RepoSourceType;
import org.hscieripple.patient.medications.model.HSCIEMedicationDetails;
import org.hscieripple.patient.medications.model.HSCIEMedicationSummary;
import org.hscieripple.patient.contacts.search.HSCIEContactSearch;
import org.hscieripple.patient.datasources.model.DataSourceSummary;
import org.rippleosi.patient.medication.model.MedicationHeadline;

public class HSCIENotConfiguredMedicationSearch implements HSCIEMedicationSearch {

	@Override
    public RepoSourceType getSource() {
        return RepoSourceTypes.NONE;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public List<HSCIEMedicationSummary> findAllMedications(String patientId, List<DataSourceSummary> datasourceSummaries) {
        throw ConfigurationException.unimplementedTransaction(HSCIEMedicationSearch.class);
    }
    
    @Override
    public List<MedicationHeadline> findAllMedicationHeadlines(String patientId, List<DataSourceSummary> datasourceSummaries) {
        throw ConfigurationException.unimplementedTransaction(HSCIEContactSearch.class);
    }

    @Override
    public HSCIEMedicationDetails findMedication(String patientId, String medicationId, String sourceId) {
        throw ConfigurationException.unimplementedTransaction(HSCIEMedicationSearch.class);
    }
}
