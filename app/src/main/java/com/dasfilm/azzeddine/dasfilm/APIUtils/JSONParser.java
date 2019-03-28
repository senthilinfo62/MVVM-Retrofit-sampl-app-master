package com.dasfilm.azzeddine.dasfilm.APIUtils;

import com.dasfilm.azzeddine.dasfilm.Entities.Movie;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by azeddine on 4/5/18.
 */

public class JSONParser {

    public static List<Movie> getMovieList(String jsonString) throws JSONException {
        JSONObject responseJson;
        Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        responseJson = new JSONObject(jsonString);

        return gson.fromJson(responseJson.getJSONArray("results").toString(), new TypeToken<List<Movie>>(){}.getType());

    }
}
