import java.awt.*;
import java.awt.event.*;
import java.io.*;




class MyNotepad extends Frame implements ActionListener,AdjustmentListener,ItemListener,TextListener
{
	TextArea t1;
	TextField t2,t3,t4;
	MenuBar m1;
	Menu file,edit,format,changecase,style,colour;
	MenuItem exit,save,open,New,size,font,find,replaceall,copy,clear,selectall,paste,touppercase,tolowercase,foreground,background;
	Checkbox bold,italic,underline;
	Dialog d1,d2,d3,d4,d5;
	Choice fs;
	Label l1,l2,l3,l4;
	Scrollbar s1,R,G,B;
	Label l5,l6,l7,l8,l9,l10,l11; //label for displaying colour combination
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	Boolean flag;
	
	
	MyNotepad()
	{
		initcomponents();
	}

		class InnerWindow extends WindowAdapter
		{
			public void windowClosing(WindowEvent we)
			{
				
			dispose();
			
			}
		}
		
		
	void initcomponents()
	{
		
		t1=new TextArea();
		t1.setSize(800,500);
		setTitle("untitled");
		
		setSize(900,600);
		setLocation(25,25);
		m1= new MenuBar();
		file= new Menu("File");
			file.add(New=new MenuItem("NEW"));
			file.add(open=new MenuItem("OPEN"));
			file.add(save=new MenuItem("SAVE"));
			file.add(exit=new MenuItem("EXIT"));
			//new dialogue box
				d4=new Dialog(this);
				d4.setSize(325,180);
				d4.setLayout(null);
				d4.setLocation(300,300);
				l9=new Label("The text in the "+getTitle()+" has changed");
				l9.setSize(200,15);
				l9.setLocation(50,50);
				
				l10=new Label("Do you want to save the changes?");
				l10.setSize(200,15);
				l10.setLocation(50,80);
				b5=new Button("YES");
				b6=new Button("NO");
				b7=new Button("CANCEL");
				d4.add(l9);
				d4.add(l10);
				d4.add(b5);
				d4.add(b6);
				d4.add(b7);

				b5.setSize(75,30);
				b5.setLocation(25,120);
				
				b6.setSize(75,30);
				b6.setLocation(125,120);
				
				b7.setSize(75,30);
				b7.setLocation(225,120);
			
			//open dialogue boxes..
				d3=new Dialog(this,"OPEN");
				d3.setSize(500,200);
				d3.setLayout(null);
				d3.setLocation(400,400);
				b3=new Button("Open");
				b4=new Button("Cancel");
				l8=new Label("File Name :");
				t3=new TextField();
				d3.add(b3);
				d3.add(b4);
				d3.add(l8);
				d3.add(t3);
				l8.setSize(70,30);
				l8.setLocation(30,50);
				t3.setSize(350,30);
				t3.setLocation(120,50);
				b3.setSize(100,50);
				b4.setSize(100,50);
				b3.setLocation(100,120);
				b4.setLocation(250,120);

				//save dialog box
				d5=new Dialog(this,"SAVE");
				d5.setSize(500,200);
				d5.setLayout(null);
				d5.setLocation(400,400);
				b8=new Button("Save");
				b9=new Button("Cancel");
				l11=new Label("File Name :");
				t4=new TextField();
				d5.add(b9);
				d5.add(b8);
				d5.add(l11);
				d5.add(t4);
				l11.setSize(70,30);
				l11.setLocation(30,50);
				t4.setSize(350,30);
				t4.setLocation(120,50);
				b8.setSize(100,50);
				b9.setSize(100,50);
				b8.setLocation(100,120);
				b9.setLocation(250,120);

				
				
			edit= new Menu("Edit");
			edit.add(selectall=new MenuItem("SELECT ALL"));
			edit.add(copy=new MenuItem("COPY"));
			edit.add(paste=new MenuItem("PASTE"));
			edit.add(clear=new MenuItem("CLEAR"));
		
		
				bold=new Checkbox("Bold");
				underline=new Checkbox("Underline");
				italic=new Checkbox("Italic");
		
		format= new Menu("Format");
			font =new MenuItem("FONT");
				
			format.add(font);
			changecase =new Menu("CHANGE CASE");
				tolowercase=new MenuItem("toLowerCase");
				touppercase=new MenuItem("toUpperCase");
				changecase.add(tolowercase);
				changecase.add(touppercase);
				fs=new Choice();
				GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
				String FontList[]=ge.getAvailableFontFamilyNames();
				
				for(int i=0;i<FontList.length;i++)
				{
					fs.add(FontList[i]);
				}
				
				
				l1=new Label("Set font:");
				l2=new Label("Size");
				l3=new Label();
				s1=new Scrollbar(Scrollbar.HORIZONTAL,8,4,0,92);
				R=new Scrollbar(Scrollbar.VERTICAL,0,0,0,256);
				G=new Scrollbar(Scrollbar.VERTICAL,0,0,0,256);
				B=new Scrollbar(Scrollbar.VERTICAL,0,0,0,256);
				l5=new Label("red");
				l6=new Label("green");
				l7=new Label("blue");				
				b1=new Button("OK");
				
				t2=new TextField(s1.getValue()+"");
					//dialogue 1 creation
						d1=new Dialog(this);
						d1.setSize(300,250);
						d1.setTitle("FONT");
						d1.setLocation(100,100);
						d1.add(l1);
						d1.add(l2);
						d1.add(s1);
						d1.setLayout(null);
						l1.setSize(70,25);
						l2.setSize(35,25);
						l1.setLocation(10,50);
						
						l2.setLocation(10,110);
						s1.setLocation(100,110);
						//l3.setText(s1.getValue()+" ");
						
						b1.setSize(80,40);
						b1.setLocation(100,180);
						
					
						
						l3.setLocation(350,50);
						l3.setSize(50,25);
						s1.setSize(150,20);
						d1.add(fs);
						d1.add(l3);
						d1.add(b1);
						
						d1.add(bold);
						d1.add(italic);
						d1.add(underline);
						d1.add(t2);
						t2.setLocation(50,115);
						t2.setSize(25,20);
						bold.setLocation(20,150);
						bold.setSize(50,20);
						underline.setLocation(180,150);
						underline.setSize(90,20);
						italic.setLocation(100,150);
						italic.setSize(50,20);
						
						fs.setSize(150,50);
						fs.setLocation(100,50);
						
						
						
			format.add(changecase);
			colour=new Menu("COLOUR");
				foreground=new MenuItem("foreground");
				background=new MenuItem("background");
				colour.add(foreground);
				colour.add(background);
			b10=new Button("  ok  ");
			b10.setSize(100,50);
				b10.setLocation(130,370);
			//dialogue box 2 creation
				d2=new Dialog(this);
				d2.setSize(350,450);
				d2.setTitle("color");
				d2.setLocation(100,100);
				
					d2.setLayout(null);
					d2.add(R);
					d2.add(G);
					d2.add(B);
					d2.add(l5);
					d2.add(l6);
					d2.add(b10);
					d2.add(l7);
					R.setSize(20,276);
					R.setLocation(40,40);
					G.setSize(20,276);
					G.setLocation(140,40);
					B.setSize(20,276);
					B.setLocation(240,40);
					
					l5.setSize(80,50);
					l6.setSize(80,50);
					l7.setSize(80,50);
					
					l5.setLocation(40,330);
					l6.setLocation(140,330);
					l7.setLocation(240,330);
		
		format.add(colour);
		setMenuBar(m1);
		m1.add(file);
		m1.add(edit);
		m1.add(format);
		
		add(t1);
		
		exit.addActionListener(this);
		font.addActionListener(this);
		tolowercase.addActionListener(this);
		touppercase.addActionListener(this);
		foreground.addActionListener(this);
		background.addActionListener(this);
		R.addAdjustmentListener(this);
		G.addAdjustmentListener(this);
		B.addAdjustmentListener(this);
		s1.addAdjustmentListener(this);
		this.addWindowListener(new InnerWindow());
		s1.addAdjustmentListener(this);
		t2.addTextListener(this);
		bold.addItemListener(this);
		italic.addItemListener(this);
		underline.addItemListener(this);
		b1.addActionListener(this);
		fs.addItemListener(this);
		open.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
		b7.addActionListener(this);
		b6.addActionListener(this);
		b5.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		New.addActionListener(this);
		save.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(bold.getState()==true)
		{
			Graphics g= t1.getGraphics();
		Font f= g.getFont();
		t1.setFont(new Font(f.getName(),Font.BOLD,f.getSize()));
		}
		
		 if(italic.getState()==true)
		{
			Graphics g= t1.getGraphics();
		Font f= g.getFont();
		t1.setFont(new Font(f.getName(),Font.ITALIC,f.getSize()));
		}
		
		 if(italic.getState()==true&&bold.getState()==true)
		{
			Graphics g= t1.getGraphics();
		Font f= g.getFont();
		t1.setFont(new Font(f.getName(),Font.ITALIC|Font.BOLD,f.getSize()));
		}
		
		 if(italic.getState()==false&&bold.getState()==false)
		{
			Graphics g= t1.getGraphics();
		Font f= g.getFont();
		t1.setFont(new Font(f.getName(),Font.PLAIN,f.getSize()));
		}
		
		if(underline.getState()==true)
		{
			
		}
		
		GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font FontList[]=ge.getAllFonts();
		
		for(int i=0;i<FontList.length;i++)
				{
					
				if(FontList[i].getName().equals(fs.getSelectedItem()))
				{
					//t1.setText(FontList[i].getName());
					Graphics g= t1.getGraphics();
					Font f= g.getFont();
					t1.setFont(new Font(FontList[i].getName(),f.getStyle(),f.getSize()));
					break;
					
				}
				}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("EXIT"))
			System.exit(0);
		else if(ae.getActionCommand().equals("FONT"))
		{
			
			d1.setVisible(true);
		}
		else if(ae.getActionCommand().equals("toUpperCase"))
		{
			String t2=t1.getText();
			String t3=t1.getSelectedText().toUpperCase();
			int i=t2.indexOf(t1.getSelectedText());
			t1.replaceRange(t3,i,i+t1.getSelectedText().length());
			
		}
		
		else if(ae.getActionCommand().equals("toLowerCase"))
		{
			String t2=t1.getText();
			String t3=t1.getSelectedText().toLowerCase();
			int i=t2.indexOf(t1.getSelectedText());
			t1.replaceRange(t3,i,i+t1.getSelectedText().length());
			
		}
		
		
		
		else if(ae.getActionCommand().equals("background"))
		{
			flag=true;
			
			d2.setVisible(true);
			
		}
		
		
		else if(ae.getActionCommand().equals("foreground"))
		{
			flag=false;
			
			d2.setVisible(true);
			
		}
		
		else if(ae.getActionCommand().equals("OK"))
		{
			d1.dispose();
		}
		else if(ae.getActionCommand().equals("OPEN"))
		{
			d3.setVisible(true);
			
		}
		else if(ae.getSource()==b4)
		{
			t3.setText(" ");
			d3.dispose();
			
		}
		
		else if(ae.getSource()==b10)
		{
			
			d2.dispose();
			
		}
		else if(ae.getSource()==b7)
		{
			d4.dispose();
		}
		
		else if(ae.getSource()==b6)
		{
			t1.setText(" ");
			d4.dispose();
			setTitle("untitled");
		}
		
		else if(ae.getSource()==b5)
		{
			d4.dispose();
			d5.setVisible(true);
		}
		
		else if(ae.getSource()==b8)
		{
			
			FileWriter fwr=null;
			try
			{
			fwr=new FileWriter(t4.getText());
			fwr.write(t1.getText());
			}
			catch(Exception i)
			{}
			finally
			{
				try
				{
				fwr.close();
				}
				catch(Exception t)
				{}
			}
			d5.dispose();
			t1.setText(" ");
			t4.setText(" ");
			setTitle("untitled");
		}
		
		else if(ae.getSource()==b9)
		{
			d5.dispose();
			d4.setVisible(true);
			
		}
		
		
		else if(ae.getSource()==b3)
		{
			
			File f;
			FileReader fr=null;
			try
			{
			f=new File(t3.getText());
			
			fr=new FileReader(f);
			char buffer[]=new char[(int)f.length()];
			fr.read(buffer);
			t1.setText(new String(buffer));
			setTitle(f.getName());
			}
			catch(Exception ioe)
			{}
			finally
			{
				try
				{
				fr.close();
				
				}
				catch(Exception ex)
				{}
			}
			d3.dispose();
			t3.setText(" ");
			
		}
		
		else if(ae.getActionCommand().equals("NEW"))
		{
			
			d4.setVisible(true);
		}
		
		else if(ae.getActionCommand().equals("SAVE"))
		{
			
			d5.setVisible(true);
		}
		
	}
	
	public void adjustmentValueChanged(AdjustmentEvent aa)
	{
		l5.setText("RED ="+R.getValue());
		l6.setText("GREEN ="+G.getValue());
		l7.setText("BLUE ="+B.getValue());
		t2.setText(s1.getValue()+"");
		int size=s1.getValue();
		Graphics g= t1.getGraphics();
		Font f= g.getFont();
		t1.setFont(new Font(f.getName(),f.getStyle(),size));
		if(flag)
		t1.setBackground(new Color(R.getValue(),G.getValue(),B.getValue()));
	
		else 
		t1.setForeground(new Color(R.getValue(),G.getValue(),B.getValue()));
	
	
	
	
	
	}
	public void textValueChanged(TextEvent te)
	{
		String s=t2.getText();
		s1.setValue(Integer.parseInt(s));
		int size=s1.getValue();
		Graphics g= t1.getGraphics();
		Font f= g.getFont();
		t1.setFont(new Font(f.getName(),f.getStyle(),size));
		
	}
	public static void main(String args[])
	{
		new MyNotepad().setVisible(true);
	}
	}