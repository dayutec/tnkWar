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
		        String content="['kevin] [ 名词 ]（人名凯文）{(Kevin loves comic./ 凯文爱漫画 " +
					 "/ 名词 : 凯文 ) (Kevin is living in ZhuHai now./ 凯文现住在珠海 / 名词 : " +
					 "凯文 )}"; 
		        String ps1="\\{.+\\}"; 
		        String ps2="\\([^)]+\\)"; 
		        String ps3="([^(]+)/(.+)/(.+):([^)]+)"; 
		        String sentence; 
		        PatternCompiler orocom=new Perl5Compiler(); 
		        Pattern pattern1=orocom.compile(ps1); 
		        Pattern pattern2=orocom.compile(ps2); 
		        Pattern pattern3=orocom.compile(ps3); 
		        PatternMatcher matcher=new Perl5Matcher(); 
		        // 先找出整个例句部分
		           if (matcher.contains(content,pattern1)) { 
		           MatchResult result=matcher.getMatch(); 
		           String example=result.toString(); 
		           PatternMatcherInput input=new PatternMatcherInput(example); 
		       // 分别找出例句一和例句二
		           while (matcher.contains(input,pattern2)){ 
		               result=matcher.getMatch(); 
		               sentence=result.toString(); 
		       // 把每个例句里的各项用分组的办法分隔出来
		               if (matcher.contains(sentence,pattern3)){ 
		                 result=matcher.getMatch(); 
		                 System.out.println("英文句 : "+result.group(1)); 
		                 System.out.println("句子中文翻译 : "+result.group(2));
		                 System.out.println("词性 : "+result.group(3)); 
		                 System.out.println("意思 : "+result.group(4)); 
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
