/*
 * Copyright 2015 Ripple OSI
 *
 *    Licensed under the HSCIEAppointment License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.HSCIEAppointment.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.hscieripple.audit.rest;
import java.util.List;

import org.hscieripple.audit.model.AuditDetails;
import org.hscieripple.audit.model.AuditSummary;
import org.hscieripple.audit.search.AuditSearch;
import org.hscieripple.audit.search.AuditSearchFactory;
import org.rippleosi.common.types.RepoSourceType;
import org.rippleosi.common.types.lookup.RepoSourceLookupFactory;
import org.rippleosi.search.reports.table.model.ReportTableQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit")
public class HSCIEAuditController {

	@Autowired  
	private RepoSourceLookupFactory repoSourceLookup;  

    @Autowired
    private AuditSearchFactory auditSearchFactory;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<AuditSummary> findAllAudits(@RequestParam(required = false) String source,
    									    @RequestBody ReportTableQuery tableQuery) {
		final RepoSourceType sourceType = repoSourceLookup.lookup(source); 	
		AuditSearch auditSearch = auditSearchFactory.select(sourceType);
		
		return auditSearch.findAllAudits(tableQuery);
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public List<AuditDetails> findAppointment(@PathVariable("username") String username,
                                              @RequestParam("patientNhsNumber") long nhsNumber,
                                              @RequestParam(required = false) String source,
                                              @RequestBody ReportTableQuery tableQuery) {
    	final RepoSourceType sourceType = repoSourceLookup.lookup(source); 
		AuditSearch auditSearch = auditSearchFactory.select(sourceType);
       
		return auditSearch.findAuditsByPatientAndUser(nhsNumber, username, tableQuery);
    }
    
}
