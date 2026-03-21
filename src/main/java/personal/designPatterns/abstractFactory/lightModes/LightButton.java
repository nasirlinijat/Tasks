package personal.designPatterns.abstractFactory.lightModes;

import personal.designPatterns.abstractFactory.elements.Button;

public class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}
