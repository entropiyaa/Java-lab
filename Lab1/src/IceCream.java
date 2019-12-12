public class IceCream extends Food {
    private String sirop;
    public IceCream(String sirop)
    {
        super("Мороженное");
        this.sirop = sirop;
    }
    public void setSirop(String sirop)
    {
        this.sirop = sirop;
    }
    public String getSirop()
    {
        return sirop;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съедено");
    }
    @Override
    public String toString()
    {
        return super.toString() + " с сиропом '" + sirop.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof IceCream))
                return false;
            return sirop.equals(((IceCream) obj).sirop);
        } else
            return false;
    }*/
}

