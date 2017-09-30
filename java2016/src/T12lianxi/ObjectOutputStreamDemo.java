package T12lianxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import T12.Student;
import T12.Student1;

public class ObjectOutputStreamDemo {
	public static void main(String[] args) {
		new ObjectOutputStreamDemo().save();
		new ObjectOutputStreamDemo().open();
	}
	//保存文件
	public  void save() {
		try{
			File file = new File("d:\\File\\student.db");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//保存对象
			Student s1 = new Student(1001,"张三","男",18);
			Student s2 = new Student(1002,"小芳","女",18);
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.close();
			System.out.println("保存成功！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void open() {
		//读文件内容
		try{
			File file = new File("d:\\File\\student.db");
			if(!file.exists()){
				System.out.println("打开文件失败：文件不存在");
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			//要把Object对象强制还原为Student对象
			Student s1 = (Student)ois.readObject();
			Student s2 = (Student)ois.readObject();
			System.out.println(s1);
			System.out.println(s2);
			ois.close();
			System.out.println("读文件成功！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
