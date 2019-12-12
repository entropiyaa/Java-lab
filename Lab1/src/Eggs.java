public class Eggs extends Food {
    private String number;
    public Eggs(String number)
    {
        super("Яйца");
        this.number = number;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public String getNumber()
    {
        return number;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съедены");
    }
    @Override
    public String toString()
    {
        return super.toString() + " количеством '" + number.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Eggs))
                return false;
            return number.equals(((Eggs) obj).number);
        } else
            return false;
    }*/
}
