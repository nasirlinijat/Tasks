package personal.designPatterns.abstractFactory.factories;

import personal.designPatterns.abstractFactory.darkModes.DarkButton;
import personal.designPatterns.abstractFactory.darkModes.DarkCheckBox;
import personal.designPatterns.abstractFactory.darkModes.DarkTextField;
import personal.designPatterns.abstractFactory.elements.Button;
import personal.designPatterns.abstractFactory.elements.CheckBox;
import personal.designPatterns.abstractFactory.elements.TextField;

public class DarkModeFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }

    @Override
    public CheckBox createCheckBox() {
        return new DarkCheckBox();
    }
}
