package com.stackroute.muzix.controller;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.ResourceNotFoundException;
import com.stackroute.muzix.exceptions.TrackAlreadyFoundExceptions;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@PropertySource("application.properties")
@RequestMapping("api/v1")
@RestController
public class TrackController {


    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    //INSERTION OF DATA........

    //    @Value("${save.message}")
//    private String savemessage;
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {

        ResponseEntity responseEntity;

        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfull", HttpStatus.CREATED);
        } catch (TrackAlreadyFoundExceptions e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping("tracklist")
    public ResponseEntity<?> getAllUsers() throws ResourceNotFoundException {
        try {
            return new ResponseEntity<List<Track>>(trackService.getAllTrack(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    //DELETION OF DATA..........
//
//    @Value("${delete.message}")
//    private String deletemessage;
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@RequestBody Track track, @PathVariable int id) throws ResourceNotFoundException {
        try {
            trackService.deleteTrack(track, id);
            return new ResponseEntity<String>("successfully deleted..", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
//
//    @GetMapping("trackbyname")
//    public  ResponseEntity<List<Track>> getTrackByName(@RequestBody String name)
//    {
//        return new ResponseEntity<>(trackService.getTrackByName(name),HttpStatus.OK);
//    }


//DATA RETRIVING..........

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        try {
            return new ResponseEntity<Optional<Track>>(trackService.getTrackById(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    //UPDATION OF DATA........
    @PatchMapping("/track/{id}")
    public ResponseEntity<?> getCommentUpdated(@RequestBody Track track, @PathVariable int id) {
        trackService.updateCommentById(track, id);


        return new ResponseEntity<Track>(track, HttpStatus.CREATED);
    }


    @GetMapping("/track/{name}")
    public ResponseEntity<?> getTrackByname(@PathVariable String trackName) {
        try {
            return new ResponseEntity<List<Track>>(trackService.getTrackByName(trackName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}




