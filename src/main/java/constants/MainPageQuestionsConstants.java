package constants;

public enum  MainPageQuestionsConstants {
    QUESTION1("Сутки — 400 рублей. " +
            "Оплата курьеру — наличными или картой."),
    QUESTION2("Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать " +
            "несколько заказов — один за другим."),
    QUESTION3("Допустим, вы оформляете заказ на 8 мая. Мы привозим " +
            "самокат 8 мая в течение дня. Отсчёт времени аренды начинается " +
            "с момента, когда вы оплатите заказ курьеру. Если мы привезли " +
            "самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
    QUESTION4("Только начиная с завтрашнего дня. " +
            "Но скоро станем расторопнее."),
    QUESTION5("Пока что нет! Но если что-то срочное — всегда можно " +
            "позвонить в поддержку по красивому номеру 1010."),
    QUESTION6("Самокат приезжает к вам с полной зарядкой. " +
            "Этого хватает на восемь суток — даже если будете кататься " +
            "без передышек и во сне. Зарядка не понадобится."),
    QUESTION7("Да, пока самокат не привезли. Штрафа не будет, " +
            "объяснительной записки тоже не попросим. Все же свои."),
    QUESTION8("Да, обязательно. Всем самокатов! И Москве, " +
            "и Московской области.");

    private String answer;

    MainPageQuestionsConstants(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
