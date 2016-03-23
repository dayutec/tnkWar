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
                //String [] substrs = str.split("��|\\��|\\��|\\?|\\.|!");  
                /*������ʽ�����ӽ�����*/  
                String regEx="[.����?.!]";  
                Pattern p =Pattern.compile(regEx);  
                Matcher m = p.matcher(str);  
  
                /*���վ��ӽ������ָ����*/  
                String[] substrs = p.split(str);  
  
                /*�����ӽ��������ӵ���Ӧ�ľ��Ӻ�*/  
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
//                //String [] substrs = str.split("[������?.!]");  
                for (int i=0;i<substrs.length;i++) {  
  
                    if (substrs[i].length()<MIN_THRESHOLD) { //���С��Ҫ��ķָ�����  
                        sb.append(substrs[i]);  
                        //sb.append("||");  
                        if (sb.length()>MIN_THRESHOLD) {  
                            //System.out.println("A New TU: " + sb.toString());  
                            list.add(sb.toString());  
                            sb.delete(0, sb.length());  
                        }  
                    }  
                    else {  //�������Ҫ��ķָ�����  
                            if(sb.length()!=0)  //��ʱ���������������Ӧ���Ƚ���������ٴ�substrs[i]������  �Ա�֤ԭ��˳��  
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
  
            //���ָ�õ�tu����List���Ա㴫�����ݿ�  
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
        
/*    //    String kissi="���죬���� �ȽϺ�"; 
        String kissi="SplitDocument,java ���һ���ĵ�Ϊ";
      //���ַ������һ��char[]���� 
      //����tochararray(),�������ĵ� 
      char[] kiss=kissi.toCharArray(); 
      for(int i=0;i<kiss.length;i++){ 
      System.out.println(kiss[i]);
       }*/
      new wordsCompare().splitSentances();
      
      
     
	}
}
