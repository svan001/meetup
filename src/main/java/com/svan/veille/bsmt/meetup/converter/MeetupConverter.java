package com.svan.veille.bsmt.meetup.converter;

import com.svan.veille.bsmt.meetup.domain.Meetup;
import com.svan.veille.bsmt.meetup.dto.MeetupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MeetupConverter {

    @Autowired
    private MeetupMemberConverter meetupMemberConverter;

    public Meetup toDomain(MeetupDto src) {
        // /!\ gestion des timezone !!
        LocalDateTime date = src.getDate() != null ?
                LocalDateTime.ofInstant(src.getDate().toInstant(), ZoneOffset.systemDefault())
                : null;

        Meetup dest = new Meetup(src.getTitle(), date);
        dest.setMembers(meetupMemberConverter.toDomain(src.getMembers()));

        return dest;
    }

    public MeetupDto toDTO(Meetup src) {
        // /!\ gestion des timezone !!
        ZonedDateTime date = src.getDate() != null ?
                ZonedDateTime.of(src.getDate(), ZoneOffset.systemDefault())
                : null;

        MeetupDto dto = new MeetupDto(src.getId(), src.getTitle(), date);
        dto.setMembers(meetupMemberConverter.toDTO(src.getMembers()));

        return dto;
    }

    public List<MeetupDto> toDTO(List<Meetup> src) {
        return src != null ? src.stream().map(r -> toDTO(r)).collect(Collectors.toList()) : null;
    }

}
