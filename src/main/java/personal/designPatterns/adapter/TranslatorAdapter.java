package personal.designPatterns.adapter;

public class TranslatorAdapter implements EnglishTranslator{
    private final Translator translator = new Translator();

    @Override
    public String translate(String text) {
        return translator.translate(text, "English");
    }
}
