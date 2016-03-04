package com.cs160.joleary.catnip;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by neil on 3/3/16.
 */
public class MemberOfCongress implements Serializable {

    String name;
    String party;
    String imagePath;
    boolean senOrRep;

    public MemberOfCongress() {
        this.name = "John Doe";
        this.party = "Independent";
        this.imagePath = "";
        this.senOrRep = true;
    }

    public MemberOfCongress(String n, String p, String i, boolean sor) {
        this.name = n;
        this.party = p;
        this.imagePath = i;
        this.senOrRep = sor;
    }

    String getName() {
        return this.name;
    }

    String getParty() {
        return this.party;
    }

    String getImagePath() {
        return this.imagePath;
    }

    boolean getSenOrRep() {
        return this.senOrRep;
    }

    public static void main(String[] args) {
        //code here maybe
    }


}
