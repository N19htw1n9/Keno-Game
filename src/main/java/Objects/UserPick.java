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

    public boolean setNumber(int number) {
        if (this.numbers.size() <= this.spots) {
            this.numbers.add(number);
            return true;
        }
        return false;
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
