package dbutil;

public class ExchangeData {
    public static String sid;									//��ǰѧ��ID--
    public static String tid;									//��ǰ��ʦID
    public static String mid;									//��ǰ����ԱID
    public static String aws;									//��ǰ��Ŀ�Ĵ�
    public static int choicescore;								//��ǰ�Ծ��ѡ�����ֵ
    public static int TFscore;									//��ǰ�Ծ���ж����ֵ
    public static int corr1;									//��ǰ�Ծ��ѡ������ȷ����
    public static int corr2;									//��ǰ�Ծ���ж�����ȷ����
    public static int corr=corr1+corr2;							//��ǰ�Ծ����ȷ����--
    public static int choicenum;								//��ǰ�Ծ��ѡ������
    public static int TFnum;									//��ǰ�Ծ���ж�����
    public static int allnum=choicenum+TFnum;					//��ǰ�Ծ��������--
    public static int score=choicescore*choicenum+TFscore*TFnum;//��ǰ�Ծ���ܷ�--
    public static int stuscore=choicescore*corr1+TFscore*corr2;	//��ǰ���ķ���--
}
