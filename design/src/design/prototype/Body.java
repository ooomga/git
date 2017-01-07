package design.prototype;

/**
 * <ul>
 * <li>{@link #Body()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class Body implements Cloneable {

	private String div;
	private String span;

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getSpan() {
		return span;
	}

	public void setSpan(String span) {
		this.span = span;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
