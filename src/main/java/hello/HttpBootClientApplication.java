package hello;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;

@SpringBootApplication
@IntegrationComponentScan
public class HttpBootClientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = 	SpringApplication.run(HttpBootClientApplication.class, args);
	Gateway gate = context.getBean(Gateway.class);
	while(Scanner.hasNext()){
		String line = Scanner.nextLine();
		System.out.println(gate.exchange(line));
	}
	scanner.close();
		
	}
	@MessagingGateway(defaultRequestChannel = "httpOut.input")
	public interface Gateway{
		public String exchange(String out);
	}
	@Bean
	public IntegrationFlow httpOut(){
		return f -> f.handle(Http.outboundGateway("http://localhost:8080/receiveGateway")
				.expectedResponseType(String.class);
				)
	}
}
