public class Milk extends Food {
    private String fat;
    public Milk(String fat)
    {
        super("Молоко");
        this.fat = fat;
    }
    public void setFat(String fat)
    {
        this.fat = fat;
    }
    public String getFat()
    {
        return fat;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " выпито");
    }
    @Override
    public String toString()
    {
        return super.toString() + " жирности '" + fat.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Milk))
                return false;
            return fat.equals(((Milk) obj).fat);
        } else
            return false;
    }*/
}

