public class Main {

    public static void main(String[] args) {

            Food[] breakfast = new Food[20];
            int i = 0;

            for (String arg: args) {

                String[] parts = arg.split("/");

                if (parts[0].equals("Cheese")) {
                    breakfast[i] = new Cheese();
                } else
                if (parts[0].equals("Apple")) {
                    breakfast[i] = new Apple(parts[1]);
                }
                i++;
            }
            for (Food item: breakfast)
                if (item!=null)
                {
                    item.consume();
                }
                else
                    { break; }

            System.out.println("Приятного аппетита..");
    }
}
