/**
 * 
 */
package com.svan.veille.bsmt.meetup.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.svan.veille.bsmt.meetup.dto.MeetupDto;
import com.svan.veille.bsmt.meetup.dto.MeetupMemberDto;
import com.svan.veille.bsmt.meetup.service.MeetupService;

/**
 * @author stephane
 *
 */
@RestController
@RequestMapping("api/meetup")
public class MeetupController {

	@Autowired
	private MeetupService MeetupService;

	@RequestMapping()
	public List<MeetupDto> findAll() {
		return MeetupService.findAll();
	}

	@RequestMapping(value = "/{id}")
	public MeetupDto findBy(@PathVariable("id") String id) {
		return MeetupService.findBy(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public MeetupDto create(@RequestBody MeetupDto meetupDto) {
		return MeetupService.create(meetupDto);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/{id}/member", method = RequestMethod.POST)
	public MeetupMemberDto addMember(@PathVariable("id") String idMeetup, @RequestBody MeetupMemberDto memberDto) {
		return MeetupService.addMember(idMeetup, memberDto);
	}

}
