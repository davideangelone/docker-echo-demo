package it.nexi.docker.echo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DockerEchoDemoApplicationTests {

	@Test
	void contextLoads() {
		assertThat(Client.runTests()).isTrue();
	}

}
