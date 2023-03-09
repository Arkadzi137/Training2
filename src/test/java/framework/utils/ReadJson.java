package framework.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadJson {
    private static JSONObject jsonConfig;
    private static JSONObject jsonTesting;
    public static JSONObject getJsonConfig() {
        return jsonConfig;
    }
    public static JSONObject getJsonTesting() {
        return jsonTesting;
    }

    static {
        try {
            JSONParser parser = new JSONParser();
            try {
                FileReader fileReaderConfig = new FileReader("./src/test/resources/config/config.json");
                jsonConfig = (JSONObject) parser.parse(fileReaderConfig);
                FileReader fileReaderTesting = new FileReader("./src/test/resources/config/testing.json");
                jsonTesting = (JSONObject) parser.parse(fileReaderTesting);
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getConfigData(String key){
        return ReadJson.getJsonConfig().get(key);
    }

    public static Object getTestingData(String key){
        return ReadJson.getJsonTesting().get(key);
    }



}