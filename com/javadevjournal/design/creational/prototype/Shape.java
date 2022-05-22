package javadevjournal.design.creational.prototype;

/**
 * @author Kunwar
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Use Object class's Clone() method to do the cloning.
     *
     * @return
     */
    public Object clone() {
        Object cloneObject = null;
        try {
            cloneObject = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("cloning failed");
            e.printStackTrace();
        }
        return cloneObject;
    }
}