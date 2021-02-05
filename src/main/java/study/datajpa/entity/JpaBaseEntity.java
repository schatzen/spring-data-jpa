package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
// 진짜 속성 관계는 아니고 속성을 밑에 내려서 테이블에서 같이 쓸 수 있게 함
@MappedSuperclass
public class JpaBaseEntity {

    // 값을 실수로 바꿔도 변경되지 않음
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // Persist 하기 전에 event 발생
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        // updatedDate을 null로 안하는 이유는 쿼리날릴 때 null이 있으면 복잡
        // 값 채워주는 용도
        updatedDate = now;
    }

    // 업데이트 되기 전에 호출
    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
