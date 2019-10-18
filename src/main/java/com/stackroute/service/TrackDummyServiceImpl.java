package com.stackroute.service;


import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Profile("dummy")
public class TrackDummyServiceImpl implements TrackService{

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException{
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track updateTrack(Track track) {
        return null;
    }

    @Override
    public void deleteTrack(Track track) {

    }

    @Override
    public List<String> findBytrackName(String trackName) throws TrackNotFoundException {
        return null;
    }
}
