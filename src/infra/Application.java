package infra;

import controller.Controller;

import java.util.Scanner;

public class Application {

    private Scanner sc = Container.sc;
    private boolean isActive = true;

    public void run(){

        while(isActive){
            System.out.print("명령어 : ");
            String inputUri = sc.nextLine().trim();

            Request request = new Request(inputUri);
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
            default:
                return null;
        }
    }
}
