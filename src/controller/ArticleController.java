package controller;

import infra.Container;
import infra.Request;
import service.ArticleService;

import java.util.Scanner;

public class ArticleController implements Controller{
    private Scanner sc;

    private ArticleService articleService;

    public ArticleController(){
        this.sc = Container.sc;
        this.articleService = Container.articleService;
    }
    @Override
    public void execute(Request request) {
        switch (request.getTarget()){
            case "write":
                write(request);
                break;
            case "read":
                read();
                break;
            default:
                System.out.println("존재하지 않는 요청입니다.");
                break;
        }
    }
    public void read(){

    }
    public void write(Request request){
        System.out.println("== 게시글 작성 ==");
        System.out.print("제목 : ");
        String title = sc.nextLine();

        if(title.length() == 0){
            System.out.println("제목을 입력하여 주십시오.");
            return;
        }
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        String author = request.getLogonMemberId();

        int articleId = articleService.write(title, body, author);

        System.out.println(articleId + "번 글이 작성되었습니다.");

    }
}
