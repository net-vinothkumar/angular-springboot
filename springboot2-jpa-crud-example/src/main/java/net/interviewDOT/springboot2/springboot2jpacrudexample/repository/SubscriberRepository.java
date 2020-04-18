package net.interviewDOT.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.interviewDOT.springboot2.springboot2jpacrudexample.model.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{

}
