package com.SpringbootApacheGeode;


import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.geode.util.GeodeAssertions.AssertThat;

import com.SpringbootApacheGeode.Repo.VisitorsRepo;
import com.SpringbootApacheGeode.model.Visitors;

import ch.qos.logback.core.joran.action.Action;

@SpringBootApplication
@ClientCacheApplication(name="x")
@EnableGemfireRepositories(basePackageClasses=VisitorsRepo.class)
@EnableEntityDefinedRegions(basePackageClasses=Visitors.class)
public class SpringdataApacheGeodeInitialApplication {

	public static void main(String[] args) {
new SpringApplicationBuilder(ClientCacheApplication.class).build().run(args);
}
	@Bean
	@SuppressWarnings("unsused")
  ApplicationRunner runner(VisitorsRepo visitorrepo) {
	return args ->{
		assertThat(visitorrepo.count()).equals(0);
		Visitors xyz= Visitors.newVisitors(1, "imteyaz");
		System.err.printf("saving visitors [%s].....%n", xyz);
		xyz=visitorrepo.save(xyz);
		assertThat(xyz).notifyAll();
		assertThat(xyz.getId()).equals(1L);
		
		assertThat(xyz.getName()).equals("rahaman");
		assertThat(visitorrepo.count()).equals(1);
		System.err.printf("quering for customer[select*from / Visitors where name like %imteyaz]");
		Visitors quiredxyz=visitorrepo.findByNameLike("%imtyaz");
		assertThat(quiredxyz).equals(xyz);
		System.err.printf("visitor was [%s] %n",quiredxyz);
	};
	  
  }
	private Object assertThat(Object visitors) {
		return null;
	}
	
}
