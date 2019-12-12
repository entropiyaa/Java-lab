public class Beef extends Food {
    private String preparedness;
    public Beef(String preparedness)
    {
        super("Мясо");
        this.preparedness = preparedness;
    }
    public void setPreparedness(String preparedness)
    {
        this.preparedness = preparedness;
    }
    public String getPreparedness()
    {
        return  preparedness;
    }
    @Override
    public void consume()
    {
        System.out.println(this + " съедено");
    }
    @Override
    public String toString()
    {
        return super.toString() + " готовностью '" + preparedness.toUpperCase() + "'";
    }
/*    @Override
    public boolean equals(Object obj)
    {
        if(super.equals(obj)) {
            if(!(obj instanceof Beef))
                return false;
            return preparedness.equals(((Beef)obj).preparedness);
        } else
            return false;
    }*/
}

