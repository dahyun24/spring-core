package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	// 스프링 컨테이너에 스프링 빈으로 등록하는 과정
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new FixDiscountPolicy();
	}
}
