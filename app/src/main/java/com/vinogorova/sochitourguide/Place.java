package com.vinogorova.sochitourguide;


public class Place {

    /** int resource ID for the name of the place */
    private int name;
    /** int resource ID for the description of the place */
    private int description;
    /** Image resource ID for the icon of the place */
    private int iconResourceID = NO_IMAGE_PROVIDED;
    /** Constant value that represents no icon was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;
    /** Image resource ID for the main picture of the place */
    private int mainImageResourceID;

    /**
     * Create a new Word object.
     *
     * @param name is the string resource ID for the name of the place
     * @param description is the string resource Id for the description of the place
     * @param mainImageResourceID is the resource ID for the main picture of the place
     */
    Place(int name, int description, int mainImageResourceID) {
        this.name = name;
        this.description = description;
        this.mainImageResourceID = mainImageResourceID;
    }

    /**
     * Create a new Word object.
     *
     * @param name is the string resource ID for the name of the place
     * @param description is the string resource Id for the description of the place
     * @param mainImageResourceID is the resource ID for the main picture of the place
     * @param iconResourceID is the resource ID for the icon of the place
     */
    Place(int name, int description, int iconResourceID, int mainImageResourceID) {
        this.name = name;
        this.description = description;
        this.iconResourceID = iconResourceID;
        this.mainImageResourceID = mainImageResourceID;
    }

    /**
     * Get the string resource ID for the name of the place
     */
    public int getName() {
        return name;
    }

    /**
     * Get the string resource ID for the description of the place.
     */
    public int getDescription() {
        return description;
    }

    /**
     * Get the string resource ID for icon of the place.
     */
    public int getIconResourceID() {
        return iconResourceID;
    }

    /**
     * Returns whether or not there is an icon for this word.
     */
    public boolean hasImage() {
        return iconResourceID != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the string resource ID for the main picture of the place.
     */
    public int getMainImageResourceID() {
        return mainImageResourceID;
    }
}
