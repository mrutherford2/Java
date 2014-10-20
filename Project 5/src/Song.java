/**
 * Stores song-related data.
 */
public class Song extends Track {
    private String name;
    private String runningTime;

    /**
     * Constructs the song object and populates the song-related data.
     * @param infoArray String array contain the song data values.
     */
    public Song(String[] infoArray) {
        super(infoArray);

        this.name = infoArray[7];
        this.runningTime = infoArray[8];
    }
    
    /**
     * Returns the song name value.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the running time value.
     */
    public String getRunningTime() {
        return runningTime;
    }
}
