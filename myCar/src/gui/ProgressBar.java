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

 
    private int mouseX;//鼠标X坐标
	private int mouseY;//鼠标Y坐标
	
	private int currentX;//进度条当前X坐标
	private int currentY;//进度条当前Y坐标
	
	static int width =300;
	static int height =20;

    public ProgressBar() {
    	
    	
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();//屏幕尺寸

		
		currentX = (int) (dimension.getWidth() - width - 3);
		
		currentY = (int) (dimension.getHeight() - height - 3);
		

       frame = new JFrame("进度条简单示例");

       frame.setBounds(100, 100, 400, 130);

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.setResizable(false);

       Container contentPanel = frame.getContentPane();

       label = new JLabel("点击运行按钮开始", JLabel.CENTER);

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

       b = new JButton("运行");

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

           label.setText("目前已完成进度：" + Integer.toString(value) + "%");

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
        JFrame frame = new JFrame("测试进度条");  
        //创建一条垂直进度条  
        JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL );  
        JCheckBox indeterminate = new JCheckBox("不确定进度");  
        JCheckBox noBorder = new JCheckBox("不绘制边框");  
        public void init()  
        {  
            Box box = new Box(BoxLayout.Y_AXIS);  
            box.add(indeterminate);  
            box.add(noBorder);  
            frame.setLayout(new FlowLayout());  
            frame.add(box);  
            //把进度条添加到JFrame窗口中  
            frame.add(bar);  
     
            //设置在进度条中绘制完成百分比  
            bar.setStringPainted(true);  
            noBorder.addActionListener(new ActionListener()  
            {    
                public void actionPerformed(ActionEvent event)  
                {  
                    //根据该选择框决定是否绘制进度条的边框  
                    bar.setBorderPainted(!noBorder.isSelected());  
                }  
            });  
            final SimulatedTarget target = new SimulatedTarget(1000);  
            //以启动一条线程的方式来执行一个耗时的任务  
            new Thread(target).start();  
            //设置进度条的最大值和最小值,  
            bar.setMinimum(0);   
            //以总任务量作为进度条的最大值  
            bar.setMaximum(target.getAmount());  
            Timer timer = new Timer(300 , new ActionListener()  
            {  
                public void actionPerformed(ActionEvent e)  
                {  
                    //以任务的当前完成量设置进度条的value  
                    bar.setValue(target.getCurrent());  
                }  
            });  
            timer.start();  
            indeterminate.addActionListener(new ActionListener()  
            {    
                public void actionPerformed(ActionEvent event)  
                {  
                    //设置该进度条的进度是否确定  
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
    //模拟一个耗时的任务  
    class SimulatedTarget implements Runnable  
    {   
        //任务的当前完成量  
        private volatile int current;  
        //总任务量  
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
        //run方法代表不断完成任务的过程  
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
            //以启动一条线程的方式来执行一个耗时的任务  
            final Thread targetThread = new Thread(target);  
            targetThread.start();  
            //创建进度对话框  
            final ProgressMonitor dialog = new ProgressMonitor(null ,  
                "等待任务完成" , "已完成：" , 0 , target.getAmount());  
            //创建一个计时器  
            timer = new Timer(300 , new ActionListener()  
            {  
                public void actionPerformed(ActionEvent e)  
                {  
                    //以任务的当前完成量设置进度对话框的完成比例  
                    dialog.setProgress(target.getCurrent());  
                    //如果用户单击了进度对话框的”取消“按钮  
                    if (dialog.isCanceled())  
                    {  
                        //停止计时器  
                        timer.stop();  
                        //中断任务的执行线程  
                        targetThread.interrupt();  
                        //系统退出  
                        System.exit(0);  
                    }  
                }  
            });  
            timer.start();  
        }  }
    
}