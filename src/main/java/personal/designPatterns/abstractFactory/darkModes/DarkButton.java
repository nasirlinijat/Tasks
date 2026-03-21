package personal.designPatterns.abstractFactory.darkModes;

import personal.designPatterns.abstractFactory.elements.Button;

public class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}
