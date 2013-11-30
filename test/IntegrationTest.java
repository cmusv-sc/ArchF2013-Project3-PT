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
