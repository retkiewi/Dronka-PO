package pl.edu.agh.dronka.shop.model;

public enum Genre {
    RAP("RAP"), POP("POP"), HOUSE("HOUSE"), DISCO("DISCO"),
    BLUES("BLUES"), ROCK("ROCK"), JAZZ("JAZZ"), DISCOPOLO("DISCOPOLO");

    private String genre_name;

    Genre(String genre_name) {
        this.genre_name = genre_name;
    }

    public static Genre parser(String genre_name){
        switch(genre_name.toUpperCase()){
            case "RAP":
                return Genre.RAP;
            case "POP":
                return Genre.POP;
            case "HOUSE":
                return Genre.HOUSE;
            case "DISCO":
                return Genre.DISCO;
            case "BLUES":
                return Genre.BLUES;
            case "ROCK":
                return Genre.ROCK;
            case "JAZZ":
                return Genre.JAZZ;
            case "DISCOPOLO":
                return  Genre.DISCOPOLO;
            default:
                throw new IllegalArgumentException("There is no " +  genre_name.toUpperCase() + " genre.");
        }
    }

    public String getGenreName() {
        return genre_name;
    }
}
