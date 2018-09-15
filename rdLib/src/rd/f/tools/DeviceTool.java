package rd.f.tools;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class DeviceTool {

	/**
	 * 获取本机IPV4地址
	 * eg.	192.168.0.101
	 * @return
	 */
	public String getLocalMachineIpV4Address() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ipV4 = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
					continue;
				} else {
					Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
					while (addresses.hasMoreElements()) {
						ipV4 = addresses.nextElement();
						if (ipV4 != null && ipV4 instanceof Inet4Address) {
							return ipV4.getHostAddress();
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("获取本机IP地址失败" + e);
		}
		return "";
	}
}
