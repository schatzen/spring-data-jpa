package study.datajpa.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        // 이렇게 하기보다
        // member1.setAge(10);
        // member1.changeTeam(teamA); 생성자로 객체 생성
        Member member1 = new Member("member1",10, teamA);
        Member member2 = new Member("member2",20, teamA);
        Member member3 = new Member("member3",30, teamB);
        Member member4 = new Member("member4",40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        // 초기화
        // 강제로 DB에 insert Query를 닐려버림
        em.flush();
        // 영속성 컨텍스트에 있는 캐시를 다 날려버림
        em.clear();

        // 확인
        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.team = " + member.getTeam());
        }


    }
}