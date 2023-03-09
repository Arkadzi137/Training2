package demoQA.entity;

import com.mashape.unirest.http.JsonNode;
import lombok.Data;

@Data
public class ResponseJSONModel {
    protected int statusCode;
    protected JsonNode body;

    public ResponseJSONModel(int statusCode, JsonNode body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
