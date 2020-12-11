package br.com.globalcode.util;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.reflect.*;
import br.com.globalcode.annotations.TextBox; 

public class FormBuilder {
	
	private Class clazz;
	private java.util.List<Field> fields;
	
	public FormBuilder(Class clazz) {
		
		this.clazz = clazz;
		
		// adiciona os declaredFields que possuem a anotação TextBox
		this.fields = new ArrayList<Field>();
		Field[] declaredFields = clazz.getDeclaredFields();
		for(Field declaredField : declaredFields) {
			if(!declaredField.isAnnotationPresent(TextBox.class)) {
				continue;
			}
			fields.add(declaredField);
		}
		
	}
	
	
	public JFrame newForm() {
		
		JFrame form = new JFrame(clazz.getSimpleName());
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.setSize(300, 30 * this.fields.size());
		
		form.add(this.newPanel());
		
		return form;
		
	}
	
	
	private JPanel newPanel() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(this.fields.size(), 2));
		
		for(Field field : fields) {
			TextBox textBox = field.getAnnotation(TextBox.class);
			panel.add(new JLabel(textBox.label()));
			JTextField textField = new JTextField("", 10);
			textField.setEnabled(textBox.enabled());
			panel.add(textField);
		}
		
		
		return panel;
		
	}
	
}
