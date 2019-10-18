package com.stackroute.listener;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRun implements CommandLineRunner {

    private TrackRepository trackRepository;
    @Autowired
    public void CLRun(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(9, "Another", "Somre singer"));
    }
}
