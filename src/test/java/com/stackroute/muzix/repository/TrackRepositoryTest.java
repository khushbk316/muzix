package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TrackRepositoryTest

{



        @Autowired
        private TrackRepository trackRepository;
        private Track track;

        @Before
        public void setUp()
        {
            track = new Track();
            track.setTrackId(1);
           track.setTrackName("hamsafar");
          track.setComment("superb");

        }

        @After
        public void tearDown(){

           trackRepository.deleteAll();
        }


        @Test
        public void testSaveTrack(){
           trackRepository.save(track);
            Track fetchtrack = trackRepository.findById(track.getTrackId()).get();
            Assert.assertEquals(1,fetchtrack.getTrackId());

        }

        @Test
        public void testSaveTrackFailure(){
           Track testTrack = new Track(2,"duniya","rocking");
            trackRepository.save(track);
            Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
            Assert.assertNotSame(testTrack,track);
        }

        @Test
        public void testGetAllTrack(){
            Track t = new Track(2,"humnava","fantastic");
            Track t1 = new Track(3,"kaabil","fabulous");
           trackRepository.save(t);
           trackRepository.save(t1);

            List<Track> list = trackRepository.findAll();
            Assert.assertEquals("humnava",list.get(0).getTrackName());




        }


    }


