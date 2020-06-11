package todo.api.test.Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler
{

        public PropertyHandler(){
        }


    /**
     * This method reads property value in properties file
     * @param fileName File Name
     * @param key property name/key
     * @return property value
     * @throws IOException
     */
        public String getProperty(String fileName, String key) throws IOException
        {
            //create object of Properties class.
            Properties prop=new Properties();
            ///Create object of FileInputStream and give property file location as fileInputStream parameter (which property file is to be read)
            FileInputStream ip= new FileInputStream("src\\test\\resources\\properties\\"+fileName);
            //Now we have to load the property file. Use properties object to load property file
            prop.load(ip);
            return prop.getProperty(key);
        }

}
