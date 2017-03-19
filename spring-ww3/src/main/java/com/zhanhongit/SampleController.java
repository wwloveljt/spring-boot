package com.zhanhongit;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.zhanhongit.support.CustomRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EnableCaching
public class SampleController {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}