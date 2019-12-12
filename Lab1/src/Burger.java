public class Burger extends Food {
    private String size;
    public Burger(String size)
    {
        super("Гамбургер");
        this.size = size;
    }
    public void setSize(String size)
    {
        this.size = size;
    }
    public String getSize()
    {
        return size;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съеден");
    }
    @Override
    public String toString()
    {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Burger))
                return false;
            return size.equals(((Burger) obj).size);
        } else
            return false;
    }*/
}

