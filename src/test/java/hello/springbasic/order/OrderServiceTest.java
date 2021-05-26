package hello.springbasic.order;

import hello.springbasic.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        // Given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // When
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // Then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
