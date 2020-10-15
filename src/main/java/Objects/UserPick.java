package Objects;

import java.util.ArrayList;

public class UserPick {
    private int spots;
    private ArrayList<Integer> numbers;

    public UserPick() {
        this.numbers = new ArrayList<>();
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    public void setNumber(int number) {
        this.numbers.add(number);
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSpots() {
        return this.spots;
    }
}
