package jpabook.jpashop.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 테이블 이름도 정해줄수있음, column명도 정할수 있고
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // 다대일 관계 order가 1쪽
    // foreign key이름이 member_id가 된다
    // 양방향 연관관계면 연관관계의 주인을 정해줘야 된다 개중요!!!!
    // 왜냐? 도대체 어디에 값이 변경됐을 때 둘의 일관성을 맞춰주냐의 문제떄문
    // 연관관계의 주인은 foreign key가 가까운쪽으로 정한다, 거울쪽에만 Mapped
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    private OrderStatus status;
}
