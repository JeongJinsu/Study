package hello.hellospring.survice;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        //result에 값이 있으면 ifPresent() 의 throw new IllegalStateException("이미 존재하는 회원입니다."); 동작함
        //ifPresent() 는 Member 객체를 감싼 Optional에 정의 되어있는 메소드

        result.ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
        memberRepository.save(member);
        return member.getId();
        */
        validateDuplicateMember(member);//이름 중복확인 메소드
        memberRepository.save(member);
        return member.getId();
    }
    //이름 중복 확인 메소드
    //Refactor -> Generate Method 를 이용해 별도 로직으로 뺌
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 ->
                {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMemebers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
