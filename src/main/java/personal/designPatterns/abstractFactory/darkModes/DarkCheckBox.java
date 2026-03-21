package personal.designPatterns.abstractFactory.darkModes;

import personal.designPatterns.abstractFactory.elements.CheckBox;

public class DarkCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering Dark CheckBox");
    }
}
