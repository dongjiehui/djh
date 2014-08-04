package cn.chiv;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cn.chiv.repository.MyRepositoryFactoryBean;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
	basePackages = "cn.chiv.**.repository",
	repositoryFactoryBeanClass = MyRepositoryFactoryBean.class
)
public class RepoConfiguration {

}
