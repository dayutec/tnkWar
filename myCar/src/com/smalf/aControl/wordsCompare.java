package com.smalf.aControl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lrc.LrcInfo;
import lrc.LrcParser;

public class wordsCompare {

	
	
	String sourceString = null;
	private static final int MIN_THRESHOLD = 50;  
    private static final int MAX_THRESHOLD = 80;  
	private static List<String>  list = new ArrayList<String>();  
	
	private static LrcInfo lrcinfo = new LrcInfo();
	
	public void splitSentances(){
		
        String str = null;  
        try {  
  
            InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("C:\\Users\\eyuuyee\\Music\\12.txt")),Charset.defaultCharset());  
            BufferedReader br = new BufferedReader(isr);  
  
            StringBuffer sb = new StringBuffer(MAX_THRESHOLD);  
  
            while ((str=br.readLine())!=null) {  
                //String [] substrs = str.split("。|\\？|\\！|\\?|\\.|!");  
                /*正则表达式：句子结束符*/  
                String regEx="[.？！?.!]";  
                Pattern p =Pattern.compile(regEx);  
                Matcher m = p.matcher(str);  
  
                /*按照句子结束符分割句子*/  
                String[] substrs = p.split(str);  
  
                /*将句子结束符连接到相应的句子后*/  
                if(substrs.length > 0)  
                {  
                    int count = 0;  
                    while(count < substrs.length)  
                    {  
                        if(m.find())  
                        {  
                            substrs[count] += m.group();  
                        }  
                        count++;  
                    }  
                }  
//                //String [] substrs = str.split("[。？！?.!]");  
                for (int i=0;i<substrs.length;i++) {  
  
                    if (substrs[i].length()<MIN_THRESHOLD) { //语句小于要求的分割粒度  
                        sb.append(substrs[i]);  
                        //sb.append("||");  
                        if (sb.length()>MIN_THRESHOLD) {  
                            //System.out.println("A New TU: " + sb.toString());  
                            list.add(sb.toString());  
                            sb.delete(0, sb.length());  
                        }  
                    }  
                    else {  //语句满足要求的分割粒度  
                            if(sb.length()!=0)  //此时如果缓存有内容则应该先将缓存存入再存substrs[i]的内容  以保证原文顺序  
                            {  
                                list.add(sb.toString());  
                                //System.out.println("A New Tu:"+sb.toString());  
                                sb.delete(0, sb.length());  
                            }  
                                list.add(substrs[i]);  
                                //System.out.println("A New Tu:"+substrs[i]);  
                    }  
                }  
            }  
            br.close();  
            isr.close();  
  
            //将分割好的tu放入List中以便传入数据库  
            for (Iterator i = list.iterator(); i.hasNext();){  
                   System.out.println(i.next());  
                 }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
	}
	
	
	
	public static void main(String[] args) {
		LrcParser lp = new LrcParser();
         try {
        	 lrcinfo = lp.parser("C:\\Users\\eyuuyee\\Music\\233212.lrc");
		} catch (Exception e) {
       System.out.println("parser erro");
			e.printStackTrace();
		}
	
        System.out.println("==============================================" + lrcinfo); 
        
        HashMap<Long,String> infos = lrcinfo.getInfos();
      //  infos.put((long) 22660, "sdf");
        System.out.println("==============================================" + infos.get((long)22660) );
       
        String[] subWords = new String[20];
        String s = infos.get((long)22660);
        System.out.println( s + s.length());
        
/*    //    String kissi="今天，天气 比较好"; 
        String kissi="SplitDocument,java 拆分一个文档为";
      //将字符串拆成一个char[]数组 
      //至于tochararray(),请查帮助文档 
      char[] kiss=kissi.toCharArray(); 
      for(int i=0;i<kiss.length;i++){ 
      System.out.println(kiss[i]);
       }*/
      new wordsCompare().splitSentances();
      
      
     
	}
}
