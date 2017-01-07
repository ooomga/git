package design.builder;

/**
 * 建造者
 * <ul>
 * <li>{@link #Builder()}功能描述,方便查找方法</li>
 * </ul>
 * 
 * @author xhl 2016年8月30日
 * 
 */
public class Builder {

	private String name;
	private int age;
	private String sex;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*********************************************/
	public static class BuilderBuild {
		private String name;
		private int age = 0;
		private String sex;
		private String address;

		public BuilderBuild(String name) {
			this.name = name;
		}

		public BuilderBuild age(int age) {
			this.age = age;
			return this;
		}

		public BuilderBuild sex(String sex) {
			this.sex = sex;
			return this;
		}

		public BuilderBuild address(String address) {
			this.address = address;
			return this;
		}

		public Builder build() {
			return new Builder(this);
		}
	}

	/**
	 * 构造方法进行构建
	 * 
	 * @param build
	 */
	private Builder(BuilderBuild build) {
		name = build.name;
		age = build.age;
		sex = build.sex;
		address = build.address;
	}
}
