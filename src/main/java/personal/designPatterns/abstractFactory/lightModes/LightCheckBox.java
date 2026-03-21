package personal.designPatterns.abstractFactory.lightModes;

import personal.designPatterns.abstractFactory.elements.CheckBox;

public class LightCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering Light CheckBox");
    }
}
