package framework.api;

import demoQA.entity.ResponseJSONModel;
import framework.Log;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;
import lombok.SneakyThrows;

public class ApiRequest {
    @SneakyThrows
    public static HttpRequestWithBody post(String request) {
        Log.info("API: Sending POST request with body");
        HttpResponse<JsonNode> jsonResponse = null;
        jsonResponse = Unirest.post(request).asJson();
        return Unirest.post(request);
    }

    @SneakyThrows
    public static ResponseJSONModel get(String request) {
        Log.info("API: Sending GET request with body");
        HttpResponse<JsonNode> jsonResponse = null;
        jsonResponse = Unirest.get(request).asJson();
        return new ResponseJSONModel(jsonResponse.getStatus(), jsonResponse.getBody());
    }
}
