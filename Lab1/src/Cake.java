public class Cake extends Food {
    private String icing;
    public Cake(String icing)
    {
        super("Пирожное");
        this.icing = icing;
    }
    public void setIcing(String icing)
    {
        this.icing = icing;
    }
    public String getIcing()
    {
        return icing;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съедено");
    }
    @Override
    public String toString()
    {
        return super.toString() + " с глазурью '" + icing.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Cake))
                return false;
            return icing.equals(((Cake) obj).toString());
        } else
            return false;
    }*/
}

