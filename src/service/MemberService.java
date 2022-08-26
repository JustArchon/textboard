package service;

import data.Member;
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

    public boolean isExistsByLoginId(String loginId){
        return memberRepository.isExistsByLoginId(loginId);
    }

    public boolean isCorrectInfo(String loginId, String password){
        Member findMember = memberRepository.getMemberByLoginId(loginId);

        if(findMember == null){
            return false;
        }
        if(findMember.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public Member getMemberByLoginId(String loginId) {
        return memberRepository.getMemberByLoginId(loginId);
    }
}
