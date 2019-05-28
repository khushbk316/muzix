package com.stackroute.muzix.service;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.ResourceNotFoundException;
import com.stackroute.muzix.exceptions.TrackAlreadyFoundExceptions;


import java.util.List;
import java.util.Optional;


public interface TrackService
{
    public Track saveTrack (Track track) throws TrackAlreadyFoundExceptions;
    public List<Track> getAllTrack() throws  ResourceNotFoundException;
    public void deleteTrack(Track track,int id) ;
    public Optional<Track> getTrackById(int id)throws ResourceNotFoundException;
    //public  void updateCommentById(Track track,int id);

    //public List<Track> getTrackByName(String str);
}
