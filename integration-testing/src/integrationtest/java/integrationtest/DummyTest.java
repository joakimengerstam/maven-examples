package integrationtest;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DummyTest {

    @Test
    public void dummyTest() {
        ConfigurationProvider configuration = ConfigurationProvider.getInstance();
        assertEquals("integration-test", configuration.getProperty("profile"));
        assertTrue(true);
    }


}
