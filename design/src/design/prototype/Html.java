package design.prototype;

/**
 * <ul>
 * <li>{@link #Html()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月1日
 * 
 */
public class Html implements Cloneable {

	private Body body;
	private Head head;

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Html html = (Html) super.clone();
		html.head = (Head) this.head.clone();
		return html;
	}

}
