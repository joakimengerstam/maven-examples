package integrationtest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProvider {

   private static ConfigurationProvider instance = null;

   private Properties properties;

   private ConfigurationProvider() {
      loadProperties();
   }

   public static ConfigurationProvider getInstance() {
      if (instance == null) {
         instance = new ConfigurationProvider();
      }
      return instance;
   }

   public String getProperty(String name) {
      return properties.getProperty(name);
   }

   private void loadProperties() {

      String env = System.getProperty("env", "dev");
      InputStream is = getClass().getResourceAsStream("/"+env + "-config.properties");
      properties = new Properties();
      try {
         properties.load(is);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (is != null) {
            try {
               is.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   }

}
