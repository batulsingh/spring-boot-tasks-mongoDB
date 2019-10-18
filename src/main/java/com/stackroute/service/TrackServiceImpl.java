package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {  // userservice implementation class implements userservice interface and overrides both the methods

    TrackRepository trackRepository;

    private static List<Track> tracks;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository = trackRepository;               // at runtime spring will provide this service a userRepository object via constructor dependency injection
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track saveTrack = trackRepository.save(track);  // this save method comes from the jpa repository interface that our user repository interface extends
        if(saveTrack == null){      // check if track object returned by the repositories save method is null, if it is null we'll create and throw custom TrackAlreadyExists exception
            throw new TrackAlreadyExistsException("Track already exits");
        }
        return saveTrack;
    }
 //   @Transactional
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
//    @Transactional
    @Override
    public Track updateTrack(Track track){
        Track tr  =trackRepository.save(track);
        return tr;
}
 //   @Transactional
    @Override
    public void deleteTrack(Track track) {  //return type should not be void. change void to a type(try boolean)
        trackRepository.delete(track);
    }
//    @Transactional
    @Override
    public List<String> findBytrackName(String t) throws TrackNotFoundException{
 //       if(boolean existsTrackBytrackName(String ))
        var trc = (List<String>) trackRepository.findByName(t);
        return trc;
    }

    //public Track findById(String trackId) {
     //   for (Track track : tracks) {
      //      if (track.getTrackId() == trackId) {
      //          return track;
      //      }
      //  }
      //  return null;
}