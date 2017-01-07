package net.juntech.util;

import java.beans.PropertyEditorSupport;

import org.springframework.web.util.HtmlUtils;

public class StringEscapeEditor extends PropertyEditorSupport {

	private boolean escapeHTML;// 编码HTML 编码javascript

	public StringEscapeEditor() {
		super();
	}

	public StringEscapeEditor(boolean escapeHTML) {
		super();
		this.escapeHTML = escapeHTML;
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			if (escapeHTML) {
				value = HtmlUtils.htmlEscape(value);
			}
			setValue(value);
		}
	}

}
