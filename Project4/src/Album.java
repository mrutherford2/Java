/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rutherford
 */
public class Album
{

    /**
     * Private class data
     */
    private String name;
    private String releaseYear;
    private String genre;
    private Song song;
    private String coverArt;

    /**
     * Constructor
     *
     * @param infoarray array to process
     */
    public Album(String[] infoarray)
    {
        name = infoarray[1];
        releaseYear = infoarray[2];
        genre = infoarray[3];
        coverArt = infoarray[4];
        song = new Song(infoarray);
    }

    /**
     * get cover art data
     *
     * @return string containing cover art data
     */
    public String getCoverArt()
    {
        return coverArt;
    }

    /**
     * get genre data
     *
     * @return string containing genre data
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * get name data
     *
     * @return string containing name data
     */
    public String getName()
    {
        return name;
    }

    /**
     * get release year data
     *
     * @return string containing release year data
     */
    public String getReleaseYear()
    {
        return releaseYear;
    }

    /**
     * get song object
     *
     * @return object containing song data
     */
    public Song getSong()
    {
        return song;
    }
}
