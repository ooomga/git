package net.juntech.develop.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

/**
 * <ul>
 * <li>xhl 2016年5月11日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class GeneratorMybatis extends PluginAdapter {

	/**
	 * 分页方法
	 * 
	 * <pre>
	 	FullyQualifiedJavaType.getIntInstance() 返回int
	 	PrimitiveTypeWrapper.getIntegerInstance() 返回Integer
	 * </pre>
	 * 
	 */
	private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		// field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setType(PrimitiveTypeWrapper.getIntegerInstance());
		field.setName(name);
		// field.setInitializationString("-1");
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		// method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));
		method.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		// method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.setReturnType(PrimitiveTypeWrapper.getIntegerInstance());
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	/**
	 * 添加分页
	 */
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		addLimit(topLevelClass, introspectedTable, "limitStart");
		addLimit(topLevelClass, introspectedTable, "limitEnd");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	/**
	 * 分页添加位置
	 */
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

		// 节点会添加到orderByClause 下
		// XmlElement isParameterPresenteElemen = (XmlElement) element.getElements().get(element.getElements().size() - 1);
		// XmlElement isNotNullElement = new XmlElement("isGreaterEqual"); //$NON-NLS-1$
		// isNotNullElement.addAttribute(new Attribute("property", "limitStart")); //$NON-NLS-1$ //$NON-NLS-2$
		// isNotNullElement.addAttribute(new Attribute("compareValue", "0")); //$NON-NLS-1$ //$NON-NLS-2$
		// isNotNullElement.addElement(new TextElement("limit $limitStart$ , $limitEnd$"));
		// isParameterPresenteElemen.addElement(isNotNullElement);
		XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$
		isNotNullElement.addAttribute(new Attribute("test", "limitStart != null and limitStart>=0")); //$NON-NLS-1$ //$NON-NLS-2$
		isNotNullElement.addElement(new TextElement("limit #{limitStart} , #{limitEnd}"));
		element.addElement(isNotNullElement);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	/**
	 * 向Base_Column_List 中添加text字段
	 */
	@Override
	public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		StringBuffer colume = new StringBuffer();
		for (IntrospectedColumn introspectedColumn : introspectedTable.getBLOBColumns()) {
			colume.append(", " + introspectedColumn.getActualColumnName());
		}
		if (introspectedTable.getBaseColumns().isEmpty()) {
			colume.delete(0, 1);
		}
		TextElement textElement = new TextElement(colume.toString());
		element.addElement(textElement);
		return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
	}
	
	@Override
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String name = "example";
		Method method = new Method("selectByExampleForOne");
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getExampleType()), name));
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
		interfaze.addMethod(method);
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}
	
	// add the new Element for mapper.xml, use to add a new Function
	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		XmlElement rootElement = document.getRootElement();
		
		XmlElement selectOne = new XmlElement("select");
		selectOne.addAttribute(new Attribute("id", "selectByExampleForOne"));
		selectOne.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		selectOne.addAttribute(new Attribute("parameterType", "java.lang.Integer"));
		selectOne.addElement(new TextElement("select"));
		
		// distinct
		XmlElement ifOne = new XmlElement("if");
		ifOne.addAttribute(new Attribute("test", "distinct"));
		ifOne.addElement(new TextElement("distinct"));
		selectOne.addElement(ifOne);
		
		// include Base_Column_List
		XmlElement includeXml = new XmlElement("include");
		includeXml.addAttribute(new Attribute("refid", "Base_Column_List"));
		selectOne.addElement(includeXml);
		
		// text table
		selectOne.addElement(new TextElement("from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));

		// _parameter
		XmlElement ifTwo = new XmlElement("if");
		ifTwo.addAttribute(new Attribute("test", "_parameter != null"));
		
		XmlElement includeRefXml = new XmlElement("include");
		includeRefXml.addAttribute(new Attribute("refid", "Example_Where_Clause"));
		ifTwo.addElement(includeRefXml);
		
		selectOne.addElement(ifTwo);
		
		// orderByClause
		XmlElement ifThree = new XmlElement("if");
		ifThree.addAttribute(new Attribute("test", "orderByClause != null"));
		ifThree.addElement(new TextElement("order by ${orderByClause}"));
		selectOne.addElement(ifThree);
		
		rootElement.addElement(selectOne);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	public static void generator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		String file = ClassLoader.getSystemResource("mybatis/generator.xml").getFile();
		String[] arg = { "-configfile", file, "-overwrite" };
		ShellRunner.main(arg);

	}

	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		generator();
	}

}
