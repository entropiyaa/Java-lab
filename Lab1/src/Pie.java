public class Pie extends Food {
    private String filling;
    public Pie(String filling)
    {
        super("Пирог");
        this.filling = filling;
    }
    public void setFilling(String filling)
    {
        this.filling = filling;
    }
    public String getFilling()
    {
        return filling;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съеден");
    }
    @Override
    public String toString() {
        return super.toString() + " с начинкой '" + filling.toUpperCase() + "'";
    }
    //   @Override
/*    public boolean equals(Object obj)
    {
        if(super.equals(obj))
        {
            if(!(obj instanceof Pie))
                return false;
            return filling.equals(((Pie)obj).filling);
        }
        else
            return false;
    }*/
}

