package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

 

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

 











import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

 

public class ProgressBar implements ActionListener, ChangeListener {

    JFrame frame = null;

    JProgressBar progressbar;

    JLabel label;

    Timer timer;

    JButton b;

 
    private int mouseX;//���X����
	private int mouseY;//���Y����
	
	private int currentX;//��������ǰX����
	private int currentY;//��������ǰY����
	
	static int width =300;
	static int height =20;

    public ProgressBar() {
    	
    	
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();//��Ļ�ߴ�

		
		currentX = (int) (dimension.getWidth() - width - 3);
		
		currentY = (int) (dimension.getHeight() - height - 3);
		

       frame = new JFrame("��������ʾ��");

       frame.setBounds(100, 100, 400, 130);

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.setResizable(false);

       Container contentPanel = frame.getContentPane();

       label = new JLabel("������а�ť��ʼ", JLabel.CENTER);

       progressbar = new JProgressBar();

       progressbar.setOrientation(JProgressBar.HORIZONTAL);

       progressbar.setMinimum(0);

       progressbar.setMaximum(100);

       progressbar.setValue(0);

       progressbar.setStringPainted(true);

       progressbar.addChangeListener(this);

       progressbar.setPreferredSize(new Dimension(width, height));

       progressbar.setBorderPainted(true);

       progressbar.setBackground(Color.pink);


       
       
       progressbar.addMouseListener(new MouseAdapter(){
    	   
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			
    			
    			System.out.println( progressbar.getWidth() );
    			System.out.println( progressbar.getMinimum() );
    			Point p=	progressbar.getMousePosition();
    				System.out.println("mouseMoved" + p);
    				double t =  progressbar.getMousePosition().getX() /progressbar.getWidth();
    				System.out.println("mouseMoved" + t);
    				progressbar.setValue((int) (t*100) );
    		}
    	   
       });

       JPanel panel = new JPanel();

       b = new JButton("����");

       b.setForeground(Color.blue);

       b.addActionListener(this);

       panel.add(b);

       timer = new Timer(100, this);

       contentPanel.add(panel, BorderLayout.NORTH);

       contentPanel.add(label, BorderLayout.CENTER);

       contentPanel.add(progressbar, BorderLayout.SOUTH);

       // frame.pack();

       frame.setVisible(true);

    }

 

    public void actionPerformed(ActionEvent e) {

       if (e.getSource() == b) {

           timer.start();

       }

       if (e.getSource() == timer) {

           int value = progressbar.getValue();

           if (value < 100)

              progressbar.setValue(++value);

           else {

              timer.stop();

              frame.dispose();

           }

       }

 

    }

 

    public void stateChanged(ChangeEvent e1) {

       int value = progressbar.getValue();

       if (e1.getSource() == progressbar) {

           label.setText("Ŀǰ����ɽ��ȣ�" + Integer.toString(value) + "%");

           label.setForeground(Color.blue);

       }

 

    }

 
    private class mouseM extends MouseAdapter{
    	
		@Override
		public void mouseDragged(MouseEvent e) {
			
		double p= progressbar.getPercentComplete();
			System.out.println("mouseMoved" + p);
		}
    }

    public static void main(String[] args) {

       try {

           UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

       } catch (Exception e) {

           Logger.getLogger(ProgressBar.class.getName()).log(Level.FINE,

                  e.getMessage());

           e.printStackTrace();

       }

       new ProgressBar();
     //  TestProgressMonitor tc= new ProgressBar().new TestProgressMonitor();
       //  tc.init(); 
    }
    
    public class TestJProgressBar  
    {  
        JFrame frame = new JFrame("���Խ�����");  
        //����һ����ֱ������  
        JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL );  
        JCheckBox indeterminate = new JCheckBox("��ȷ������");  
        JCheckBox noBorder = new JCheckBox("�����Ʊ߿�");  
        public void init()  
        {  
            Box box = new Box(BoxLayout.Y_AXIS);  
            box.add(indeterminate);  
            box.add(noBorder);  
            frame.setLayout(new FlowLayout());  
            frame.add(box);  
            //�ѽ�������ӵ�JFrame������  
            frame.add(bar);  
     
            //�����ڽ������л�����ɰٷֱ�  
            bar.setStringPainted(true);  
            noBorder.addActionListener(new ActionListener()  
            {    
                public void actionPerformed(ActionEvent event)  
                {  
                    //���ݸ�ѡ�������Ƿ���ƽ������ı߿�  
                    bar.setBorderPainted(!noBorder.isSelected());  
                }  
            });  
            final SimulatedTarget target = new SimulatedTarget(1000);  
            //������һ���̵߳ķ�ʽ��ִ��һ����ʱ������  
            new Thread(target).start();  
            //���ý����������ֵ����Сֵ,  
            bar.setMinimum(0);   
            //������������Ϊ�����������ֵ  
            bar.setMaximum(target.getAmount());  
            Timer timer = new Timer(300 , new ActionListener()  
            {  
                public void actionPerformed(ActionEvent e)  
                {  
                    //������ĵ�ǰ��������ý�������value  
                    bar.setValue(target.getCurrent());  
                }  
            });  
            timer.start();  
            indeterminate.addActionListener(new ActionListener()  
            {    
                public void actionPerformed(ActionEvent event)  
                {  
                    //���øý������Ľ����Ƿ�ȷ��  
                    bar.setIndeterminate(indeterminate.isSelected());  
                    bar.setStringPainted(!indeterminate.isSelected());  
                }  
            });  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            frame.pack();  
            frame.setVisible(true);  
        }  
   //     public static void main(String[] args)   
    //    {  
    //        new TestJProgressBar().init();  
    //    }  
    }  
    //ģ��һ����ʱ������  
    class SimulatedTarget implements Runnable  
    {   
        //����ĵ�ǰ�����  
        private volatile int current;  
        //��������  
        private int amount;  
        public SimulatedTarget(int amount)  
        {    
            current = 0;  
            this.amount = amount;  
        }  
     
        public int getAmount()  
        {    
          return amount;  
        }  
     
        public int getCurrent()  
        {    
            return current;  
        }  
        //run�����������������Ĺ���  
        public void run()  
        {    
     
            while (current < amount)  
            {   
                try 
                {  
                    Thread.sleep(50);  
                }  
                catch(InterruptedException e)  
                {  
     
                }  
                current++;  
            }  
        }  
    } 
    
    
    public class TestProgressMonitor  
    {  
        Timer timer;  
        public void init()  
        {  
            final SimulatedTarget target = new SimulatedTarget(1000);  
            //������һ���̵߳ķ�ʽ��ִ��һ����ʱ������  
            final Thread targetThread = new Thread(target);  
            targetThread.start();  
            //�������ȶԻ���  
            final ProgressMonitor dialog = new ProgressMonitor(null ,  
                "�ȴ��������" , "����ɣ�" , 0 , target.getAmount());  
            //����һ����ʱ��  
            timer = new Timer(300 , new ActionListener()  
            {  
                public void actionPerformed(ActionEvent e)  
                {  
                    //������ĵ�ǰ��������ý��ȶԻ������ɱ���  
                    dialog.setProgress(target.getCurrent());  
                    //����û������˽��ȶԻ���ġ�ȡ������ť  
                    if (dialog.isCanceled())  
                    {  
                        //ֹͣ��ʱ��  
                        timer.stop();  
                        //�ж������ִ���߳�  
                        targetThread.interrupt();  
                        //ϵͳ�˳�  
                        System.exit(0);  
                    }  
                }  
            });  
            timer.start();  
        }  }
    
}