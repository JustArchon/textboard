package controller;

import data.Member;
import infra.Container;
import infra.Request;
import service.MemberService;

import java.util.Scanner;

public class MemberController implements Controller{

    private Scanner sc;
    private MemberService memberService;

    public MemberController(){
        this.sc = Container.sc;
        this.memberService = Container.memberService;
    }
    @Override
    public void execute(Request request) {
        switch (request.getTarget()){
            case "join":
                saveMember();
                break;
            default:
                System.out.println("올바른 요청을 보내주시기 바랍니다.");
                break;
        }
    }

    public void saveMember(){

        System.out.println("== 회원가입 ==");

        System.out.print("아이디 : ");
        String loginId = sc.nextLine().trim();

        System.out.print("비밀번호 : ");
        String password = sc.nextLine().trim();

        System.out.print("이름 : ");
        String name = sc.nextLine().trim();

        int memberId = memberService.saveMember(loginId, password, name);

        System.out.println(memberId + "번째 회원님 환영합니다.");
    }
}
