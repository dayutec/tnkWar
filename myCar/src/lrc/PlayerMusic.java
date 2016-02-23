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
//播放对象  
private Player player;  
//是否循环播放  
private boolean first,loop;  
//文件路径  
private String path;  
//存放MP3文件  
private List<String> mp3List;  
//当前MP3文件数量  
private int mp3NO=0;  
  
PlayerMusic(List<String> mp3List)  
{  
this.mp3List=mp3List;  
}  
  
//播放方法  
public void start()  
{  
try {  
player = Manager.createPlayer(new File(mp3List.get(mp3NO)).toURI().toURL());  
} catch (NoPlayerException e) {  
// TODO 自动生成 catch 块  
e.printStackTrace();  
System.out.println("不能播放此文件！");  
return;  
} catch (IOException e) {  
// TODO 自动生成 catch 块  
e.printStackTrace();  
return;  
}  
if(player==null)  
{  
System.out.println("播放文件为空！");  
return;  
}  
player.addControllerListener(this);  
//提取媒体内容  
player.prefetch();  
}  
  
  
  
public void controllerUpdate(ControllerEvent e) {  
//当媒体播放结束时，循环播放  
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
  
//当提取媒体的内容结束  
if (e instanceof PrefetchCompleteEvent) {  
System.out.println("内容结束");  
player.start();  
return;  
}  
  
//当实例化后  
if (e instanceof RealizeCompleteEvent) {  
System.out.println("实例化");  
//pack(); //执行pack()操作  
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