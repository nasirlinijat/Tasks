package personal.designPatterns.abstractFactory;

import personal.designPatterns.abstractFactory.factories.DarkModeFactory;
import personal.designPatterns.abstractFactory.factories.LightModeFactory;
import personal.designPatterns.abstractFactory.factories.UIFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory uiFactory = new DarkModeFactory();
        Application application = new Application(uiFactory);
        application.renderUI();


        uiFactory = new LightModeFactory();
        application = new Application(uiFactory);
        application.renderUI();
    }
}
