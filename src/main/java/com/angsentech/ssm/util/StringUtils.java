package com.angsentech.ssm.util;

import java.util.StringTokenizer;

/**
 * @ClassName: StringUtils 
 * @Description: TODO(字符串处理通用类) 
 * @author 孙钊宁
 * @date 2016年7月26日
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	/**
	 * 判断一个字符串是否为空
	 * 不包括："", "null"
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(null!=str && str.length()>0 && !"null".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断一个字符串的编码格式
	 * @param str
	 * @return
	 * @throws Exception 
	 */
	public static String getEncoding(String str){
		if(StringUtils.isEmpty(str)) return str;
		String[] encodeArr = new String[]{"ISO-8859-1", "GB2312", "GBK", "UTF-8", "UTF-16"};
		try {
			for (String encode : encodeArr) {
				if(str.equals(new String(str.getBytes(encode), encode))){
					return encode;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	 /**
     * 此方法将给出的字符串source使用delim划分为单词数组。
     * @param source 需要进行划分的原字符串
     * @param delim 单词的分隔字符串
     * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组，
     *         如果delim为null则使用逗号作为分隔字符串。
     * @since  0.1
     */
    public static String[] split(String source, String delim) {
      String[] wordLists;
      if (source == null) {
        wordLists = new String[1];
        wordLists[0] = source;
        return wordLists;
      }
      if (delim == null) {
        delim = ",";
      }
      StringTokenizer st = new StringTokenizer(source, delim);
      int total = st.countTokens();
      wordLists = new String[total];
      for (int i = 0; i < total; i++) {
        wordLists[i] = st.nextToken();
      }
      return wordLists;
    } 
    
    
    public static String SubString(String source,int limit){
    	String result = source;
    	if(result==null ||"".equals(result)) result = "";
    	else  if(source.length()>limit ) result = result.substring(0, limit);
    	return result;
    }
    /*从notify_data切出trade_no*/    
      public static String subData(String source,String begin,String end){
  		int a=source.indexOf(begin);
  		int b=source.indexOf(end);
  		String str=source.substring(a+10, b);
  		return str;
  	}
      /*从notify_data切出trade_status、out_trade_no*/   
  	public static String subData2(String source,String begin,String end){
  		int a=source.indexOf(begin);
  		int b=source.indexOf(end);
  		String str2=source.substring(a+14, b);
  		return str2;
  	}
  	
  	 /**
     * 
     * </p>替换从beginIndex到endIndex(包含beginIndex但不包含endIndex)的内容</p>
     * @param str           需替换的字符串
     * @param beginIndex    起始索引 从0开始
     * @param endIndex      结束索引 
     * @param replacement   替换内容
     * @return
     * @author yujl
     * @date 2015年1月7日
     */
    public static String mix(String str, Integer beginIndex, Integer endIndex, String replacement){
        if (StringUtils.isBlank(str)) {
            return null;
        }
        
        if (beginIndex == null && endIndex == null) {
            return str;
        }
        
        beginIndex = (beginIndex == null || beginIndex < 0) ? 0 : beginIndex;
        endIndex = (endIndex == null || endIndex < 0) ? null : (endIndex > str.length() ? str.length() : endIndex);
        
        if (beginIndex >= str.length() || (endIndex != null && beginIndex > endIndex)) {
            return str;
        }
        
        StringBuffer buffer = new StringBuffer();
        
        if (endIndex == null) {
            buffer.append(str.substring(0, beginIndex)).append(replacement);
        } else {
            buffer.append(str.substring(0, beginIndex)).append(replacement).append(str.substring(endIndex));
        }
        
        return buffer.toString();
    }

}
