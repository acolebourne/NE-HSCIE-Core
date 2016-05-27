/*
 * Copyright 2016 Ripple OSI
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

package org.hscieripple.patient.consent.search;

import org.rippleosi.common.repo.AbstractRepositoryFactory;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class DefaultConsentSearchFactory extends AbstractRepositoryFactory<ConsentSearch> implements ConsentSearchFactory {

    @Override
    protected ConsentSearch defaultRepository() {
        return new NotConfiguredConsentSearch();
    }

    @Override
    protected Class<ConsentSearch> repositoryClass() {
        return ConsentSearch.class;
    }
}