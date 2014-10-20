/**
 * Stores album-related data.
 */
public class Album {
    private String coverArt;
    private String genre;
    private String name;
    private String releaseYear;
    private Song song;

    /**
     * Constructs the album object, populates the album-related data, and creates an song object.
     * @param infoArray String array contain the song data values.
     */
    public Album(String[] infoArray) {
        this.name = infoArray[1];
        this.releaseYear = infoArray[2];
        this.genre = infoArray[3];
        this.coverArt = infoArray[4];
        this.song = new Song(infoArray);
    }
    
    /**
     * Returns the cover art value.
     */
    public String getCoverArt() {
        return coverArt;
    }
    
    /**
     * Returns the genre value.
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Returns the album name value.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the release year value.
     */
    public String getReleaseYear() {
        return releaseYear;
    }
    
    /**
     * Returns the song object.
     */
    public Song getSong() {
        return song;
    }
}
