package framework.form;

import framework.elements.BaseElement;
import framework.Log;

abstract public class BaseForm {
    protected BaseElement element;
    protected String name;

    public BaseForm(BaseElement element,String name){
        this.name = name;
        this.element = element;
    }
    public boolean isOpen() {
        Log.info(name + " opened" );
        element.waitUntilElementIsAppear();
        return element.isVisible();
    }
}
