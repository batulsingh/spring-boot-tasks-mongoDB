package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "tracks")    //specifies a tracks collection. This tells Spring Data MongoDB to store a Track document to the tracks collection. This collection will be created if it doesn’t exist.
public class Track {                //The @Document annotation is optional, and if we don’t use one, the collection will be named with the class name.
    @Id                     //maps to the MongoDB document’s _id. It’s not mandatory to use the @Id annotation if the primary key field is named id (we have named it trackId)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column
    int trackId;
  //  @Column
    String trackName;
   // @Column
    String comments;

}
