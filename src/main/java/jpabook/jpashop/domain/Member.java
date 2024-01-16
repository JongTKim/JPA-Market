package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") // id값에는 클래스_id형태로 컬럼명을 정해주는게 국룰
    private Long id;

    private String name;

    @Embedded
    // 임베디드 타입에 대해서 알필요 있음, Embedded타입은 테이블이 생성되지않음
    // Entity에 @Embedded나 Embeddable객체에 @Embeddable이나 둘중에 하나만 사용가능
    private Address address;

    // 나는 그저 매핑된 거울임을 정의. 이 요소가 바뀌더라도 order의 member는 바뀌지 않음
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
