package com.journal.calendar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "calendar_id", nullable = false)
    private Long calendarId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser owner;

    @Column(name = "calendar_name")
    private String calendarName;

    @Column(name = "calendar_description")
    private String calendarDescription;

    @OneToMany(mappedBy = "calendar")
    private List<Event> events = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
