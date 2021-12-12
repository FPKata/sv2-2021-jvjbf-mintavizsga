package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    protected static final int CAPACITY = 20;
    private List<Fish> fishList = new ArrayList<>();

    public Aquarium() {
    }

    public Aquarium(List<Fish> fishList) {
        this.fishList = fishList;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void addFish(Fish fish){
        if (fishList.isEmpty() || CAPACITY / fishList.size() > 5){
            fishList.add(fish);
        }else{
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
    }

    public void feed(){
        for (Fish actual : fishList){
            actual.feed();
        }
    }

    public void removeFish(int maxWeight){
        List<Fish> toBeRemoved = new ArrayList<>();
        for (Fish actual : fishList){
            if (actual.weight > maxWeight){
                toBeRemoved.add(actual);
            }
        }
        fishList.removeAll(toBeRemoved);
    }

    public List<String> getStatus(){
        List<String> statusList = new ArrayList<>();
        for (Fish actual : fishList){
            statusList.add(actual.getStatus());
        }
        return statusList;
    }

    public int getNumberOfFishWithMemoryLoss(){
        int counter = 0;
        for (Fish actual : fishList){
            if (actual.memoryLoss){
                counter++;
            }
        }
        return counter;
    }

    public boolean isThereFishWithGivenColor(String color){
        boolean success = false;
        for (int i = 0; !success && i < fishList.size(); i++){
            success = fishList.get(i).color.equals(color);
        }
        return success;
    }

    public Fish getSmallestFish(){
        Fish smallest = fishList.get(0);
        for (int i = 1; i < fishList.size(); i++){
            if (fishList.get(i).weight < smallest.weight){
                smallest = fishList.get(i);
            }
        }
        return smallest;
    }
}
