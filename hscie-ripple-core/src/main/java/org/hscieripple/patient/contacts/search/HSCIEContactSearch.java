/*
 * Copyright 2015 Ripple OSI
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.hscieripple.patient.contacts.search;

import java.util.List;

import org.rippleosi.common.repo.Repository;
import org.rippleosi.patient.contacts.model.ContactHeadline;
import org.hscieripple.patient.contacts.model.HSCIEContactDetails;
import org.hscieripple.patient.contacts.model.HSCIEContactSummary;
import org.hscieripple.patient.datasources.model.DataSourceSummary;

/**
 */
public interface HSCIEContactSearch extends Repository {
	
    List<HSCIEContactSummary> findAllContacts(String patientId, List<DataSourceSummary> datasourceSummaries);

    HSCIEContactDetails findContact(String patientId, String contactId, String source);
    
    
}
