package net.juntech.develop.mybatis;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * mybatis生成实体添加序列号
 * <ul>
 * <li>xhl 2016年5月17日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class PluginSerializable extends PluginAdapter {

	private FullyQualifiedJavaType serializable;
	private FullyQualifiedJavaType gwtSerializable;
	private boolean addGWTInterface;
	private boolean suppressJavaInterface;

	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}

	public PluginSerializable() {
		super();
		serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$
		gwtSerializable = new FullyQualifiedJavaType("com.google.gwt.user.client.rpc.IsSerializable"); //$NON-NLS-1$
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		addGWTInterface = Boolean.valueOf(properties.getProperty("addGWTInterface")); //$NON-NLS-1$
		suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); //$NON-NLS-1$
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	/**
	 * 添加给Example类序列化的方法
	 */
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		if (addGWTInterface) {
			topLevelClass.addImportedType(gwtSerializable);
			topLevelClass.addSuperInterface(gwtSerializable);
		}

		if (!suppressJavaInterface) {
			topLevelClass.addImportedType(serializable);
			topLevelClass.addSuperInterface(serializable);

			Field field = new Field();
			field.setFinal(true);
			field.setInitializationString("1L"); //$NON-NLS-1$
			field.setName("serialVersionUID"); //$NON-NLS-1$
			field.setStatic(true);
			field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
			field.setVisibility(JavaVisibility.PRIVATE);
			context.getCommentGenerator().addFieldComment(field, introspectedTable);
			topLevelClass.addField(field);
		}
	}

}
