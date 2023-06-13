package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Manual test:
 *  + ./mvnw package
 *  + java -jar target/taco-cloud-0.0.1-SNAPSHOT.jar (build voi maven truoc da)
 *  + ./mvnw spring-boot: run
 *  Nhung chung ta se khong test nhu vay, ma dung auto test 
 *  
 *
 */
@SpringBootApplication
public class TacoCloudApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
