package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    //-----@RequiredArgsConstructor 사용 안했을 때----
//    @PersistenceContext
//    private EntityManager em;
    private final EntityManager em;

     //----@RequiredArgsConstructor 사용 안했을 때----
//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    }

    public void save(Member member) {
        em.persist(member);

    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> finaAll() {
        return em.createQuery("selet m from Member m", Member.class)
                .getResultList();
    }
    //이름으로 검샥할때
    public List<Member> findByName(String name) {       // :name -> 파라미터를 바인딩 하는거
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
