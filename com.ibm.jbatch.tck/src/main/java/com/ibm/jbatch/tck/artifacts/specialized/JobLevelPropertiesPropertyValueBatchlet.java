/*
 * Copyright 2013, 2020 International Business Machines Corp. and others
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.jbatch.tck.artifacts.specialized;

import java.util.Properties;

import jakarta.batch.api.AbstractBatchlet;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;

@jakarta.inject.Named("jobLevelPropertiesPropertyValueBatchlet")
public class JobLevelPropertiesPropertyValueBatchlet extends AbstractBatchlet {

    @Inject
    JobContext JobCtx;

    public static String GOOD_EXIT_STATUS = "VERY GOOD INVOCATION";

    @Override
    public String process() throws Exception {

        Properties properties = JobCtx.getProperties();
        String foo = properties.getProperty("foo");

        JobCtx.setExitStatus(foo);

        return GOOD_EXIT_STATUS;
    }

}
