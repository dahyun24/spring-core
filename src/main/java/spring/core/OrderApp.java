package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.order.Order;
import spring.core.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();
		// OrderService orderService = appConfig.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
	}
}