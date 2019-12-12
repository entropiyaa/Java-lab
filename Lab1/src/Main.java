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

        System.out.println("Общее количество продуктов:");

        for(Food item: breakfast)
        {
            if(item != null)
            {
                if(item.equals(Apple))
                { Apple.addC(); }

                if(item.equals(Cheese))
                { Cheese.addC(); }

                if(item.equals(Tea))
                { Tea.addC(); }

                if(item.equals(Pie))
                { Pie.addC(); }

                if(item.equals(Milk))
                { Milk.addC(); }

                if(item.equals(Potatoes))
                { Potatoes.addC(); }

                if(item.equals(Burger))
                { Burger.addC(); }

                if(item.equals(Coffee))
                { Coffee.addC(); }

                if(item.equals(IceCream))
                { IceCream.addC(); }

                if(item.equals(ChewingGum))
                { ChewingGum.addC(); }

                if(item.equals(Eggs))
                { Eggs.addC(); }

                if(item.equals(Lemonade))
                { Lemonade.addC(); }

                if(item.equals(Cake))
                { Cake.addC(); }

                if(item.equals(Beef))
                { Beef.addC(); }
            }
        }

        System.out.println("Яблок съедено " + Apple.getC());
        System.out.println("Сыра съедено " + Cheese.getC());
        System.out.println("Чаю выпито " + Tea.getC());
        System.out.println("Пирога съедено " + Pie.getC());
        System.out.println("Молока выпито " + Milk.getC());
        System.out.println("Картошки съедено " + Potatoes.getC());
        System.out.println("Гамбургеров съедено " + Burger.getC());
        System.out.println("Кофе выпито " + Coffee.getC());
        System.out.println("Мороженного съедено " + IceCream.getC());
        System.out.println("Жевательной резинки съедено " + ChewingGum.getC());
        System.out.println("Яиц съедено " + Eggs.getC());
        System.out.println("Лимонада выпито " + Lemonade.getC());
        System.out.println("Пирожных съедено " + Cake.getC());
        System.out.println("Мяса съедено " + Beef.getC());

        System.out.println("Приятного аппетита..");
        System.out.println("Спасибо..");
    }
}
