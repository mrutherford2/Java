/**
 * Stores track-related data.
 */
public class Track {
    private String trackInfo;
    
    /**
     * Constructs the track object and populates the track-related data.
     * @param infoArray String array contain the song data values.
     */
    public Track(String[] infoArray) {
        this.trackInfo = infoArray[5] + " of " + infoArray[6];
    }
    
    /**
     * Returns the track info value.
     */
    public String getTrackInfo() {
        return trackInfo;        
    }
}
