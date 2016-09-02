package com.svan.veille.bsmt.meetup.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.svan.veille.bsmt.meetup.domain.Meetup;
import com.svan.veille.bsmt.meetup.dto.MeetupDto;

@Component
public class MeetupConverter {

	@Autowired
	private MeetupMemberConverter meetupMemberConverter;
	
	public Meetup toDomain(MeetupDto src) {
		Meetup dest = new Meetup();

		dest.setTitle(src.getTitle());
		dest.setDate(src.getDate());

		dest.setMembers(meetupMemberConverter.toDomain(src.getMembers()));

		return dest;
	}

	public MeetupDto toDTO(Meetup src) {
		MeetupDto dto = new MeetupDto();

		dto.setId(src.getId());
		dto.setTitle(src.getTitle());
		dto.setDate(src.getDate());

		dto.setMembers(meetupMemberConverter.toDTO(src.getMembers()));

		
		return dto;
	}

	public List<MeetupDto> toDTO(List<Meetup> src) {
		return src != null ? src.stream().map(r -> toDTO(r)).collect(Collectors.toList()) : null;
	}

}
