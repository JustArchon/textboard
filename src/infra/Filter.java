package infra;

import config.ApplicationConfig;

public class Filter {

    public Request request;

    public Filter(Request request){
        this.request = request;
    }

    private boolean isAnonymous(String url){
        String[] anonymousUriList = ApplicationConfig.anonymousUriList;

        for(String regUrl : anonymousUriList){
            if(regUrl.equals(url)){
                return true;
            }
        }
        return false;
    }
    private boolean isNeedAuth(String url){
        String[] hasAuthUriList = ApplicationConfig.hasAuthUriList;

        for(String regUrl : hasAuthUriList){
            if(regUrl.equals(url)){
                return true;
            }
        }
        return false;
    }
}
