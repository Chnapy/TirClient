/*
 * 
 * 
 * 
 */
package vue;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * NumberField.java
 *
 */
public class NumberField extends TextField {

    public NumberField() {
	super();
	this.addEventFilter(KeyEvent.KEY_TYPED, (KeyEvent t) -> {
	    char ar[] = t.getCharacter().toCharArray();
	    char ch = ar[t.getCharacter().toCharArray().length - 1];
	    if (!(ch >= '0' && ch <= '9')) {
		t.consume();
	    }
	});
    }

    public NumberField(int nombre) {
	this();
	this.setText(Integer.toString(nombre));
    }
    
    public void setPromptNumber(int nombre) {
	this.setPromptText(Integer.toString(nombre));
    }
    
    public int getNumber() {
	if(getText().isEmpty())
	    return -1;
	return Integer.parseInt(getText());
    }
}
