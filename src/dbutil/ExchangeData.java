package dbutil;

public class ExchangeData {
    public static String sid;									//当前学生ID--
    public static String tid;									//当前教师ID
    public static String mid;									//当前管理员ID
    public static String aws;									//当前题目的答案
    public static int choicescore;								//当前试卷的选择题分值
    public static int TFscore;									//当前试卷的判断题分值
    public static int corr1;									//当前试卷的选择题正确个数
    public static int corr2;									//当前试卷的判断题正确个数
    public static int corr=corr1+corr2;							//当前试卷的正确个数--
    public static int choicenum;								//当前试卷的选择题数
    public static int TFnum;									//当前试卷的判断题数
    public static int allnum=choicenum+TFnum;					//当前试卷的总题数--
    public static int score=choicescore*choicenum+TFscore*TFnum;//当前试卷的总分--
    public static int stuscore=choicescore*corr1+TFscore*corr2;	//当前答卷的分数--
}
