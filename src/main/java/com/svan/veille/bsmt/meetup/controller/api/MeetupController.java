/**
 *
 */
package com.svan.veille.bsmt.meetup.controller.api;

import com.svan.veille.bsmt.meetup.dto.MeetupDto;
import com.svan.veille.bsmt.meetup.dto.MeetupMemberDto;
import com.svan.veille.bsmt.meetup.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author stephane
 */
@RestController
@RequestMapping("api/meetup")
public class MeetupController {

    @Autowired
    private MeetupService MeetupService;

    @RequestMapping()
    public List<MeetupDto> findAll(@RequestParam(required = false) Integer limit) {
        return MeetupService.findAll(limit);
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
