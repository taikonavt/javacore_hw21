import bigTask.Apple;
import bigTask.Box;
import bigTask.Orange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        firstMethod(createStringArray());

        ArrayList<String> stringArrayList = secondMethod(createStringArray());
        System.out.println(stringArrayList.get(2));

        thirdMethod();
    }

    private static String[] createStringArray(){
        String[] strings = new String [10];

        for (int i = 0; i < strings.length; i++){
            strings[i] = ("element" + i);
        }
        return strings;
    }

    private static  <T> void firstMethod(T[] array){
        if (array.length == 0)
            return;

        for (T item : array) {
            System.out.println(item.toString());
        }
        System.out.println();

        T tempItem = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = tempItem;

        for (T item : array) {
            System.out.println(item.toString());
        }
        System.out.println();
    }

    private static <T> ArrayList<T> secondMethod(T[] array){
        ArrayList<T> arrayList = new ArrayList<>();

        for(T item : array){
            arrayList.add(item);
        }
        return arrayList;
    }

    private static void thirdMethod(){
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        for (int i = 0; i < 3; i++) {
            System.out.println("Fruit has been added: " + box1.putFruit(new Apple()));
        }
        System.out.println("Fruit has been added: " + box1.putFruit(new Orange()));
        System.out.println(box1.weightOfBox());

        for (int i = 0; i < 2; i++) {
            System.out.println("Fruit has been added: " + box2.putFruit(new Orange()));
        }
        System.out.println(box2.weightOfBox());

        System.out.println("Weight of boxes is equal: " + box1.compare(box2));

        System.out.println("Fruits has been transferred: " + box1.transferFruitsTo(box3));
        System.out.println(box1.weightOfBox());
        System.out.println(box3.weightOfBox());
    }
}
