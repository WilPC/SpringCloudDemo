package johnny.demo.springcloud.mms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableDiscoveryClient
public class MmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);
	}

	@RestController
	class MMSController {

		// value is from config server or default value
		@Value("${mms.welcomeStr:Welcome to MMS SIT,}")
		private String welcomeStr;

		@GetMapping("/hello")
		public String getMethodName(@RequestParam String name) {

			return welcomeStr + name;
		}

	}
}
