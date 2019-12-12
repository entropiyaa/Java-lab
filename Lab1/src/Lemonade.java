public class Lemonade extends Food {
    private String taste;
    public Lemonade(String taste)
    {
        super("Лимонад");
        this.taste = taste;
    }
    public void setTaste(String taste)
    {
        this.taste = taste;
    }
    public String getTaste()
    {
        return taste;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " выпит");
    }
    @Override
    public String toString()
    {
        return super.toString() + " вкуса '" + taste.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Lemonade))
                return false;
            return taste.equals(((Lemonade) obj).toString());
        } else
            return false;
    }*/
}

