/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rutherford
 */
public class Song extends Track
{

    /**
     * Private class data
     */
    private String name;
    private String runningTime;

    /**
     * Constructor that takes in an array to process
     *
     * @param infoarray array to process
     */
    public Song(String[] infoarray)
    {
        super(infoarray);
        name = infoarray[7];
        runningTime = infoarray[8];
    }

    /**
     * Return name of song
     *
     * @return the name of the song
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get running time
     *
     * @return return running time
     */
    public String getRunningTime()
    {
        return runningTime;
    }
    
     
}
