package design.prototype;

/**
 * <ul>
 * <li>{@link #Head()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class Head implements Cloneable {
	private String meta;
	private String title;

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
