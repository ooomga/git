package design.singleton;

/**
 * <ul>
 * <li>{@link #SSS()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年9月2日
 * 
 */
public enum SSS {

	AAAA("中国人") {
		public String toString() {
			return "这是"+this.getValue();
		}
	},
	BBBB("美国人") {
		public String toString() {
			return "这是美国人";
		}
	};

	private String value = null;

	private SSS() {
		value = "其他人";
	}

	SSS(String s) {
		this.value = s;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
