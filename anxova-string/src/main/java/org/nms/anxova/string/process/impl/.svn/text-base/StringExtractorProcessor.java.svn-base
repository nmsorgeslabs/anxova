package org.nms.anxova.string.process.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nms.anxova.process.beans.BaseElement;
import org.nms.anxova.process.beans.IElement;
import org.nms.anxova.process.impl.AbstractBaseProcessor;
import org.nms.anxova.string.process.StringExtractorProcessComplexTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extracts Strings from a String element.
 * <p>
 * Uses regex to obtain the strings from the original element.
 * </p>
 * @author daviz
 *
 */
public class StringExtractorProcessor<T extends Serializable> 
extends AbstractBaseProcessor<T ,String,String>{


	/**
	 * Logger.
	 */
	private final static Logger logger = LoggerFactory.getLogger(StringExtractorProcessComplexTest.class);
		
	
	
	public enum FilterType{
		OR,AND
	}
	
	private List<String> prefixes;
	
	private List<String> postfixes;
	
	private FilterType prefixesFilterType;
	
	private FilterType postfixesFilterType;
	
	/**
	 * The default REGEX used for matching is (.*?).
	 * 
	 */
	private String regex = "(.*?)";
	
	@Override
	public List<IElement<String>> process(IElement<T> e) {

		List<IElement<String>> result = new ArrayList<IElement<String>>();
		
		Pattern p = Pattern.compile(getPattern());
		
		Matcher m = p.matcher(e.getElement().toString());
		
		while(m.find()){ // For each string obtained
			
			// Create the element and add to the result.
			BaseElement<String> eObtained = new BaseElement<String>();
			
			eObtained.setElement(m.group().toString());
			
			result.add(eObtained);
		}
		
		return result;
	}

	/**
	 * Obtains the pattern for the regex filter, prefixes and postfixes
	 * @return The string representing the pattern.
	 */
	private String getPattern(){
		
		
		String result = getPattern(prefixes,prefixesFilterType) + regex +  
		 	 	getPattern(postfixes,postfixesFilterType);
		
		logger.debug("Pattern obtained : [{}]",result);
		return result;
	}
	
	/**
	 * Obtains the pattern for the regex
	 * @param list List of partial patterns
	 * @param type Type of concatenator for the patterns.
	 * @return The string representing the pattern
	 */
	private String getPattern(List<String> list,FilterType type){
		
		StringBuffer sb = new StringBuffer();
		if(list!=null && list.size()>0 && type!=null){
			
			sb.append("(");
			
			int c = 1;
			for(String f:list){
				sb.append(f);
				if(c<list.size()){
					switch(type){
					case AND:
						sb.append("&");
						break;
					case OR:
						sb.append("|");
						break;
					}
					c++;
				}
			}
			
			sb.append(")");
		}else{
			// TODO log warning
			logger.warn("Empty pattern obtained");
		}
		
		return sb.toString();
	}
	
	public void addPrefix(String prefix){
		if(prefixes==null){
			prefixes = new ArrayList<String>();
		}
		prefixes.add(prefix);
	}
	
	public void addPostfix(String postfix){
		if(postfixes==null){
			postfixes = new ArrayList<String>();
		}
		postfixes.add(postfix);
	}
	
	public void removePrefixes(){
		this.prefixes = new ArrayList<String>();
	}
	
	public void removePostfixes(){
		this.postfixes = new ArrayList<String>();
	}
	
	public void setPrefixes(List<String> prefixes){
		this.prefixes = prefixes;
	}
	
	public List<String> getPrefixes(){
		return this.prefixes;
	}
	
	public void setPostfixes(List<String> postfixes){
		this.postfixes = postfixes;
	}
	
	public List<String> getPostfixes(){
		return this.postfixes;
	}

	/**
	 * @return the prefixesFilterType
	 */
	public FilterType getPrefixesFilterType() {
		return prefixesFilterType;
	}

	/**
	 * @param prefixesFilterType the prefixesFilterType to set
	 */
	public void setPrefixesFilterType(FilterType prefixesFilterType) {
		this.prefixesFilterType = prefixesFilterType;
	}

	/**
	 * @return the postfixesFilterType
	 */
	public FilterType getPostfixesFilterType() {
		return postfixesFilterType;
	}

	/**
	 * @param postfixesFilterType the postfixesFilterType to set
	 */
	public void setPostfixesFilterType(FilterType postfixesFilterType) {
		this.postfixesFilterType = postfixesFilterType;
	}
}
