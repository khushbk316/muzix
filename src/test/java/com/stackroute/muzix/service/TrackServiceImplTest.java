package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.ResourceNotFoundException;
import com.stackroute.muzix.exceptions.TrackAlreadyFoundExceptions;
import com.stackroute.muzix.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceImplTest {



        private Track track;

        //Create a mock for UserRepository
        @Mock
        private TrackRepository trackRepository;

        //Inject the mocks as dependencies into UserServiceImpl
        @InjectMocks
        private TrackServiceImpl trackServiceimpl;
        List<Track> list= null;


        @Before
        public void setUp(){
            //Initialising the mock object
            MockitoAnnotations.initMocks(this);
            track = new Track();
            track.setTrackId(1);
            track.setTrackName("sweet sweet isabelle");
            track.setComment("sweet song");
            list = new ArrayList<>();
            list.add(track);


        }
    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyFoundExceptions{

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackRepository.save(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }


    @Test
    public void saveTrackTestFailure() throws TrackAlreadyFoundExceptions {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedTrack = trackServiceimpl.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        Assert.assertEquals(null,savedTrack);
    }

        @Test
        public void getAlltrack() throws ResourceNotFoundException {

            trackRepository.save(track);
            //stubbing the mock to return specific data
            when(trackRepository.findAll()).thenReturn(list);
            List<Track> tracklist = trackServiceimpl.getAllTrack();
            Assert.assertEquals(list,tracklist);
        }





    }


