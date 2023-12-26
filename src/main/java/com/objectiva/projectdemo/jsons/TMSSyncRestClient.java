package com.objectiva.projectdemo.jsons;

import org.json.JSONException;
import org.json.JSONObject;

public class TMSSyncRestClient {

    public TMSSyncRestClient() {
    }

    public String getBody() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", "willis");
            json.put("supportEmail", "willis.bai@outlook.com");
            json.put("applicationTitle", "title");
            json.put("orgInternalOnly", false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
