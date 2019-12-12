public abstract class Food implements Consumable {

    private String name = null;
    private int c = 0;             //количество

    public Food(String name)
    {
        this.name = name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public int getC()
    {
        return c;
    }
    public void addC()
    {
        c++;
    }
    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Food))
            return false;
        if(name == null || ((Food)obj).name == null)
            return false;
        return name.equals(((Food)obj).name);
    }
}
