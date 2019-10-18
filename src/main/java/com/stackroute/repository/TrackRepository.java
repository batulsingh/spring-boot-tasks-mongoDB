package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// Allows spring-data-jpa repository infrastructure to scan the classpath for this interface and create a springbean for it (it will be created at runtime)
public interface TrackRepository extends JpaRepository<Track, Integer> {
   @Query("SELECT t.trackName FROM Track t WHERE t.trackName = :trackName")
    public List<String> findByName(String trackName);      //the findByName() method returns Track entries whose trackName is ‘trackName’, because that is the query which is specified by using the @Query annotation
}
