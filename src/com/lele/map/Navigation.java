package com.lele.map;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class Navigation {
	
	public static final int Map_BaiDu = 0;
	public static final int Map_AutoNavi = 1;
	public static final int Map_Tencent = 2;
	
	private static final String baidu = "com.baidu.BaiduMap";
	private static final String autonavi = "com.autonavi.minimap";
	private static final String tencent = "com.tencent.map";
	
	private static String referer = "lele";

	public static void setReferer(String referer) {
		Navigation.referer = referer;
	}


	public static boolean OpenMap(Context context, int map, Route route) {
		switch (map) {
		case Map_BaiDu: {
			if (!isAppInstalled(context, baidu)) {
				return false;
			}
			openBaiduMap(context, route);
			break;
		}
		case Map_AutoNavi: {
			if (!isAppInstalled(context, autonavi)) {
				return false;
			}
			openAutoNavi(context, route);
			break;
		}
		case Map_Tencent: {
			if (!isAppInstalled(context, tencent)) {
				return false;
			}
			openTencentMap(context, route);
			break;
		}
		}
		return true;
	}
	
	
	private static void openTencentMap(Context context, Route route) {
		String from = route.getOriginName();
		String fromcoord = route.getOriginLatitude() + "," + route.getOriginLongitude();
		String to = route.getDestinationName();
		String tocoord = route.getDestinationLatitude() + "," + route.getDestinationLongitude();
		String referer = Navigation.referer;
		
		Uri uri = Uri.parse("qqmap://map/routeplan?type=drive&from=" + from + "&fromcoord=" + fromcoord + "&to=" + to + "&tocoord=" + tocoord + "&policy=1&referer=" + referer);
		Intent intent = new Intent("android.intent.action.VIEW", uri);
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setPackage(tencent);
		context.startActivity(intent);
	}

	private static void openAutoNavi(Context context, Route route) {
		String sname = route.getOriginName();
		double slat = route.getOriginLatitude();
		double slon = route.getOriginLongitude();
		String dname = route.getDestinationName();
		double dlat = route.getDestinationLatitude();
		double dlon = route.getDestinationLongitude();
		String sourceApplication = Navigation.referer;
		
		Uri uri = Uri.parse("androidamap://route?sourceApplication=" + sourceApplication + "&slat=" + slat + "&slon=" + slon + "&sname=" + sname + "&dlat=" + dlat + "&dlon=" + dlon + "&dname=" + dname + "&dev=0&m=0&t=2");
		Intent intent = new Intent("android.intent.action.VIEW", uri);
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setPackage(autonavi);
		context.startActivity(intent);

	}

	private static void openBaiduMap(Context context, Route route) {
		String sname = route.getOriginName();
		String slatlng = route.getOriginLatitude() + "," + route.getOriginLongitude();
		String dname = route.getDestinationName();
		String dlatlng = route.getDestinationLatitude() + "," + route.getDestinationLongitude();
		String src = Navigation.referer;
		Uri uri = Uri.parse("bdapp://map/direction?origin=latlng:" + slatlng + "|name:" + sname + "&destination=latlng:" + dlatlng + "|name:" + dname + "&mode=driving&region=Î÷°²&src=" + src);
		Intent intent = new Intent("android.intent.action.VIEW", uri);
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setPackage(baidu);
		context.startActivity(intent);
	}
  
	private static boolean isAppInstalled(Context context, String packageName) {
		final PackageManager packageManager = context.getPackageManager();
		List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
		List<String> pName = new ArrayList<String>();
		if (pinfo != null) {
			for (int i = 0; i < pinfo.size(); i++) {
				String pn = pinfo.get(i).packageName;
				pName.add(pn);
			}
		}
		return pName.contains(packageName);
	}
}
