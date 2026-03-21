package personal.designPatterns.adapter;

public class Main {
    public static void main(String[] args) {
        EnglishTranslator englishTranslator = new TranslatorAdapter();
        englishTranslator.translate("Salam");
    }
}
