import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpriteSheet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpriteSheet extends Actor
{
    /**
     * The if you switch your inputs for topLeftX, and bottomRightX the image will be flipped horizontilly,
     * if you do the same with the topLeftY and bottomRightY the image will be flipped vertically. The width
     * and height are the dimesions of the returned image.
     */
    public GreenfootImage getSprite(GreenfootImage spriteSheet, int topLeftX, int topLeftY, int bottomRightX, int bottomRightY, int width, int height) {
        int tempWidth;
        int tempHeight;
        if(topLeftX<bottomRightX)
            tempWidth = bottomRightX - topLeftX;
        else
            tempWidth = topLeftX - bottomRightX;
        if(topLeftY<bottomRightY)
            tempHeight = bottomRightY - topLeftY;
        else
            tempHeight = topLeftY - bottomRightY;
        GreenfootImage img = new GreenfootImage(tempWidth, tempHeight);
        if(topLeftX<bottomRightX) {
            for(int x = topLeftX; x < bottomRightX; x++) {
                if(topLeftY<bottomRightY) {
                    for(int y = topLeftY; y < bottomRightY; y++) {
                        if(x>=0 && x<spriteSheet.getWidth() && y>=0 && y<spriteSheet.getHeight()) {
                            img.setColorAt(tempWidth-(bottomRightX - x), tempHeight-(bottomRightY - y), spriteSheet.getColorAt(x, y));
                        }
                    }
                } else {
                    for(int y = bottomRightY; y < topLeftY; y++) {
                        img.setColorAt(tempWidth-(bottomRightX - x), tempHeight-(topLeftY - y), spriteSheet.getColorAt(x, y));
                    }
                }
            }
        } else {
            for(int x = bottomRightX; x < topLeftX; x++) {
                if(topLeftY<bottomRightY) {
                    for(int y = topLeftY; y < bottomRightY; y++) {
                        img.setColorAt(tempWidth-(topLeftX - x), tempHeight-(bottomRightY - y), spriteSheet.getColorAt(x, y));
                    }
                } else {
                    for(int y = bottomRightY; y < topLeftY; y++) {
                        img.setColorAt(tempWidth-(topLeftX - x), tempHeight-(topLeftY - y), spriteSheet.getColorAt(x, y));
                    }
                }
            }
        }
        img.scale(width, height);
        return img;
    }
    
    /**
     * This will return an object intersecting with the coloured part of your image.
     */
    public Actor getAnIntersectingObject(Class clss) {
        GreenfootImage img = getImage();
        Actor actor = null;
        for(int x = 0; x<img.getWidth(); x++) {
            for(int y = 0; y<img.getHeight(); y++) {
                if(img.getColorAt(x, y).getAlpha()>0) {
                    if(getOneObjectAtOffset(x-img.getWidth()/2, y-img.getHeight()/2, clss)!=null) {
                        actor = getOneObjectAtOffset(x-img.getWidth()/2, y-img.getHeight()/2, clss);
                    }
                }
            }
        }
        return actor;
    }
    
    /**
     * This uses an ID where 0 will be the first image on the sheet. The spriteCellWidth and Height are
     * the dimesions of each individual cells on your sprite sheet. The width and height are the dimesions
     * of the returned image.
     */
    public GreenfootImage getSprite(GreenfootImage spriteSheet, int ID, int spriteCellWidth, int spriteCellHeight, int width, int height) {
        int topX = 0;
        int topY = 0;
        int rowSize = spriteSheet.getWidth()/spriteCellWidth;
        topX = (ID%rowSize)*spriteCellWidth;
        topY = (ID-(ID%rowSize))/rowSize*spriteCellHeight;
        
        return getSprite(spriteSheet, topX, topY, topX+spriteCellWidth, topY+spriteCellHeight, width, height);
    }
    
    /**
     * This uses an ID where 0 will be the first image on the sheet. The spriteCellWidth and Height are
     * the dimesions of each individual cells on your sprite sheet.
     */
    public GreenfootImage getSprite(GreenfootImage spriteSheet, int ID, int spriteCellWidth, int spriteCellHeight) {
        return getSprite(spriteSheet, ID, spriteCellWidth, spriteCellHeight, spriteCellWidth, spriteCellHeight);
    }
    
    /**
     * This uses an ID where 0 will be the first image on the sheet.
     * The block width is the width of a SQUARE block on the sheet,
     * the returned image will also be a SQUARE block.
     */
    public GreenfootImage getSprite(GreenfootImage spriteSheet, int ID, int blockWidth) {
        return getSprite(spriteSheet, ID, spriteSheet.getWidth()/blockWidth, spriteSheet.getHeight()/blockWidth);
    }
}