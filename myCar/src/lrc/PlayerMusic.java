package lrc;

import javax.media.ControllerEvent;  
import javax.media.ControllerListener;  
import javax.media.NoPlayerException;  
import javax.media.Player;  
import javax.media.Manager;  
import javax.media.MediaLocator;  
import javax.media.EndOfMediaEvent;  
import javax.media.PrefetchCompleteEvent;  
import javax.media.RealizeCompleteEvent;  
import java.io.*;  
import java.util.*;  
public class PlayerMusic implements ControllerListener {  
//���Ŷ���  
private Player player;  
//�Ƿ�ѭ������  
private boolean first,loop;  
//�ļ�·��  
private String path;  
//���MP3�ļ�  
private List<String> mp3List;  
//��ǰMP3�ļ�����  
private int mp3NO=0;  
  
PlayerMusic(List<String> mp3List)  
{  
this.mp3List=mp3List;  
}  
  
//���ŷ���  
public void start()  
{  
try {  
player = Manager.createPlayer(new File(mp3List.get(mp3NO)).toURI().toURL());  
} catch (NoPlayerException e) {  
// TODO �Զ����� catch ��  
e.printStackTrace();  
System.out.println("���ܲ��Ŵ��ļ���");  
return;  
} catch (IOException e) {  
// TODO �Զ����� catch ��  
e.printStackTrace();  
return;  
}  
if(player==null)  
{  
System.out.println("�����ļ�Ϊ�գ�");  
return;  
}  
player.addControllerListener(this);  
//��ȡý������  
player.prefetch();  
}  
  
  
  
public void controllerUpdate(ControllerEvent e) {  
//��ý�岥�Ž���ʱ��ѭ������  
if(e instanceof EndOfMediaEvent)  
{  
mp3NO++;  
System.out.println(mp3NO);  
if(mp3NO<mp3List.size())  
{  
  
this.start();  
}  
return;  
}  
  
//����ȡý������ݽ���  
if (e instanceof PrefetchCompleteEvent) {  
System.out.println("���ݽ���");  
player.start();  
return;  
}  
  
//��ʵ������  
if (e instanceof RealizeCompleteEvent) {  
System.out.println("ʵ����");  
//pack(); //ִ��pack()����  
return;  
}  
  
}  
public static void main(String[] args)  
{  
List<String> path=new ArrayList<String>();  
path.add("C:\\Users\\eyuuyee\\Music\\0541.mp3");  
PlayerMusic play=new PlayerMusic(path);  
play.start();  
}  
} 