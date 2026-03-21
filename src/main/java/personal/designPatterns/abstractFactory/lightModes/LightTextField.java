package personal.designPatterns.abstractFactory.lightModes;

import personal.designPatterns.abstractFactory.elements.TextField;

public class LightTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Light TextField");
    }
}
