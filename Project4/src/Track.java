/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rutherford
 */
public class Track
{

    /**
     * Private class data
     */
    private String trackInfo;

    /**
     * Parameterized constructor that takes in a string array should be of length 2
     *
     * @param infoarray array to process
     */
    public Track(String[] infoarray)
    {
        trackInfo = infoarray[5] + " of " + infoarray[6];
    }

    /**
     * Return the track info as required
     *
     * @return string containing the track information
     */
    public String getTrackInfo()
    {
        return trackInfo;
    }
}
