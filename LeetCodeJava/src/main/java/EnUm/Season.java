package EnUm;

public enum Season {
    SPRING(1), SUMMER(2), AUTuMN(3), WINTER(4);
    private int code;

    private Season(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
