package com.jac.app;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class SpringBootDataJpaApplication extends SpringBootServletInitializer implements CommandLineRunner{
//	@Autowired
//	IUploadFileService uploadFileService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Costa_Rica"));
		SpringApplication.run(SpringBootDataJpaApplication.class, args);		
	}
	@Override
	public void run(String... args)throws Exception{
		//probador
		// TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		String password="12345";
		for(int i=0; i<4; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.print(bcryptPassword);
		}
	}

}
