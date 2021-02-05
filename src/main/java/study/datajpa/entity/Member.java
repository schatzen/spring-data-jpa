package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;


// 실제 업무에서 꼭 필요하지 않는 이상 Setter을 사용하진 않는다.
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//ToString시 foreignkey 설정되어 있는 객체는 x. (Team x)
// 연관관계를 타서 또 출력하게 되고.. 무한루프 가능성때문
@ToString(of = {"id", "username", "age"})
public class Member extends BaseEntity{

    // GeneratedValue 설정시 , PK값을 JPA가 알아서 부여
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;

        if (team != null) {
            changeTeam(team);
        }
    }

    // 연관관계를 세팅하는 메소드
    public void changeTeam(Team team) {
        this.team = team;
        // 팀에도 해당 Member도 세팅해준다.
        team.getMembers().add(this);
    }

    // Entity는 기본적으로 생성자가 있어야 한다.
    // Access 레벨은 Private이 아닌 protected로 열어놔야 한다.
    // JPA가 Proxying을 할 때 private으로 막나놓으면 막힐 수 있기 때문.
    // @NoArgsConstructor(access = AccessLevel.PROTECTED) 와 같은 기능
    //protected Member() {
    //}

    public Member(String username) {
        this.username = username;
    }

    // Setter를 사용하지 않아도 이러한 메소드를 통해서 username 변경 가능
    //public void changeUsername(String username) {
    //this.username = username;
    //}
}
