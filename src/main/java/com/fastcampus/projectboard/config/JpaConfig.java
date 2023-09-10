package com.fastcampus.projectboard.config;

import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

	@Bean
	public AuditorAware<String> auditorAware(){
		return () -> Optional.of("ga");//TODO 스프링 시큐리티로 인증 기능을 붙이게 될때 수정하자.
	}

}
