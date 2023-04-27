package co.app.splitwise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.app.splitwise.consoleDriver.AppDriver;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner{
	AppDriver appDriver;
	public SplitwiseApplication(AppDriver appDriver) {
		this.appDriver = appDriver;
	}
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		appDriver.init();
		
	}

}
