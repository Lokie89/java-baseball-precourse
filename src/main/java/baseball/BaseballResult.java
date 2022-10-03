package baseball;

/**
 * @author SeongRok.Oh
 * @since 2022/10/03
 */
public enum BaseballResult {
    BALL("볼"),
    STRIKE("스트라이크"),
    ;

    BaseballResult(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }
}
