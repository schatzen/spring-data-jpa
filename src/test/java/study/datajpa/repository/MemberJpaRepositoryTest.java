package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.assertThat;

// JUnut5에서는 테스트 실행시키기 위해 하단 어노테이션
@SpringBootTest
@Transactional
// JPA는 테스트 끝날 때 Rollback을 해버린다.
// 따라서 DB에 남기기 위해서는 Rollback을 false로 해준다.
@Rollback(false)
public class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA");
        // ctrl + alt + v : value로 꺼낼 수 있다.
        Member savedMember = memberJpaRepository.save(member);
        Member findMember = memberJpaRepository.find(savedMember.getId());

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        // 같은 Transaction이므로 같은 인스턴스 보장 > JPA가 보장하는 기능
        assertThat(findMember).isEqualTo(member);
    }




}