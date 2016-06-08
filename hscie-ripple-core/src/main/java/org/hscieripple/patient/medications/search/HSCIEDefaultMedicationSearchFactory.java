/*
 * Copyright 2015 Ripple OSI
 *
 *    Licensed under the MedicationSTFT License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.MedicationSTFT.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.hscieripple.patient.medications.search;

import org.rippleosi.common.repo.AbstractRepositoryFactory;
import org.springframework.stereotype.Service;

@Service
public class HSCIEDefaultMedicationSearchFactory extends AbstractRepositoryFactory<HSCIEMedicationSearch>
    implements HSCIEMedicationSearchFactory {

    @Override
    protected HSCIEMedicationSearch defaultRepository() {
        return new HSCIENotConfiguredMedicationSearch();
    }

    @Override
    protected Class<HSCIEMedicationSearch> repositoryClass() {
        return HSCIEMedicationSearch.class;
    }
}
