package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages ={"asset_master","asset_meter_details","asset_location_details"})
@EnableJpaRepositories(basePackages = {"asset_master","asset_meter_details","asset_location_details"})
@ComponentScan({"asset_master","asset_meter_details","asset_location_details"})
public class AssetManagementAdmin_Main extends SpringBootServletInitializer  
{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AssetManagementAdmin_Main.class);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(AssetManagementAdmin_Main.class, args);
	}
}