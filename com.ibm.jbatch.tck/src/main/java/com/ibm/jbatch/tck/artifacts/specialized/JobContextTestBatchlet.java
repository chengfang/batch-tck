/**
 * Copyright 2013, 2020 International Business Machines Corp. and others
 * <p>
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.jbatch.tck.artifacts.specialized;

import jakarta.batch.api.Batchlet;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;

@jakarta.inject.Named("jobContextTestBatchlet")
public class JobContextTestBatchlet implements Batchlet {

    @Inject
    JobContext jobCtx;

    @Override
    public String process() throws Exception {
        jobCtx.setExitStatus("JobName=" + jobCtx.getJobName() + ";JobInstanceId=" + jobCtx.getInstanceId() + ";JobExecutionId=" + jobCtx.getExecutionId());
        return "GOOD";
    }

    @Override
    public void stop() throws Exception {
        // TODO Auto-generated method stub

    }

}
