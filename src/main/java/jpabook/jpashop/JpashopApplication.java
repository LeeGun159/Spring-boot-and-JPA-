package jpabook.jpashop;


import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(JpashopApplication.class ,  args);
	}

	@Bean
	Hibernate5JakartaModule hibernate5JakartaModule() {
		//강제 LAZY 로딩 하는 구문 but 이렇게 하면 엔티티를 외부로 노출하게 돼서 쓰지말것
//		Hibernate5JakartaModule hibernate5JakartaModule = new Hibernate5JakartaModule();
//		hibernate5JakartaModule.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true);
		return new Hibernate5JakartaModule();
	}

	//스프링 부트 3.0 이하
//	@Bean
//	Hibernate5Module hibernate5Module() {
//		return new Hibernate5Module();
//	}
}
