package utils;

import infra.Request;

public class Util {

    public static boolean hasParam(Request request, String key){

        return request.hasParam(key);
    }
}
