package com.stackroute.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Track {
    @Id                     // identifying column(primary key)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column
    int trackId;
  //  @Column
    String trackName;
   // @Column
    String comments;

}
