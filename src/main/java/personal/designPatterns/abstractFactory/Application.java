package personal.designPatterns.abstractFactory;

import personal.designPatterns.abstractFactory.elements.Button;
import personal.designPatterns.abstractFactory.elements.CheckBox;
import personal.designPatterns.abstractFactory.elements.TextField;
import personal.designPatterns.abstractFactory.factories.UIFactory;

public class Application {
    private final Button button;
    private final CheckBox checkBox;
    private final TextField textField;

    public Application(UIFactory factory) {
        this.button    = factory.createButton();
        this.textField = factory.createTextField();
        this.checkBox  = factory.createCheckBox();
    }

    public void renderUI() {
        button.render();
        textField.render();
        checkBox.render();
    }
}
