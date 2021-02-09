package views;
import dao.PaperDao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
public class PaperTableFrm extends JFrame{		//�Ծ���Ϣ����
  private JTable table=null;
  private PaperDao dao=new PaperDao();
  private JButton btnReturn=new JButton("���ص�¼����");
  private void initTable() {
    String[] cols= {"PID","Question","OptionA","OptionB","OptionC","OptionD","OptionT","OptionF","answer"};
    String[][] rows=dao.queryAllCustomers();
    table=new JTable(rows,cols);
  }
  public void updateTable() {
    String[] cols= {"PID","Question","OptionA","OptionB","OptionC","OptionD","OptionT","OptionF","answer"};
    String[][] rows=dao.queryAllCustomers();
    table.setModel(new DefaultTableModel(rows,cols));
  }
  public PaperTableFrm() {
    JPanel jp = (JPanel) this.getContentPane();
    JPanel jp_North=new JPanel();
    jp.add(BorderLayout.NORTH,jp_North);
    initTable();
    JScrollPane jsp_table=new JScrollPane(table); 
    jp.add(jsp_table);
    jp.add(BorderLayout.SOUTH,btnReturn);
	btnReturn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnReturnClicked();
		}
	});
    
      this.setTitle("�Ծ�����̨");
      this.setSize(800,600);
      setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
      
      DefaultTableCellRenderer cr = new DefaultTableCellRenderer();		//����JTable�����ݾ�����ʾ
      cr.setHorizontalAlignment(JLabel.CENTER);
      table.setDefaultRenderer(Object.class, cr);
      
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 	public void btnReturnClicked() {	//���ص�¼����
 		new LoginFrm();
		this.dispose();
	}
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    new PaperTableFrm();
  }
}
