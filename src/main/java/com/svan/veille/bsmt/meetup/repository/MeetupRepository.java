package com.svan.veille.bsmt.meetup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.svan.veille.bsmt.meetup.domain.Meetup;

public interface MeetupRepository extends MongoRepository<Meetup, String> {

}
