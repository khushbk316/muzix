package com.stackroute.muzix.repository;


import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    @Query ( value = "select * from track where track_name = ?1", nativeQuery = true)
    public List<Track> fnName(String str);


//public  Track updateCommentById(Track track ,int id);
   // public  List<Track> findByTrackName(String name);
}
