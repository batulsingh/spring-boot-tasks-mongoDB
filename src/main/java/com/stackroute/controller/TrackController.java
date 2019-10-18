package com.stackroute.controller;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackServiceImpl.*;
import com.stackroute.domain.Track;
import com.stackroute.service.TrackService ;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {   // @RestController annotation is a responsible for returning the data by directly writing the data into http response as JSON

    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @PostMapping("track")  //resource name is user
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {     // handler method to handle post request to save a user
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);        // in the try block we created a responseEntity object (the first parameter is a string message to be sent back as response and the second parameter is the http status code)
        } catch (TrackAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;          // we returned a responseEntity from saveUser method in spring REST a responseEntity represents a complete http response including response body, status code and headers.
    }

    @GetMapping("track")// handler method to retrieve all users
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try {
            trackService.getAllTracks();
            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        } catch (Exception ex1) {
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("Update Successful", HttpStatus.OK);
        } catch (Exception ex1) {
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try{
            trackService.deleteTrack(track);
            responseEntity = new ResponseEntity<String>( "Delete Successfull", HttpStatus.OK);
        }
        catch(Exception ex1){
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    /*to search using trackName*/
    @GetMapping("track/{trackName}")
    public ResponseEntity<?> findBytrackName(@PathVariable String trackName) {
        ResponseEntity responseEntity;
        try {
            trackService.findBytrackName(trackName);
            responseEntity = new ResponseEntity<List<String>>(trackService.findBytrackName(trackName), HttpStatus.OK);
        } catch (Exception ex1) {
            responseEntity = new ResponseEntity<String>(ex1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
