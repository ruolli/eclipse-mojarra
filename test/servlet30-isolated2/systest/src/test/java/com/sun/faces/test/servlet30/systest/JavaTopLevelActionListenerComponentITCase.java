/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.servlet30.systest;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Unit tests for Composite Components.
 */
public class JavaTopLevelActionListenerComponentITCase extends HtmlUnitFacesITCase {

    public JavaTopLevelActionListenerComponentITCase() {
        this("JavaTopLevelActionListenerComponentTestCase");
    }

    public JavaTopLevelActionListenerComponentITCase(String name) {
        super(name);
    }

    /**
     * Set up instance variables required by this test case.
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Return the tests included in this test suite.
     */
    public static Test suite() {
        return (new TestSuite(JavaTopLevelActionListenerComponentITCase.class));
    }

    /**
     * Tear down instance variables required by this test case.
     */
    @Override
    public void tearDown() {
        super.tearDown();
    }

    // -------------------------------------------------------------- Test Cases

    public void testActionListeningComponentWasInvokedSuccessFully() throws Exception {
        HtmlPage page = getPage("/faces/composite/javaTopLevelActionListenerComponentUsingPage.xhtml");
        HtmlInput htmlInput = getInputContainingGivenId(page, "loginAction");
        HtmlPage newPage = htmlInput.click();
        String text = newPage.asText();
        assertTrue(-1 != text.indexOf("javax.faces.Command"));
        assertTrue(-1 != text.indexOf("Action was processed successfully"));
    }

}
