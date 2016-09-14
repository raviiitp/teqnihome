package com.teqnihome2;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Teqnihome2Application {
	
	private static final Logger log = LoggerFactory.getLogger(Teqnihome2Application.class);
	
    public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(Teqnihome2Application.class);
		app.setBannerMode(Banner.Mode.OFF);

		ApplicationContext ctx = app.run(args);

		Environment env = ctx.getEnvironment();
		log.info("Access URLs:\n----------------------------------------------------------\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
				+ "External: \thttp://{}:{}\n----------------------------------------------------------", env.getProperty("server.port"), InetAddress
				.getLocalHost().getHostAddress(), env.getProperty("server.port"));
	}
}
