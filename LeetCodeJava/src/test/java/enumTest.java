import EnUm.ResultCode;
import EnUm.Season;

public class enumTest {
    public static String getChineseSeason(Season season) {
        StringBuilder result = new StringBuilder();
        switch (season) {
            case SPRING -> result.append("春" + season.getCode());
            case SUMMER -> result.append("夏" + season.getCode());
            case AUTuMN -> result.append("秋" + season.getCode());
            case WINTER -> result.append("冬" + season.getCode());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        for (Season s : Season.values()) {
            System.out.println(getChineseSeason(s));
        }

        for (ResultCode code : ResultCode.values()) {
            System.out.println(code.getCode() + code.getMessage());
        }

    }
}
