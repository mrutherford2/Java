/**
 * Stores artist-related data.
 */
public class Artist {
    private Album album;
    private String name;

    /**
     * Constructs the artist object, populates the artist-related data, and creates an album object.
     * @param infoArray String array contain the song data values.
     */
    public Artist(String[] infoArray) {
        this.name = infoArray[0];
        this.album = new Album(infoArray);
    }

    /**
     * Returns the album value.
     */
    public Album getAlbum() {
        return album;
    }
    
    /**
     * Returns the artist name value.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Overrides the default behavior of the Object class to display the song name 
     * associated with this object.
     * @return The name of the song associated with this object.
     */
    @Override
    public String toString() {
        return album.getSong().getName();
    }
}
