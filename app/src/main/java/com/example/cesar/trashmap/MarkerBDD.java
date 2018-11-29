package com.example.cesar.trashmap;

public class MarkerBDD {
    public String name;
    public int difficulty;
    public double lat;
    public double lng;
    public boolean status;
    public TypeEnum type;
    public UserBDD user;

    public enum TypeEnum {
        FERRAILE,
        PLASTIQUE,
        BOIS
    }
}
