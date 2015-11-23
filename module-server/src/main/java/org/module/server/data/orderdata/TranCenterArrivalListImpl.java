package org.module.server.data.orderdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.TranCenterArrivalListService;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;
import org.module.common.po.TranCenterArrivalListPO;
import org.module.server.data.FileHelper;

public class TranCenterArrivalListImpl implements TranCenterArrivalListService{
	FileHelper help;
	public TranCenterArrivalListImpl(){
		help = new FileHelper(new File("file"+File.separator+"TranCenterArrivalList.txt"));
	}
	public ArrayList<TranCenterArrivalListPO> getAll() {
		// TODO 自动生成的方法存根
		ArrayList<TranCenterArrivalListPO> re = new ArrayList<TranCenterArrivalListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new TranCenterArrivalListPO(temp));
		}
		return re;
	}

	public boolean add(TranCenterArrivalListPO o) {
		// TODO 自动生成的方法存根
		ArrayList<TranCenterArrivalListPO> oll = new ArrayList<TranCenterArrivalListPO>();
		oll.add(o);
		return help.rewrite(oll);
	}

	public boolean update(TranCenterArrivalListPO newone) {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<TranCenterArrivalListPO> getByState(State s) {
		// TODO 自动生成的方法存根
		ArrayList<TranCenterArrivalListPO> oal = this.getAll();
		ArrayList<TranCenterArrivalListPO> newone = new ArrayList<TranCenterArrivalListPO>();
		for(TranCenterArrivalListPO a : oal){
			if(a.getState().equals(s)){
				newone.add(a);
			}
		}
		return newone;
	}

}
