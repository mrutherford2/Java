/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rutherford
 */
public class Artist
{

    /**
     * Private class data
     */
    private Album album;
    private String name;

    /**
     * Constructor takes in the main string array
     *
     * @param infoarray array to process
     */
    public Artist(String[] infoarray)
    {
        name = infoarray[0];
        album = new Album(infoarray);
    }

    /**
     * get album object
     *
     * @return album object
     */
    public Album getAlbum()
    {
        return album;
    }

    /**
     * get name string
     *
     * @return name string
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the value stored in the Name variable of the current Artist object
     *
     * @return string to return
     */
  @Override
    public String toString()
    {
        return this.getAlbum().getSong().getName();
    }
}
