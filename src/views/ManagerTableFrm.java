package views;
import dao.ManagerDao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
public class ManagerTableFrm extends JFrame{		//����Ա�û���Ϣ����
  private JTable table=null;
  private ManagerDao dao=new ManagerDao();
  private JButton btnAdd=new JButton("����");
  private JButton btnDelete=new JButton("ɾ��");
  private JButton btnAlter=new JButton("���� / �޸�");
  private JButton btnReturn=new JButton("����");
  private JLabel blank1=new JLabel("                 "); //��JButton֮����ӿհ�JLabel,ʹ��JButton֮���м��
  private JLabel blank2=new JLabel("                 ");
  private JLabel blank3=new JLabel("-----------------");
  private JTextField field1 = new JTextField(6);
  private void initTable() {
    String[] cols= {"uid","upwd","name","email","needfindpwd"};
    String[][] rows=dao.queryAllCustomers();
    table=new JTable(rows,cols);
  }
  public void updateTable() {
    String[] cols= {"uid","upwd","name","email","needfindpwd"};
    String[][] rows=dao.queryAllCustomers();
    table.setModel(new DefaultTableModel(rows,cols));
  }
  public ManagerTableFrm() {
    JPanel jp = (JPanel) this.getContentPane();
    JPanel jp_North=new JPanel();
    jp_North.add(btnAdd);
    jp_North.add(blank1);
    jp_North.add(btnDelete);
    jp_North.add(blank2);
    jp_North.add(btnAlter);
    jp_North.add(blank3);
    jp_North.add(field1);
    jp.add(BorderLayout.SOUTH,btnReturn);
    jp.add(BorderLayout.NORTH,jp_North);
    initTable();
    JScrollPane jsp_table=new JScrollPane(table); 
    jp.add(jsp_table);
    btnAdd.addActionListener(new ActionListener() {		//���ӹ���Ա�û���Ϣ
        public void actionPerformed(ActionEvent e) {
        	new ManagerAddFrm();
        }
      });
    btnDelete.addActionListener(new ActionListener() {	//ɾ������Ա�û���Ϣ
      public void actionPerformed(ActionEvent e) {
        btnDelete_Clicked();
      }
    });
    btnReturn.addActionListener(new ActionListener() {	//������һ������
        public void actionPerformed(ActionEvent e) {
        	Return();
        }
      });
    btnAlter.addActionListener(new ActionListener() {	//���Ҳ��޸Ĺ���Ա�û���Ϣ
        public void actionPerformed(ActionEvent e) {
			if(field1.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null, "�����޸��û��ı�ţ�");
			}
			else
			{
				new ManagerAlterFrm(field1.getText());
			}
        }
      });
      this.setTitle("����Ա�û������̨");
      this.setSize(800,600);
      setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
      
      DefaultTableCellRenderer cr = new DefaultTableCellRenderer();		//����JTable�����ݾ�����ʾ
      cr.setHorizontalAlignment(JLabel.CENTER);
      table.setDefaultRenderer(Object.class, cr);
      
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  private void btnDelete_Clicked() {
    int selectedRow=table.getSelectedRow();
    if(selectedRow==-1) {
      JOptionPane.showMessageDialog(this, "û��ѡ���κ���!");
    }else {
      if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(this, "ȷ��ɾ����һ�У�")) {
          int r=dao.deleteCustomerById(table.getValueAt(selectedRow,0).toString());
          if(r>0) {
            JOptionPane.showMessageDialog(this, "�ɹ�ɾ����һ����¼!");
            updateTable();
          }
      }
    }
  }
  public void Return() {
	   this.setVisible(false);
 }
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    new ManagerTableFrm();
  }
}