package abstract_factory;

// Factory for creating UI elements of type B
public class BFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }

    @Override
    public TextField createTextField(String placeholder) {
        return new TextFieldB(placeholder);
    }
}
