package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;  // method to accept a user object to save and return the saved user object

    public List<Track> getAllTracks();   // returns all user objects stored in the database as a list of user objects

    public Track updateTrack(Track track);

    public void deleteTrack(Track track);

    public List<String> findById(int trackId)  throws TrackNotFoundException;  //latest edit
}
