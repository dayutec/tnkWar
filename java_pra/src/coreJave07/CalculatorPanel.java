package coreJave07;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalculatorPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private String lastCalCommand;
	private String lastInsert;
	private boolean start;
	private boolean startCal=false;
	
	public CalculatorPanel()
	{
		setLayout(new BorderLayout());
		result =0;
		lastCommand = "=";
		lastCalCommand = "=";
		start= true;
		
		display = new JButton("0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);
		
		ActionListener insert = new InsertListener();
		ActionListener command = new CommandListener();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));

		addButten("7",insert);
		addButten("8",insert);
		addButten("9",insert);
		addButten("/",command);
		
		addButten("4",insert);
		addButten("5",insert);
		addButten("6",insert);
		addButten("*",command);
		
		addButten("1",insert);
		addButten("2",insert);
		addButten("3",insert);
		addButten("-",command);
		
		addButten("0",insert);
		addButten(".",insert);
		addButten("=",command);
		addButten("+",command);
		
		add(panel,BorderLayout.CENTER);
	}
	
	private void addButten(String label,ActionListener listener){
		JButton  button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	private class InsertListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			String input = event.getActionCommand();
			if(start){
				display.setText("");
				start =false;
			}
			display.setText(display.getText()+input);
			lastInsert = display.getText();
		}
	}
	
	
	private class CommandListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			String command = event.getActionCommand();

		 
			
			/*if(start){
				if(command.equals("=")){
					
					calculate(Double.parseDouble(lastInsert),lastCommand);
					lastCalCommand = lastCommand;
				}  
				else{
					lastCalCommand = lastCommand;
					start = false;
				}
			 
				if(startCal){
					command =lastCalCommand;
					calculate(Double.parseDouble(lastInsert));
				}
				
			  }
			else{
				lastInsert = display.getText();
				lastCommand = command;
				
				if(!command.equals("="))lastCalCommand=command;
					
				calculate(Double.parseDouble(lastInsert));
				start=true;
				startCal=true;
			}
			*/
				if(lastCommand.equals("=") && startCal){
					lastCommand = lastCalCommand;
					calculate(Double.parseDouble(lastInsert));
				}else
				{
			
					if(lastInsert != null ){						
						calculate(Double.parseDouble(lastInsert));
					}
				}					
				lastCommand = command;
				if(!command.equals("="))lastCalCommand = command;
					
				startCal=true;
				
				start=true;
			
		}
			
	}


	public void calculate(double parseDouble) {
		// TODO Auto-generated method stub
		//if(lastCommand.equals("+")) result += parseDouble;
		
		switch(lastCommand) {
		
			case "+": result += parseDouble; break;
			case "-": result -= parseDouble; break;
			case "*": result *= parseDouble; break;
			case "/": result /= parseDouble; break;
			case "=": result = parseDouble; break;
			default: break;
		}
		display.setText(""+result);
		
	}

}
