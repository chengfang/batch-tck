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

import java.util.ArrayList;
import java.util.List;

import jakarta.batch.api.AbstractBatchlet;
import jakarta.batch.runtime.context.JobContext;
import jakarta.batch.runtime.context.StepContext;
import jakarta.inject.Inject;

@jakarta.inject.Named("splitFlowTransitionLoopTestBatchlet")
public class SplitFlowTransitionLoopTestBatchlet extends AbstractBatchlet {

    public static String GOOD_EXIT_STATUS = "VERY GOOD INVOCATION";

    @Inject
    JobContext jobCtx;

    @Inject
    StepContext stepCtx = null;

    @Override
    public String process() throws Exception {
        List<String> stepsInJob = new ArrayList<String>();
        stepsInJob.add("split1FlowStep1");
        stepsInJob.add("split1FlowStep2");
        stepsInJob.add("split1FlowSplitFlow1Step");
        stepsInJob.add("split1FlowSplitFlow2Step");
        stepsInJob.add("flow2step1");
        stepsInJob.add("flow2step2");

        if (!stepsInJob.contains(stepCtx.getStepName())) {
            throw new Exception("Failed to assert steps id");
        }

        return GOOD_EXIT_STATUS;
    }

}
