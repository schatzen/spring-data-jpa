package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

//component scan 대상이 되서 bean으로 등록하여 Scanning될 수 있게 된다.
@Repository
public class MemberJpaRepository {

    @PersistenceContext
    private EntityManager em;

    // 저장,수정 기능
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public void delete(Member member) {
        em.remove(member);
    }

    // 전체 조회와 조건 조회는 createQuery로
    // 결과 값이 리스트인 경우 .getResultList()
    public List<Member> findAll () {
        // 객체를 대상으로 하는 쿼리
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // Optional 조회
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // 결과 값이 단 건인 경우 .getSingleResult()
    public long count() {
        return em.createQuery("select count(m) from Member m",Long.class).getSingleResult();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    // 파라미터를 넣을 경우 .setParameter
    public List<Member> findByUsernameAndAgeGreaterThen(String username, int age) {
        return em.createQuery("select m from Member m where m.username = :username and m.age > :age", Member.class)
                .setParameter("username", username)
                .setParameter("age",age)
                .getResultList();

    }
}
