package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// 실제 업무에서 꼭 필요하지 않는 이상 Setter을 사용하진 않는다.
@Entity
@Getter
@Setter
public class Member {

    // GeneratedValue 설정시 , PK값을 JPA가 알아서 부여
    @Id @GeneratedValue
    private Long id;
    private String username;

    // Entity는 기본적으로 생성자가 있어야 한다.
    // Access 레벨은 Private이 아닌 protected로 열어놔야 한다.
    // JPA가 Proxying을 할 때 private으로 막나놓으면 막힐 수 있기 때문
    protected Member() {
    }

    public Member(String username) {
        this.username = username;
    }

    // Setter를 사용하지 않아도 이러한 메소드를 통해서 username 변경 가능
    //public void changeUsername(String username) {
        //this.username = username;
    //}
}
