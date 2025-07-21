package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();

		// ApplicationContext 를 스프링 컨테이너라고 한다.
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 스프링 컨테이너를 통해 필요한 스프링 빈(객체)을 찾아야 한다.
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new Member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());
	}
}
