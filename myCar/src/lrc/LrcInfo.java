package lrc;

import java.util.HashMap;
import java.util.Map;

public class LrcInfo {
   
	private String title;//������
	private String singer;//�ݳ���
	private String album;//ר��	
	private HashMap<Long,String> infos;//��������Ϣ��ʱ���һһ��Ӧ��Map
   //����Ϊgetter()  setter()

	
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