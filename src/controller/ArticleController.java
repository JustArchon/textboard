package controller;

import data.Article;
import data.Member;
import infra.Container;
import infra.Request;
import service.ArticleService;
import utils.Util;

import java.time.LocalDateTime;
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
            case "detail":
                detail(request);
                break;
            case "delete":
                delete(request);
                break;
            case "modify":
                modify(request);
                break;
            default:
                System.out.println("존재하지 않는 요청입니다.");
                break;
        }
    }
    public void detail(Request request){
        String paramKey = "id";
        if(!Util.hasParam(request, paramKey)){
            System.out.println(paramKey + " 파라미터가 필요합니다.");
            return;
        }
        int articleId = request.getParameterIntValue(paramKey);

        Article findArticle = articleService.getById(articleId);

        if(findArticle == null){
            System.out.println("해당 게시글은 존재하지 않습니다.");
            return;
        }

        System.out.println("== " + articleId + "번 게시글 ==");
        System.out.print("작성자 : ");
        System.out.println(findArticle.getAuthor());
        System.out.print("제목 : ");
        System.out.println(findArticle.getTitle());
        System.out.print("내용 : ");
        System.out.println(findArticle.getBody());
        System.out.print("작성일 : ");
        System.out.println(findArticle.getRegDate());
        System.out.print("수정일 : ");
        System.out.println(findArticle.getUpdateDate());

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
    public void delete(Request request){

        String paramKey = "id";
        if(!Util.hasParam(request, paramKey)){
            System.out.println(paramKey + "파라미터가 필요합니다.");
            return;
        }
        int articleId = request.getParameterIntValue(paramKey);

        Article findArticle = articleService.getById(articleId);

        if(findArticle == null){
            System.out.println("해당 게시물은 존재하지 않습니다.");
            return;
        }
        if(!request.getLogonMemberId().equals(findArticle.getAuthor())) {
            System.out.println("권한이 없습니다.");
            return;
        }
            articleService.delete(findArticle);
            System.out.println(articleId + "번 게시글이 성공적으로 삭제되었습니다.");
    }
    public void modify(Request request){
        String paramKey = "id";
        if(!Util.hasParam(request, paramKey)){
            System.out.println(paramKey + "파라미터가 필요합니다.");
            return;
        }
        int articleId = request.getParameterIntValue(paramKey);

        Article findArticle = articleService.getById(articleId);

        if(findArticle == null){
            System.out.println("해당 게시물은 존재하지 않습니다.");
            return;
        }
        if(!request.getLogonMemberId().equals(findArticle.getAuthor())) {
            System.out.println("권한이 없습니다.");
            return;
        }
        System.out.println("== " + articleId + "번 게시글 수정 ==");
        System.out.print("제목 : ");
        String newtitle = sc.nextLine().trim();
        System.out.print("내용 : ");
        String newbody = sc.nextLine().trim();
        findArticle.setTitle(newtitle);
        findArticle.setBody(newbody);
        findArticle.setUpdateDate(LocalDateTime.now());
        System.out.println("정상적으로 글이 수정되었습니다.");
    }
}
