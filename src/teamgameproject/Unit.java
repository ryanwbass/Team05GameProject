package teamgameproject;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Unit {

    private int health;
    private int attack;
    private int range;
    private String details;
    private int posX;
    private int posY;
    private int mobility;
    protected Image image;
    protected int width;
    protected int height;
    protected boolean vis;

    public Unit(int health, int attack, int range, String details, int posX, int posY, int mobility) {
        this.health = health;
        this.attack = attack;
        this.range = range;
        this.details = details;
        this.posX = posX;
        this.posY = posY;
        this.mobility = mobility;
    }

    public int getHealth() {
        return health;
    }

    public boolean checkUnitMovement(int newPosX, int newPosY) {
        if ((Math.abs(posX - newPosX) <= mobility) && (Math.abs(posY - newPosY) <= mobility)) {
            return true;
        } else {
            return false;
        }

    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getRange() {
        return range;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

}