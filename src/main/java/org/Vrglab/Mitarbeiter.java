package org.Vrglab;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Mitarbeiter {
    private String name;
    private Date FZG;
    private double performance;
    private int abgesProjekte, fehlTage;
    private boolean teamLeader;
}
