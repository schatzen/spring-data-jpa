package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age2);

    // By 뒤에 아무것도 안넣으면 전체 조회
   List<Member> findHelloBy();

   // 상위 3번째까지의 데이터 호출
   List<Member> findTop3HelloBy();


}
