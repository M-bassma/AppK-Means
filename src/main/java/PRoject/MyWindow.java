package PRoject;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyWindow extends JFrame {
	/*** fonctionnement****/
	protected AlgoKMeans kMeans;
	protected ArrayList<Float> errors=new ArrayList<Float>();
	protected static String data_chemin;
	protected ArrayList<String> chemins=new ArrayList<String>();
	
	/*** interface *****/
	protected JButton selectionner= new JButton("selectionner");
	protected JFrame frame = new JFrame();
    protected JScrollPane lesClassesDimages = new JScrollPane();
    
    protected JPanel sideBarre = new JPanel();
    protected JPanel recupererClasse = new JPanel();
    protected JPanel SelectionnerImage = new JPanel();
    protected JPanel TauxErrors = new JPanel();
    private javax.swing.JPanel bg;
    private javax.swing.JPanel classificationImageBarre;
    private javax.swing.JLabel classificationImageTitre;
    private javax.swing.JLabel fermer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    
    public MyWindow() {
        initComponents();
    }
                            
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
    	 bg = new JPanel();
        bg.setBackground(new Color(255, 255, 255));
    	 
         classificationImageBarre = new JPanel();
         classificationImageTitre = new JLabel();
         
        sideBarre.setBackground(new Color(40, 24, 50));
         JLabel Menu = new JLabel();
         jSeparator1 = new JSeparator();


   
        lesClassesDimages.setBackground(new Color(255, 255, 255));
        lesClassesDimages.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        lesClassesDimages.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        /******** Selectionner Image****/

        jButton1 = new JButton();
        jLabel1 = new JLabel();
        SelectionnerImage.setBackground(new Color(85, 65, 118));

        jButton1.setBackground(new Color(85, 65, 118));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jButton1.setForeground(new Color(204, 204, 204));
        jButton1.setText("-");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
                jButton1.setBackground(new Color(85, 65, 118));
            }
        });

        jLabel1.setFont(new Font("Segoe UI", 1, 14)); 
        jLabel1.setForeground(new Color(204, 204, 204));
        jLabel1.setText("Sélectionner une image");

        javax.swing.GroupLayout SelectionnerImageLayout = new javax.swing.GroupLayout(SelectionnerImage);
        SelectionnerImage.setLayout(SelectionnerImageLayout);
        SelectionnerImageLayout.setHorizontalGroup(
            SelectionnerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectionnerImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectionnerImageLayout.setVerticalGroup(
            SelectionnerImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectionnerImageLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jButton1.setBackground(new java.awt.Color(85, 65, 118));
        SelectionnerImage.getAccessibleContext().setAccessibleName("jButton1");
        jButton1.getAccessibleContext().setAccessibleName("Sélectionner une image");
        /********* recuperer Classe *****/

        jButton2 = new JButton();
        jButton2.setText("+");
        jLabel2 = new JLabel();
        recupererClasse.setBackground(new Color(64, 43, 100));

        jButton2.setBackground(new Color(64, 43, 100));
        jButton2.setFont(new Font("Segoe UI", 1, 30)); 
        jButton2.setForeground(new Color(204, 204, 204));
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jButton2MouseClicked(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new Color(204, 204, 204));
        jLabel2.setText("Récuperer les classes");

        javax.swing.GroupLayout recupererClasseLayout = new javax.swing.GroupLayout(recupererClasse);
        recupererClasse.setLayout(recupererClasseLayout);
        recupererClasseLayout.setHorizontalGroup(
            recupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        recupererClasseLayout.setVerticalGroup(
            recupererClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(recupererClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        recupererClasse.getAccessibleContext().setAccessibleName("jButton2");
        jButton2.getAccessibleContext().setAccessibleName("Récuperer une image");
        /***** Taux Errors******/

        jButton3 = new JButton();
        jLabel3 = new JLabel();
        TauxErrors.setBackground(new Color(69, 49, 109));

        jButton3.setFont(new Font("Segoe UI", 1, 30));
        jButton3.setBackground(new Color(69, 49, 109)); 
        jButton3.setForeground(new Color(69, 49, 109));
        jButton3.setText("x");
        jButton3.setBorder(null);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jButton3MouseClicked(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(204, 204, 204));
        jLabel3.setText("le Taux errors");

        javax.swing.GroupLayout TauxErrorsClasseLayout = new javax.swing.GroupLayout(TauxErrors);
        TauxErrors.setLayout(TauxErrorsClasseLayout);
        TauxErrorsClasseLayout.setHorizontalGroup(
        		TauxErrorsClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TauxErrorsClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        TauxErrorsClasseLayout.setVerticalGroup(
        		TauxErrorsClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TauxErrorsClasseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(TauxErrorsClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        TauxErrors.getAccessibleContext().setAccessibleName("jButton3");
        jButton3.getAccessibleContext().setAccessibleName("le Taux errors");
        
        
        Menu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(204, 204, 204));
        Menu.setText("Menu");

        javax.swing.GroupLayout sideBarreLayout = new javax.swing.GroupLayout(sideBarre);
        sideBarre.setLayout(sideBarreLayout);
        sideBarreLayout.setHorizontalGroup(
            sideBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recupererClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SelectionnerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TauxErrors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sideBarreLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Menu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        sideBarreLayout.setVerticalGroup(
            sideBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarreLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(recupererClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SelectionnerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TauxErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        
        /******* la barre du classification**********/
        classificationImageBarre.setBackground(new Color(110, 89, 222));

        classificationImageTitre.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        classificationImageTitre.setForeground(new Color(204, 204, 204));
        classificationImageTitre.setText("La classification des images");

        GroupLayout classificationImageBarreLayout = new GroupLayout(classificationImageBarre);
        classificationImageBarre.setLayout(classificationImageBarreLayout);
        classificationImageBarreLayout.setHorizontalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(classificationImageTitre)
                .addContainerGap(893, Short.MAX_VALUE))
        );
        classificationImageBarreLayout.setVerticalGroup(
            classificationImageBarreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classificationImageBarreLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(classificationImageTitre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        
        /*******le layout du contentPane global*****/
        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sideBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		.addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 1000,javax.swing.GroupLayout.DEFAULT_SIZE)
                		.addComponent(lesClassesDimages, javax.swing.GroupLayout.PREFERRED_SIZE, 1000,javax.swing.GroupLayout.DEFAULT_SIZE)
                    ))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20) //43
                .addComponent(classificationImageBarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lesClassesDimages))
            .addComponent(sideBarre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        /***le layout du frame********/
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        setSize(500, 500);
        pack();
    }                      
    /****recuperer les classes**********/
    private void jButton1MouseClicked(MouseEvent evt) { 
    	JPanel panel = new JPanel();
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
	    chooser.setFileFilter(filter);
	    panel.setLayout(new FlowLayout());
	    if( chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) 
	          try {
	            data_chemin = new String("E:/java/color  hist/img/"+chooser.getSelectedFile().getName());
				chemins = this.rechercher(data_chemin);
				Image[] img = new Image[1000];
				JLabel[] pimg = new JLabel[1000];
				ImageIcon imageicon;
				
				for ( int i = 0 ; i < chemins.size() ; i++ ) {
					imageicon = new ImageIcon(chemins.get(i));
		         	pimg[i] = new JLabel();
                    pimg[i].setIcon(imageicon);
         			panel.add(pimg[i]);
				}
				lesClassesDimages.setViewportView(panel);
				
		        lesClassesDimages.setBackground(new java.awt.Color(255, 255, 255));
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
    }    

    public ArrayList<String> rechercher(String chemin) throws IOException{
    	kMeans = new AlgoKMeans();
		Cluster cluster = new Cluster();
		 ArrayList<Data> dataSet = kMeans.dataSet;
		 ArrayList<String> path = new ArrayList<String>();
		 for(Data data:dataSet) {
			 if(chemin.equals(data.getchemin())) {
				 cluster = data.getCluster();
			 }
		 }
		 for(Data data:cluster.dataSet) {
			 path.add(data.getchemin());
		 }
		 return path;
	 }
    /****recuperer les classes**********/
    private void  jButton2MouseClicked(MouseEvent evt) throws IOException {                                         
    	JPanel panel = new JPanel();
    	kMeans= new AlgoKMeans();
    	JLabel[] classes = new JLabel[kMeans.clusters.size()];
    	//panel.setLayout(new GridLayout(20,0));
    	panel.setLayout(new GridLayout(10,0));
    	
    	JPanel[] folowImages = new JPanel[kMeans.clusters.size()];
    	JPanel[] folowImages1 = new JPanel[kMeans.clusters.size()];
    	
		JLabel[] pimg = new JLabel[kMeans.dataSet.size()];
		ImageIcon imageicon;
		ArrayList<String> path ;
		int i = 0;
		
    	for(Cluster cluster : kMeans.clusters) {
    		classes[i] = new JLabel("Classe " + i);
    		classes[i].setBackground(new Color(255, 255, 255));
    		classes[i].setPreferredSize(new Dimension(100,100));
    		classes[i].setFont(new java.awt.Font("Segoe UI", 1, 14));
    		
    		//panel.add(classes[i]);
    		path = new ArrayList<String>();
    		for(Data data:cluster.dataSet) {
    			 path.add(data.getchemin());
    		}
    		
    		
    		folowImages1[i] = new JPanel(new BorderLayout());
    		
    		folowImages[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
    		
    		for ( int j = 0 ; j < path.size() ; j++ ) {
				imageicon = new ImageIcon(path.get(j));
			    pimg[j] = new JLabel();
	            pimg[j].setIcon(imageicon);
	            folowImages[i].add(pimg[j]);
			}
    		
    		folowImages1[i].add(classes[i], BorderLayout.NORTH);
    		folowImages1[i].add(folowImages[i], BorderLayout.CENTER);
    		
    		panel.add(folowImages1[i]);
    		i++;
    	}
    	lesClassesDimages.setViewportView(panel);
        lesClassesDimages.setBackground(new java.awt.Color(255, 255, 255));
    } 
    private void jButton3MouseClicked(MouseEvent evt) throws IOException { 
    	kMeans = new AlgoKMeans();
    	errors=kMeans.errors;
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		l2.add("");
		l1.add("Classe1");
		l1.add("Classe2");
		l1.add("Classe3");
		l1.add("Classe4");
		l1.add("Classe5");
		l1.add("Classe6");
		l1.add("Classe7");
		l1.add("Classe8");
		l1.add("Classe9");
		l1.add("Classe10");
		freechart free = new freechart("Taux d'erreur", "x", "y", Color.white, l2, l1, true,errors);

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(10,10,900,700);
		f.add(free);
		f.setVisible(true);
    }                                   

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyWindow().setVisible(true);
            }
        });
    }                  
}
