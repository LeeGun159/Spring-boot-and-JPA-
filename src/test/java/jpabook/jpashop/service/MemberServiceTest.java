package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional   //이게 있어야 롤백이 됨
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    EntityManager em;
    @Test
    public void 회원가입() throws Exception {
        Member member = new Member();
        member.setName("kim");

        Long savedId = memberService.join(member);

        em.flush();
        assertEquals(member,memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        memberService.join(member2);  //예외 발생해야함
        //(expected = IllegalStateException.class) 이거 넣어서 주석처리 가능
//        try {
//            memberService.join(member2);
//
//        } catch (IllegalAccessError e) {
//            return;
//        }
        fail("예외가 발생해야한다");


    }

}