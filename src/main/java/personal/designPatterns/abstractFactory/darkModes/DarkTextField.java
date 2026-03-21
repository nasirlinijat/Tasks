package personal.designPatterns.abstractFactory.darkModes;

import personal.designPatterns.abstractFactory.elements.TextField;

public class DarkTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering Dark TextField");
    }
}
