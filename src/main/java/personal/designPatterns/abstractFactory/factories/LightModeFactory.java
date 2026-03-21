package personal.designPatterns.abstractFactory.factories;

import personal.designPatterns.abstractFactory.elements.Button;
import personal.designPatterns.abstractFactory.elements.CheckBox;
import personal.designPatterns.abstractFactory.elements.TextField;
import personal.designPatterns.abstractFactory.lightModes.LightButton;
import personal.designPatterns.abstractFactory.lightModes.LightCheckBox;
import personal.designPatterns.abstractFactory.lightModes.LightTextField;

public class LightModeFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LightCheckBox();
    }
}
