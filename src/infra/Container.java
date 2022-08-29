package infra;

import controller.ArticleController;
import controller.Controller;
import controller.MemberController;
import controller.SystemController;
import repository.ArticleRepository;
import repository.MemberRepository;
import service.ArticleService;
import service.MemberService;

import java.util.Scanner;

public class Container {

    public static Scanner sc;
    public static Session session;
    public static SystemController systemController;
    public static ArticleController articleController;
    public static MemberRepository memberRepository;
    public static ArticleRepository articleRepository;
    public static MemberService memberService;
    public static ArticleService articleService;
    public static MemberController memberController;

    static {
        sc = new Scanner(System.in);
        session = new Session();
        systemController = new SystemController();

        memberRepository = new MemberRepository();
        articleRepository = new ArticleRepository();

        memberService = new MemberService();
        articleService = new ArticleService();

        memberController = new MemberController();
        articleController = new ArticleController();
    }

}
