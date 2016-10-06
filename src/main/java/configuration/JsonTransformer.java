package configuration;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

/**
 * Created by augustoccesar on 3/17/16.
 */
public class JsonTransformer implements ResponseTransformer {
    public static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd")
            .create();

    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }

    public static <T> T  fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
