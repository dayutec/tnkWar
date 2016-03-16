package lrc;



import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

public class regExpTest {

	public void test(){
			try{ 
		        String content="['kevin] [ ���� ]���������ģ�{(Kevin loves comic./ ���İ����� " +
					 "/ ���� : ���� ) (Kevin is living in ZhuHai now./ ������ס���麣 / ���� : " +
					 "���� )}"; 
		        String ps1="\\{.+\\}"; 
		        String ps2="\\([^)]+\\)"; 
		        String ps3="([^(]+)/(.+)/(.+):([^)]+)"; 
		        String sentence; 
		        PatternCompiler orocom=new Perl5Compiler(); 
		        Pattern pattern1=orocom.compile(ps1); 
		        Pattern pattern2=orocom.compile(ps2); 
		        Pattern pattern3=orocom.compile(ps3); 
		        PatternMatcher matcher=new Perl5Matcher(); 
		        // ���ҳ��������䲿��
		           if (matcher.contains(content,pattern1)) { 
		           MatchResult result=matcher.getMatch(); 
		           String example=result.toString(); 
		           PatternMatcherInput input=new PatternMatcherInput(example); 
		       // �ֱ��ҳ�����һ�������
		           while (matcher.contains(input,pattern2)){ 
		               result=matcher.getMatch(); 
		               sentence=result.toString(); 
		       // ��ÿ��������ĸ����÷���İ취�ָ�����
		               if (matcher.contains(sentence,pattern3)){ 
		                 result=matcher.getMatch(); 
		                 System.out.println("Ӣ�ľ� : "+result.group(1)); 
		                 System.out.println("�������ķ��� : "+result.group(2));
		                 System.out.println("���� : "+result.group(3)); 
		                 System.out.println("��˼ : "+result.group(4)); 
		               } 
		           } 
		       } 
		      } 
		 catch(Exception e) { 
		            System.out.println(e); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regExpTest re = new regExpTest();
		re.test();
	}

}
