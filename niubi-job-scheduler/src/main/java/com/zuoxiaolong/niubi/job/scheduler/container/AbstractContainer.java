/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zuoxiaolong.niubi.job.scheduler.container;

import com.zuoxiaolong.niubi.job.core.helper.AssertHelper;
import com.zuoxiaolong.niubi.job.scanner.JobScanner;
import com.zuoxiaolong.niubi.job.scanner.JobScannerFactory;

/**
 * @author Xiaolong Zuo
 * @since 16/1/17 22:20
 */
public abstract class AbstractContainer implements Container {

    private JobScanner jobScanner;

    /**
     * for local
     * @param classLoader
     */
    public AbstractContainer(ClassLoader classLoader, String packagesToScan) {
        this.jobScanner = JobScannerFactory.createClasspathJobScanner(classLoader, packagesToScan);
    }

    /**
     * for remote
     * @param jarUrl
     */
    public AbstractContainer(ClassLoader classLoader, String packagesToScan, String jarUrl) {
        AssertHelper.notEmpty(jarUrl, "jar url can't be empty.");
        this.jobScanner = JobScannerFactory.createJarFileJobScanner(classLoader, packagesToScan, jarUrl);
    }

    protected JobScanner getJobScanner() {
        return jobScanner;
    }

}