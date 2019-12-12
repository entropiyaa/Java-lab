public class Coffee extends Food {
    private String aroma;
    public Coffee(String aroma)
    {
        super("Кофе");
        this.aroma = aroma;
    }
    public void setAroma(String aroma)
    {
        this.aroma = aroma;
    }
    public String getAroma()
    {
        return aroma;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " выпит");
    }
    @Override
    public String toString()
    {
        return super.toString() + " аромата '" + aroma.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Coffee))
                return false;
            return aroma.equals(((Coffee) obj).aroma);
        } else
            return false;
    }*/
}

