package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    //MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("1번 Name");

        //when
        Long saveId = memberService.join(member);
        //then

        Member findMember =memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName()); //import static 사용 근데 왜?? 그냥 임포트 해논 상태로 써도 되는거아닌가?


    }

    /**
     * 중복회원 예외
     */
    @Test
    void join2() {
        //given
        Member member1 = new Member();
        member1.setName("2번 Name");

        Member member2 = new Member();
        member2.setName("2번 Name");

        //when
        Long saveId = memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try{
            Long saveId2 = memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            //System.out.println(e.toString());
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다...");
        }
        */


    }

    @Test
    void findMemebers() {
    }

    @Test
    void findOne() {
    }
}