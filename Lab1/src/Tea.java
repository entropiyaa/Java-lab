public class Tea extends Food {
    private String color;
    public Tea(String color)
    {
        super("Чай");
        this.color = color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public String getColor()
    {
        return color;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " выпит");
    }
    @Override
    public String toString()
    {
        return super.toString() + " цвета '" + color.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Tea))
                return false;
            return color.equals(((Tea) obj).color);
        } else
            return false;
    }*/

}

