public class Main {

    public static void main(String[] args) {

            Food[] breakfast = new Food[20];
            int i = 0;

        for (String arg: args)
        {
            String[] parts = arg.split("/");

            if (parts[0].equals("Cheese"))
            {
                breakfast[i] = new Cheese();
            } else
            if (parts[0].equals("Apple"))
            {
                breakfast[i] = new Apple(parts[1]);
                breakfast[i].addC();
            } else
            if(parts[0].equals("Tea"))
            {
                breakfast[i] = new Tea(parts[1]);
            } else
            if(parts[0].equals("Pie"))
            {
                breakfast[i] = new Pie(parts[1]);
            } else
            if(parts[0].equals("Milk"))
            {
                breakfast[i] = new Milk(parts[1]);
            } else
            if(parts[0].equals("Potatoes"))
            {
                breakfast[i] = new Potatoes(parts[1]);
            } else
            if(parts[0].equals("Burger"))
            {
                breakfast[i] = new Burger(parts[1]);
            } else
            if(parts[0].equals("Coffee"))
            {
                breakfast[i] = new Coffee(parts[1]);
            } else
            if(parts[0].equals("IceCream"))
            {
                breakfast[i] = new IceCream(parts[1]);
            } else
            if(parts[0].equals("ChewingGum"))
            {
                breakfast[i] = new ChewingGum(parts[1]);
            } else
            if(parts[0].equals("Eggs"))
            {
                breakfast[i] = new Eggs(parts[1]);
            } else
            if(parts[0].equals("Lemonade"))
            {
                breakfast[i] = new Lemonade(parts[1]);
            } else
            if(parts[0].equals("Cake"))
            {
                breakfast[i] = new Cake(parts[1]);
            } else
            if(parts[0].equals("Beef"))
            {
                breakfast[i] = new Beef(parts[1]);
            }
            i++;
        }

            for (Food item: breakfast)
            {
                if (item!=null)
                {
                    item.consume();
                }
                else
                    { break; }
            }

        Food Apple = new Apple("");
        Food Cheese = new Cheese();
        Food Tea = new Tea("");
        Food Pie = new Pie("");
        Food Milk = new Milk("");
        Food Potatoes = new Potatoes("");
        Food Burger = new Burger("");
        Food Coffee = new Coffee("");
        Food IceCream = new IceCream("");
        Food ChewingGum = new ChewingGum("");
        Food Eggs = new Eggs("");
        Food Lemonade = new Lemonade("");
        Food Cake = new Cake("");
        Food Beef = new Beef("");





            System.out.println("Приятного аппетита..");
    }
}
