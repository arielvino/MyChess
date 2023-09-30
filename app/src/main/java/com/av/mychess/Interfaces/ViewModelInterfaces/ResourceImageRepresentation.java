package com.av.mychess.Interfaces.ViewModelInterfaces;

public class ResourceImageRepresentation implements IImageRepresentation {
    private final int resID;

    public int getResID() {
        return resID;
    }

    public ResourceImageRepresentation(int resID){
        this.resID = resID;
    }
}
