public class Dices {
    private static Integer COUNT;

    public Dices(Integer count) {
        COUNT = count;
    }

    public Integer throwChance() {
        Integer totalThrow = 0;
        for (int i = 0; i < COUNT; ++i) {
            totalThrow += getRandomValue();
        }
        return totalThrow;
    }

    private Integer getRandomValue() {
        return 1 + (int) (Math.random() * 6.0);
    }
}
