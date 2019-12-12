public class Potatoes extends Food {
    private String type;
    public Potatoes(String type)
    {
        super("Картошка");
        this.type = type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return type;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съедена");
    }
    @Override
    public String toString()
    {
        return super.toString() + " типа '" + type.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj)) {
            if (!(obj instanceof Potatoes))
                return false;
            return type.equals(((Potatoes) obj).type);
        } else
            return false;
    }*/
}

