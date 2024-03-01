package customJsonObject;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import org.json.JSONObject;

import lombok.extern.slf4j.Slf4j;
public class CustomJsonObject {
    public static JSONObject printJSONObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            Field changeMap = jsonObject.getClass().getDeclaredField("map");
            changeMap.setAccessible(true);
            changeMap.set(jsonObject, new LinkedHashMap<>());
            changeMap.setAccessible(false);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }
}

