
public class Array
{
/**
 * 
 * @param textToSearch
 * @param searchString
 * @return 
 */
    public static boolean Contains(String textToSearch, String searchString)
    {
        if ((textToSearch.toLowerCase()).contains(searchString.toLowerCase()))
        {
            return true;
        }
        return false;
    }
/**
 * Resizes the array to the necessary size
 * @param artistArray
 * @param itemCount 
 */
    @SuppressWarnings("UnusedAssignment")
    public static void ResizeArray(Artist[] artistArray, int itemCount)
    {
        Artist[] copy = new Artist[itemCount];
        System.arraycopy(artistArray, 0, copy, 0, itemCount);
        artistArray = copy;
    }

    /**
     * Searches the artistArray using the search String 
     * @param artistArray
     * @param searchString
     * @return 
     */
    public static Artist[] SearchArray(Artist[] artistArray, String searchString)
    {
        Artist[] searchResults = new Artist[artistArray.length];
        int index = 0;
        for (int x = 0; x < artistArray.length; x++)
        {
            Artist temp = artistArray[x];
            if (temp.getAlbum().getName().contains(searchString)
                || temp.getName().contains(searchString)
                || temp.getAlbum().getGenre().contains(searchString)
                || temp.getAlbum().getSong().getName().contains(searchString))
            {
                searchResults[index++] = temp;
            }
        }
        ResizeArray(searchResults, index);
        return searchResults;
    }
/**
 * Sorts by album name using selection sort 
 * @param artistArray 
 */
    public static void SortByAlbumname(Artist[] artistArray)
    {
        int min;
        for (int x = 0; x < artistArray.length; x++)
        {
            min = x;
            for (int y = x + 1; y < artistArray.length; y++)
            {
                if (artistArray[y].getAlbum().getName().compareToIgnoreCase(artistArray[min].
                        getAlbum().getName()) < 0)
                {
                    min = y;
                }
            }
            if (min != x)
            {
                Swap(artistArray, x, min);
            }
        }
    }

    /**
     * Sorts by artist name using selection sort 
     * @param artistArray 
     */
    public static void SortByAristname(Artist[] artistArray)
    {
        int min;
        for (int x = 0; x < artistArray.length; x++)
        {
            min = x;
            for (int y = x + 1; y < artistArray.length; y++)
            {
                if (artistArray[y].getName().compareToIgnoreCase(artistArray[min].getName()) < 0)
                {
                    min = y;
                }
            }
            if (min != x)
            {
                Swap(artistArray, x, min);
            }
        }
    }

    /**
     * Sorts by genre using selection sort 
     * @param artistArray 
     */
    public static void SortByGenre(Artist[] artistArray)
    {
        int min;
        for (int x = 0; x < artistArray.length; x++)
        {
            min = x;
            for (int y = x + 1; y < artistArray.length; y++)
            {
                if (artistArray[y].getAlbum().getGenre().compareToIgnoreCase(artistArray[min]
                        .getAlbum().getGenre()) < 0)
                {
                    min = y;
                }
            }
            if (min != x)
            {
                Swap(artistArray, x, min);
            }
        }
    }
    
    /**
     * Sorts by release year using selection sort
     * @param artistArray 
     */

    public static void SortByReleaseYear(Artist[] artistArray)
    {
        int min;
        for (int x = 0; x < artistArray.length; x++)
        {
            min = x;
            for (int y = x + 1; y < artistArray.length; y++)
            {
                if (artistArray[y].getAlbum().getReleaseYear().compareToIgnoreCase(artistArray[min]
                        .getAlbum().getReleaseYear()) < 0)
                {
                    min = y;
                }
            }
            if (min != x)
            {
                Swap(artistArray, x, min);
            }
        }
    }
    /**
     * Sorts by Running Time using selection sort
     * @param artistArray 
     */

    public static void SortByRunningTime(Artist[] artistArray)
    {
        int min;
        for (int x = 0; x < artistArray.length; x++)
        {
            min = x;
            for (int y = x + 1; y < artistArray.length; y++)
            {
                if (artistArray[y].getAlbum().getSong().getRunningTime().compareToIgnoreCase(artistArray[min]
                        .getAlbum().getSong().getRunningTime()) < 0)
                {
                    min = y;
                }
            }
            if (min != x)
            {
                Swap(artistArray, x, min);
            }
        }
    }

    /**
     * Sorts by Song Name using selection sort 
     * @param artistArray 
     */
    public static void SortBySongName(Artist[] artistArray)
    {
        int min;
        for (int x = 0; x < artistArray.length; x++)
        {
            min = x;
            for (int y = x + 1; y < artistArray.length; y++)
            {
                if (artistArray[y].getAlbum().getSong().getName().compareToIgnoreCase(artistArray[min]
                        .getAlbum().getSong().getName()) < 0)
                {
                    min = y;
                }
            }
            if (min != x)
            {
                Swap(artistArray, x, min);
            }
        }
    }

    /**
     * Performs Swap in the artistArray 
     * @param artistArray
     * @param pos1
     * @param pos2 
     */
    private static void Swap(Artist[] artistArray, int pos1, int pos2)
    {
        Artist temp = artistArray[pos1];
        artistArray[pos1] = artistArray[pos2];
        artistArray[pos2] = temp;
    }
}
