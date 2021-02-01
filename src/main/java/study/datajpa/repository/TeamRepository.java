package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Team;

// spring data jpa가 자동적으로 proxy 객체를 생성하여 구현체를 만듦
// @repository 생략 가능
public interface TeamRepository extends JpaRepository<Team, Long> {

}
