package rd.f.tools;


public class T {
	public static String ErrorTag = "error";
	
    public static MathTool math;
    public static String MathToolTag = "math";
    
    public static DeviceTool device;
    public static String DeviceTool = "device";
    
    // view、controller、service、dao
    /*public static ActivityTool activity;
    public static String ActivityToolTag = "activity";
    public static ServiceTool service;
    public static String ServiceToolTag = "service";
    public static ContentProviderTool contentprovider;
    public static String ContentProviderToolTag = "contentprovider";
    public static BroadcastReceiverTool broadcastreceiver;
    public static String BroadcastReceiverToolTag = "broadcastreceiver";*/
	
	/**
	 * 静态代码块,初始化下列静态成员
	 */
	static {
		math = new MathTool();
		device = new DeviceTool();
		
		// 四大组件的
/*		activity = new ActivityTool();
		service = new ServiceTool();
		contentprovider = new ContentProviderTool();
		broadcastreceiver = new BroadcastReceiverTool();*/
	}
}
