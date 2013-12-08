/*
 * Copyright (c) 2013 Carnegie Mellon University Silicon Valley.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available
 * under the terms of dual licensing(GPL V2 for Research/Education
 * purposes). GNU Public License v2.0 which accompanies this distribution
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact http://www.cmu.edu/silicon-valley/ if you have any
 * questions.
 */

package integration;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
 * Contains Integration tests - for testing proper html rendering
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class IntegrationTest
{
   /**
    * simple integration test to check if the index page is being shown
    */
   @Test
   public void simpleIndexTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333");
                  assertThat(browser.pageSource()).contains(
                        "Team Mercury");
               }
            });
   }

}
