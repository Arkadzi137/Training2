package framework.utils;

import framework.Log;
import lombok.SneakyThrows;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    @SneakyThrows
    public static List<String> getBookTitleListByAPI(JSONArray listBooks) {
        Log.info("Get list data");
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < listBooks.length(); i++) {
            titles.add(listBooks.getJSONObject(i).get("title").toString());
        }
        return titles;
    }
}
