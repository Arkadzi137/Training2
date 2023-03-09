package demoQA.apiDemoQA;

import demoQA.entity.ResponseJSONModel;
import framework.api.ApiRequest;
import framework.Log;
import framework.utils.ReadJson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import lombok.SneakyThrows;
import org.json.JSONArray;

public class ApiUtils {

    private static final String API_URI = ReadJson.getConfigData("api").toString();
    private static final String CREATE_ACCOUNT = ReadJson.getConfigData("createAccount").toString();
    private static final String GET_BOOKS = ReadJson.getConfigData("getBooks").toString();

    @SneakyThrows
    public static ResponseJSONModel createAccount(String userName, String password) {
        Log.info("API: create account");
        String request = API_URI + CREATE_ACCOUNT;
        HttpResponse<JsonNode> jsonResponse = ApiRequest.post(request)
                .field("userName", userName)
                .field("password", password).asJson();
        Log.info("API: Response status " + jsonResponse.getStatus());
        return new ResponseJSONModel(jsonResponse.getStatus(), jsonResponse.getBody());
    }

    @SneakyThrows
    public static JSONArray getBooks() {
        Log.info("API: get books");
        return ApiRequest.get(API_URI + GET_BOOKS).getBody().getObject().optJSONArray("books");
    }
}
