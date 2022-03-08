package PojoExample;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Dal.Datahelper;
public class CrudExample {

	static void selectRecord() {
		Datahelper.connection();
		Query q=Datahelper.dql("from TeacherExample s");
		List lst=q.list();
		Iterator it=lst.iterator();
		while(it.hasNext()) {
			TeacherExample s=(TeacherExample)it.next();
			System.out.println(s.getTid()+" "+s.getTname());
		}
		Datahelper.closeconn();
	}
	
	static void insertRecord(int tid,String tname) {
		Datahelper.connection();
		TeacherExample s=new TeacherExample();
		s.setTid(tid);
		s.setTname(tname);
		Datahelper.dmlInsert(s);
		Datahelper.closeconn();
	}
	
	static void deleteRecord(int tid) {
		Datahelper.connection();
		TeacherExample s=(TeacherExample)Datahelper.dqlFind(TeacherExample.class,tid);
		Datahelper.dmlDelete(s);
		Datahelper.closeconn();
	}
	
	static void updateRecord(int tid,String tname) {
		Datahelper.connection();
		TeacherExample s=(TeacherExample)Datahelper.dqlFind(TeacherExample.class,tid);
		Datahelper.dmlUpdate(s);
		Datahelper.closeconn();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//insertRecord(104,"c");
			//updateRecord(104,"d");
			//deleteRecord(104);
			selectRecord();
	}

}
