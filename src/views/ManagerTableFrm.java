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
public class ManagerTableFrm extends JFrame{		//管理员用户信息界面
  private JTable table=null;
  private ManagerDao dao=new ManagerDao();
  private JButton btnAdd=new JButton("增加");
  private JButton btnDelete=new JButton("删除");
  private JButton btnAlter=new JButton("查找 / 修改");
  private JButton btnReturn=new JButton("返回");
  private JLabel blank1=new JLabel("                 "); //在JButton之间添加空白JLabel,使得JButton之间有间距
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
    btnAdd.addActionListener(new ActionListener() {		//增加管理员用户信息
        public void actionPerformed(ActionEvent e) {
        	new ManagerAddFrm();
        }
      });
    btnDelete.addActionListener(new ActionListener() {	//删除管理员用户信息
      public void actionPerformed(ActionEvent e) {
        btnDelete_Clicked();
      }
    });
    btnReturn.addActionListener(new ActionListener() {	//返回上一个界面
        public void actionPerformed(ActionEvent e) {
        	Return();
        }
      });
    btnAlter.addActionListener(new ActionListener() {	//查找并修改管理员用户信息
        public void actionPerformed(ActionEvent e) {
			if(field1.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null, "输入修改用户的编号！");
			}
			else
			{
				new ManagerAlterFrm(field1.getText());
			}
        }
      });
      this.setTitle("管理员用户管理后台");
      this.setSize(800,600);
      setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
      
      DefaultTableCellRenderer cr = new DefaultTableCellRenderer();		//设置JTable中数据居中显示
      cr.setHorizontalAlignment(JLabel.CENTER);
      table.setDefaultRenderer(Object.class, cr);
      
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  private void btnDelete_Clicked() {
    int selectedRow=table.getSelectedRow();
    if(selectedRow==-1) {
      JOptionPane.showMessageDialog(this, "没有选择任何行!");
    }else {
      if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(this, "确认删除这一行？")) {
          int r=dao.deleteCustomerById(table.getValueAt(selectedRow,0).toString());
          if(r>0) {
            JOptionPane.showMessageDialog(this, "成功删除了一条记录!");
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