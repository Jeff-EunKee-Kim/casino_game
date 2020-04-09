package slots;

/**
 * @author Vincent Sinfeugo
 */
public class Cell {
    private int myID;
    private Icon myIcon;

    public Cell(int myID, Icon icon) {
        this.myID = myID;
        this.myIcon = icon;
    }

    public Cell(Cell other) {
        this.myID = other.getID();
        this.myIcon = other.getIcon();
    }

    public int getID() {
        return myID;
    }

    public Icon getIcon() {
        return myIcon;
    }

    public void setIcon(Icon icon) {
        this.myIcon = icon;
    }

    /**
     * @param o - object to be compared to
     * @return boolean representing general equality between two cell objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return myID == cell.myID &&
                myIcon == cell.myIcon;
    }

    /**
     * @return cell in string form
     */
    @Override
    public String toString() {
        return "Cell{" +
                "id=" + myID +
                ", state=" + myIcon +
                '}';
    }
}
