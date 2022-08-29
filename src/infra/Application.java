package infra;

import controller.Controller;

import java.util.Scanner;

public class Application {

    private Scanner sc = Container.sc;
    private boolean isActive = true;
    private String myAppName;

    public Application(String myAppName){
        this.myAppName = myAppName;
    }

    public void run(){

        while(isActive){

            String line = "https://" + myAppName + ".com";
            System.out.print(line);
            String inputUri = sc.nextLine().trim();

            if(inputUri.equals(".exit")){
                System.out.println("어플리케이션을 종료합니다.");
                break;
            }

            Request request = new Request(inputUri);
            if(!request.isValidRequest()){
                System.out.println("존재하지 않는 명령어입니다.");
                continue;
            }

            Controller controller = getController(request.getControllerCode());

            if(controller != null){
                controller.execute(request);
            }else{
                System.out.println("올바른 uri를 입력해주세요.");
            }
        }

    }
    public Controller getController(String code){
        switch (code){
            case "system":
                return Container.systemController;
            case "members":
            case "member":
                return Container.memberController;
            case "articles":
            case "article":
                return Container.articleController;
            default:
                return null;
        }
    }
}
