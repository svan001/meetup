package com.svan.veille.bsmt.meetup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svan.veille.bsmt.meetup.converter.MeetupConverter;
import com.svan.veille.bsmt.meetup.converter.MeetupMemberConverter;
import com.svan.veille.bsmt.meetup.domain.Meetup;
import com.svan.veille.bsmt.meetup.domain.MeetupMember;
import com.svan.veille.bsmt.meetup.domain.enums.MeetupMemberStatus;
import com.svan.veille.bsmt.meetup.dto.MeetupDto;
import com.svan.veille.bsmt.meetup.dto.MeetupMemberDto;
import com.svan.veille.bsmt.meetup.repository.MeetupRepository;

@Service
public class MeetupService {

	@Autowired
	private MeetupRepository meetupRepository;

	@Autowired
	private MeetupMemberConverter memberConverter;

	@Autowired
	private MeetupConverter converter;

	public List<MeetupDto> findAll() {
		return converter.toDTO(meetupRepository.findAll());
	}

	public MeetupDto findBy(String id) {
		return converter.toDTO(meetupRepository.findOne(id));
	}

	public MeetupDto create(MeetupDto meetupDto) {
		// Init
		validateNewMeetup(meetupDto);

		Meetup meetup = converter.toDomain(meetupDto);

		// Create
		meetupRepository.save(meetup);
		return converter.toDTO(meetup);
	}

	private void validateNewMeetup(MeetupDto meetup) {
		String title = meetup.getTitle();

		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Titre vide : " + title);
		}
	}

	public MeetupMemberDto addMember(String idMeetup, MeetupMemberDto memberDto) {
		// Init
		validateNewMember(memberDto);

		MeetupMember member = memberConverter.toDomain(memberDto);
		Meetup meetup = meetupRepository.findOne(idMeetup);

		// Update
		meetup.getMembers().add(member);
		meetupRepository.save(meetup);

		return memberConverter.toDTO(member);
	}

	private void validateNewMember(MeetupMemberDto member) {
		String name = member.getName();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Nom vide : " + name);
		}

		String status = member.getStatus();
		if (status == null || MeetupMemberStatus.findByCode(status) == null) {
			throw new IllegalArgumentException("Status non reconnus : " + status);
		}
	}

}
