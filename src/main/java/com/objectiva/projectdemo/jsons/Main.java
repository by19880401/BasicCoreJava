package com.objectiva.projectdemo.jsons;

import cn.hutool.log.StaticLog;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class Main {
    public static final String NAME_KEY = "name";
    private static final String NAME_NODE_NOT_FOUND = "Name node not found";

    public static void main(String[] args) {
        try {
            String response = getBrandOrClientId();
            validateNodeInResponse(response, NAME_KEY, NAME_NODE_NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void validateNodeInResponse(final String response, final String key, final String message) throws Exception {
        if (StringUtils.isBlank(response)) {
            throw new TMSException("response is empty");
        }

        String nameKey = getNameKey(response);
        if (StringUtils.isBlank(nameKey)) {
            throw new TMSException(message);
        }

        StaticLog.info("success.................");

    }

    private static String getNameKey(final String response) {
        final JSONObject jsonObject = new JSONObject(response);
        return (String) jsonObject.get(NAME_KEY);
    }

    private static String getBrandOrClientId() {
        return new TMSSyncRestClient().getBody();
    }


}
