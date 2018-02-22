package bigTask;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> arrayList = new ArrayList<>();

    public Box(){
    }

    public boolean putFruit(T item){
        if (arrayList.isEmpty()){
            arrayList.add(item);
            return true;
        }
        else {
            if (arrayList.get(0).getClass() == item.getClass()) {
                arrayList.add(item);
                return true;
            }
            else
                return false;
        }
    }

    public float weightOfBox(){
        float weight = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            weight += arrayList.get(i).getWeight();
        }
        return weight;
    }

    public boolean compare(Box anotherBox){
        return Math.abs(this.weightOfBox() - anotherBox.weightOfBox()) < 0.0001f;
    }

    public boolean transferFruitsTo(Box anotherBox){
        if (this.arrayList.isEmpty())
            return true;
        else if (anotherBox.arrayList.isEmpty() ||
                (anotherBox.arrayList.get(0).getClass() == this.arrayList.get(0).getClass())){
            anotherBox.arrayList.addAll(this.arrayList);
            this.arrayList.clear();
            return true;
        }
        else
            return false;
    }
}
