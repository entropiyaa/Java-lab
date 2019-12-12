public class ChewingGum extends Food {
    private String flavour;
    public ChewingGum(String flavour)
    {
        super("Жевательная резинка");
        this.flavour = flavour;
    }
    public void setFlavour(String flavour)
    {
        this.flavour = flavour;
    }
    public String getFlavour()
    {
        return flavour;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " употреблена");
    }
    @Override
    public String toString()
    {
        return super.toString() + " со вкусом '" + flavour.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof ChewingGum))
                return false;
            return flavour.equals(((ChewingGum) obj).flavour);
        } else
            return false;
    }*/
}
