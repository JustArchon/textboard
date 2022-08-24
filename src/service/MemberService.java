package service;

import infra.Container;
import repository.MemberRepository;

public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(){
        this.memberRepository = Container.memberRepository;
    }
    public int saveMember(String loginId, String password, String name){
        return memberRepository.saveMember(loginId, password, name);
    }
}
