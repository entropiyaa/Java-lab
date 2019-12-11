public class Apple extends Food {
    private String size;
    public Apple(String size)
    {
        super("Яблоко");
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
    public void consume()
    {
        System.out.println(this + " съедено");
    }
    @Override
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
 /*   @Override
    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            if(!(obj instanceof Apple))
                return false;
            return size.equals(((Apple)obj).size);

        }
        else
            return false;
    }*/
}
