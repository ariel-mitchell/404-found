package org.launchcode.fourohfourfound.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "org.launchcode.fourohfourfound.finalproject.service")
public class DnDCharacterCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDCharacterCreatorApplication.class, args);
	}

}
