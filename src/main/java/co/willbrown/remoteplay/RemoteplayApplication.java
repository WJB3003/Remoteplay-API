package co.willbrown.remoteplay;

import co.willbrown.remoteplay.controller.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;

@SpringBootApplication
public class RemoteplayApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(RemoteplayApplication.class, args);
	}

}

