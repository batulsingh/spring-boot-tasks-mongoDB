package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {  // TrackServiceImpl implementation class implements Trackservice interface and overrides both the methods

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
    public List<String> findById(int t) throws TrackNotFoundException{
        if(!trackRepository.existsById(t)){
            throw new TrackNotFoundException("Track doesn't exists");
        }
        var trc = (List<String>) trackRepository.findByTrackId(t);
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