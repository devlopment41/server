package com.utils;


import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringTemplate implements Cloneable{


	private Map<String, String>	values	= Collections.synchronizedMap(new HashMap<String, String>());
	private String		_template;
	private String		_pre;
	private String		_suff;

	public StringTemplate(String template) {
		this(template, "{", "}");
	}

	public StringTemplate(String template, String pre, String suff) {
		_pre = pre;
		_suff = suff;
		_template = template;
	}

	public StringTemplate add(String name, Object value , Object def) {
		return add(name,value != null ? value : def);
	}
	
	public StringTemplate add(String name, Object value) {
	    try{
            values.put(name, value.toString() );
        }catch (Exception e){
            throw new RuntimeException("fail add to template of value " + name  ,e);
        }
		return this;
	}

	public void addAll(Map<String, String> values) {
		values.putAll(values);
	}

	public Map<String, String> getValues() {
		return values;
	}

	@Override
	public String toString() {
		StrSubstitutor sub = new StrSubstitutor(values, _pre, _suff);
		return sub.replace(_template);
	}

    public File toFile(){
        return new File(toString());
    }

    public File toFile(File parent){
        return new File(parent,toString());
    }

    public StringTemplate addUrlParam(String key , String value , String defaults){
        return  addUrlParam(key,(value == null ? defaults : value));
    }

	public StringTemplate addUrlParam(String key , Object value){
        if(value != null){
            _template +=  (!_template.contains("?") ? "?" + key : "&" + key) + "=" + ( _pre + key + _suff );
            values.put(key, String.valueOf(value));
        }else {
            //logger.debug("value of {} is null , and will ignore it" , key);
        }
		return this;
	}	
	public void addEmptyUrlParam(String key){
		_template +=  (!_template.contains("?") ? "?" + key : "&" + key);		
	}
	
	public StringTemplate addPathValiable(String key , Object value){
        if ( !values.containsKey(key) ) {
            String pathVar = "/" + ( _pre + key + _suff );
            if(!_template.contains("?")){
                _template +=  pathVar;
            }else{
                _template = _template.replace("?", pathVar + "?");
            }
        }
		values.put(key, value.toString() );
		return this;
	}
	
	
	public StringTemplate addParam(String key , String value){
		_template +=  _pre + key + _suff;
		 values.put(key, value);
		 return this;
	}

    public StringTemplate addEmptyArgs(String key , String value){
        addParam(key," " +value);
        return this;
    }

    public StringTemplate addArgs(String key , String value){
        addParam(key," " + key.trim() + "=" + value.trim());
        return this;
    }



	public String  toUrl()  {
		Map<String, String> params = new HashMap<String, String>(values);
		for (String param : params.keySet()) {
			try {
				params.put(param, URLEncoder.encode(params.get(param),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		StrSubstitutor sub = new StrSubstitutor(params, _pre, _suff);
		return sub.replace(_template);
	}

    public String []  toCommand()  {
        return toString().split("\\s");
    }

}
