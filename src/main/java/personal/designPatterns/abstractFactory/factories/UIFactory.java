package personal.designPatterns.abstractFactory.factories;

import personal.designPatterns.abstractFactory.elements.Button;
import personal.designPatterns.abstractFactory.elements.CheckBox;
import personal.designPatterns.abstractFactory.elements.TextField;

public interface UIFactory {
    Button createButton();
    TextField createTextField();
    CheckBox createCheckBox();
}
