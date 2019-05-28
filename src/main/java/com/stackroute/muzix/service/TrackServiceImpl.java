package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.ResourceNotFoundException;
import com.stackroute.muzix.exceptions.TrackAlreadyFoundExceptions;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class TrackServiceImpl implements TrackService {



    Track saveTrack;
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyFoundExceptions {
        //  if (trackRepository.existsById(track.getTrackId())) {
//            saveTrack = trackRepository.save(track);
        if(trackRepository.existsById(track.getTrackId()))
            throw new TrackAlreadyFoundExceptions("Track already exists...");
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() throws  ResourceNotFoundException {
        return trackRepository.findAll();
    }



//    @Override
//    public List<Track> getTrackByName(String name) {
//         return trackRepository.findByTrackName(name);
//    }

    @Override
    public Optional<Track> getTrackById(int id) throws ResourceNotFoundException{
        if(trackRepository.existsById(id)==false)
            throw new ResourceNotFoundException("does not exist..");
        return trackRepository.findById(id);
    }

//    @Override
//    public void updateCommentById(Track track, int id) {
//
//        saveTrack = trackRepository.getOne(id);
//
//        track.setTrackId(saveTrack.getTrackId());
//        track.setTrackName(saveTrack.getTrackName());
//        trackRepository.save(track);
//
//
//    }
//
//    @Override
//    public List<Track> getTrackByName(String str) {
//        return trackRepository.fnName(str);
//    }

    @Override
    public void deleteTrack(Track track, int id)  {

        trackRepository.deleteById(track.getTrackId());

    }
}


