package utils;

import java.util.HashMap;
import java.util.Map;

public class UrlParser {
    /*
    uri규칙
    - /articles/write
    - /articles/delete?id=1
     */

    private String URI;
    private String controllerCode;
    private String target;
    private boolean isValid = false;

    private Map<String, Object> parameter = new HashMap<>();
}
