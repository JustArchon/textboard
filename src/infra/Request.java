package infra;

import utils.UriParser;

import java.util.Map;

public class Request {

    private UriParser uriParser;

    public Request(String uri){
        this.uriParser = new UriParser(uri);
    }

    private void setSessionAttribute(String key, Object value){
        Session session = Container.session;
        session.setAttribute(key, value);
    }
    private Object getSessionAttribute(String key){
        Session session =  Container.session;
        return session.getAttribute(key);
    }

    public void removeSessionAttribute(String key){
        Session session = Container.session;
        session.removeAttribute(key);
    }

    public boolean hasSessionAttribute(String key){
        Session session = Container.session;
        return session.hasAttribute(key);
    }
    public void login(String loginId){
        setSessionAttribute("logonMember", loginId);
    }

    public void logout(){
        removeSessionAttribute("logonMember");
    }
    public boolean isLogon(){
        return hasSessionAttribute("logonMember");
    }
    public String getLogonMemberId(){
        return (String)getSessionAttribute("logonMember");
    }
    public boolean isValidRequest(){
        return uriParser.isValid();
    }
    public String getControllerCode(){
        return uriParser.getControllerCode();
    }
    public String getTarget(){
        return uriParser.getTarget();
    }

//    public Object getParameterValue(String key, Class cls){
//        Map<String, Object> parameter = uriParser.getParameter();
//        return cls.cast(parameter.get(key));
//    }
    public int getParameterIntValue(String key){
        Map<String, Object> parameter = uriParser.getParameter();
        return Integer.parseInt(parameter.get(key).toString());
    }
    public String getParameterStrValue(String key){
        Map<String, Object> parameter = uriParser.getParameter();
        return parameter.get(key).toString();
    }
}
