package com.stackroute.muzix.domain;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Track {
    @Id
    private  int TrackId;
    private String TrackName;
    private String Comment;



//    public Track() {
//    }
//
//
//    public Track(int trackId, String trackName, String comment) {
//        TrackId = trackId;
//        TrackName = trackName;
//        this.Comment = comment;
//    }
//
//
//    public int getTrackId() {
//        return TrackId;
//    }
//
//    public void setTrackId(int trackId) {
//        TrackId = trackId;
//    }
//
//    public String getTrackName() {
//        return TrackName;
//    }
//
//    public void setTrackName(String trackName) {
//        TrackName = trackName;
//    }
//
//    public String getComment() {
//        return Comment;
//    }
//
//    public void setComment(String comment) {
//        this.Comment = comment;
//    }


}
