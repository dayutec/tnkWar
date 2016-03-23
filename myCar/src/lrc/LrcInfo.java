package lrc;

import java.util.HashMap;
import java.util.Map;

public class LrcInfo {
   
	private String title;//歌曲名
	private String singer;//演唱者
	private String album;//专辑	
	private HashMap<Long,String> infos;//保存歌词信息和时间点一一对应的Map
   //以下为getter()  setter()

	
	public HashMap<Long, String> getInfos() {
		return infos;
	}
	public void setInfos(Map<Long, String> maps) {
		this.infos = (HashMap<Long, String>) maps;
	}
	public void setTitle(String title) {
		this.title = title;
		
	}
	public void setSinger(String singer) {
		// TODO Auto-generated method stub
		this.singer = singer;
	}
	public void setAlbum(String album) {
		// TODO Auto-generated method stub
		this.album = album;
	}
	
}