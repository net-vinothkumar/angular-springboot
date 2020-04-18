package net.interviewDOT.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import net.interviewDOT.springboot2.springboot2jpacrudexample.model.Subscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SubscriberControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllSubscribers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/subscribers",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetSubscriberById() {
		Subscriber subscriber = restTemplate.getForObject(getRootUrl() + "/subscribers/1", Subscriber.class);
		System.out.println(subscriber.getFirstName());
		assertNotNull(subscriber);
	}

	@Test
	public void testCreateSubscriber() {
		Subscriber subscriber = new Subscriber();
		subscriber.setEmailId("admin@gmail.com");
		subscriber.setFirstName("admin");
		subscriber.setLastName("admin");

		ResponseEntity<Subscriber> postResponse = restTemplate.postForEntity(getRootUrl() + "/subscribers", subscriber, Subscriber.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateSubscriber() {
		int id = 1;
		Subscriber subscriber = restTemplate.getForObject(getRootUrl() + "/subscribers/" + id, Subscriber.class);
		subscriber.setFirstName("admin1");
		subscriber.setLastName("admin2");

		restTemplate.put(getRootUrl() + "/subscribers/" + id, subscriber);

		Subscriber updatedSubscriber = restTemplate.getForObject(getRootUrl() + "/subscribers/" + id, Subscriber.class);
		assertNotNull(updatedSubscriber);
	}

	@Test
	public void testDeleteSubscriber() {
		int id = 2;
		Subscriber subscriber = restTemplate.getForObject(getRootUrl() + "/subscribers/" + id, Subscriber.class);
		assertNotNull(subscriber);

		restTemplate.delete(getRootUrl() + "/subscribers/" + id);

		try {
			subscriber = restTemplate.getForObject(getRootUrl() + "/subscribers/" + id, Subscriber.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
