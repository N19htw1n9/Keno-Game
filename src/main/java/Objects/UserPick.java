package Objects;

import java.util.ArrayList;
import java.util.Random;

public class UserPick {
    private int spots;
    private ArrayList<Integer> numbers;

    public UserPick() {
        this.numbers = new ArrayList<>();
    }

    public UserPick(int spots) {
        this.numbers = new ArrayList<>();
        this.spots = spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    /**
     * Adds number as long as the list size < spots. If the condition is not met,
     * the number is not added to the list.
     * 
     * @param number Value that will be added to numbers list
     */
    public void setNumber(int number) {
        if (this.numbers.size() < this.spots) {
            this.numbers.add(number);
        }
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * Fills out numbers with unique random values. If spots = 3 and the list is
     * empty then this will fill out the 3 spots with unique random numbers. If
     * spots = 10 and the list contains 4 values then it proceeds to fill out the
     * rest of the 6 values with unique random numbers.
     */
    public void randomPick() {
        final int randomFillSize = this.spots - numbers.size();

        for (int i = 0; i < randomFillSize; i++) {
            int randPick = new Random().nextInt(80) + 1;
            while (this.numbers.contains(randPick))
                randPick = new Random().nextInt(80) + 1;
            this.setNumber(randPick);
        }
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSpots() {
        return this.spots;
    }
}
