package com.svan.veille.bsmt.meetup.service;

import com.svan.veille.bsmt.meetup.converter.MeetupConverter;
import com.svan.veille.bsmt.meetup.converter.MeetupMemberConverter;
import com.svan.veille.bsmt.meetup.domain.Meetup;
import com.svan.veille.bsmt.meetup.domain.MeetupMember;
import com.svan.veille.bsmt.meetup.domain.enums.MeetupMemberStatus;
import com.svan.veille.bsmt.meetup.dto.MeetupDto;
import com.svan.veille.bsmt.meetup.dto.MeetupMemberDto;
import com.svan.veille.bsmt.meetup.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetupService {
    private static final Integer DEFAULT_QUERY_LIMIT = 10;

    @Autowired
    private MeetupRepository meetupRepository;

    @Autowired
    private MeetupMemberConverter memberConverter;

    @Autowired
    private MeetupConverter converter;

    public List<MeetupDto> findAll(Integer limit) {
        Integer nbRes = (limit != null) && (limit > 0) ?
                limit : DEFAULT_QUERY_LIMIT;
        PageRequest pageRequest = new PageRequest(0, nbRes, new Sort(Sort.Direction.DESC, "date"));

        Page<Meetup> page = meetupRepository.findAll(pageRequest);
        return converter.toDTO(page.getContent());
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

    public void removeMember(String idMeetup, String memberName) {
        Meetup meetup = meetupRepository.findOne(idMeetup);
        if (meetup == null) {
            throw new IllegalStateException("Meetup inconnus");
        }

        meetup.getMembers().removeIf(
                member -> member.getName().equals(memberName)
        );
        meetupRepository.save(meetup);

        return;
    }
}
