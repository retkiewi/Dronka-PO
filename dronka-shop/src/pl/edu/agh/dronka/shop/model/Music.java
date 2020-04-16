package pl.edu.agh.dronka.shop.model;

public class Music extends Item{

    private Genre genre;
    private boolean video;

    public Music(String name, Category category, int price, int quantity, String genre, boolean video) {
        super(name, category, price, quantity);
        this.genre = Genre.parser(genre);
        this.video = video;
    }

    public Music(){}

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
