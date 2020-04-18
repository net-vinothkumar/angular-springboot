package net.interviewDOT.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.interviewDOT.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.interviewDOT.springboot2.springboot2jpacrudexample.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.interviewDOT.springboot2.springboot2jpacrudexample.repository.SubscriberRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SubscriberController {
	@Autowired
	private SubscriberRepository subscriberRepository;

	@GetMapping("/subscribers")
	public List<Subscriber> getAllSubscribers() {
		return subscriberRepository.findAll();
	}

	@GetMapping("/subscribers/{id}")
	public ResponseEntity<Subscriber> getSubscriberById(@PathVariable(value = "id") Long subscriberId)
			throws ResourceNotFoundException {
		Subscriber subscriber = subscriberRepository.findById(subscriberId)
				.orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));
		return ResponseEntity.ok().body(subscriber);
	}

	@PostMapping("/subscribers")
	public Subscriber createSubscriber(@Valid @RequestBody Subscriber subscriber) {
		return subscriberRepository.save(subscriber);
	}

	@PutMapping("/subscribers/{id}")
	public ResponseEntity<Subscriber> updateSubscriber(@PathVariable(value = "id") Long subscriberId,
													 @Valid @RequestBody Subscriber subscriberDetails) throws ResourceNotFoundException {
		Subscriber subscriber = subscriberRepository.findById(subscriberId)
				.orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));

		subscriber.setEmailId(subscriberDetails.getEmailId());
		subscriber.setLastName(subscriberDetails.getLastName());
		subscriber.setFirstName(subscriberDetails.getFirstName());
		final Subscriber updatedSubscriber = subscriberRepository.save(subscriber);
		return ResponseEntity.ok(updatedSubscriber);
	}

	@DeleteMapping("/subscribers/{id}")
	public Map<String, Boolean> deleteSubscriber(@PathVariable(value = "id") Long subscriberId)
			throws ResourceNotFoundException {
		Subscriber subscriber = subscriberRepository.findById(subscriberId)
				.orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));

		subscriberRepository.delete(subscriber);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
