package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties myproperties = new Properties();
    private static TestProperties ONLYONE = null;

    private TestProperties(){
        try{
            myproperties.load(new FileInputStream(new File("./" + "settings.properties")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static TestProperties getOnlyOne(){
        if (ONLYONE == null){
            ONLYONE = new TestProperties();
        }
        return ONLYONE;
    }
    public Properties getProperties() { return myproperties ;}
}

