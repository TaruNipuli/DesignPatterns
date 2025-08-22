package abstract_factory;

// Factory for creating UI elements of type A
public class AFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }

    @Override
    public TextField createTextField(String placeholder) {
        return new TextFieldA(placeholder);
    }

}
