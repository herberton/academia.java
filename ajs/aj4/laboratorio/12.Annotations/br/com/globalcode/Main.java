package br.com.globalcode;

import br.com.globalcode.util.*;
import br.com.globalcode.model.*;

public class Main {

	public static void main(String... args) {
		new FormBuilder(Produto.class).newForm().setVisible(true);
	}
	
}
