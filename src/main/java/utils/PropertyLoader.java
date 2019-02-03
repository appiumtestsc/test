package utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import entity.Account;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * app.properties, cre.json
 */
public abstract class PropertyLoader {

    private static final String PROPERTY_PATH = "src/main/resources/";
    private static final String APP_PROPERTIES = "app.properties";
    private static final String CRE_JSON = "cre.json";
    private static Properties PROPERTIES;

    public static String loadProperty(final String key) {
        if (PROPERTIES == null) {
            PROPERTIES = new Properties();
            URL props = ClassLoader.getSystemResource(APP_PROPERTIES);
            try {
                PROPERTIES.load(new InputStreamReader(props.openStream(), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return PROPERTIES.getProperty(key);
    }

    public static Account loadUser() {
        JsonReader reader;
        JSOMProp r = new JSOMProp();
        try (FileInputStream fs = new FileInputStream(PROPERTY_PATH + CRE_JSON);
             InputStreamReader is = new InputStreamReader(fs, "UTF-8")) {
            reader = new JsonReader(is);
            r = new Gson().fromJson(reader, JSOMProp.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r.getAccount();
    }
}

@Data
class JSOMProp {
    private Account account;
}