package com.stackroute.muzix.seeddata;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    TrackService trackService;

    Track track=new Track();

    @Autowired
    Environment env;

    @Override
    public void run(String... args) throws Exception {
        track.setTrackId(Integer.parseInt(env.getProperty("song-id")));
        track.setTrackName(env.getProperty("song-name"));
        track.setComment(env.getProperty("song-comment"));

        System.out.println(trackService.saveTrack(track));


    }
}
