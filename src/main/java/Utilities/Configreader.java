package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configreader {
    public static Properties initializeproperties()
    {
        Properties prop=new Properties();
        File propfile=new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");

        try{
            FileInputStream fis=new FileInputStream(propfile);
            prop.load(fis);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return prop;
    }

}
