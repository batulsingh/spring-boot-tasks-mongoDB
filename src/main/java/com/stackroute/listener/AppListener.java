package com.stackroute.listener;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;
    @Autowired
    public void setrepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        System.out.println("______ContextRefreshedEvent Fired________");
        trackRepository.save(new Track(1, "Demons", "Imagine Dragons"));
        trackRepository.save(new Track(2, "Kids", "One Republic"));
    }
}